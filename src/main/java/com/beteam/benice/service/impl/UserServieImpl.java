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
import com.beteam.benice.model.UserRequest;
import com.beteam.benice.service.UserService;

@Service
public class UserServieImpl implements UserService{
	
	@Autowired
	UsuarioDao usuarioDao;
	
	public SessionBeNice getDataUser(UserAuthRequest userRequest) {
		SessionBeNice sessionBeNice = new SessionBeNice();
		
		Usuario usuario = usuarioDao.getUsuarioByUserName(userRequest.getUser(), userRequest.getPassword());
		
		sessionBeNice.setUsuario_id(usuario.getUsuario_id());
		sessionBeNice.setUserName(usuario.getUserName());
		sessionBeNice.setPassword(usuario.getPassword());
		sessionBeNice.setNombre(usuario.getNombre());
		sessionBeNice.setCorreo(usuario.getCorreo());
		
		return sessionBeNice;
	}

	@Override
	public List<Publication> getPublicaciones() {
		

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
		
		
		return publications;
	}

	@Override
	public void updateUser(UserRequest usuario) {
		
		Usuario usuarioDomain = new Usuario();
		
		usuarioDomain.setUsuario_id(usuario.getUsuario_id());
		usuarioDomain.setUserName(usuario.getUserName());
		usuarioDomain.setNombre(usuario.getNombre());
		usuarioDomain.setCorreo(usuario.getCorreo());
		usuarioDomain.setPassword(usuario.getPassword_());
		
		usuarioDao.updateUsuario(usuarioDomain);
				
	}

	@Override
	public List<Publication> getHistoryByUser(Long usuario_id) {
		
		List<Publicacion> publicacionesDomain = usuarioDao.getHistoryByUser(usuario_id);
		List<Publication> publicationResponses = new ArrayList<Publication>();
		
		for (Publicacion publication : publicacionesDomain) {
			
			Publication publicationResponse = new Publication();
			publicationResponse.setDescription(publication.getDescripcion());
			publicationResponse.setImagen(publication.getImagen_url());
			publicationResponse.setTema(publication.getTema().getTitulo());
			publicationResponse.setUbicacion(publication.getUbicacion().getNombre());
			publicationResponse.setLikes(publication.getLike_usuarios().size());
			publicationResponse.setUsuario(publication.getUsuario().getNombre());
			publicationResponse.setUsuario_id(publication.getUsuario().getUsuario_id());
			
			publicationResponses.add(publicationResponse);
		}
		
		return publicationResponses;
	}

	@Override
	public void createUser(UserRequest usuario) {
		Usuario usuarioDomain = new Usuario();
		
		usuarioDomain.setUserName(usuario.getUserName());
		usuarioDomain.setPassword(usuario.getPassword_());
		usuarioDomain.setNombre(usuario.getNombre());
		usuarioDomain.setCorreo(usuario.getCorreo());
	
		usuarioDao.createUser(usuarioDomain);
		
	}
}
