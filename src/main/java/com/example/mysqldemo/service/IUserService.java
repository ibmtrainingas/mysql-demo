package com.example.mysqldemo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.mysqldemo.entity.User;

public interface IUserService {
	int save(User user);

	List<User> getUsers();

	Optional<User> getUser(Integer userId);

	void updateUser(@Valid User user);

	void deleteUser(Integer userId);
}
