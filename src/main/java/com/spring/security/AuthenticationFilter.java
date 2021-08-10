package com.spring.security;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.Gson;
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
		final String authToken = request.getHeader("Auth-Token");

		try {
			if (!this.isValid(authToken)) {
				throw new SecurityException("Authentication failed, please login to continue.");
			}

			final AppUser appUser = this.userService.getLoggedInAppUser(authToken);
			
			// throw exception if appUser is null
						if (appUser == null) {
							throw new AuthenticationException("Authentication failed, please login to continue.");
						}

						// Create our Authentication and let Spring know about it
						final Authentication auth = new DemoAuthenticationToken(appUser.getAuthorities(), appUser, appUser.getId());
						auth.setAuthenticated(true);
						SecurityContextHolder.getContext().setAuthentication(auth);
						filterChain.doFilter(request, response);

					} catch (SecurityException | AuthenticationException se) {
						final GeneralResponse genericResponse = new GeneralResponse(se.getMessage());
						response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
						response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
						response.getWriter().write(new Gson().toJson(genericResponse));
						// logger.error(se);
						se.printStackTrace();
					} catch (final Exception e) {
						final GeneralResponse genericResponse = new GeneralResponse(Constants.RESPONSE_FAILURE,
								"Something went wrong. Please try again in few moments");
						response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
						response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
						response.getWriter().write(new Gson().toJson(genericResponse));
						// logger.error(e);
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
