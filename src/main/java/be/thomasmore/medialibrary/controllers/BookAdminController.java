package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.*;
import be.thomasmore.medialibrary.repositories.AuthorRepository;
import be.thomasmore.medialibrary.repositories.BookRepository;
import be.thomasmore.medialibrary.services.GoogleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class BookAdminController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GoogleService googleService;

    @ModelAttribute("book")
    public Book findBook(@PathVariable(required = false) Integer id){
        if(id == null) return new Book();
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) return optionalBook.get();
        return null;
    }

    @GetMapping({"/bookedit/{id}"})
    public String bookEdit(Model model, @PathVariable (required = false) Integer id) {
        List<Author> optionalAuthors = (List<Author>) authorRepository.findAll();
        if(!optionalAuthors.isEmpty()) model.addAttribute("allAuthors", optionalAuthors);
        return "admin/bookedit";
    }

    @PostMapping("/bookedit/{id}")
    public String bookEditPost(@PathVariable int id,
                               Book book,
                               @RequestParam(required = false) MultipartFile image,
                               BindingResult bindingResult) throws IOException {

        if(bindingResult.hasErrors()){
            return "admin/book edit/" + id;
        }
        if(!image.isEmpty()) {
            book.setImageUrl(uploadImage(image, "book" + book.getId())); //overwrite old image independent of changes to the movie
        }
        bookRepository.save(book);
        return "redirect:/bookdetails/" + id;
    }

    @GetMapping({"/booknew"})
    public String movieNew(Model model) {
        List<Author> optionalAuthors = (List<Author>) authorRepository.findAll();
        if(!optionalAuthors.isEmpty()) model.addAttribute("allAuthors", optionalAuthors);
        return "admin/booknew";
    }

    @PostMapping("/booknew")
    public String movieNewPost(Model model,
                               @Valid Book book,
                               /*@RequestParam(required = false) MultipartFile image,*/
                               BindingResult bindingResult) throws IOException{
        if(bindingResult.hasErrors()){
            model.addAttribute("allAuthors", authorRepository.findAll());
            return "admin/booknew";
        }
        Book newBook = bookRepository.save(book); //save to create unique id usable for firebase

        /*if(!image.isEmpty()) {
            book.setImageUrl(uploadImage(image, "book" + newBook.getId())); //add unique id to
        }*/

        bookRepository.save(book); //save imageUrl containing specific id
        return "redirect:/bookdetails/" + newBook.getId();
    }

    public String uploadImage(MultipartFile multipartFile, String uniqueName) throws IOException{
        final String filename = multipartFile.getOriginalFilename();
        final File fileToUpload = new File(filename);
        FileOutputStream fos = new FileOutputStream(fileToUpload);
        fos.write(multipartFile.getBytes());
        fos.close();
        final String urlToFirebase = googleService.toFirebase(fileToUpload, uniqueName);
        fileToUpload.delete();
        return urlToFirebase;
    }

}