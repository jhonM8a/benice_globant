package com.beteam.benice.service;

import java.util.List;

import com.beteam.benice.model.Publication;
import com.beteam.benice.model.SessionBeNice;
import com.beteam.benice.model.UserAuthRequest;
import com.beteam.benice.model.UserRequest;

public interface UserService {

	public SessionBeNice getDataUser(UserAuthRequest user);
	
	public List<Publication> getPublicaciones();

	public void updateUser(UserRequest usuario);

	public List<Publication> getHistoryByUser(Long usuario_id);

	public void createUser(UserRequest usuario);
}
