package com.capgemini.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.springboot.entities.User;
import com.capgemini.springboot.repositories.UserRepository;

@Controller
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_page.html";
    }

    @PostMapping("/signup")
    public String processSignupForm(@ModelAttribute User user) {
		if (userRepository.findByUsername(user.getUsername()) != null) {
			return "redirect:signup_page.html?error";
		}
		if (userRepository.findByEmail(user.getEmail()) != null) {
			return "redirect:signup_page.html?error";
		}
        // Save the user to the database
        userRepository.save(user);

        // Redirect to the login page or any other page after successful signup
        return "redirect:signup_success.html";
    }
}