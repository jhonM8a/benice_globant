package com.beteam.benice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beteam.benice.dao.UsuarioDao;
import com.beteam.benice.domain.Publicacion;
import com.beteam.benice.domain.Usuario;
import com.beteam.benice.model.SessionBeNice;
import com.beteam.benice.model.UserAuthRequest;
import com.beteam.benice.service.UserService;

@Service
public class UserServieImpl implements UserService{
	
	@Autowired
	UsuarioDao usuarioDao;
	
	public SessionBeNice getDataUser(UserAuthRequest userRequest) {
		SessionBeNice sessionBeNice = new SessionBeNice();
		
		Usuario usuario = usuarioDao.getUsuarioByUserName(userRequest.getUser(), userRequest.getPassword());
		sessionBeNice.setName(usuario.getNombre());
		
		return sessionBeNice;
	}

	@Override
	public List<Publicacion> getPublicaciones() {
		

		List<Publicacion>   publicaciones = usuarioDao.getPubicaciones();
		
		
		return null;
	}
}
