package com.beteam.benice.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.beteam.benice.dao.ClienteDao;
import com.beteam.benice.domain.Cliente;

@Repository
public class ClienteDaoImpl extends AbstractSession implements ClienteDao{

	@Override
	public List<Cliente> findAllClientes() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Cliente").list();
	}

}
