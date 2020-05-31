package com.beteam.benice.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "publicaciones")
public class Publicacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "publicacion_id")
	private Long publicacion_id;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
    @JoinColumn(name = "tema_id")
	private Tema tema;
	
	@ManyToOne
    @JoinColumn(name = "ubicacion_id")
	private Ubicacion ubicacion;

	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToMany
	@JoinTable(
	  name = "likes", 
	  joinColumns = @JoinColumn(name = "publicacion_id", referencedColumnName = "publicacion_id"), 
	  inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"))
	 @JsonManagedReference
	private Set<Usuario> like_usuarios;
	
	public Set<Usuario> getLike_usuarios() {
		return like_usuarios;
	}
	
	public void setLike_usuarios(Set<Usuario> like_usuarios) {
		this.like_usuarios = like_usuarios;
	}

	@Column(name = "imagen_url")
	private String imagen_url;
	
		
	public Long getPublicacion_id() {
		return publicacion_id;
	}

	public void setPublicacion_id(Long publicacion_id) {
		this.publicacion_id = publicacion_id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen_url() {
		return imagen_url;
	}

	public void setImagen_url(String imagen_url) {
		this.imagen_url = imagen_url;
	}



	
	
	

}
