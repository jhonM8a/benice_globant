package com.beteam.benice.service;

import java.util.List;

import com.beteam.benice.domain.Publicacion;
import com.beteam.benice.domain.Usuario;
import com.beteam.benice.model.UserAuthRequest;

public interface UserService {

	public Usuario getDataUser(UserAuthRequest user);


	public void updateUser(Usuario usuario);

	public List<Publicacion> getHistoryByUser(Long usuario_id);

	public void createUser(Usuario usuario);

	public List<Publicacion> getPublicaciones();

	public Object createPublication(Publicacion publicacionRequest);
}
