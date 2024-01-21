package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.Actor;
import be.thomasmore.medialibrary.repositories.EndUserRepository;
import be.thomasmore.medialibrary.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private EndUserRepository endUserRepository;

    @GetMapping({"/actordetails/{id}", "/actordetails", "/actordetails/"})
    public String actordetails(Model model, @PathVariable(required = false) Integer id, Principal principal) {

        if (id == null) return "actordetails";
        Optional<Actor> actorFromDb = actorRepository.findById(id);

        if (actorFromDb.isPresent()){
            Optional<Actor> nextactorFromDb = actorRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextactorFromDb.isEmpty())
                nextactorFromDb = actorRepository.findFirstByOrderByIdAsc();
            Optional<Actor> prevactorFromDb = actorRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (prevactorFromDb.isEmpty())
                prevactorFromDb = actorRepository.findFirstByOrderByIdDesc();

            model.addAttribute("nextId", nextactorFromDb.get().getId());
            model.addAttribute("prevId", prevactorFromDb.get().getId());
            model.addAttribute("actor", actorFromDb.get());
            model.addAttribute("movies", actorFromDb.get().getMovies()); //to allow use of card fragment
            if(principal != null) model.addAttribute("currentUser", endUserRepository.findByUsername(principal.getName()));
        }

        return "actordetails";
    }

}