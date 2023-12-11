package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.Movie;
import be.thomasmore.medialibrary.model.Producer;
import be.thomasmore.medialibrary.model.ProductionCompany;
import be.thomasmore.medialibrary.repositories.MovieRepository;
import be.thomasmore.medialibrary.repositories.ProducerRepository;
import be.thomasmore.medialibrary.repositories.ProductionCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class MovieAdminController {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ProducerRepository producerRepository;
    @Autowired
    private ProductionCompanyRepository productionCompanyRepository;


    @ModelAttribute("movie")
    public Movie findMovie(@PathVariable(required = false) Integer id){
        if(id == null) return new Movie();
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isPresent()) return optionalMovie.get();
        return null;
    }

    @GetMapping({"/movieedit/{id}"})
    public String movieEdit(Model model, @PathVariable (required = false) Integer id) {
        List<Producer> optionalProducers = (List<Producer>) producerRepository.findAll();
        if(!optionalProducers.isEmpty()) model.addAttribute("producers", optionalProducers);
        List<ProductionCompany> optionalProductionCompanies = (List<ProductionCompany>) productionCompanyRepository.findAll();
        if(!optionalProductionCompanies.isEmpty()) model.addAttribute("productionCompanies", optionalProductionCompanies);
        return "admin/movieedit";
    }

    @PostMapping("/movieedit/{id}")
    public String movieEditPost(@PathVariable int id, Movie movie){
        //logger.info("findParty " + id + " -- new name=" + party.getName());
        movieRepository.save(movie);
        return "redirect:/moviedetails/" + id;
    }

    @GetMapping({"/partynew"})
    public String movieNew(Model model) {
        List<Movie> optionalVenues = (List<Movie>) movieRepository.findAll();
        if(!optionalVenues.isEmpty()) model.addAttribute("venues", optionalVenues);
        return "admin/partynew";
    }

    @PostMapping("/partynew")
    public String movieNewPost(Movie movie){
        Movie newParty = movieRepository.save(movie);
        return "redirect:/partydetails/" + newParty.getId();
    }

}