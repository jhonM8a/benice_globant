package com.beteam.benice.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.beteam.benice.dao.UsuarioDao;
import com.beteam.benice.domain.Like;
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

	@Override
	public Long createLikeUser(Like likeUserRequest) {
		
		Session session = getSession();
		session.beginTransaction();

		getSession().save(likeUserRequest);

        session.getTransaction().commit();
        session.close();
        return (long) 1;		
	}

	@Override
	public Long deleteLikeUser(Like likeUserRequest) {
		Session session = getSession();
		session.beginTransaction();

		getSession().delete(likeUserRequest);

        session.getTransaction().commit();
        session.close();
        	
        return (long) 1;
	}
	
	
	

}
