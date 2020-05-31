package com.beteam.benice.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "publicaciones")
public class Publicacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "publicacion_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long publicacion_id;
	
	@Column(name = "descripcion")
	private String descripcion;


	@Column(name = "imagen_url")
	private String imagen_url;
	
	@Column(name = "usuario_id", nullable=false)
	private long usuario_id;
	
	@Column(name = "fecha_registro", nullable=false)
	private Date fecha_registro;
	
	@JsonBackReference
	@ManyToOne(optional=false)
    @JoinColumn(name = "usuario_id",insertable=false, updatable=false)
	private Usuario usuario;

	@Column(name = "tema_id", nullable=false)
	private long tema_id;
	
	//@JsonManagedReference
	@ManyToOne(optional=false)
	@JsonIgnore
    @JoinColumn(name = "tema_id", insertable=false, updatable=false)
	private Tema tema;
	
	@Column(name = "ubicacion_id", nullable=false)
	private long ubicacion_id;
	
	//@JsonManagedReference
	@ManyToOne(optional=false)
	@JsonIgnore
    @JoinColumn(name = "ubicacion_id", insertable=false, updatable=false)
	private Ubicacion ubicacion;
		
	


	
	
	@ManyToMany
	@JoinTable(
	  name = "likes", 
	  joinColumns = @JoinColumn(name = "publicacion_id", referencedColumnName = "publicacion_id"), 
	  inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"))
	 @JsonIgnore
	private Set<Usuario> like_usuarios;
	
	public Set<Usuario> getLike_usuarios() {
		return like_usuarios;
	}
	
	public void setLike_usuarios(Set<Usuario> like_usuarios) {
		this.like_usuarios = like_usuarios;
	}	
		
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

	public long getTema_id() {
		return tema_id;
	}

	public void setTema_id(long tema_id) {
		this.tema_id = tema_id;
	}

	public long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public long getUbicacion_id() {
		return ubicacion_id;
	}

	public void setUbicacion_id(long ubicacion_id) {
		this.ubicacion_id = ubicacion_id;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	
	

}
