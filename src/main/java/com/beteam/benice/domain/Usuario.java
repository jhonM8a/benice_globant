package com.beteam.benice.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "usuario_id")
	private Long usuario_id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password_")
	private String password;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "correo")
	private String correo;
	
	@OneToMany(mappedBy = "usuarios")
    private List<Publicacion> publicaciones;
	
	@ManyToMany
	@JoinTable(
	  name = "likes", 
	  joinColumns = @JoinColumn(name = "publicacion_id", referencedColumnName = "publicacion_id"), 
	  inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"))
	private List<Publicacion> like_publicaciones;

	public List<Publicacion> getLikePublicaciones() {
		return like_publicaciones;
	}

	public void setLikePublicaciones(List<Publicacion> likePublicaciones) {
		this.like_publicaciones = likePublicaciones;
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
