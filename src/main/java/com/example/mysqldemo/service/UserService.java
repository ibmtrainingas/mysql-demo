package com.example.mysqldemo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysqldemo.entity.User;
import com.example.mysqldemo.repo.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * method to save the new user in db
	 */
	@Override
	public int save(User user) {
		User savedUser = userRepository.save(user);
		return savedUser.getId();
	}

	/**
	 * method to get all the users from db
	 */
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	/**
	 * method to get specific user from db using userId
	 */
	@Override
	public Optional<User> getUser(Integer userId) {
		return userRepository.findById(userId);
	}

	/**
	 * method to update the existing user in db
	 */
	@Override
	public void updateUser(@Valid User user) {
		userRepository.save(user);
	}

	/**
	 * method to delete a specific user from db
	 */
	@Override
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);

	}

}
