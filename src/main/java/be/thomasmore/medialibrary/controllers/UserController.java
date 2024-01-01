package be.thomasmore.medialibrary.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping({"/login"})
    public String login(Model model, Principal principal) {
        if(principal != null) return "redirect:/home";
        return "user/login";
    }

    @GetMapping({"/logout"})
    public String logout(Model model, Principal principal) {
        if(principal == null) return "redirect:/home";
        return "user/logout";
    }
}
