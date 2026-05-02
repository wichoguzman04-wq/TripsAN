package com.trips.models;

import java.time.LocalDate;

public class Rol {
	
	    private Integer id;
	    private String nombre;
	    private String descripcion;
	    private boolean estado;
	    private LocalDate fechaCreacion;

	    public Rol() {}

	    public Integer getId() { return id; }
	    public void setId(Integer id) { this.id = id; }
	    public String getNombre() { return nombre; }
	    public void setNombre(String nombre) { this.nombre = nombre; }
	    public String getDescripcion() { return descripcion; }
	    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	    public boolean isEstado() { return estado; }
	    public void setEstado(boolean estado) { this.estado = estado; }
	    public LocalDate getFechaCreacion() { return fechaCreacion; }
	    public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; }
	}
