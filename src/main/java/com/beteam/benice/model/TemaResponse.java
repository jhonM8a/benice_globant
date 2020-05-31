package com.beteam.benice.model;

public class TemaResponse {
	
	private Long tema_id;
	
	private String titulo;

	private String descripcion;

	public Long getTema_id() {
		return tema_id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setTema_id(Long tema_id) {
		this.tema_id = tema_id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
