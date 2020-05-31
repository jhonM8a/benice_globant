package com.beteam.benice.dao;

import java.util.List;

import com.beteam.benice.domain.Like;
import com.beteam.benice.domain.Publicacion;
import com.beteam.benice.domain.Tema;
import com.beteam.benice.domain.Usuario;

public interface UsuarioDao {

	public Usuario getUsuarioByUserName(String usuerName, String password);

	public List<Publicacion> getPubicaciones(Usuario usuarioRequest);

	public void updateUsuario(Usuario usuarioDomain);

	public List<Publicacion> getHistoryByUser(Long usuario_id);

	public void createUser(Usuario usuarioDomain);

	public long createPublicacion(Publicacion publicacionRequest);

	public Publicacion getPublicacionById(Long publicacion_id);

	public void deletePublicacion(Publicacion publicacion);

	public Long createLikeUser(Like likeUserRequest);

	public Long deleteLikeUser(Like likeUserRequest);

	public List<Publicacion> getPublicacionesPorTema(Tema temaRequest);
}
