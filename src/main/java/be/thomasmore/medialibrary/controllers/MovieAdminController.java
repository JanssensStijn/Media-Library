package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.Movie;
import be.thomasmore.medialibrary.model.Producer;
import be.thomasmore.medialibrary.model.ProductionCompany;
import be.thomasmore.medialibrary.repositories.MovieRepository;
import be.thomasmore.medialibrary.repositories.ProducerRepository;
import be.thomasmore.medialibrary.repositories.ProductionCompanyRepository;
import be.thomasmore.medialibrary.services.GoogleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

    @Autowired
    private GoogleService googleService;

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
        if(!optionalProducers.isEmpty()) model.addAttribute("allProducers", optionalProducers);
        List<ProductionCompany> optionalProductionCompanies = (List<ProductionCompany>) productionCompanyRepository.findAll();
        if(!optionalProductionCompanies.isEmpty()) model.addAttribute("allProductionCompanies", optionalProductionCompanies);
        return "admin/movieedit";
    }

    @PostMapping("/movieedit/{id}")
    public String movieEditPost(@PathVariable int id,
                                @Valid Movie movie,
                                @RequestParam(required = false) MultipartFile image,
                                BindingResult bindingResult) throws IOException{
        if(bindingResult.hasErrors()){
            return "admin/movieedit/" + id;
        }
        movie.setImageUrl(uploadImage(image, movie.getImdb()));
        movieRepository.save(movie);
        return "redirect:/moviedetails/" + id;
    }

    @GetMapping({"/movienew"})
    public String movieNew(Model model) {
        List<Producer> optionalProducers = (List<Producer>) producerRepository.findAll();
        if(!optionalProducers.isEmpty()) model.addAttribute("allProducers", optionalProducers);
        List<ProductionCompany> optionalProductionCompanies = (List<ProductionCompany>) productionCompanyRepository.findAll();
        if(!optionalProductionCompanies.isEmpty()) model.addAttribute("allProductionCompanies", optionalProductionCompanies);
        return "admin/movienew";
    }

    @PostMapping("/movienew")
    public String movieNewPost(Model model,
                               @Valid Movie movie,
                               @RequestParam(required = false) MultipartFile image,
                               BindingResult bindingResult) throws IOException{
        if(bindingResult.hasErrors()){
            model.addAttribute("allProducers", producerRepository.findAll());
            model.addAttribute("allProductionCompanies", productionCompanyRepository.findAll());
            return "admin/movienew";
        }
        if(!image.isEmpty()) {
            googleService.deleteFromFirebase(movie.getImdb());
            movie.setImageUrl(uploadImage(image, movie.getImdb()));
        }

        Movie newMovie = movieRepository.save(movie);
        return "redirect:/moviedetails/" + newMovie.getId();
    }

    private String uploadImage(MultipartFile multipartFile, String uniqueName) throws IOException{
        final String filename = multipartFile.getOriginalFilename();
        final File fileToUpload = new File(filename);
        FileOutputStream fos = new FileOutputStream(fileToUpload);
        fos.write(multipartFile.getBytes());
        final String urlToFirebase = googleService.toFirebase(fileToUpload, uniqueName);
        fileToUpload.delete();
        return urlToFirebase;
    }

}