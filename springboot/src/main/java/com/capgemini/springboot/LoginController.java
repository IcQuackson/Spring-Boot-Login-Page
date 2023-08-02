package com.capgemini.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String showLoginPage() {
		return "index.html"; 
	}

	@PostMapping("/login")
	public String processLogin(@RequestParam("username") String username, 
                               @RequestParam("password") String password) {
		if ("admin".equals(username) && "admin".equals(password)) {
			return "redirect:/login_success.html";
		}
		else {
			return "redirect:/login?error";
		}
	}
}
