package com.beteam.benice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.beteam.benice.domain.Usuario;

import com.beteam.benice.domain.Publicacion;
import com.beteam.benice.model.Publication;
import com.beteam.benice.model.SessionBeNice;
import com.beteam.benice.model.UserAuthRequest;
import com.beteam.benice.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
@RequestMapping("/benice/v1")
public class UserContoller {
	
	@Autowired
	private UserService userService;

	@PostMapping("/user/auth")
	public SessionBeNice authUser(@RequestBody UserAuthRequest userRequest) {

		return userService.getDataUser(userRequest);
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/publicaciones")
	@JsonIgnore
	public List<Publication> getPublicaciones() {

		//userService.getPublicaciones()
		return userService.getPublicaciones();
	}
	
	
	@PutMapping("/user")
	public void updateUser(@RequestBody Usuario usuario) {
		System.out.println(usuario.getCorreo());
	}

}
