package com.beteam.benice.model;

import java.io.Serializable;

public class Publication implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private String Description;
	
	private String tema;
	
	private String imagen;
	
	private Long point;
	
	private String ubicacion;
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
}
