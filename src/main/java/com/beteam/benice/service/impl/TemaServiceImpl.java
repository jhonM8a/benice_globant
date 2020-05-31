package com.beteam.benice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beteam.benice.dao.TemaDao;
import com.beteam.benice.domain.Tema;
import com.beteam.benice.model.TemaResponse;
import com.beteam.benice.service.TemasService;
@Service
public class TemaServiceImpl implements TemasService{
	
	@Autowired
	TemaDao temaDao;

	@Override
	public List<TemaResponse> getAllFilters() {
	
		List<Tema> temasDomain = temaDao.getAllFilters();
		List<TemaResponse> temasResponses = new ArrayList<TemaResponse>();
		
		for (Tema temaDomain : temasDomain) {
			TemaResponse temaResponse = new TemaResponse();
			
			temaResponse.setDescripcion(temaDomain.getDescripcion());
			temaResponse.setTitulo(temaDomain.getTitulo());
			temaResponse.setTema_id(temaDomain.getTema_id());
			temasResponses.add(temaResponse);
		} 
		
		return temasResponses ;
	}

	
}
