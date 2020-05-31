package com.beteam.benice.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.beteam.benice.dao.TemaDao;
import com.beteam.benice.domain.Tema;
@Repository
public class TemaDaoImpl extends AbstractSession implements TemaDao{

	@Override
	public List<Tema> getAllFilters() {
		
		return getSession().createQuery("from Tema").list();
	}

}
