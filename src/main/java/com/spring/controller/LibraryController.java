package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.beans.Library.AppUserBean;
import com.spring.beans.Library.PageRequestBean;
import com.spring.beans.Library.UserActivityBean;
import com.spring.services.LibraryService;
import com.spring.services.UserService;
import com.spring.utils.Constants;
import com.spring.utils.GeneralResponse;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LibraryController {

	@Autowired
	UserService userService;

	@Autowired
	LibraryService libraryService;

	// Create a User
	@PostMapping("/signup")
	public GeneralResponse addUser(@RequestBody AppUserBean bean) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.signUp(bean));
	}

	// User Login
	@PostMapping("/login")
	public GeneralResponse login(@RequestBody AppUserBean bean) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.login(bean));
	}

	@PostMapping("/logout")
	public GeneralResponse logout(@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.logout(authToken));
	}

	// Get a Single User
	@GetMapping("/user/{userId}")
	public GeneralResponse getUser(@PathVariable Long userId, @RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.getUser(userId));
	}

	// Get All Users
	@GetMapping("/users")
	public GeneralResponse getAllUsers(@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.getAllUsers());
	}


	// Get All Languages
	@GetMapping("/get-all-languages")
	public GeneralResponse getAllLanguages() {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.getAllLanguages());
	}

	// Get a Single Language
	@GetMapping("/get-language/{langId}")
	public GeneralResponse getLanguage(@PathVariable Long langId) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.getLanguage(langId));
	}

	@GetMapping("/get-cities")
	public GeneralResponse getCities() {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.getCities());
	}

	@GetMapping("/get-all-library")
	public GeneralResponse getAllLibrarys(@RequestParam(name = "cityId", required = false) Long cityId,
			@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.getAllLibrarys(cityId,authToken));
	}
	@GetMapping("get-library/{Id}")
	public GeneralResponse getLibrary(@PathVariable Long Id, @RequestHeader("Auth-Token") final String authToken){
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.getLibrary(Id));
	}
	@GetMapping("/get-book/{Id}")
	public GeneralResponse getBook(@PathVariable Long Id, @RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.getBook(Id));
	}

	@GetMapping("/get-all-books")
	public GeneralResponse getAllBooks(/*@RequestBody PageRequestBean bean,*/ @RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.getAllBooks(authToken));
	}

	@GetMapping("/search-books")
	public GeneralResponse searchBook(@RequestParam(name = "langaugeId", required = false) Long languageId,
			@RequestParam(name = "categoryId", required = false) Long categoryId,
			@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.searchBooks(languageId, categoryId));
	}

	@GetMapping("/library-books/{Id}")
	public GeneralResponse getLibraryBooks(@PathVariable Long Id, @RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.LibraryBooks(Id));
	}

	@PostMapping("/books-adding-tocart")
	public GeneralResponse userActivity(@RequestBody UserActivityBean bean,
			@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.userAddingBookToCart(bean));
	}
	
	@GetMapping("/forgot-password")
	public GeneralResponse forgotPassword(@RequestParam(name = "emailId", required = true) String emailId){
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.forgotPassword(emailId));
	}
	
	@PostMapping("/reset-password")
	public GeneralResponse resetPassword(@RequestBody AppUserBean bean){
		return new GeneralResponse(Constants.RESPONSE_SUCCESS,this.userService.resetPassword(bean));
	}
	
}
