package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.Book;
import be.thomasmore.medialibrary.repositories.AuthorRepository;
import be.thomasmore.medialibrary.repositories.BookRepository;
import be.thomasmore.medialibrary.repositories.EndUserRepository;
import be.thomasmore.medialibrary.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.*;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private EndUserRepository endUserRepository;

    @GetMapping({"/bookdetails/{id}", "/bookdetails", "/bookdetails/"})
    public String bookdetails(Model model, @PathVariable(required = false) Integer id, Principal principal) {

        if (id == null) return "bookdetails";
        Optional<Book> bookFromDb = bookRepository.findById(id);

        if (bookFromDb.isPresent()){
            Optional<Book> nextbookFromDb = bookRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextbookFromDb.isEmpty())
                nextbookFromDb = bookRepository.findFirstByOrderByIdAsc();
            Optional<Book> prevbookFromDb = bookRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (prevbookFromDb.isEmpty())
                prevbookFromDb = bookRepository.findFirstByOrderByIdDesc();

            model.addAttribute("nextId", nextbookFromDb.get().getId());
            model.addAttribute("prevId", prevbookFromDb.get().getId());
            model.addAttribute("book", bookFromDb.get());
            if(principal != null) model.addAttribute("currentUser", endUserRepository.findByUsername(principal.getName()));
        }

        return "bookdetails";
    }

    @GetMapping({"/booklist", "/booklist/"})
    public String booklistWithFilter(Model model, Principal principal,
                                      @RequestParam(required = false) String title,
                                      @RequestParam(required = false) String author,
                                      @RequestParam(required = false) Integer yearOfRelease,
                                      @RequestParam(required = false) String genre,
                                      @RequestParam(required = false, defaultValue = "off") Boolean sorted) {


        List<Book> filteredBooks;
        if(sorted) filteredBooks = bookRepository.findByFilterSorted(title, author, genre, yearOfRelease);
        else filteredBooks = bookRepository.findByFilter(title, author, genre, yearOfRelease);

        model.addAttribute("authorFiltered" , author);
        model.addAttribute("titleFiltered" , title);
        model.addAttribute("yearOfReleaseFiltered", yearOfRelease);
        model.addAttribute("yearOfReleaseFiltered", yearOfRelease);
        model.addAttribute("genreFiltered", genre);
        model.addAttribute("sortedFiltered", sorted);
        model.addAttribute("numberOfBooks" , filteredBooks.size());
        model.addAttribute("authors", authorRepository.findByOrderByNameAsc());
        model.addAttribute("yearsOfRelease", bookRepository.findDistinctYearsOfRelease());
        model.addAttribute("books", filteredBooks);
        model.addAttribute("genres", genreRepository.findByGenreForOrderByName("book"));
        if(principal != null) model.addAttribute("currentUser", endUserRepository.findByUsername(principal.getName()));

        return "booklist";
    }

}