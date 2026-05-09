package com.trips.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trips.models.Rol;
import com.trips.services.IRolService;

@Controller
@RequestMapping("/roles") 
public class RolController {

    @Autowired
    private IRolService serviceRoles;

    @GetMapping("/index") 
    public String mostrarIndex(Model model) {
        List<Rol> lista = serviceRoles.buscarTodo();
        model.addAttribute("roles", lista);
        return "roles"; 
    }
}