package com.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.beans.Library.BooksBean;
import com.spring.beans.Library.CategoryBean;
import com.spring.beans.Library.LibraryBean;
import com.spring.beans.Library.LibraryInfoBean;
import com.spring.beans.Library.PublisherBean;
import com.spring.model.library.Books;
import com.spring.model.library.Category;
import com.spring.model.library.City;
import com.spring.model.library.Language;
import com.spring.model.library.Library;
import com.spring.model.library.LibraryInfo;
import com.spring.model.library.Publisher;
import com.spring.repo.Library.BooksRepo;
import com.spring.repo.Library.CategoryRepo;
import com.spring.repo.Library.CityRepo;
import com.spring.repo.Library.LanguageRepo;
import com.spring.repo.Library.LibraryInfoRepo;
import com.spring.repo.Library.LibraryRepo;
import com.spring.repo.Library.PublisherRepo;
import com.spring.utils.PracticeUtils;

import scala.collection.parallel.ParIterableLike.Foreach;

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
	@Autowired
	PublisherRepo publisherRepo;
	@Autowired
	LibraryInfoRepo libraryInfoRepo;
	
	public Library addLibrary(LibraryBean bean) {
		Library library;
		if (bean.getId() != null) {
			library = this.libraryRepo.findOne(bean.getId());

		} else {
			library = new Library();
		}
		Assert.notNull(bean.getName(), "Please provide name");

		library.setName(bean.getName());
		City city = this.cityRepo.findOne(bean.getCityId());
		if (PracticeUtils.isNotEmpty(city)) {
			library.setCity(city);
		}else {
			throw new IllegalArgumentException("Entered city Id is wrong");
		}
		library.setAddress(bean.getAddress());

		return this.libraryRepo.save(library);

	}
	
	public List<LibraryBean> getAllLibrarys(String cityCode) {
		List<Library> libraries;
		if (cityCode != null) {
			libraries = this.libraryRepo.findByCityCityCode(cityCode);
		} else {
			libraries = this.libraryRepo.findAll();
		}
		List<LibraryBean> beans = new ArrayList<>();
		for (Library library : libraries) {
			LibraryBean bean = new LibraryBean();
			bean.setId(library.getId());
			bean.setName(library.getName());
			bean.setCityName(library.city.getCityName());
			beans.add(bean);
		}

		beans.sort((a, b) -> a.getId().compareTo(b.getId()));
		return beans;
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
		book.setIsActive(bean.getIsActive());
		book.setDescription(bean.getDescription());
		Language language = this.languageRepo.findOne(bean.getLanguageId());
		book.setLanguage(language);
		book.setPages(bean.getPages());
		Publisher publisher = this.publisherRepo.findOne(bean.getPublisherId());
		book.setPublisher(publisher);
		Category category = this.categoryRepo.findOne(bean.getCategoryId());
		book.setCategory(category);	
		book.setCopies(bean.getCopies());
		return this.booksRepo.save(book);
	}
	
	public BooksBean getBook(Long Id) {
		BooksBean bean = new BooksBean();
		Books books = this.booksRepo.findOne(Id);
		Assert.notNull(books, "No Book found with given Id");
		bean.setTitle(books.getTitle());
		bean.setAuthor(books.getAuthor());
		bean.setLanguageName(books.language.getName());
		bean.setCategoryName(books.category.getName());
		return bean;

	}
	
	public List<Books> getAllBooks() {
		List<Books> books = this.booksRepo.findAll();
		books.sort((a, b) -> a.getId().compareTo(b.getId()));
		return books;
	}
	
	public List<BooksBean> searchBooks(Long languageId, Long categoryId) {
		
		List<Books> books = new ArrayList<Books>();
		if (languageId != null && categoryId != null) {
			books = this.booksRepo.findByLanguageIdAndCategoryId(languageId,categoryId);
		}else if (languageId != null) {
			books = this.booksRepo.findByLanguageId(languageId);
		}else if (categoryId != null) {
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
	
	public Publisher addPublisher(PublisherBean bean){
		Publisher publisher;
		if (bean.getId() != null ) {
			publisher= this.publisherRepo.findOne(bean.getId());
		}else {
			publisher = new Publisher();
		}
		publisher.setName(bean.getName());
		publisher.setDescription(bean.getDescription());
		this.publisherRepo.save(publisher);
		return publisher;
	}
	
	public String deleteBook(BooksBean bean) {
		Assert.isNull(bean.getId(), "Provide Id");
		Books book = this.booksRepo.findOne(bean.getId());
		Assert.notNull(bean.getId(), "No Book found");
		book.setIsActive(bean.getIsActive());
		return "Book deleted successfully";
	}
	
	public List<LibraryInfo> addBooksToLibrary(LibraryInfoBean infoBean) {
		LibraryInfo info;
		List<LibraryInfoBean> beans = new ArrayList<>();
		List<LibraryInfo> infos = new ArrayList<>();

		for (LibraryInfoBean iterable : beans) {
			info = this.libraryInfoRepo.findByLibraryIdAndBookId(iterable.getLibraryId(), iterable.getBookId());
			Books copies = new Books();
			copies = this.booksRepo.findOne(iterable.getBookId());
			Integer count = copies.getCopies();
			if (info == null) {
				info = new LibraryInfo();
				copies.setCopies(count - iterable.getCopies());
				this.booksRepo.save(copies);
			}
			Assert.isTrue(iterable.getCopies() <= 5, "Only 5 copies are allowed");
			if (iterable.getCopies() < info.getCopies()) {
				copies.setCopies(count+(info.getCopies()-iterable.getCopies()));
			}else if (iterable.getCopies() > info.getCopies()) {
				copies.setCopies(count-(iterable.getCopies()-info.getCopies()));
			}
			info.setCopies(iterable.getCopies());
			infos.add(info);
			this.libraryInfoRepo.save(infos);
		}
		return infos;
	}
}
