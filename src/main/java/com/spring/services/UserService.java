package com.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.beans.Library.AppUserBean;
import com.spring.beans.Library.CityBean;
import com.spring.beans.Library.LanguageBean;
import com.spring.beans.Library.LibraryBean;
import com.spring.beans.Library.UserActivityBean;
import com.spring.enums.Role;
import com.spring.model.library.AppUser;
import com.spring.model.library.Author;
import com.spring.model.library.Books;
import com.spring.model.library.City;
import com.spring.model.library.Language;
import com.spring.model.library.Library;
import com.spring.model.library.LibraryInfo;
import com.spring.model.library.UserActivity;
import com.spring.repo.Library.AppUserRepo;
import com.spring.repo.Library.AuthorRepo;
import com.spring.repo.Library.BooksRepo;
import com.spring.repo.Library.CityRepo;
import com.spring.repo.Library.LanguageRepo;
import com.spring.repo.Library.LibraryInfoRepo;
import com.spring.repo.Library.LibraryRepo;
import com.spring.repo.Library.UserActivityRepo;
import com.spring.utils.PracticeUtils;

@Service
public class UserService {

	@Autowired
	private AppUserRepo userRepository;
	@Autowired
	private LanguageRepo languageRepository;
	@Autowired
	private CityRepo cityRepo;
	@Autowired
	private LibraryRepo libraryRepo;
	@Autowired
	private AuthorRepo authorRepo;
	@Autowired
	private LibraryInfoRepo libraryInfoRepo;
	@Autowired
	private BooksRepo booksRepo;
	@Autowired
	private UserActivityRepo userActivityRepo;

	public List<AppUser> getAllUsers() {

		List<AppUser> list = this.userRepository.findByIsActiveTrue();
		list.sort((a, b) -> a.getId().compareTo(b.getId()));
		return list;

		// Sending only required filds and sorting them increasing order
		/*
		 * final List<UserBean> userBeans = new ArrayList<>(); for (final
		 * UserRecord ur : this.userRepository.findAll()) { UserBean bean = new
		 * UserBean(); bean.appUserId = ur.id; bean.email = ur.email; bean.name
		 * = ur.name; bean.mobileNumber = ur.mobileNumber; bean.employeeId =
		 * ur.employeeId; userBeans.add(bean); } userBeans.sort((a, b) ->
		 * a.appUserId.compareTo(b.appUserId));
		 * 
		 * return userBeans;
		 */

	}

	public AppUser getUser(Long userId) {

		AppUser user = this.userRepository.findOne(userId);
		Assert.notNull(user, "No User found with the given userId");

		// final UserBean bean= new UserBean();
		// bean.userData.add(this.mapUserBeans(user));
		return user;
	}

	public AppUserBean mapUserBeans(AppUser user) {

		AppUserBean bean = new AppUserBean();
		bean.name = user.name;
		bean.email = user.email;
		bean.appUserId = user.id;
		bean.mobileNumber = user.mobileNumber;
		return bean;
	}

	public AppUser signUp(AppUserBean bean) {
		AppUser user;
		if (bean.appUserId != null) {
			user = this.userRepository.findOne(bean.appUserId);
			Assert.isNull(
					this.userRepository.findByEmailIgnoreCaseAndIdNot(bean.email.trim().toLowerCase(), bean.appUserId),
					"Entered email is already registered.");
			Assert.isNull(this.userRepository.findByMobileNumberAndIdNot(bean.mobileNumber, bean.appUserId),
					"Entered mobile number is already registered.");
		} else {
			user = new AppUser();
			Assert.isNull(this.userRepository.findByEmailIgnoreCase(bean.email.trim().toLowerCase()),
					"Entered email is already registered.");
			Assert.isNull(this.userRepository.findByMobileNumber(bean.mobileNumber),
					"Entered mobile number is already registered.");
			user.password = PracticeUtils.encryptPassword(bean.password);
		}
		user.name = bean.name;
		user.email = bean.email;
		user.mobileNumber = bean.mobileNumber;
		City city = this.cityRepo.findByCityCode(bean.getCityCode());
		if (PracticeUtils.isNotEmpty(city)) {
			user.setCity(city.getCityName());
		} else {
			throw new IllegalArgumentException("Entered city code is wrong");
		}
		user.setGender(bean.getGender());
		user.setRole(bean.getRole());
		if (bean.getRole().equals(Role.AUTHOR)) {
			Author author = new Author();
			author.appUser = user;
			this.authorRepo.save(author);
		}
		final AppUser add = this.userRepository.save(user);
		return add;
	}

	public TreeMap<String, Object> login(AppUserBean bean) {
		AppUser user = this.userRepository.findByEmailIgnoreCase(bean.email);
		if (user == null) {
			throw new NullPointerException("You're password or email is wrong");
		}

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		if (passwordEncoder.matches(bean.getPassword(), user.getPassword())) {
			user.auth = PracticeUtils.RandomStrInt();
			this.userRepository.save(user);
			List<Library> list = this.libraryRepo.findByCityCityCode(bean.getCityCode());
			List<LibraryBean> beans = new ArrayList<>();
			for (Library library : list) {
				LibraryBean bean2 = new LibraryBean();
				bean2.setName(library.getName());
				bean2.setAddress(library.getAddress());
				bean2.setId(library.getId());
				beans.add(bean2);
			}
			beans.sort((a, b) -> a.getId().compareTo(b.getId()));
			TreeMap<String, Object> map = new TreeMap<String, Object>();
			map.put("libraries", beans);
			map.put("userDetails", user);
			return map;
		} else {
			throw new IllegalArgumentException("You're password or email is wrong");
		}
	}

	public String deleteUser(Long userId) {
		final AppUser user = this.userRepository.findOne(userId);
		Assert.notNull(user, "No User found with the given userId");
		this.userRepository.delete(user);
		return "User deleted successfully";
	}

	public Language saveOrUpdateLanguage(LanguageBean bean) {
		Language language;

		if (bean.languageId != null) {
			language = this.languageRepository.findOne(bean.languageId);
			Assert.notNull(language, "No Language found !!");
			Assert.isNull(this.languageRepository.findByNameIgnoreCaseAndIdNot(bean.name, bean.languageId),
					"Language already exists with the given name.");
		} else {
			language = new Language();
			Assert.isNull(this.languageRepository.findByNameIgnoreCase(bean.name),
					"Language already exists with the given name.");
		}
		language.name = bean.name;
		language.isActive = bean.isActive;
		return this.languageRepository.save(language);

	}

	public List<Language> getAllLanguages() {
		return this.languageRepository.findByIsActive(Boolean.TRUE);
		// return this.languageRepository.findAll();
	}

	public String deleteLanguage(Long languageId) {
		Language lang = this.languageRepository.findOne(languageId);
		lang.setIsActive(Boolean.FALSE);
		this.languageRepository.save(lang);
		return "Language Deleted successfully";
	}

	public Language getLanguage(Long langid) {
		return this.languageRepository.findOne(langid);
	}

	public City addCity(CityBean bean) {
		City city;
		if (bean.getCityId() != null) {
			city = this.cityRepo.findOne(bean.getCityId());
		} else {
			city = new City();
		}
		city.setCityCode(bean.getCityCode());
		city.setCityName(bean.getCityName());
		this.cityRepo.save(city);
		return city;
	}

	public List<City> getCities() {

		List<City> cities = this.cityRepo.findAll();
		cities.sort((a, b) -> a.getId().compareTo(b.getId()));
		return cities;
	}

	public String userAddingBookToCart(UserActivityBean bean) {
		List<LibraryInfo> infos = this.libraryInfoRepo.findByLibraryId(bean.getLibraryId());
		List<Long> bookId = new ArrayList<>();
		infos.forEach(a -> bookId.add(a.book.getId()));
		Assert.isTrue(bookId.contains(bean.getBookId()), "Selected Book is not available in this library");
		LibraryInfo libraryInfo = this.libraryInfoRepo.findByLibraryIdAndBookId(bean.getLibraryId(), bean.getBookId());
		UserActivity activity;
		activity = this.userActivityRepo.findByAppUserIdAndBookId(bean.appUserId, bean.bookId);
		Integer copies = libraryInfo.getCopies();
		if (activity == null) {
			activity = new UserActivity();
			copies = libraryInfo.getCopies() - bean.getCopies();
			libraryInfo.setCopies(copies);
			Assert.isTrue(bean.getCopies() != 0, "No copies selected!");
		}
		if (activity.getCopies() != null) {
			Assert.isTrue(activity.getCopies() + libraryInfo.getCopies() == bean.getCopies()|| bean.getCopies() < activity.getCopies(),libraryInfo.getCopies() + " copy/copies are available");
		}
		AppUser appUser = this.userRepository.findOne(bean.appUserId);
		activity.setAppUser(appUser);
		Books books = this.booksRepo.findOne(bean.getBookId());
		activity.setBook(books);
		Library library = this.libraryRepo.findOne(bean.getLibraryId());
		activity.setLibrary(library);
		if (activity.getCopies() != null) {
			if (bean.getCopies() > activity.getCopies()) {
				int less = bean.getCopies() - activity.getCopies();
				libraryInfo.setCopies(copies - less);
			} else if (bean.getCopies() < activity.getCopies()) {
				int add = activity.getCopies() - bean.getCopies();
				libraryInfo.setCopies(copies + add);
			}
			this.libraryInfoRepo.save(libraryInfo);
		}
		activity.setCopies(bean.getCopies());
		this.userActivityRepo.save(activity);
		return "Successfully Added";
	}
}
