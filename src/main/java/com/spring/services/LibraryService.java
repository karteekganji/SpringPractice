package com.spring.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.beans.Library.BooksBean;
import com.spring.beans.Library.CategoryBean;
import com.spring.beans.Library.LibraryBean;
import com.spring.model.library.Books;
import com.spring.model.library.Category;
import com.spring.model.library.City;
import com.spring.model.library.Language;
import com.spring.model.library.Library;
import com.spring.repo.Library.BooksRepo;
import com.spring.repo.Library.CategoryRepo;
import com.spring.repo.Library.CityRepo;
import com.spring.repo.Library.LanguageRepo;
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
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	LanguageRepo languageRepo;
	
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

	public Category addCategory(CategoryBean bean) {
		Category category;
		if (bean.getId() != null) {
			category = this.categoryRepo.findOne(bean.getId());
		} else {
			category = new Category();
		}
		category.setName(bean.getName());
		category.setDescription(bean.getDescription());

		return this.categoryRepo.save(category);

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
		Language language = this.languageRepo.findOne(bean.getLanguageId());
		book.setLanguage(language);
		book.setPages(bean.getPages());
		book.setPublisher(bean.getPublisher());
		Category category = this.categoryRepo.findOne(bean.getCategoryId());
		book.setCategory(category);	
		return this.booksRepo.save(book);
	}
	
	public BooksBean getBook(Long Id){
		
		BooksBean bean = new BooksBean();
		Books books = this.booksRepo.findOne(Id);
		
		bean.setTitle(books.getTitle());
		bean.setAuthor(books.getAuthor());
		bean.setLanguageName(books.language.getName());
		bean.setCategoryName(books.category.getName());
		return bean;
		
	}
	
	public List<Books> getAllBooks() {
		List<Books> books = this.booksRepo.findAll();
		books.sort((a,b)-> a.getTitle().compareTo(b.getTitle()));
		return books;
	}
	
	public List<BooksBean> searchBooks(Long languageId, Long categoryId) {
		
		List<Books> books = new ArrayList<Books>();
		System.out.println("languageId>> "+languageId + "categoryId >> "+ categoryId);
		if (languageId != null && categoryId != null) {
			System.out.println(">> Condition 1");
			books = this.booksRepo.findByLanguageIdAndCategoryId(languageId,categoryId);
		}else if (languageId != null) {
			System.out.println(">> Condition 2");
			books = this.booksRepo.findByLanguageId(languageId);
		}else if (categoryId != null) {
			System.out.println(">> Condition 3");
			 books = this.booksRepo.findByCategoryId(categoryId);
		}
		books.sort((a,b)->a.getId().compareTo(b.getId()));
		
		List<BooksBean> beans = new ArrayList<>();
		for (Books books2 : books) {
			BooksBean bean= new BooksBean();
			bean.setId(books2.getId());
			bean.setTitle(books2.getTitle());
			bean.setAuthor(books2.getAuthor());
			bean.setLanguageName(books2.language.getName());
			bean.setCategoryName(books2.category.getName());
			beans.add(bean);
		}
		return beans;
	}
	
	public String deleteBook(BooksBean bean) {
		Assert.isNull(bean.getId(), "Provide Id");
		Books book = this.booksRepo.findOne(bean.getId());
		Assert.notNull(bean.getId(), "No Book found");
		book.setIsActive(bean.getIsActive());
		return "Book deleted successfully";
	}
}
