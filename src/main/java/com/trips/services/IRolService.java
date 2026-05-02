package com.trips.services;

import java.util.List;

import com.trips.models.Rol;

public interface IRolService {
	
	Rol buscarPorId(Integer id);
	List<Rol> buscarTodo();
	<buscarTodos> List<Rol> buscarTodos();
	
}
