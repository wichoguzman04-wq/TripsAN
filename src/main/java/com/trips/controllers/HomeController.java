package com.trips.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String mostrarHome (Model model) {
		
		String trip = "Rapel en el volcan";
		Date fechaPublicacion = new Date();
		double costo = 5.0;
		boolean vigente = true;
		
		model.addAttribute("trip", trip);
		model.addAttribute("fechaPublicacion", fechaPublicacion);
		model.addAttribute("Costo", costo);
		model.addAttribute("vigente", vigente);		
		return "Home";
		
	}
}
