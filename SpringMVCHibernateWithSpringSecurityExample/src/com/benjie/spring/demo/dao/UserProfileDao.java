package com.benjie.spring.demo.dao;

import java.util.List;

import com.benjie.spring.demo.model.UserProfile;

public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
	
}
