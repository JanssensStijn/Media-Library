package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.*;
import be.thomasmore.medialibrary.repositories.AuthorRepository;
import be.thomasmore.medialibrary.repositories.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class BookAdminController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

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
    public String bookEditPost(@PathVariable int id, Book book){
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
                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("allAuthors", authorRepository.findAll());
            return "admin/booknew";
        }
        Book newBook = bookRepository.save(book);
        return "redirect:/bookdetails/" + newBook.getId();
    }

}