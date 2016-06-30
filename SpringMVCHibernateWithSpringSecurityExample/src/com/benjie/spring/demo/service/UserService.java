package com.benjie.spring.demo.service;

import java.util.List;

import com.benjie.spring.demo.model.User;

public interface UserService {

	User findByid(int id);

	User findBySSO(String sso);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserBySSO(String sso);

	List<User> findAllUsers();

	boolean isUserSSOUnique(Integer id, String sso);
}
