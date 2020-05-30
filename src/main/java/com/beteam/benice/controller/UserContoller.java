package com.beteam.benice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beteam.benice.domain.Usuario;
import com.beteam.benice.model.SessionBeNice;
import com.beteam.benice.model.UserAuthRequest;
import com.beteam.benice.service.UserService;

@RestController
@RequestMapping("/benice/v1")
public class UserContoller {
	
	@Autowired
	private UserService userService;

	@PostMapping("/user/auth")
	public SessionBeNice authUser(@RequestBody UserAuthRequest userRequest) {

		return userService.getDataUser(userRequest);
	}
	
	@PutMapping("/user")
	public void updateUser(@RequestBody Usuario usuario) {
		System.out.println(usuario.getCorreo());
	}

}
