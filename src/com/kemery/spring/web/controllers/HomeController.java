package com.kemery.spring.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHome() {
		
		return "home";
	}	
}
