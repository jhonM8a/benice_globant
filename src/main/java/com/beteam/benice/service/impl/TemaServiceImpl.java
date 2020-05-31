package com.beteam.benice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beteam.benice.dao.TemaDao;
import com.beteam.benice.domain.Tema;
import com.beteam.benice.service.TemasService;
@Service
public class TemaServiceImpl implements TemasService{
	
	@Autowired
	TemaDao temaDao;

	@Override
	public List<Tema> getAllFilters() {
	
		List<Tema> temasDomain = temaDao.getAllFilters();
		return temasDomain ;
	}

	
}
