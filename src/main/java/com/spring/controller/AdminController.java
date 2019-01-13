package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.beans.Library.BooksBean;
import com.spring.beans.Library.CategoryBean;
import com.spring.beans.Library.CityBean;
import com.spring.beans.Library.LanguageBean;
import com.spring.beans.Library.LibraryBean;
import com.spring.beans.Library.LibraryInfoBean;
import com.spring.beans.Library.PublisherBean;
import com.spring.services.LibraryService;
import com.spring.services.UserService;
import com.spring.utils.Constants;
import com.spring.utils.GeneralResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	UserService userService;
	@Autowired
	LibraryService libraryService;

	@PostMapping("/add-language")
	public GeneralResponse saveOrUpdateLanguage(@RequestBody LanguageBean bean,
			@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.saveOrUpdateLanguage(bean));
	}

	// Delete single Languages
	@PostMapping("/delete-language/{languageId}")
	public GeneralResponse deleteLanguage(@PathVariable Long languageId,
			@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.deleteLanguage(languageId));
	}

	@PostMapping("/add-city")
	public GeneralResponse addCity(@RequestBody CityBean bean, @RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.addCity(bean));
	}
	// Library API's

	@PostMapping("/add-library")
	public GeneralResponse addLibrary(@RequestBody LibraryBean bean,
			@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.addLibrary(bean));
	}

	@PostMapping("/add-category")
	public GeneralResponse addLibrary(@RequestBody CategoryBean bean,
			@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.addCategory(bean));
	}

	@DeleteMapping("/delete-library/{Id}")
	public GeneralResponse deleteLibrary(@PathVariable Long Id,
			@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.deleteLibrary(Id));
	}

	@PostMapping("/add-book")
	public GeneralResponse addBook(@RequestBody BooksBean bean, @RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.addBook(bean));
	}

	@PostMapping("/delete-book/{Id}")
	public GeneralResponse deleteBook(@RequestBody BooksBean bean,
			@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.deleteBook(bean));
	}

	@PostMapping("/add-publisher")
	public GeneralResponse addPublisher(@RequestBody PublisherBean bean,
			@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.addPublisher(bean));
	}

	@PostMapping("/add-books-tolibrary")
	public GeneralResponse addBooksToLibrary(@RequestBody LibraryInfoBean bean,
			@RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.addBooksToLibrary(bean));
	}

	// Delete a User
	@DeleteMapping("/user/{userId}")
	public GeneralResponse deleteUser(@PathVariable Long userId, @RequestHeader("Auth-Token") final String authToken) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.deleteUser(userId));
	}
	
	@GetMapping("/books-data")
	public GeneralResponse booksData(@RequestHeader("Auth-Token") final String authToken){
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.getBooksData());
	}
}
