package com.beteam.benice.dao;

import com.beteam.benice.domain.Usuario;

public interface UsuarioDao {
	
	public Usuario getUsuarioByUserName(String usuerName, String password);
}
