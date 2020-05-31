package com.beteam.benice.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.beteam.benice.dao.UsuarioDao;
import com.beteam.benice.domain.Publicacion;
import com.beteam.benice.domain.Usuario;

@Repository
public class UsuarioDaoImpl extends AbstractSession implements UsuarioDao{

	@Override
	public Usuario getUsuarioByUserName(String usuerName, String password) {
		// TODO Auto-generated method stub
		return (Usuario) getSession().createQuery("from Usuario where username = :username and password_ = :password").
				setParameter("username", usuerName)
				.setParameter("password", password) 
				.uniqueResult();
	}

	@Override
	public List<Publicacion> getPubicaciones() {
	
		return getSession().createQuery("from Publicacion").list();
	}

	@Override
	public long createPublicacion(Publicacion publicacionRequest) {
		
		return (long) getSession().save(publicacionRequest);
	
		
	}
	
	
	

}
