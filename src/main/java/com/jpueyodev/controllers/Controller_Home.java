package com.jpueyodev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Home {

	@GetMapping("/")
	public String showHomeWeb() {
		return "home";
	}
}
