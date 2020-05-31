package com.beteam.benice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beteam.benice.domain.Publicacion;
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
	
	@GetMapping("/publicaciones")
	@JsonIgnore
	public List<Publicacion> getPublicaciones() {

		//userService.getPublicaciones()
		return userService.getPublicaciones();
	}
	
	
	@PutMapping("/user")
	public void updateUser(@RequestBody Usuario usuario) {
		userService.updateUser(usuario);
	}
	
	@PostMapping("/user/historys")
	public  List<Publicacion> getHistoryByUser(@RequestBody Usuario usuario){
		return userService.getHistoryByUser(usuario.getUsuario_id());
	}
	
	@PostMapping("/publicacion")
	public Object createPublication(@RequestBody Publicacion publicacionRequest) {
		
		return userService.createPublication(publicacionRequest);
	}

	@PostMapping("/user")
	public void createUser(@RequestBody Usuario usuario) { 
		userService.createUser(usuario);
	}
}
