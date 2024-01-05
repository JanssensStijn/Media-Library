package be.thomasmore.medialibrary.controllers;

import be.thomasmore.medialibrary.model.EndUser;
import be.thomasmore.medialibrary.model.Movie;
import be.thomasmore.medialibrary.repositories.EndUserRepository;
import ch.qos.logback.core.model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private EndUserRepository endUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @GetMapping({"/login"})
    public String login(Principal principal) {
        if(principal != null) return "redirect:/home";
        return "user/login";
    }

    @GetMapping({"/logout"})
    public String logout(Principal principal) {
        if(principal == null) return "redirect:/home";
        return "user/logout";
    }

    @GetMapping({"/signup"})
    public String signup(Principal principal) {
        if(principal != null) return "redirect:/home";
        return "user/signup";
    }

    @PostMapping({"/signup"})
    public String signupPost (
            Principal principal,
            HttpServletRequest request,
            @RequestParam String name,
            @RequestParam String username,
            @RequestParam String password1,
            @RequestParam String password2) throws ServletException {
        if (principal != null) return "redirect:/home";
        if (username == null || username.isBlank()) return "redirect:/user/signup";
        if (jdbcUserDetailsManager.userExists(username)) return "redirect:/user/signup";
        if (!password1.equals(password2)) return "redirect:/user/signup";

        UserDetails user = org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(passwordEncoder.encode(password1))
                .authorities("USER")
                .build();
        jdbcUserDetailsManager.createUser(user);

        EndUser newEndUser = new EndUser();
        newEndUser.setName(name);
        newEndUser.setUsername(username);
        endUserRepository.save(newEndUser);

        //log in after signing up
        request.login(username, password1);

        return "redirect:/home";
    }
}
