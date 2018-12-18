package com.spring.security;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.model.library.AppUser;
import com.spring.services.UserService;
import com.spring.utils.Constants;
import com.spring.utils.GeneralResponse;

@CrossOrigin
public class AuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private final UserService userService;

	private static final Logger logger = Logger.getLogger(AuthenticationFilter.class);

	public AuthenticationFilter(final UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException {

		logger.info("  ---  url " + request.getRequestURL());
		final String xAuth = request.getHeader("Auth-Token");

		try {
			if (!this.isValid(xAuth)) {
				throw new SecurityException("Authentication failed, please login to continue.");
			}

			final AppUser appUser = this.userService.getLoggedInAppUser(xAuth);

			// throw exception if appUser is null
			if (appUser == null) {
				throw new AuthenticationException("Authentication failed, please login to continue.");
			}

		} catch (SecurityException | AuthenticationException e) {
			new GeneralResponse(Constants.RESPONSE_FAILURE, "Something went wrong. Please try again in few moments");
			e.printStackTrace();
		} catch (Exception e) {
			new GeneralResponse(Constants.RESPONSE_FAILURE, "Something went wrong. Please try again in few moments");
			e.printStackTrace();
		}

	}

	private boolean isValid(final String authToken) {
		if ((authToken != null) && (authToken != "") && !authToken.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
