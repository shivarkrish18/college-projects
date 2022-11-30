package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;


@Controller
public class WelcomeController {

    @GetMapping(value = "/")
    public String showWelcomePage(ModelMap model) {
        model.put("name", getLoggedinUserName());
        return "welcome";
    }

    private String getLoggedinUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

}
