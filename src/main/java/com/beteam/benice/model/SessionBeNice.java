package com.beteam.benice.model;

import java.io.Serializable;
import java.util.List;

public class SessionBeNice implements Serializable{

	private static final long serialVersionUID = 1L;


	private Long usuario_id;
	

	private String userName;
	

	private String password;
	

	private String nombre;
	

	private String correo;


	public Long getUsuario_id() {
		return usuario_id;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}


	public String getNombre() {
		return nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}

	

}

