package com.beteam.benice.dao;

import java.util.List;

import com.beteam.benice.domain.Cliente;

public interface ClienteDao {

	List<Cliente> findAllClientes();
}
