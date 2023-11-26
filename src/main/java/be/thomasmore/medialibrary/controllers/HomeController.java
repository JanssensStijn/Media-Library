package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.Book;
import be.thomasmore.medialibrary.model.Movie;
import be.thomasmore.medialibrary.repositories.BookRepository;
import be.thomasmore.medialibrary.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;

@Controller
public class HomeController {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private BookRepository bookRepository;
    @GetMapping({"/", "/home"})
    public String home(Model model) {

        final Iterable<Movie> allMovies = movieRepository.findAll();
        model.addAttribute("movies", allMovies);


        final Iterable<Book> allMBooks = bookRepository.findAll();
        model.addAttribute("books", allMBooks);

        return "home";
    }
    @GetMapping({"/error"})
    public String error(Model model) {
        return "error";
    }

}
