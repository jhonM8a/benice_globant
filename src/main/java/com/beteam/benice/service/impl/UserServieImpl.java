package com.beteam.benice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beteam.benice.dao.UsuarioDao;
import com.beteam.benice.domain.Publicacion;
import com.beteam.benice.domain.Usuario;
import com.beteam.benice.model.UserAuthRequest;
import com.beteam.benice.service.UserService;

@Service
public class UserServieImpl implements UserService{
	
	@Autowired
	UsuarioDao usuarioDao;
	
	public Usuario getDataUser(UserAuthRequest userRequest) {
		
		Usuario usuario = usuarioDao.getUsuarioByUserName(userRequest.getUser(), userRequest.getPassword());
		
		return usuario;
	}

	@Override
	public List<Publicacion> getPublicaciones() {
		

		List<Publicacion>   publicaciones = usuarioDao.getPubicaciones();
		
		return publicaciones;
	}

	@Override
	public Long createPublication(Publicacion publicacionRequest) {
			
		Long request = usuarioDao.createPublicacion(publicacionRequest);
	
		return request;
	}

	@Override
	public void updateUser(Usuario usuario) {
				
		usuarioDao.updateUsuario(usuario);
				
	}

	@Override
	public List<Publicacion> getHistoryByUser(Long usuario_id) {
		
		List<Publicacion> publicacionesDomain = usuarioDao.getHistoryByUser(usuario_id);
		
		return publicacionesDomain;
	}

	@Override
	public void createUser(Usuario usuario) {

		usuarioDao.createUser(usuario);
		
	}

	@Override
	public void deletePublicationById(Long publicacion_id) {
		
		Publicacion publicacion = usuarioDao.getPublicacionById(publicacion_id);
		if(publicacion!=null) {
			System.out.println(publicacion.getUbicacion_id());
			usuarioDao.deletePublicacion(publicacion);
		}
		
	}
}
