package com.trips.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trips.models.Trip;
import com.trips.services.ITripServices;

@Controller
@RequestMapping("/trips")
public class TripController {

	@Autowired
	private ITripServices servicTrip;

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idTrip, Model model) {
		System.out.println("idTrip es " + idTrip);
		model.addAttribute("id", idTrip);
		return "mensaje";
	}

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idTrip, Model model) {
		Trip trip = servicTrip.buscarPorId(idTrip);
		model.addAttribute("trip", trip);
		return "trips/detalle";
	}

	@GetMapping("/create")
	public String crear(Trip trip) { 
	    return "trips/formTrip";
	}
	
	@PostMapping("/save")
	public String guardar(Trip trip, BindingResult result, RedirectAttributes attributes) {
	    
	    if (result.hasErrors()) {
	        return "trips/formTrip";
	    }
	    
	    servicTrip.guardar(trip);
	    
	    attributes.addFlashAttribute("msg", "¡Registro Guardado con Éxito!");
	    return "redirect:/trips/index";
	}

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
	    List<Trip> lista = servicTrip.buscarTodo(); 
	    model.addAttribute("listadoTrips", lista); 
	    return "listado"; 
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}