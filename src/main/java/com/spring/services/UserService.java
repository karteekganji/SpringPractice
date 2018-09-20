package com.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.beans.user.LanguageBean;
import com.spring.beans.user.LanguageInfoBean;
import com.spring.beans.user.UserBean;
import com.spring.model.user.Language;
import com.spring.model.user.UserLanguageInfo;
import com.spring.model.user.UserRecord;
import com.spring.repo.user.LanguageRepository;
import com.spring.repo.user.UserRepository;
import com.spring.repo.user.userLanguageInfoRepository;
import com.spring.utils.PracticeUtils;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LanguageRepository languageRepository;
	
	@Autowired
	private userLanguageInfoRepository userLanguageInfoRepository;
	
	public List<UserRecord> getAllUsers() {

		List<UserRecord> list = this.userRepository.findByIsActiveTrue();
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

	public UserRecord getUser(Long userId) {

		UserRecord user = this.userRepository.findOne(userId);
		Assert.notNull(user, "No User found with the given userId");

//		 final UserBean bean= new UserBean();
//		 bean.userData.add(this.mapUserBeans(user));
		return user;
	}

	public UserBean mapUserBeans(UserRecord user) {

		UserBean bean = new UserBean();
		bean.name = user.name;
		bean.email = user.email;
		bean.appUserId = user.id;
		bean.mobileNumber = user.mobileNumber;
		return bean;
	}

	public UserRecord addUser(UserBean bean) {
		UserRecord user = new UserRecord();
		Assert.isNull(this.userRepository.findByEmailIgnoreCase(bean.email.trim().toLowerCase()),
				"Entered email is already registered.");
		Assert.isNull(this.userRepository.findByMobileNumber(bean.mobileNumber),
				"Entered mobile number is already registered.");
		Assert.isNull(this.userRepository.findByEmployeeId(bean.employeeId),
				"Employee ID is already registered.");
		
		user.name = bean.name;
		user.email = bean.email;
		user.mobileNumber = bean.mobileNumber;
		user.password = bean.password;

		final UserRecord add = this.userRepository.save(user);
		return add;
	}
	
	public UserRecord login(UserBean bean) {

		UserRecord user = this.userRepository.findByEmailIgnoreCase(bean.email);

		if (user.password.equals(bean.password)) {
			user.auth = PracticeUtils.RandomStrInt();
			return this.userRepository.save(user);
		} else {
			throw new IllegalArgumentException("You're password or email is wrong");
		}
	}
	
	public String deleteUser(Long userId) {
		final UserRecord user = this.userRepository.findOne(userId);
		Assert.notNull(user, "No User found with the given userId");
		this.userRepository.delete(user);
		return "User deleted successfully";
	}

	public UserRecord updateUser(UserBean bean) {
		UserRecord userRecord;
		userRecord = this.userRepository.findOne(bean.appUserId);
		Assert.isNull(
				this.userRepository.findByEmailIgnoreCaseAndIdNot(bean.email.trim().toLowerCase(), bean.appUserId),
				"Entered email is already registered.");
		Assert.isNull(this.userRepository.findByMobileNumberAndIdNot(bean.mobileNumber, bean.appUserId),
				"Entered mobile number is already registered.");
		Assert.isNull(this.userRepository.findByEmployeeIdAndIdNot(bean.employeeId, bean.appUserId),
				"Employee ID is already registered.");
		Assert.notNull(userRecord, "No User found with the given userId");
		userRecord.name = bean.name;
		userRecord.email = bean.email;
		userRecord.mobileNumber = bean.mobileNumber;
		userRecord.password = bean.password;

		return this.userRepository.save(userRecord);
	}

	public Language saveOrUpdateLanguage(LanguageBean bean) {
		Language language;

		if (bean.languageId != null) {
			language = this.languageRepository.findOne(bean.languageId);
			Assert.notNull(language, "No Language found !!");
			Assert.isNull(this.languageRepository.findByNameIgnoreCaseAndIdNot(bean.languageTitle, bean.languageId),
					"Language already exists with the given name.");
			language.name = bean.languageTitle;
		} else {
			language = new Language();
			Assert.isNull(this.languageRepository.findByNameIgnoreCase(bean.languageTitle),
					"Language already exists with the given name.");
			language.name = bean.languageTitle;
		}

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

	public UserLanguageInfo saveUserLanguageInfo(LanguageInfoBean langBean) {

		UserRecord user = this.userRepository.findOne(langBean.appUserId);
		Language language = this.languageRepository.findOne(langBean.languageId);

		UserLanguageInfo langinfo = new UserLanguageInfo();

		langinfo.appUser = user;
		langinfo.language = language;

		List<UserLanguageInfo> data = this.userLanguageInfoRepository.findByAppUserIdAndLanguageId(langBean.appUserId,
				langBean.languageId);

		if (data.isEmpty()) {
			return this.userLanguageInfoRepository.save(langinfo);
		} else {
			throw new IllegalArgumentException("You cannot add duplicate lanuages to one user");
		}
	}
	
	public UserBean getUserLanguages(Long userId) {
		final UserBean bean = new UserBean();
		bean.userLanguageInfos = this.mapUserLanguageInfoBeans(userId);
		return bean;
	}

	public List<LanguageBean> mapUserLanguageInfoBeans(Long userId) {
		final List<LanguageBean> languageBeans = new ArrayList<>();
		final List<UserLanguageInfo> userLanguageInfos = this.userLanguageInfoRepository.findByAppUserId(userId);
		Assert.notEmpty(userLanguageInfos, "No language Info found for given user");
		for (final UserLanguageInfo userLanguageInfo : userLanguageInfos) {
			final LanguageBean languageBean = new LanguageBean();
			languageBean.languageId = userLanguageInfo.language.id;
			languageBean.languageTitle = userLanguageInfo.language.name;
			languageBeans.add(languageBean);
		}
		return languageBeans;
	}
	
	

}
