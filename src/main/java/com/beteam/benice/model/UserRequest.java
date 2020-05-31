package com.beteam.benice.model;

import java.io.Serializable;



public class UserRequest implements Serializable{
	

	private Long usuario_id;
	

	private String userName;
	

	private String password_;
	

	private String nombre;
	

	private String correo;


	public Long getUsuario_id() {
		return usuario_id;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword_() {
		return password_;
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


	public void setPassword_(String password_) {
		this.password_ = password_;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
