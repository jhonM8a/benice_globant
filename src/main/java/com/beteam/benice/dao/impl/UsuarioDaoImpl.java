package com.beteam.benice.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.beteam.benice.dao.UsuarioDao;
import com.beteam.benice.domain.Like;
import com.beteam.benice.domain.Publicacion;
import com.beteam.benice.domain.Usuario;

@Repository
public class UsuarioDaoImpl extends AbstractSession implements UsuarioDao {

	@Override
	public Usuario getUsuarioByUserName(String usuerName, String password) {
		// TODO Auto-generated method stub
		return (Usuario) getSession().createQuery("from Usuario where username = :username and password_ = :password")
				.setParameter("username", usuerName).setParameter("password", password).uniqueResult();
	}

	@Override
	public List<Publicacion> getPubicaciones() {

		List<Publicacion> publicaciones = getSession().createQuery("from Publicacion").list();
		for (Publicacion publicacion : publicaciones) {
			
			long count_likes = (long) getSession().createQuery("select count(*) from Like where publicacion_id = :publicacion_id")
					.setParameter("publicacion_id", publicacion.getPublicacion_id()).uniqueResult();
			//long count_likes_ = 5;
					
			publicacion.setCount_likes(count_likes);
		}
		
		return publicaciones;
	}

	@Override
	public void updateUsuario(Usuario usuarioDomain) {

		Session session = getSession();
		session.beginTransaction();

		getSession().update(usuarioDomain);

		session.getTransaction().commit();
		session.close();

	}

	@Override
	public List<Publicacion> getHistoryByUser(Long usuario_id) {

		return getSession().createQuery("from Publicacion where usuario_id = :usuario_id")
				.setParameter("usuario_id", usuario_id).list();
	}

	@Override
	public void createUser(Usuario usuarioDomain) {
		getSession().save(usuarioDomain);
	}

	public long createPublicacion(Publicacion publicacionRequest) {

		return (long) getSession().save(publicacionRequest);

	}

	@Override
	public Publicacion getPublicacionById(Long publicacion_id) {

		return (Publicacion) getSession().createQuery("from Publicacion where publicacion_id = :publicacion_id")
				.setParameter("publicacion_id", publicacion_id).uniqueResult();
	}

	@Override
	public void deletePublicacion(Publicacion publicacion) {
		Session session = getSession();
		session.beginTransaction();

		session.delete(publicacion);

		session.getTransaction().commit();
		session.close();

	}

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
