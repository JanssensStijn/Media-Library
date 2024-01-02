package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.*;
import be.thomasmore.medialibrary.repositories.EndUserRepository;
import be.thomasmore.medialibrary.repositories.MovieRepository;
import be.thomasmore.medialibrary.repositories.ProducerRepository;
import be.thomasmore.medialibrary.repositories.ProductionCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ProducerRepository producerRepository;
    @Autowired
    private ProductionCompanyRepository productionCompanyRepository;
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
    public String MovieListWithFilter(Model model,
                                      @RequestParam(required = false) Integer id,
                                      @RequestParam(required = false) String imdb,
                                      @RequestParam(required = false) String title,
                                      @RequestParam(required = false) Integer yearOfRelease,
                                      @RequestParam(required = false) String producer,
                                      @RequestParam(required = false) String productionCompany,
                                      Principal principal) {

        final List<Movie> filteredMovies = movieRepository.findByFilter(id,imdb, title, yearOfRelease, producer, productionCompany);

        final Iterable<Movie> allMovies = movieRepository.findAll();
        final List<Producer> producers = (List<Producer>) producerRepository.findAll();
        final List<ProductionCompany> productionCompanies = (List<ProductionCompany>) productionCompanyRepository.findAll();


        ArrayList<Integer> yearsOfRelease = StreamSupport.stream(allMovies.spliterator(), false)
                .map(Movie::getYearOfRelease)
                .distinct().sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        yearsOfRelease.add(0, null);

        model.addAttribute("idFiltered" , id);
        model.addAttribute("imdbFiltered" , imdb);
        model.addAttribute("titleFiltered" , title);
        model.addAttribute("yearOfReleaseFiltered", yearOfRelease);
        model.addAttribute("producerFiltered", producer);
        model.addAttribute("productionCompanyFiltered", productionCompany);
        model.addAttribute("numberOfMovies" , filteredMovies.size());
        model.addAttribute("movies", filteredMovies);
        model.addAttribute("yearsOfRelease", yearsOfRelease);
        model.addAttribute("producers", producers);
        model.addAttribute("productionCompanies", productionCompanies);
        if(principal != null)  model.addAttribute("currentUser", endUserRepository.findByUsername(principal.getName()));

        return "movielist";
    }

}