package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.*;
import be.thomasmore.medialibrary.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/enduser")
public class EndUserController {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private EndUserRepository endUserRepository;

    @ModelAttribute("movies")
    public Iterable<Movie> findMovies(Principal principal){
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
        EndUser userFromDb = endUserRepository.findByUsername(principal.getName());
        return movies.stream().filter(movie -> movie.getEndUsersWishlist().contains(userFromDb)).toList();
    }
    @ModelAttribute("books")
    public Iterable<Book> findBooks(Principal principal){
        List<Book> books = (List<Book>) bookRepository.findAll();
        EndUser userFromDb = endUserRepository.findByUsername(principal.getName());
        return books.stream().filter(book -> book.getEndUsersWishlist().contains(userFromDb)).toList();
    }

    @GetMapping("/wishlist")
    public String MovieListWithFilter(Model model, Principal principal) {
        if(principal == null) return "redirect:/home";
        model.addAttribute("username", principal.getName());
        return "enduser/wishlist";
    }
    @PostMapping("/wishlist")
    public String movieEditPost(@PathVariable int id, Movie movie){
        movieRepository.save(movie);
        return "redirect:/moviedetails/" + id;
    }

}