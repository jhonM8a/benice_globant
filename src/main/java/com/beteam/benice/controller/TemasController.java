package com.beteam.benice.controller;

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
}
