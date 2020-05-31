package com.beteam.benice.dao;

import java.util.List;

import com.beteam.benice.domain.Like;
import com.beteam.benice.domain.Publicacion;
import com.beteam.benice.domain.Usuario;

public interface UsuarioDao {
	
	public Usuario getUsuarioByUserName(String usuerName, String password);

	public List<Publicacion> getPubicaciones();

	public long createPublicacion(Publicacion publicacionRequest);

	public Long createLikeUser(Like likeUserRequest);

	public Long deleteLikeUser(Like likeUserRequest);
}
