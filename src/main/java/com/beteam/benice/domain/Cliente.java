package com.beteam.benice.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "clie_id")
	private Long clieId;
	
	@Column(name = "activo")
	private String activo;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "telefono")
	private String telefono;
	
	
	@Column(name = "usu_creador")
	private String usuCreador;
	
	@Column(name = "usu_modificador")
	private String usuModificador;
	
	@Column(name = "fecha_creacion")
	private Timestamp fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Timestamp fechaModificacion;

	@Column(name = "tdoc_id")
	private Long tdocId;
	
	public Cliente() {
	}

	public Long getClieId() {
		return this.clieId;
	}

	public void setClieId(Long clieId) {
		this.clieId = clieId;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsuCreador() {
		return this.usuCreador;
	}

	public void setUsuCreador(String usuCreador) {
		this.usuCreador = usuCreador;
	}

	public String getUsuModificador() {
		return this.usuModificador;
	}

	public void setUsuModificador(String usuModificador) {
		this.usuModificador = usuModificador;
	}

	public Long getTdocId() {
		return tdocId;
	}

	public void setTdocId(Long tdocId) {
		this.tdocId = tdocId;
	}


}