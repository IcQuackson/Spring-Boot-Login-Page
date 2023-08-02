package com.capgemini.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private final UserServiceImpl userService;

    @Autowired
    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }
	
	@RequestMapping("/login")
	public String showLoginPage() {
		return "index.html"; 
	}

	@PostMapping("/login")
	public String processLogin(@RequestParam("username") String username, 
                               @RequestParam("password") String password) {
		
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		if (userService.isValidUser(username, password)) {
			System.out.println("Valid username and password");
			return "redirect:/login_success.html";
		}
		else {
			System.out.println("Invalid username or password");
			return "redirect:/login?error";
		}
	}
}
