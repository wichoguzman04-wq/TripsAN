package com.trips.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trips.models.Trip;


@Controller

public class HomeController {
	
	
	@GetMapping("/")
	public String mostrarHome (Model model) {
		
		String trip = "Rapel en el Volcan";
		Date fechaPublicacion = new Date();
		double costo = 5.0;
		boolean vigente= true;

		model.addAttribute ("trip", trip); 
		model.addAttribute("fechaPublicacion", fechaPublicacion); 
		model.addAttribute ("costo", costo); 
		model.addAttribute ("vigente", vigente);
		
		return "home";
	}
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
	    List<Trip> lista = getTrips();
	    model.addAttribute("trips", lista);
	    return "tabla";
	}
	
	@GetMapping("/listado")
    public String mostrarListado(Model model) {
        model.addAttribute("listadoTrips", getTrips());
        return "listado";
    }

	private List<Trip> getTrips() {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    List<Trip> lista = new LinkedList<Trip>();
	    try {
	        Trip trip1 = new Trip();
	        trip1.setId(1);
	        trip1.setNomTrip("Rapel en Volcatenango");
	        trip1.setDescripcion("Hacer rapel en los circuitos de Volcatenango");
	        trip1.setFecha(sdf.parse("10-05-2022"));
	        trip1.setCosto(5.0);
	        trip1.setDestacado(1);

	        Trip trip2 = new Trip();
	        trip2.setId(2);
	        trip2.setNomTrip("Deslizadero en El picnic");
	        trip2.setDescripcion("Deslizarte en un divertido tobogan sobre la colina");
	        trip2.setFecha(sdf.parse("10-05-2022"));
	        trip2.setCosto(5.0);
	        trip2.setDestacado(1);

	        Trip trip3 = new Trip();
	        trip3.setId(3);
	        trip3.setNomTrip("Comida y Flores");
	        trip3.setDescripcion("Disfrutar de un amplio jardin");
	        trip3.setFecha(sdf.parse("10-05-2022"));
	        trip3.setCosto(1.0);
	        trip3.setDestacado(0); 

	        Trip trip4 = new Trip();
	        trip4.setId(4);
	        trip4.setNomTrip("Caminatas");
	        trip4.setDescripcion("Disfruta hacer senderismo por las montañas chalatecas");
	        trip4.setFecha(sdf.parse("01-02-2022"));
	        trip4.setCosto(1.0);
	        trip4.setDestacado(0);

	        lista.add(trip1);
	        lista.add(trip2);
	        lista.add(trip3);
	        lista.add(trip4);

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return lista;
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Trip trip = new Trip();
		trip.setNomTrip("Rapel en Volcatenango");
		trip.setDescripcion("Aventa rapel en un circuito conectado en las...");
		trip.setFecha(new Date());
		trip.setCosto(10.0);
		model.addAttribute("trip" , trip);
		
		return "detalle";
	}
	
	
}
