package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.*;
import be.thomasmore.medialibrary.repositories.*;
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
    private ActorRepository actorRepository;
    @Autowired
    private GenreRepository genreRepository;

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
    public String movieEdit(Model model) {
        getAllFromRepos(model);
        return "admin/movieedit";
    }

    @PostMapping("/movieedit/{id}")
    public String movieEditPost(Model model,
                                @PathVariable int id,
                                @RequestParam(required = false) MultipartFile image,
                                @Valid Movie movie,
                                BindingResult bindingResult) throws IOException{
        if(bindingResult.hasErrors()){
            getAllFromRepos(model);
            return "admin/movieedit";
        }
        if(!image.isEmpty()) {
            movie.setImageUrl(uploadImage(image, "movie" + movie.getId())); //overwrite old image independent of changes to the movie
        }
        movieRepository.save(movie);
        return "redirect:/moviedetails/" + id;
    }

    @GetMapping({"/movienew"})
    public String movieNew(Model model) {
        getAllFromRepos(model);
        return "admin/movienew";
    }

    @PostMapping("/movienew")
    public String movieNewPost(Model model,
                               @RequestParam(required = false) MultipartFile image,
                               @Valid Movie movie,
                               BindingResult bindingResult) throws IOException{
        if(bindingResult.hasErrors()){
            getAllFromRepos(model);
            return "admin/movienew";
        }

        Movie newMovie = movieRepository.save(movie); //save to create unique id usable for firebase

        if(!image.isEmpty()) {
            movie.setImageUrl(uploadImage(image, "movie" + newMovie.getId())); //add unique id to image name
        }

        movieRepository.save(movie); //save imageUrl containing specific id
        return "redirect:/moviedetails/" + newMovie.getId();
    }

    public String uploadImage(MultipartFile multipartFile, String uniqueName) throws IOException{
        final String filename = multipartFile.getOriginalFilename();
        final File fileToUpload = new File(filename);
        FileOutputStream fos = new FileOutputStream(fileToUpload);
        fos.write(multipartFile.getBytes());
        fos.close();
        final String urlToFirebase = googleService.toFirebase(fileToUpload, uniqueName);
        fileToUpload.delete();
        return urlToFirebase;
    }


    private void getAllFromRepos(Model model) {
        List<Producer> optionalProducers = (List<Producer>) producerRepository.findAll();
        if(!optionalProducers.isEmpty()) model.addAttribute("allProducers", optionalProducers);
        List<ProductionCompany> optionalProductionCompanies = (List<ProductionCompany>) productionCompanyRepository.findAll();
        if(!optionalProductionCompanies.isEmpty()) model.addAttribute("allProductionCompanies", optionalProductionCompanies);
        List<Actor> optionalActors = (List<Actor>) actorRepository.findAll();
        if(!optionalActors.isEmpty()) model.addAttribute("allActors", optionalActors);
        List<Genre> optionalGenres = (List<Genre>) genreRepository.findAll();
        if (!optionalGenres.isEmpty()) model.addAttribute("allGenres", optionalGenres.stream().filter(genre -> genre.getGenreFor().equals("movie")));
    }
}