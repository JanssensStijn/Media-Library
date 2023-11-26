package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.Book;
import be.thomasmore.medialibrary.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping({"/bookdetails/{id}", "/bookdetails", "/bookdetails/"})
    public String bookdetails(Model model, @PathVariable(required = false) Integer id) {

        if (id == null) return "bookdetails";
        Optional<Book> bookFromDb = bookRepository.findById(id);

        if (bookFromDb.isPresent()){
            Optional<Book> nextbookFromDb = bookRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextbookFromDb.isEmpty()) //if no Movie id is higher, get the Movie with the lowest id
                nextbookFromDb = bookRepository.findFirstByOrderByIdAsc();
            Optional<Book> prevbookFromDb = bookRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (prevbookFromDb.isEmpty()) //if no Movie id is lower, get the Movie with the highest id
                prevbookFromDb = bookRepository.findFirstByOrderByIdDesc();

            model.addAttribute("nextId", nextbookFromDb.get().getId());
            model.addAttribute("prevId", prevbookFromDb.get().getId());
            model.addAttribute("book", bookFromDb.get());
        }

        return "bookdetails";
    }

    @GetMapping({"/booklist", "/booklist/",})
    public String booklist(Model model) {
        final Iterable<Book> allBooks = bookRepository.findAll();
        final long numberOfBooks = bookRepository.count();
        model.addAttribute("numberOfBooks", numberOfBooks);
        model.addAttribute("books", allBooks);
        model.addAttribute("showFilter", false);
        return "booklist";
    }

    @GetMapping({"/booklist/filter"})
    public String booklistWithFilter(Model model,
                                      @RequestParam(required = false) Integer id,
                                      @RequestParam(required = false) String title,
                                      @RequestParam(required = false) String author,
                                      @RequestParam(required = false) Integer yearOfRelease) {

        final List<Book> allBooks = bookRepository.findByFilter(id, title, author, yearOfRelease);

        model.addAttribute("idFiltered" , id);
        model.addAttribute("authorFiltered" , author);
        model.addAttribute("titleFiltered" , title);
        model.addAttribute("yearOfReleaseFiltered", yearOfRelease);
        model.addAttribute("numberOfBooks" , allBooks.size());
        model.addAttribute("books", allBooks);
        model.addAttribute("showFilter", true);
        return "booklist";
    }

}