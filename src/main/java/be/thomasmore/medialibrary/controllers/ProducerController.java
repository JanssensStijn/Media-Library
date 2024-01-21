package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.Producer;
import be.thomasmore.medialibrary.repositories.ProducerRepository;
import be.thomasmore.medialibrary.repositories.EndUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ProducerController {

    @Autowired
    private ProducerRepository producerRepository;
    @Autowired
    private EndUserRepository endUserRepository;

    @GetMapping({"/producerdetails/{id}", "/producerdetails", "/producerdetails/"})
    public String producerdetails(Model model, @PathVariable(required = false) Integer id, Principal principal) {

        if (id == null) return "producerdetails";
        Optional<Producer> producerFromDb = producerRepository.findById(id);

        if (producerFromDb.isPresent()){
            Optional<Producer> nextproducerFromDb = producerRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextproducerFromDb.isEmpty())
                nextproducerFromDb = producerRepository.findFirstByOrderByIdAsc();
            Optional<Producer> prevproducerFromDb = producerRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (prevproducerFromDb.isEmpty())
                prevproducerFromDb = producerRepository.findFirstByOrderByIdDesc();

            model.addAttribute("nextId", nextproducerFromDb.get().getId());
            model.addAttribute("prevId", prevproducerFromDb.get().getId());
            model.addAttribute("producer", producerFromDb.get());
            model.addAttribute("movies", producerFromDb.get().getMovies()); //to allow use of card fragment
            if(principal != null) model.addAttribute("currentUser", endUserRepository.findByUsername(principal.getName()));
        }

        return "producerdetails";
    }

}