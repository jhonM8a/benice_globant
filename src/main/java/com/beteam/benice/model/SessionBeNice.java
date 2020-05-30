package com.beteam.benice.model;

import java.io.Serializable;
import java.util.List;

public class SessionBeNice implements Serializable{

	private static final long serialVersionUID = 1L;

	private String location;
	
	private String name;
	
	private Long totalPoint;
	
	private String picture;
	
	private List<Publication> publications;
	
	private List<String> tag;
	
	private List<String> tags;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Long totalPoint) {
		this.totalPoint = totalPoint;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
