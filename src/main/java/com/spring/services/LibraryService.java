package com.spring.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.beans.Library.BooksBean;
import com.spring.beans.Library.BooksSubBean;
import com.spring.beans.Library.CategoryBean;
import com.spring.beans.Library.LibraryBean;
import com.spring.beans.Library.LibraryInfoBean;
import com.spring.beans.Library.PageRequestBean;
import com.spring.beans.Library.PublisherBean;
import com.spring.enums.Role;
import com.spring.model.library.AppUser;
import com.spring.model.library.Author;
import com.spring.model.library.Books;
import com.spring.model.library.Category;
import com.spring.model.library.City;
import com.spring.model.library.Language;
import com.spring.model.library.Library;
import com.spring.model.library.LibraryInfo;
import com.spring.model.library.Publisher;
import com.spring.repo.Library.AppUserRepo;
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
	private LibraryRepo libraryRepo;
	@Autowired
	private CityRepo cityRepo;
	@Autowired
	private BooksRepo booksRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private LanguageRepo languageRepo;
	@Autowired
	private PublisherRepo publisherRepo;
	@Autowired
	private LibraryInfoRepo libraryInfoRepo;
	@Autowired
	private AuthorRepo authorRepo;
	@Autowired
	private AppUserRepo appUserRepo;
	
	@Autowired
	private UserService userService; 
	@Autowired
	private EntityManager entityManager;
	
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

	public List<Library> getAllLibrarys(Long cityId, String authToken) {
		if (cityId != null) {
			City city = this.cityRepo.findOne(cityId);
			Assert.notNull(city, "Selected city is not available");
		}
		AppUser appUser = this.appUserRepo.findByAuth(authToken);
		List<Library> libraries;
		if (cityId != null) {
			if (appUser.getRole().equals(Role.ADMIN)) {
				libraries = this.libraryRepo.findByCityId(cityId);
			} else {
				libraries = this.libraryRepo.findByCityIdAndIsActiveTrue(cityId);
			}
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
		Library library = this.libraryRepo.findOne(Id);
		Assert.notNull(library, "No library found");
		this.libraryRepo.delete(library);
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
		this.booksRepo.save(book);
		return bookInfos(book);
	}

	public BooksBean getBook(Long Id) {
		Books books = this.booksRepo.findOne(Id);
		Assert.notNull(books, "No Book found with given Id");
		return bookInfos(books);
	}

	public List<BooksBean> getAllBooks(String xAuth /*, PageRequestBean bean*/) {
		AppUser user = userService.getLoggedInAppUser(xAuth);
		List<Books> books = this.booksRepo.findAll();
		
		/*CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Books> criteriaQuery = builder.createQuery(Books.class);
		Root<Books> customerRoot = criteriaQuery.from(Books.class);
		this.applyFiltersForIndividualCustomer(builder, criteriaQuery, customerRoot, bean, user, false);
		TypedQuery<Books> customQuery = entityManager.createQuery(criteriaQuery);
		customQuery.setFirstResult(bean.getStart());
		customQuery.setMaxResults(bean.getNumberOfRecords());

		CriteriaQuery<Long> countCriteriaQuery = builder.createQuery(Long.class);
		Root<Books> countRoot = countCriteriaQuery.from(Books.class);
		countCriteriaQuery.select(builder.count(countRoot));
		this.applyFiltersForIndividualCustomer(builder, countCriteriaQuery, countRoot, bean, user, true);
		Long totalRecords = entityManager.createQuery(countCriteriaQuery).getSingleResult();*/
		
		
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
		bean.setCopies(book.getCopies());
		bean.setIsActive(book.getIsActive());
		if (book.getCategory() != null) {
			bean.setCategoryName(book.getCategory().getName());
			bean.setCategoryId(book.getCategory().getId());
		}else {
			bean.setCategoryName("No Category");
		}
		if (book.getAuthor() != null) {
			bean.setAuthorName(book.getAuthor().getAppUser().getName());
			bean.setAuthorId(book.getAuthor().getAppUser().getId());
		}else {
			bean.setAuthorName("No Author");
		}
		if (book.getLanguage() != null) {
			bean.setLanguageName(book.getLanguage().getName());
			bean.setLanguageId(book.getLanguage().getId());
		}else {
			bean.setLanguageName("No Language");
		}
		if (book.getPublisher() != null) {
			bean.setPublisherName(book.getPublisher().getName());
			bean.setPublisherId(book.getPublisher().getId());
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
		this.booksRepo.delete(book);
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
