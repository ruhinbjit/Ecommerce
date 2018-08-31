package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.User;

public interface UserService {
	public void addUser(User user);
	public List<User> getUserList();
}
