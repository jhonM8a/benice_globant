package com.beteam.benice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beteam.benice.domain.Like;
import com.beteam.benice.domain.Publicacion;
import com.beteam.benice.domain.Tema;
import com.beteam.benice.domain.Usuario;
import com.beteam.benice.model.UserAuthRequest;
import com.beteam.benice.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
@RequestMapping("/benice/v1")
public class UserContoller {
	
	@Autowired
	private UserService userService;

	@PostMapping("/user/auth")
	public Usuario authUser(@RequestBody UserAuthRequest userRequest) {

		return userService.getDataUser(userRequest);
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/publicaciones/todas")
	@JsonIgnore
	public List<Publicacion> getPublicaciones(@RequestBody Usuario usuario) {

		return userService.getPublicaciones(usuario);
	}
	
	@PostMapping("/publicaciones_por_tema")
	@JsonIgnore
	public List<Publicacion> getPublicacionesPorTema(@RequestBody Tema temaRequest) {

		return userService.getPublicacionesPorTema(temaRequest);
	}
	
	
	@PutMapping("/user") 
	public void updateUser(@RequestBody Usuario usuario) {
		userService.updateUser(usuario);
	}
	
	@PostMapping("/user/historys")
	public  List<Publicacion> getHistoryByUser(@RequestBody Usuario usuario){
		
		System.out.println("usuario.getGeneral()  " + usuario.getGeneral() );
		if(usuario.getGeneral() == 1 ) {
			return userService.getPublicaciones(usuario);
		} else {
			return userService.getHistoryByUser(usuario.getUsuario_id());
		}
		
		
	}
	
	@PostMapping("/publicacion")
	public Object createPublication(@RequestBody Publicacion publicacionRequest) {
		
		return userService.createPublication(publicacionRequest);
	}
	
	@PostMapping("/like_user")
	public Object setLikeUser(@RequestBody Like likeUserRequest) {
		
		System.out.println(likeUserRequest.getUsuario_id());
		return userService.createLikeUser(likeUserRequest);
	}
	
	@PostMapping("/dislike_user")
	public Object setDislikeUser(@RequestBody Like likeUserRequest) {
		
		System.out.println(likeUserRequest.getUsuario_id());
		return userService.deleteLikeUser(likeUserRequest);
	}

	@PostMapping("/user")
	public void createUser(@RequestBody Usuario usuario) { 
		userService.createUser(usuario);
	}
	
	@PostMapping("/user/delete")
	public void deletePublicationById(@RequestBody Publicacion publicacion) {
		userService.deletePublicationById(publicacion.getPublicacion_id());
	}
}
