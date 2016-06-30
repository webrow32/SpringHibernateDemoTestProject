package com.benjie.spring.demo.service;

import java.util.List;

import com.benjie.spring.demo.model.UserProfile;

public interface UserProfileService {

	UserProfile findById(int id);
	
	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
