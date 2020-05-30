package com.beteam.benice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.beteam.benice.domain.Cliente;
import com.beteam.benice.service.impl.DummyService;

@RestController
public class Dummy {
	
	@Autowired
	private DummyService dummy;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<String>  getHello() {
		return ResponseEntity.ok().body("Hol mundo");
	}
	
	@GetMapping("/test")
	@ResponseBody
	public List<Cliente> findAll(){
		return dummy.findAll();
	}

}
