package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.*;
import be.thomasmore.medialibrary.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    private final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ProducerRepository producerRepository;
    @Autowired
    private ProductionCompanyRepository productionCompanyRepository;
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private EndUserRepository endUserRepository;

    @GetMapping({"/moviedetails/{id}", "/moviedetails", "/moviedetails/"})
    public String moviedetails(Model model, @PathVariable(required = false) Integer id, Principal principal) {

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
            if(principal != null)  model.addAttribute("currentUser", endUserRepository.findByUsername(principal.getName()));
        }

        return "moviedetails";
    }

    @GetMapping({"/movielist", "/movielist/"})
    public String MovieListWithFilter(Model model, Principal principal,
                                      @RequestParam(required = false) String title,
                                      @RequestParam(required = false) Integer yearOfRelease,
                                      @RequestParam(required = false) String genre,
                                      @RequestParam(required = false) String producer,
                                      @RequestParam(required = false) String productionCompany,
                                      @RequestParam(required = false) String[] actor,
                                      @RequestParam(required = false, defaultValue = "off") Boolean sorted) {

        if(actor == null) logger.info("value of actors: null");
            else logger.info("value of actors: " + Arrays.asList(actor));
        List<Movie> filteredMovies;
        if(sorted) filteredMovies = movieRepository.findByFilterSorted(title, yearOfRelease, genre, producer, productionCompany, Arrays.asList(actor));
        else filteredMovies = movieRepository.findByFilter(title, yearOfRelease, genre, producer, productionCompany, Arrays.asList(actor));

        model.addAttribute("titleFiltered" , title);
        model.addAttribute("yearOfReleaseFiltered", yearOfRelease);
        model.addAttribute("producerFiltered", producer);
        model.addAttribute("productionCompanyFiltered", productionCompany);
        model.addAttribute("actorFiltered", actor);
        model.addAttribute("genreFiltered", genre);
        model.addAttribute("sortedFiltered", sorted);
        model.addAttribute("numberOfMovies" , filteredMovies.size());
        model.addAttribute("movies", filteredMovies);
        model.addAttribute("yearsOfRelease", movieRepository.findDistinctYearsOfRelease());
        model.addAttribute("producers", producerRepository.findByOrderByNameAsc());
        model.addAttribute("productionCompanies",productionCompanyRepository.findByOrderByNameAsc());
        model.addAttribute("actors", actorRepository.findByOrderByNameAsc());
        model.addAttribute("genres", genreRepository.findByGenreForOrderByName("movie"));
        if(principal != null) model.addAttribute("currentUser", endUserRepository.findByUsername(principal.getName()));

        return "movielist";
    }
}