package com.example.mysqldemo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysqldemo.entity.User;
import com.example.mysqldemo.service.IUserService;

@RestController
public class UserController {
	@Autowired
	private IUserService userService;

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong, Please retry !!");
		}

	}

	/**
	 * method to create user
	 * 
	 * @param user
	 * @return user id of the created user
	 */
	@PostMapping("user")
	@ResponseStatus(code = HttpStatus.CREATED)
	int createUser(@RequestBody User user) {
		return userService.save(user);
	}

	/**
	 * method to get all the users
	 * 
	 * @return all the users
	 */

	@GetMapping("/user")
	List<User> getUsers() {
		return userService.getUsers();

	}

	/**
	 * method to get user by id
	 * 
	 * @param userId
	 * @return zero or matching user
	 */

	@GetMapping("/user/{id}")
	Optional<User> getUser(@PathVariable("id") Integer userId) {
		return userService.getUser(userId);
	}

	/**
	 * method to update user properties
	 * 
	 * @param user
	 * @param bindingResult
	 * @param userId
	 */

	@PutMapping("/user/{id}")
	void updateUser(@RequestBody @Valid User user, BindingResult bindingResult, @PathVariable("id") Integer userId) {
		validateModel(bindingResult);
		user.setId(userId);
		userService.updateUser(user);
	}

	/**
	 * method to delete the user by id
	 * 
	 * @param userId
	 */
	@DeleteMapping("/user/{id}")
	void deleteUser(@PathVariable("id") Integer userId) {
		userService.deleteUser(userId);
	}

}
