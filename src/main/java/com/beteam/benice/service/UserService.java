package com.beteam.benice.service;

import java.util.List;

import com.beteam.benice.domain.Publicacion;
import com.beteam.benice.model.Publication;
import com.beteam.benice.model.SessionBeNice;
import com.beteam.benice.model.UserAuthRequest;

public interface UserService {

	public SessionBeNice getDataUser(UserAuthRequest user);
	
	public List<Publicacion> getPublicaciones();

	public Object createPublication(Publicacion publicacionRequest);
}
