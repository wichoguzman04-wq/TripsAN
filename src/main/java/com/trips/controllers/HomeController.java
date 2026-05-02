package com.trips.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trips.models.Trip;
import com.trips.services.ITripServices;

@Controller
public class HomeController {

    @Autowired
    private ITripServices tripService;

    @GetMapping("/")
    public String mostrarHome(Model model) {
        List<Trip> lista = tripService.buscarTodo();
        model.addAttribute("trips", lista);
        return "home";
    }

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Trip> lista = tripService.buscarTodo();
        model.addAttribute("trips", lista);
        return "tabla";
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        model.addAttribute("listadoTrips", getTrips());
        return "listado";
    }

    @GetMapping("/detalle/{id}")
    public String mostrarDetalle(@PathVariable("id") int id, Model model) {
        Trip trip = new Trip();
        trip.setId(id);
        trip.setNomTrip("Rapel en Volcatenango");
        trip.setDescripcion("Aventa rapel en un circuito conectado en las...");
        trip.setFecha(new Date());
        trip.setCosto(10.0);

        model.addAttribute("trip", trip);

        return "trips/detalle";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTrip(@PathVariable("id") int id, Model model) {
        model.addAttribute("mensajeEliminado", "El Id trip " + id + " ha sido eliminado");
        return "mensaje";
    }

    @GetMapping("/mensaje")
    public String mostrarMensaje() {
        return "mensaje";
    }

    @GetMapping("/formCategoria")
    public String mostrarFormularioCategoria() {
        return "categoriasTrip/formCategoria";
    }

    @GetMapping("/listCategoria")
    public String mostrarListadoCategorias() {
        return "categoriasTrip/listCategoria";
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
            trip1.setImagen("trip01.png");

            Trip trip2 = new Trip();
            trip2.setId(2);
            trip2.setNomTrip("Deslizadero en El picnic");
            trip2.setDescripcion("Deslizarte en un divertido tobogan sobre la colina");
            trip2.setFecha(sdf.parse("10-05-2022"));
            trip2.setCosto(5.0);
            trip2.setDestacado(1);
            trip2.setImagen("trip02.png");

            Trip trip3 = new Trip();
            trip3.setId(3);
            trip3.setNomTrip("Comida y Flores");
            trip3.setDescripcion("Disfrutar de un amplio jardin");
            trip3.setFecha(sdf.parse("10-05-2022"));
            trip3.setCosto(1.0);
            trip3.setDestacado(0);
            trip3.setImagen("trip03.png");

            Trip trip4 = new Trip();
            trip4.setId(4);
            trip4.setNomTrip("Caminatas");
            trip4.setDescripcion("Disfruta hacer senderismo por las montañas chalatecas");
            trip4.setFecha(sdf.parse("01-02-2022"));
            trip4.setCosto(1.0);
            trip4.setDestacado(0);
            trip4.setImagen("no-image.png");

            lista.add(trip1);
            lista.add(trip2);
            lista.add(trip3);
            lista.add(trip4);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return lista;
    }

}