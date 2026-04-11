package com.trips.controllers;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String mostrarHome (Model model) {
		

		return "Home";
		
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		
		List<String> lista = new LinkedList<String>();
		lista.add("En la montana");
		lista.add("En la ciudad");
		lista.add("En los pueblos");
		lista.add("En las playas");
		
		model.addAttribute("listadoTrips", lista);
		
		return "listado";
		
	}
	
	
	
}
