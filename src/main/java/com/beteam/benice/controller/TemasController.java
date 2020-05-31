package com.beteam.benice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beteam.benice.model.TemaResponse;
import com.beteam.benice.service.TemasService;
@RestController
@RequestMapping("/benice/v1")
public class TemasController {
	
	@Autowired
	TemasService temasService;

	@GetMapping("/filters")
	public List<TemaResponse> getAllFilters() {
		return temasService.getAllFilters();
	}
}
