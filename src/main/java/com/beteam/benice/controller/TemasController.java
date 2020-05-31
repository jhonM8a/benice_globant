package com.beteam.benice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beteam.benice.domain.Tema;
import com.beteam.benice.service.TemasService;
@RestController
@RequestMapping("/benice/v1")
public class TemasController {
	
	@Autowired
	TemasService temasService;

	@GetMapping("/filters")
	public List<Tema> getAllFilters() {
		return temasService.getAllFilters();
	}
	
	@GetMapping("/themes")
	public List<Tema> getAllThemes(){
		
		List<Tema> temas = new ArrayList<Tema>();

		Tema tema_1 = new Tema();
		tema_1.setLikes(10L);
		tema_1.setTitulo("medio ambiente");
		
		Tema tema_2 = new Tema();
		tema_2.setLikes(5L);
		tema_2.setTitulo("Ciudadania");
		
		Tema tema_3 = new Tema();
		tema_3.setLikes(1L);
		tema_3.setTitulo("Donaciones");
		
		temas.add(tema_1);
		temas.add(tema_2);
		temas.add(tema_3);
		
		
		return temas; 
		
	}
}
