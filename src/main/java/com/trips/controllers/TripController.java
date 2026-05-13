package com.trips.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        System.err.println("Trip: " + trip);
        model.addAttribute("trip" , trip);
        return "trips/detalle";
    }
    
    @GetMapping("/create")
    public String crear() {
        return "trips/formTrip"; // 
    }
    @PostMapping("/save")
    public String guardar(@RequestParam("nombre") String nombre, 
                          @RequestParam("descripcion") String descripcion,
                          @RequestParam("estatus") String estatus,
                          @RequestParam("fecha") String fecha,
                          @RequestParam("destacado") int destacado,
                          @RequestParam("costo") double costo,
                          @RequestParam("detalles") String detalles) {
        
        System.out.println("Nombre: " + nombre); // 
        System.out.println("Descripcion: " + descripcion); // 
        System.out.println("fecha: " + fecha); // 
        System.out.println("costo: " + costo); // 
        System.out.println("Detalles: " + detalles); // 
        return "trips/listTrips"; 
    }
}