package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.Author;
import be.thomasmore.medialibrary.repositories.AuthorRepository;
import be.thomasmore.medialibrary.repositories.EndUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Optional;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private EndUserRepository endUserRepository;

    @GetMapping({"/authordetails/{id}", "/authordetails", "/authordetails/"})
    public String authordetails(Model model, @PathVariable(required = false) Integer id, Principal principal) {

        if (id == null) return "authordetails";
        Optional<Author> authorFromDb = authorRepository.findById(id);

        if (authorFromDb.isPresent()){
            Optional<Author> nextauthorFromDb = authorRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextauthorFromDb.isEmpty())
                nextauthorFromDb = authorRepository.findFirstByOrderByIdAsc();
            Optional<Author> prevauthorFromDb = authorRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (prevauthorFromDb.isEmpty())
                prevauthorFromDb = authorRepository.findFirstByOrderByIdDesc();

            model.addAttribute("nextId", nextauthorFromDb.get().getId());
            model.addAttribute("prevId", prevauthorFromDb.get().getId());
            model.addAttribute("author", authorFromDb.get());
            model.addAttribute("books", authorFromDb.get().getBooks()); //to allow use of card fragment
            if(principal != null) model.addAttribute("currentUser", endUserRepository.findByUsername(principal.getName()));
        }

        return "authordetails";
    }

}