package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.ProductionCompany;
import be.thomasmore.medialibrary.repositories.EndUserRepository;
import be.thomasmore.medialibrary.repositories.ProductionCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ProductionCompanyController {

    @Autowired
    private ProductionCompanyRepository productionCompanyRepository;
    @Autowired
    private EndUserRepository endUserRepository;

    @GetMapping({"/productioncompanydetails/{id}", "/productioncompanydetails", "/productioncompanydetails/"})
    public String productionCompanydetails(Model model, @PathVariable(required = false) Integer id, Principal principal) {

        if (id == null) return "productioncompanydetails";
        Optional<ProductionCompany> productionCompanyFromDb = productionCompanyRepository.findById(id);

        if (productionCompanyFromDb.isPresent()){
            Optional<ProductionCompany> nextproductionCompanyFromDb = productionCompanyRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextproductionCompanyFromDb.isEmpty())
                nextproductionCompanyFromDb = productionCompanyRepository.findFirstByOrderByIdAsc();
            Optional<ProductionCompany> prevproductionCompanyFromDb = productionCompanyRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (prevproductionCompanyFromDb.isEmpty())
                prevproductionCompanyFromDb = productionCompanyRepository.findFirstByOrderByIdDesc();

            model.addAttribute("nextId", nextproductionCompanyFromDb.get().getId());
            model.addAttribute("prevId", prevproductionCompanyFromDb.get().getId());
            model.addAttribute("productionCompany", productionCompanyFromDb.get());
            model.addAttribute("movies", productionCompanyFromDb.get().getMovies()); //to allow use of card fragment
            if(principal != null) model.addAttribute("currentUser", endUserRepository.findByUsername(principal.getName()));
        }

        return "productioncompanydetails";
    }

}