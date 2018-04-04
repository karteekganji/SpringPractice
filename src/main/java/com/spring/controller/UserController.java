package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.beans.LanguageBean;
import com.spring.beans.UserBean;
import com.spring.repo.UserRepository;
import com.spring.services.UserService;
import com.spring.utils.Constants;
import com.spring.utils.GeneralResponse;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	// Create a User
	@PostMapping("/add-user")
	public GeneralResponse addUser(@RequestBody UserBean bean) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.addUser(bean));
	}

	// Get a Single User
	@GetMapping("/get-user/{userId}")
	public GeneralResponse getUser(@PathVariable Long userId) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.getUser(userId));
	}

	// Get All Users
	@GetMapping("/get-all-users")
	public GeneralResponse getAllUser() {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.getAllUsers());
	}

	// Delete a User
	@PostMapping("/delete-user/{userId}")
	public GeneralResponse deleteUser(@PathVariable Long userId) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.deleteUser(userId));
	}

	// Update a User
	@PostMapping("/update-user")
	public GeneralResponse updateUser(@RequestBody UserBean bean) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.updateUser(bean));
	}
	
	// Create a User
		@PostMapping("/add-language")
		public GeneralResponse saveOrUpdateLanguage(@RequestBody LanguageBean bean) {
			return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.saveOrUpdateLanguage(bean));
		}
}
