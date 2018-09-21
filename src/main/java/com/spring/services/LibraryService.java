package com.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.beans.Library.BooksBean;
import com.spring.beans.Library.LibraryBean;
import com.spring.model.library.Books;
import com.spring.model.library.City;
import com.spring.model.library.Library;
import com.spring.repo.Library.BooksRepo;
import com.spring.repo.Library.CityRepo;
import com.spring.repo.Library.LibraryRepo;
import com.spring.utils.PracticeUtils;

@Service
public class LibraryService {

	@Autowired
	LibraryRepo libraryRepo;

	@Autowired
	CityRepo cityRepo;
	
	@Autowired
	BooksRepo booksRepo;
	
	public Library addLibrary(LibraryBean bean) {
		Library library;
		if (bean.getId() != null) {
			library = this.libraryRepo.findOne(bean.getId());

		} else {
			library = new Library();
		}
		Assert.notNull(bean.getName(), "Please provide name");

		library.setName(bean.getName());
		City city = this.cityRepo.findByCityCode(bean.getCity());
		if (PracticeUtils.isNotEmpty(city)) {
			library.setCity(city.getCityName());
		}else {
			throw new IllegalArgumentException("Entered city code is wrong");
		}
		library.setAddress(bean.getAddress());

		return this.libraryRepo.save(library);

	}
	
	public String deleteLibrary(LibraryBean bean) {
		Assert.isNull(bean.getId(), "Provide Id");
		Library lb = this.libraryRepo.findOne(bean.getId());
		Assert.notNull(bean.getId(), "No library found");
		lb.setIsActive(bean.getIsActive());
		return "Library deleted successfully";
	}
	
	public Books addBook(BooksBean bean){
		Books book;
		if (bean.getId() !=null) {
			book = this.booksRepo.findOne(bean.getId());
		}else {
			book = new Books();
		}
		book.setTitle(bean.getTitle());
		book.setAuthor(bean.getAuthor());
		book.setDescription(bean.getDescription());
		book.setLanguage(bean.getLanguage());
		book.setPages(bean.getPages());
		book.setPublisher(bean.getPublisher());
		book.setSection(bean.getSection());
		
		return this.booksRepo.save(book);
	}
	
	public String deleteBook(BooksBean bean) {
		Assert.isNull(bean.getId(), "Provide Id");
		Books book = this.booksRepo.findOne(bean.getId());
		Assert.notNull(bean.getId(), "No Book found");
		book.setIsActive(bean.getIsActive());
		return "Book deleted successfully";
	}
}
