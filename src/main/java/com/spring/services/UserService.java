package com.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.spring.beans.UserBean;
import com.spring.model.UserRecord;
import com.spring.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<UserBean> getAllUsers() {
		final List<UserBean> userBeans = new ArrayList<>();
		// return this.userRepository.findAll();
		/* Sending only required filds and sorting them increasing order*/
		for (final UserRecord ur : this.userRepository.findAll()) {
			UserBean bean = new UserBean();
			bean.appUserId = ur.id;
			bean.email = ur.email;
			bean.name = ur.name;
			// bean.mobileNumber = ur.mobileNumber;
			bean.employeeId = ur.employeeId;
			userBeans.add(bean);
		}
		userBeans.sort((a, b) -> a.appUserId.compareTo(b.appUserId));
		return userBeans;
	}

	public UserRecord getUser(Long userId) {
		
		UserRecord user = userRepository.findOne(userId);
		Assert.notNull(user,"No User found with the given userId");
		
//		final UserBean bean= new UserBean();
//		bean.userData.add(this.mapUserBeans(user));
		return user;
	}
	
	public UserBean mapUserBeans (UserRecord user){
		
		UserBean bean = new UserBean();
		bean.name = user.name;
		bean.email = user.email;
		bean.appUserId = user.id;
		bean.employeeId = user.employeeId;
		bean.mobileNumber = user.mobileNumber;
		return bean;
		
	}
	public UserRecord addUser(UserBean bean) {
		UserRecord user = new UserRecord();
		user.name = bean.name;
		user.email = bean.email;
		user.mobileNumber = bean.mobileNumber;
		user.employeeId = bean.employeeId;

		final UserRecord add = this.userRepository.save(user);
		return add;

	}

	public String deleteUser(Long userId) {
		final UserRecord user = this.userRepository.findOne(userId);
		Assert.notNull(user,"No User found with the given userId");
		this.userRepository.delete(user);
		return "User deleted successfully";
	}

	public UserRecord updateUser(UserBean bean) {
		UserRecord userRecord;
		userRecord = this.userRepository.findOne(bean.appUserId);
		Assert.notNull(userRecord,"No User found with the given userId");
		userRecord.name = bean.name;
		userRecord.email = bean.email;
		userRecord.mobileNumber = bean.mobileNumber;
		userRecord.employeeId = bean.employeeId;

		return this.userRepository.save(userRecord);

	}

}
