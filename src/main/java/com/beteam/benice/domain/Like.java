package com.beteam.benice.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Like implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name = "publicacion_id")
	private Publicacion publicacion;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
