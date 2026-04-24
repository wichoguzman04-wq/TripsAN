package com.trips.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/trips")
public class TripController {

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idTrip, Model model) {
	    System.out.println("idTrip es " + idTrip);
	    model.addAttribute("id", idTrip);
	    
	    return "mensaje";
	}
}