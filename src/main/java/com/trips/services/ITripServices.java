package com.trips.services;

import java.util.List;

import com.trips.models.Trip;

public interface ITripServices {
	
	List<Trip> buscarTodo();
	Trip buscarPorId(Integer idTrip);
	
} 
