package com.beteam.benice.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.beteam.benice.dao.UsuarioDao;
import com.beteam.benice.domain.Like;
import com.beteam.benice.domain.Publicacion;
import com.beteam.benice.domain.Tema;
import com.beteam.benice.domain.Usuario;

@Repository
public class UsuarioDaoImpl extends AbstractSession implements UsuarioDao {

	@Override
	public Usuario getUsuarioByUserName(String usuerName, String password) {
		// TODO Auto-generated method stub
		return (Usuario) getSession().createQuery("from Usuario where username = :username and password_ = :password ")
				.setParameter("username", usuerName).setParameter("password", password).uniqueResult();
	}

	@Override
	public List<Publicacion> getPubicaciones(Usuario usuarioRequest) {

		List<Publicacion> publicaciones = getSession().createQuery("from Publicacion order by fecha_registro desc").list();
		
		return getInfoAdicionalPublicaciones(usuarioRequest.getUsuario_id(),publicaciones);
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

		List<Publicacion> publicaciones = getSession().createQuery("from Publicacion where usuario_id = :usuario_id order by fecha_registro desc")
		.setParameter("usuario_id", usuario_id).list();
		
		return getInfoAdicionalPublicaciones(usuario_id, publicaciones);
	}

	@Override
	public void createUser(Usuario usuarioDomain) {
		getSession().save(usuarioDomain);
	}

	public long createPublicacion(Publicacion publicacionRequest) {

		publicacionRequest.setFecha_registro(new Date());
		
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

	@Override
	public List<Publicacion> getPublicacionesPorTema(Tema temaRequest) {
		
		
		List<Publicacion> publicaciones = getSession().createQuery("from Publicacion where tema_id = :tema_id order by fecha_registro desc")
											.setParameter("tema_id", temaRequest.getTema_id()).list();
		
		return getInfoAdicionalPublicaciones(temaRequest.getUsuario_logeado_id(), publicaciones);
	}
	
	private List<Publicacion> getInfoAdicionalPublicaciones(long usuario_id, List<Publicacion> publicaciones){
		
		Date date = new Date();
		for (Publicacion publicacion : publicaciones) {
			
			long count_likes = (long) getSession().createQuery("select count(*) from Like where publicacion_id = :publicacion_id")
					.setParameter("publicacion_id", publicacion.getPublicacion_id()).uniqueResult();
			String like_estado = (String) getSession().createQuery("select 'true' from Like where publicacion_id = :publicacion_id and usuario_id = :usuario_id")
					.setParameter("publicacion_id", publicacion.getPublicacion_id())
					.setParameter("usuario_id", usuario_id)
					.uniqueResult();
			if(like_estado == null ) like_estado = "false";
			
			if(publicacion.getFecha_registro() !=null) {
				
				publicacion.setFecha_texto(publicacion.getFecha_registro().toString());
				//Diefrencia en segundos
				publicacion.setFecha_diferencia_segundos((date.getTime() - publicacion.getFecha_registro().getTime())/1000);
			}
			
			publicacion.setCount_likes(count_likes);
			publicacion.setNombre_suario(publicacion.getUsuario().getNombre());
			publicacion.setLike_estado(like_estado);
			publicacion.setTema_nombre(publicacion.getTema().getTitulo());
		}
		
		return publicaciones;
	}

}
