package com.rosillo.sisgestion.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class MainController {
	@GetMapping("/gestion")
    public String getGestion(Model model) {
		return "infraccion";
	}
	
}
