package com.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.CommandLineRunner;
import com.spring.enums.Role;
import com.spring.model.library.AppUser;
import com.spring.repo.Library.AppUserRepo;
import com.spring.utils.Constants;
import com.spring.utils.PracticeUtils;

@SpringBootApplication
@EnableJpaAuditing
public class PracticeSpringBootApplication implements CommandLineRunner{
	@Autowired
	private AppUserRepo appUserRepo;
	public static void main(String[] args)  {
		SpringApplication.run(PracticeSpringBootApplication.class, args);
		
	}
	@Override
	public void run(final String... arg0) throws Exception {
		final List<AppUser> appUsers = this.appUserRepo.findByRole(Role.ADMIN);
		if (appUsers.isEmpty()) {
			/**
			 * Saving Admin details in the DB(if details doesn't exist), at the
			 * time of application/code execution
			 */
			final AppUser appUser = new AppUser();
			appUser.setEmail(Constants.ADMIN_EMAIL);
			appUser.setIsActive(Boolean.TRUE);
			appUser.setMobileNumber("111111");
			appUser.setName("admin");
			
			appUser.setPassword(PracticeUtils.encryptPassword("admin"));
			appUser.setRole(Role.ADMIN);
			this.appUserRepo.save(appUser);
		}
	}
}
