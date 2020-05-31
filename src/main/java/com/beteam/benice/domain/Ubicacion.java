package com.beteam.benice.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ubicaciones")
public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ubicacion_id")
	private Long ubicacion_id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "ubicacion")
    private List<Publicacion> publicaciones;

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Long getUbicacion_id() {
		return ubicacion_id;
	}

	public void setUbicacion_id(Long ubicacion_id) {
		this.ubicacion_id = ubicacion_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
