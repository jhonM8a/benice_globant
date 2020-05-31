package com.beteam.benice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beteam.benice.dao.UsuarioDao;
import com.beteam.benice.domain.Publicacion;
import com.beteam.benice.domain.Usuario;
import com.beteam.benice.model.Publication;
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
		
		List<Publication> publications = new ArrayList<>();
		
		for (Publicacion publicacion : publicaciones) {
			
			Publication publication = new Publication();
			publication.setDescription(publicacion.getDescripcion());
			publication.setImagen(publicacion.getImagen_url());
			publication.setTema(publicacion.getTema().getTitulo());
			publication.setUbicacion(publicacion.getUbicacion().getNombre());
			publication.setLikes(publicacion.getLike_usuarios().size());
			publication.setUsuario(publicacion.getUsuario().getNombre());
			publication.setUsuario_id(publicacion.getUsuario().getUsuario_id());
			publications.add(publication);
		}
		
		
		return publicaciones;
	}

	@Override
	public Long createPublication(Publicacion publicacionRequest) {
			
		Long request = usuarioDao.createPublicacion(publicacionRequest);
	
		return request;
	}
}
