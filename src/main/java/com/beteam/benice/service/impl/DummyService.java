package com.beteam.benice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beteam.benice.dao.ClienteDao;
import com.beteam.benice.domain.Cliente;

@Service
public class DummyService {

	@Autowired
	private ClienteDao clienteDao;
	
	public List<Cliente> findAll(){
		return clienteDao.findAllClientes();
	}
}
