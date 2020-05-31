package com.beteam.benice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beteam.benice.model.Publication;
import com.beteam.benice.model.SessionBeNice;
import com.beteam.benice.model.UserAuthRequest;
import com.beteam.benice.model.UserRequest;
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
	public void updateUser(@RequestBody UserRequest usuario) {
		userService.updateUser(usuario);
	}
	
	@PostMapping("/user/historys")
	public  List<Publication> getHistoryByUser(@RequestBody UserRequest usuario){
		return userService.getHistoryByUser(usuario.getUsuario_id());
	}

	@PostMapping("/user")
	public void createUser(@RequestBody UserRequest usuario) {
		userService.createUser(usuario);
	}
}
