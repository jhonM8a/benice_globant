package com.beteam.benice.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Like implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "publicacion_id", nullable=false)
	private Long publicacion_id;
	
	@Id
	@Column(name = "usuario_id", nullable=false)
	private Long usuario_id;
	
	public Long getPublicacion_id() {
		return publicacion_id;
	}

	public void setPublicacion_id(Long publicacion_id) {
		this.publicacion_id = publicacion_id;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}
	
}
