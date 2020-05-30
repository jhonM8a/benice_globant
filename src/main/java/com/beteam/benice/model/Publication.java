package com.beteam.benice.model;

import java.io.Serializable;

public class Publication implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private String Description;
	
	private String tag;
	
	private String photo;
	
	private Long point;
	
	private String location;
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
