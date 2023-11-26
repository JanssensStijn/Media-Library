package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.Movie;
import be.thomasmore.medialibrary.repositories.MovieRepository;
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
public class MovieController {
    private Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping({"/moviedetails/{id}", "/moviedetails", "/moviedetails/"})
    public String moviedetails(Model model, @PathVariable(required = false) Integer id) {

        if (id == null) return "moviedetails";
        Optional<Movie> movieFromDb = movieRepository.findById(id);

        if (movieFromDb.isPresent()){
            Optional<Movie> nextMovieFromDb = movieRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextMovieFromDb.isEmpty()) //if no Movie id is higher, get the Movie with the lowest id
                nextMovieFromDb = movieRepository.findFirstByOrderByIdAsc();
            Optional<Movie> prevMovieFromDb = movieRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (prevMovieFromDb.isEmpty()) //if no Movie id is lower, get the Movie with the highest id
                prevMovieFromDb = movieRepository.findFirstByOrderByIdDesc();

            model.addAttribute("nextId", nextMovieFromDb.get().getId());
            model.addAttribute("prevId", prevMovieFromDb.get().getId());
            model.addAttribute("movie", movieFromDb.get());
        }

        return "moviedetails";
    }

    @GetMapping({"/movielist", "/movielist/",})
    public String movielist(Model model) {
        final Iterable<Movie> allMovies = movieRepository.findAll();
        final long numberOfMovies = movieRepository.count();
        model.addAttribute("numberOfMovies", numberOfMovies);
        model.addAttribute("movies", allMovies);
        model.addAttribute("showFilter", false);
        return "movielist";
    }

    @GetMapping({"/movielist/filter"})
    public String MovieListWithFilter(Model model,
                                      @RequestParam(required = false) Integer id,
                                      @RequestParam(required = false) String imdb,
                                      @RequestParam(required = false) String title,
                                      @RequestParam(required = false) String linkMoreInfo,
                                      @RequestParam(required = false) Integer yearOfRelease) {

        final List<Movie> allMovies = movieRepository.findByFilter(id,imdb, title, linkMoreInfo, yearOfRelease);

        model.addAttribute("idFiltered" , id);
        model.addAttribute("imdbFiltered" , imdb);
        model.addAttribute("titleFiltered" , title);
        model.addAttribute("yearOfReleaseFiltered", yearOfRelease);
        model.addAttribute("numberOfMovies" , allMovies.size());
        model.addAttribute("movies", allMovies);
        model.addAttribute("showFilter", true);
        return "movielist";
    }

}