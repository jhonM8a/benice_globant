package com.beteam.benice.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "temas")
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "tema_id")
	private Long tema_id;
	
	@Column(name = "titulo")
	private String titulo;

	@Column(name = "descripcion")
	private String descripcion;
	
	//@JsonBackReference
	@OneToMany(mappedBy = "tema")
    private List<Publicacion> publicaciones;
	

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Long getTema_id() {
		return tema_id;
	}

	public void setTema_id(Long tema_id) {
		this.tema_id = tema_id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
