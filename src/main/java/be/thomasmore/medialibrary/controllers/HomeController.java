package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.Book;
import be.thomasmore.medialibrary.model.Movie;
import be.thomasmore.medialibrary.repositories.BookRepository;
import be.thomasmore.medialibrary.repositories.EndUserRepository;
import be.thomasmore.medialibrary.repositories.MovieRepository;
import be.thomasmore.medialibrary.services.GoogleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private EndUserRepository endUserRepository;

    @GetMapping({"/", "/home"})
    public String home(Model model, Principal principal) {

        final Iterable<Movie> allMovies = movieRepository.findTopBought();
        model.addAttribute("movies", allMovies);


        final Iterable<Book> allMBooks = bookRepository.findTopBought();
        model.addAttribute("books", allMBooks);
        if(principal != null) model.addAttribute("currentUser", endUserRepository.findByUsername(principal.getName()));

        return "home";
    }

    @GetMapping({"/error"})
    public String error(Model model) {
        return "error";
    }
}