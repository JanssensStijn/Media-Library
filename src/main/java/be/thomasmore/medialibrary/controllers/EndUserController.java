package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.*;
import be.thomasmore.medialibrary.repositories.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
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
        model.addAttribute("currentUser", endUserRepository.findByUsername(principal.getName()));
        return "enduser/wishlist";
    }
    @PostMapping("/wishlist/{type}/{id}")
    public String movieEditPost(Model model,@PathVariable String type,  @PathVariable int id, Principal principal, HttpServletRequest request){
        if(principal == null) return "redirect:/home";

        EndUser currentUser = endUserRepository.findByUsername(principal.getName());

        switch (type) {
            case "movie":
                Movie movie = movieRepository.findById(id).get();
                if (currentUser.getWishlistMovies().contains(movie)) currentUser.getWishlistMovies().remove(movie);
                else currentUser.getWishlistMovies().add(movie);
                break;
            case "book":
                Book book = bookRepository.findById(id).get();
                if (currentUser.getWishlistBooks().contains(book)) currentUser.getWishlistBooks().remove(book);
                else currentUser.getWishlistBooks().add(book);
                break;
        }


        endUserRepository.save(currentUser);

        //go back to the page where item was added to the wishlist
        String referer = request.getHeader("Referer");
        if (referer != null && !referer.isEmpty()) {
            // Redirect to the previous page
            return "redirect:" + referer;
        }
        // Default redirect if referer is not available or empty
        return "redirect:/home";


    }

}