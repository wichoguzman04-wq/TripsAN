package com.trips.models;

public class Perfil {
	
	private Integer id;
	private String nomPerfil;
	private String descripcion;
	private boolean activo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomPerfil() {
		return nomPerfil;
	}
	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	


}
