package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.beans.Library.AppUserBean;
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

	// Create a User
	@PostMapping("/login")
	public GeneralResponse login(@RequestBody AppUserBean bean) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.login(bean));
	}

	// Get a Single User
	@GetMapping("/user/{userId}")
	public GeneralResponse getUser(@PathVariable Long userId) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.getUser(userId));
	}

	// Get All Users
	@GetMapping("/users")
	public GeneralResponse getAllUsers() {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.getAllUsers());
	}

	// Delete a User
	@DeleteMapping("/user/{userId}")
	public GeneralResponse deleteUser(@PathVariable Long userId) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.deleteUser(userId));
	}
	// Create a User
	@PostMapping("/add-language")
	public GeneralResponse saveOrUpdateLanguage(@RequestBody LanguageBean bean) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.saveOrUpdateLanguage(bean));
	}

	// Get All Languages
	@GetMapping("/get-all-languages")
	public GeneralResponse getAllLanguages() {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.getAllLanguages());
	}

	// Delete single Languages
	@PostMapping("/delete-language/{languageId}")
	public GeneralResponse deleteLanguage(@PathVariable Long languageId) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.deleteLanguage(languageId));
	}

	// Get a Single Language
	@GetMapping("/get-language/{langId}")
	public GeneralResponse getLanguage(@PathVariable Long langId) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.userService.getLanguage(langId));
	}
	
	@PostMapping("/add-city")
	public GeneralResponse addCity(@RequestBody CityBean bean){
		return new GeneralResponse (Constants.RESPONSE_SUCCESS, this.userService.addCity(bean));
	}
	
	@GetMapping("/get-cities")
	public GeneralResponse getCities(){
		return new GeneralResponse (Constants.RESPONSE_SUCCESS, this.userService.getCities());
	}
	
	//Library API's
	
	@PostMapping("/add-library")
	public GeneralResponse addLibrary(@RequestBody LibraryBean bean	){
		return new GeneralResponse (Constants.RESPONSE_SUCCESS, this.libraryService.addLibrary(bean));
	}
	
	@GetMapping("/get-all-library")
	public GeneralResponse getAllLibrarys(@RequestParam(name = "cityCode", required = false) String cityCode){
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.getAllLibrarys(cityCode));
	}

	@PostMapping("/add-category")
	public GeneralResponse addLibrary(@RequestBody CategoryBean bean) {
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.addCategory(bean));
	}

	@DeleteMapping("/delete-library/{Id}")
	public GeneralResponse deleteLibrary(@RequestBody LibraryBean bean	){
		return new GeneralResponse (Constants.RESPONSE_SUCCESS, this.libraryService.deleteLibrary(bean));
	}
	
	@PostMapping("/add-book")
	public GeneralResponse addBook(@RequestBody BooksBean bean){
		return new GeneralResponse (Constants.RESPONSE_SUCCESS, this.libraryService.addBook(bean));
	}
	@GetMapping("/get-book/{Id}")
	public GeneralResponse getBook(@PathVariable Long Id){
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.getBook(Id));
	}
	@GetMapping("/get-all-books")
	public GeneralResponse getAllBooks(){
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.getAllBooks());
	}
	
	@GetMapping("/search-books")
	public GeneralResponse searchBook(@RequestParam(name = "langaugeId", required = false) Long languageId, @RequestParam(name = "categoryId", required = false) Long categoryId ){
		return new GeneralResponse(Constants.RESPONSE_SUCCESS, this.libraryService.searchBooks(languageId,categoryId));
	}

	@PostMapping("/delete-book/{Id}")
	public GeneralResponse deleteBook(@RequestBody BooksBean bean	){
		return new GeneralResponse (Constants.RESPONSE_SUCCESS, this.libraryService.deleteBook(bean));
	}
	
	@PostMapping("/add-publisher")
	public GeneralResponse addPublisher(@RequestBody PublisherBean bean){
		return new GeneralResponse (Constants.RESPONSE_SUCCESS, this.libraryService.addPublisher(bean));
	}
	
	@PostMapping("/add-books-tolibrary")
	public GeneralResponse addBooksToLibrary(@RequestBody LibraryInfoBean bean){
		return new GeneralResponse (Constants.RESPONSE_SUCCESS, this.libraryService.addBooksToLibrary(bean));
	}
}
