package com.spring.services;

import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.beans.Library.AppUserBean;
import com.spring.beans.Library.LanguageBean;
import com.spring.model.library.AppUser;
import com.spring.model.library.City;
import com.spring.model.library.Language;
import com.spring.model.library.Library;
import com.spring.repo.Library.AppUserRepo;
import com.spring.repo.Library.CityRepo;
import com.spring.repo.Library.LanguageRepo;
import com.spring.repo.Library.LibraryRepo;
import com.spring.utils.PracticeUtils;


@Service
public class UserService {

	@Autowired
	private AppUserRepo userRepository;
	
	@Autowired
	private LanguageRepo languageRepository;
	
	@Autowired
	CityRepo cityRepo;
	
	@Autowired
	LibraryRepo libraryRepo;
	public List<AppUser> getAllUsers() {

		List<AppUser> list = this.userRepository.findByIsActiveTrue();
		list.sort((a, b) -> a.getId().compareTo(b.getId()));
		return list;

		// Sending only required filds and sorting them increasing order 
		/*final List<UserBean> userBeans = new ArrayList<>();
		for (final UserRecord ur : this.userRepository.findAll()) {
			UserBean bean = new UserBean();
			bean.appUserId = ur.id;
			bean.email = ur.email;
			bean.name = ur.name;
			bean.mobileNumber = ur.mobileNumber;
			bean.employeeId = ur.employeeId;
			userBeans.add(bean);
		}
		userBeans.sort((a, b) -> a.appUserId.compareTo(b.appUserId));

		return userBeans;*/
				
	}

	public AppUser getUser(Long userId) {

		AppUser user = this.userRepository.findOne(userId);
		Assert.notNull(user, "No User found with the given userId");

//		 final UserBean bean= new UserBean();
//		 bean.userData.add(this.mapUserBeans(user));
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

	public AppUser addUser(AppUserBean bean) {
		AppUser user;
		if (bean.appUserId !=null) {
			user = this.userRepository.findOne(bean.appUserId);
			Assert.isNull(
					this.userRepository.findByEmailIgnoreCaseAndIdNot(bean.email.trim().toLowerCase(), bean.appUserId),
					"Entered email is already registered.");
			Assert.isNull(this.userRepository.findByMobileNumberAndIdNot(bean.mobileNumber, bean.appUserId),
					"Entered mobile number is already registered.");
		}else {
			user = new AppUser();
			Assert.isNull(this.userRepository.findByEmailIgnoreCase(bean.email.trim().toLowerCase()),
					"Entered email is already registered.");
			Assert.isNull(this.userRepository.findByMobileNumber(bean.mobileNumber),
					"Entered mobile number is already registered.");
			user.password = bean.password;
		}
		user.name = bean.name;
		user.email = bean.email;
		user.mobileNumber = bean.mobileNumber;
		City city = this.cityRepo.findByCityCode(bean.getCityCode());
		if (PracticeUtils.isNotEmpty(city)) {
			user.setCity(city.getCityName());
		}else {
			throw new IllegalArgumentException("Entered city code is wrong");
		}
		user.setGender(bean.getGender());

		final AppUser add = this.userRepository.save(user);
		return add;
	}
	
	public TreeMap<String, Object> login(AppUserBean bean) {
		AppUser user = this.userRepository.findByEmailIgnoreCase(bean.email);
		if (user==null) {
			throw new NullPointerException("You're password or email is wrong");
		}
		
		if (user.password.equals(bean.password)) {
			user.auth = PracticeUtils.RandomStrInt();
			this.userRepository.save(user);
			List<Library> list = this.libraryRepo.findByCity(bean.getCity());
			list.sort((a,b) -> a.getId().compareTo(b.getId()));
			TreeMap<String, Object> map = new TreeMap<String, Object>();
			map.put("Libraries", list);
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
		language.isDeleted = bean.isDeleted;
		return this.languageRepository.save(language);

	}
	
	public List<Language> getAllLanguages() {
		return this.languageRepository.findByIsDeleted(Boolean.FALSE);
		// return this.languageRepository.findAll();
	}
	
	public String deleteLanguage(Long languageId){
		Language lang = this.languageRepository.findOne(languageId);
		lang.isDeleted = Boolean.TRUE;
		this.languageRepository.save(lang);
		return "Language Deleted successfully";
	}
	
	public Language getLanguage(Long langid){
		return this.languageRepository.findOne(langid);
	}

	public List<City> getCities() {

		List<City> cities = this.cityRepo.findAll();
		cities.sort((a, b) -> a.getId().compareTo(b.getId()));
		return cities;
	}

}
