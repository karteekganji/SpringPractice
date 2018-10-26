package com.spring.services;

import java.awt.print.Book;
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
		} else {
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

	public Books addBook(BooksBean bean) {
		Books book;
		if (bean.getId() != null) {
			book = this.booksRepo.findOne(bean.getId());
		} else {
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
			books = this.booksRepo.findByLanguageIdAndCategoryId(languageId, categoryId);
		} else if (languageId != null) {
			books = this.booksRepo.findByLanguageId(languageId);
		} else if (categoryId != null) {
			books = this.booksRepo.findByCategoryId(categoryId);
		}
		books.sort((a, b) -> a.getId().compareTo(b.getId()));

		List<BooksBean> beans = new ArrayList<>();
		for (Books books2 : books) {
			BooksBean bean = new BooksBean();
			bean.setId(books2.getId());
			bean.setTitle(books2.getTitle());
			bean.setAuthor(books2.getAuthor());
			bean.setLanguageName(books2.language.getName());
			bean.setCategoryName(books2.category.getName());
			beans.add(bean);
		}
		return beans;
	}

	public Publisher addPublisher(PublisherBean bean) {
		Publisher publisher;
		if (bean.getId() != null) {
			publisher = this.publisherRepo.findOne(bean.getId());
		} else {
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

	public LibraryInfoBean addBooksToLibrary(LibraryInfoBean infoBean) {

		Assert.isTrue(!infoBean.getBooks().isEmpty() || infoBean.getBooks() != null, "No book selected!");
		LibraryInfo info = new LibraryInfo();
		for (Long bookId : infoBean.getBooks()) {
			info=OperationsAddingbooksToLibrary(infoBean, bookId);
		}
		if (infoBean.getCopies() == 0) {
			this.libraryInfoRepo.delete(info);
		} else {
			this.libraryInfoRepo.save(info);
		}
		return infoBean;
	}
	
	public LibraryInfo OperationsAddingbooksToLibrary(LibraryInfoBean infoBean, Long bookId) {
		LibraryInfo info = new LibraryInfo();
		Books books = new Books();
		info = this.libraryInfoRepo.findByLibraryIdAndBookId(infoBean.getLibraryId(), bookId);
		books = this.booksRepo.findOne(bookId);
		Assert.notNull(books, "No book found with given Id");
		Integer count = books.getCopies();

		Assert.isTrue(count != 0, books.getTitle() + " Book not available");

		if (info == null) {
			info = new LibraryInfo();
			books.setCopies(count - infoBean.getCopies());
			this.booksRepo.save(books);
		}
		Assert.isTrue(infoBean.getCopies() <= 5, "Only 5 copies are allowed");
		if (info.getCopies() != 0) {
			if (infoBean.getCopies() > info.getCopies()) {
				int less = infoBean.getCopies() - info.getCopies();
				books.setCopies(count - less);
			} else if (infoBean.getCopies() < info.getCopies()) {
				int add = info.getCopies() - infoBean.getCopies();
				books.setCopies(count + add);
			}
			this.booksRepo.save(books);
		}
		Library library = this.libraryRepo.findOne(infoBean.getLibraryId());
		info.setBook(books);
		info.setCopies(infoBean.getCopies());
		info.setLibrary(library);

		return info;
	}

	public List<BooksBean> LibraryBooks(Long id) {
		List<LibraryInfo> infos = this.libraryInfoRepo.findByLibraryId(id);
		List<BooksBean> books = new ArrayList<BooksBean>();
		for (LibraryInfo libraryInfo : infos) {
			BooksBean bean = new BooksBean();
			Books book = this.booksRepo.findOne(libraryInfo.getBook().id);
			bean.setId(book.getId());
			bean.setTitle(book.getTitle());
			bean.setDescription(book.getDescription());
			bean.setAuthor(book.getAuthor());
			books.add(bean);
		}
		books.sort((a,b) -> a.getTitle().compareTo(b.getTitle()));
		return books;
	}
}
