package com.beteam.benice.service;

import com.beteam.benice.model.SessionBeNice;
import com.beteam.benice.model.UserAuthRequest;

public interface UserService {

	public SessionBeNice getDataUser(UserAuthRequest user);
}
