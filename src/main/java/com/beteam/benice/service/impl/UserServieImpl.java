package com.beteam.benice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.beteam.benice.model.Publication;
import com.beteam.benice.model.SessionBeNice;
import com.beteam.benice.model.UserAuthRequest;
import com.beteam.benice.service.UserService;

@Service
public class UserServieImpl implements UserService{
	
	public SessionBeNice getDataUser(UserAuthRequest user) {
		SessionBeNice sessionBeNice = new SessionBeNice();
		
		sessionBeNice.setName("Juan Perez");
		sessionBeNice.setLocation("Cali");
		sessionBeNice.setTotalPoint(10L);
		sessionBeNice.setPicture("/img/picture.jpg");
		//Data of publications of community
		Publication publication = new Publication();
		publication.setDescription("Planté un arbol");
		publication.setTag("Medio ambiente");
		publication.setPhoto("/img/foto.jpg");
		publication.setPoint(10L);
		publication.setLocation("Cali");
		
		List<Publication> publications = new ArrayList<>();
		publications.add(publication);
		
		sessionBeNice.setPublications(publications);
		//Tags using for user
		List<String> tag = new ArrayList<String>();
		tag.add("Medio ambiente");
		tag.add("Transporte ecologico");
		//Tags for one publication
		List<String> tags = new ArrayList<String>();
		tags.add("Medio ambiente");
		tags.add("Donación");
		tags.add("QuedateEnCasa");
		
		sessionBeNice.setTag(tag);
		sessionBeNice.setTags(tags);
		
		return sessionBeNice;
	}
}
