package edu.mum.cs.cs425.fsap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}
}
