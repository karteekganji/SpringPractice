package com.spring.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.beans.Library.BooksBean;
import com.spring.beans.Library.BooksSubBean;
import com.spring.beans.Library.CategoryBean;
import com.spring.beans.Library.LibraryBean;
import com.spring.beans.Library.LibraryInfoBean;
import com.spring.beans.Library.PublisherBean;
import com.spring.model.library.AppUser;
import com.spring.model.library.Author;
import com.spring.model.library.Books;
import com.spring.model.library.Category;
import com.spring.model.library.City;
import com.spring.model.library.Language;
import com.spring.model.library.Library;
import com.spring.model.library.LibraryInfo;
import com.spring.model.library.Publisher;
import com.spring.repo.Library.AuthorRepo;
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
	@Autowired
	AuthorRepo authorRepo;
	
	@Autowired
	UserService userService; 

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
		library.setIsActive(bean.getIsActive());

		return this.libraryRepo.save(library);

	}

	public List<Library> getAllLibrarys(Long cityId,String authToken) {
		if (cityId !=null) {
			City city = this.cityRepo.findOne(cityId);
			Assert.notNull(city, "Selected city is not available");
		}
		List<Library> libraries;
		if (cityId != null) {
			libraries = this.libraryRepo.findByCityIdAndIsActiveTrue(cityId);
		} else {
			libraries = this.libraryRepo.findAll();
		}
		
		libraries.sort((a, b) -> a.getId().compareTo(b.getId()));
		return libraries;
	}
	
	public Library getLibrary(Long Id) {
		Library library = this.libraryRepo.findOne(Id);
		Assert.notNull(library, "No library found");
		return library;
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

	public String deleteLibrary(Long Id) {
		Assert.notNull(Id, "Provide Library Id");
		Library lb = this.libraryRepo.findOne(Id);
		Assert.notNull(lb, "No library found");
		lb.setIsActive(Boolean.FALSE);
		this.libraryRepo.save(lb);
		return "Library deleted successfully";
	}

	public BooksBean addBook(BooksBean bean) {
		Books book;
		if (bean.getBookId() != null) {
			book = this.booksRepo.findOne(bean.getBookId());
		} else {
			book = new Books();
		}
		book.setTitle(bean.getTitle());
		Author author = this.authorRepo.findOne(bean.getAuthorId());
		book.setAuthor(author);
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
		return bookInfos(book);
	}

	public BooksBean getBook(Long Id) {
		Books books = this.booksRepo.findOne(Id);
		Assert.notNull(books, "No Book found with given Id");
		return bookInfos(books);
	}

	public List<BooksBean> getAllBooks() {
		List<Books> books = this.booksRepo.findAll();
		books.sort((a, b) -> a.getId().compareTo(b.getId()));
		List<BooksBean> beans = new ArrayList<>();
		for (Books books2 : books) {
			beans.add(bookInfos(books2));
		}
		return beans;
	}

	public static BooksBean bookInfos(Books book) {
		BooksBean bean = new BooksBean();
		bean.setBookId(book.getId());
		bean.setTitle(book.getTitle());
		bean.setDescription(book.getDescription());
		bean.setPages(book.getPages());
		if (book.getCategory() != null) {
			bean.setCategoryName(book.getCategory().getName());
		}else {
			bean.setCategoryName("No Category");
		}
		if (book.getAuthor() != null) {
			bean.setAuthorName(book.getAuthor().getAppUser().getName());
		}else {
			bean.setAuthorName("No Author");
		}
		if (book.getLanguage() != null) {
			bean.setLanguageName(book.getLanguage().getName());
		}else {
			bean.setLanguageName("No Language");
		}
		if (book.getPublisher() != null) {
			bean.setPublisherName(book.getPublisher().getName());
		}else {
			bean.setPublisherName("No Publisher");
		}
		return bean;
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
			beans.add(bookInfos(books2));
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
		Assert.isNull(bean.getBookId(), "Provide Id");
		Books book = this.booksRepo.findOne(bean.getBookId());
		Assert.notNull(bean.getBookId(), "No Book found");
		book.setIsActive(bean.getIsActive());
		this.booksRepo.save(book);
		return "Book deleted successfully";
	}

	public LibraryInfoBean addBooksToLibrary(LibraryInfoBean infoBean) {
		LibraryInfo info = new LibraryInfo();
		for (BooksSubBean bean : infoBean.getBooksDetails()) {
			info = OperationsAddingbooksToLibrary(infoBean, bean);
			if (bean.getCopies() == 0) {
				this.libraryInfoRepo.delete(info);
			} else {
				Library library = this.libraryRepo.findOne(infoBean.getLibraryId());
				info.setLibrary(library);
				this.libraryInfoRepo.save(info);
			}
		}
		return infoBean;
	}

	public LibraryInfo OperationsAddingbooksToLibrary(LibraryInfoBean infoBean, BooksSubBean bean) {
		Assert.notNull(bean.getBookId(), "No book selected!");
		LibraryInfo info = new LibraryInfo();
		Books books = new Books();
		info = this.libraryInfoRepo.findByLibraryIdAndBookId(infoBean.getLibraryId(), bean.getBookId());
		books = this.booksRepo.findOne(bean.getBookId());
		Assert.notNull(books, "No book found with given Id");
		Integer count = books.getCopies();

		Assert.isTrue(count != 0, books.getTitle() + " Book not available");

		if (info == null) {
			info = new LibraryInfo();
			books.setCopies(count - bean.getCopies());
			this.booksRepo.save(books);
		}
		Assert.isTrue(bean.getCopies() <= 5, "Only 5 copies are allowed");
		if (info.getCopies() != 0) {
			if (bean.getCopies() > info.getCopies()) {
				int less = bean.getCopies() - info.getCopies();
				books.setCopies(count - less);
			} else if (bean.getCopies() < info.getCopies()) {
				int add = info.getCopies() - bean.getCopies();
				books.setCopies(count + add);
			}
			this.booksRepo.save(books);
		}
		info.setBook(books);
		info.setCopies(bean.getCopies());
		return info;
	}

	public Map<String, Object> LibraryBooks(Long id) {
		List<LibraryInfo> infos = this.libraryInfoRepo.findByLibraryId(id);
		List<BooksBean> beans = new ArrayList<BooksBean>();
		Library library = this.libraryRepo.getOne(id);
		Map<String, Object> map = new HashMap<>();
		for (LibraryInfo libraryInfo : infos) {
			Books book = this.booksRepo.findOne(libraryInfo.getBook().getId());
			BooksBean booksBean = bookInfos(book);
			booksBean.setCopies(libraryInfo.getCopies());
			beans.add(booksBean);
		}
		map.put("libraryDetails", library.getName());
		map.put("bookDetails", beans);
		beans.sort((a, b) -> a.getTitle().compareTo(b.getTitle()));
		return map;
	}

}
