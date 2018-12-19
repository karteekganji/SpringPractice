package com.spring.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.spring.services.UserService;

@CrossOrigin
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityAuthenticationProvider demoAuthenticationProvider;
	
//	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		AccessDeniedHandler accessDeniedHandler = new AccessDeniedHandler() {
			@Override
			public void handle(HttpServletRequest request, HttpServletResponse response,
							   AccessDeniedException accessDeniedException) throws IOException, ServletException {
			}
		};
		return accessDeniedHandler;
	}
	
	
	@Override
	public void configure(final WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/","/api/signup", "/api/login","/api/logout","/api/get-cities");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
		http.csrf().disable().authorizeRequests()
//				.antMatchers("/api/admin/**").hasAnyAuthority("ADMIN")
				.antMatchers("/api/**").hasAnyAuthority("ADMIN", "USER","AUTHOR")
				.anyRequest().authenticated().and()
				.addFilterBefore(corsFilter(), ChannelProcessingFilter.class)
				.addFilterBefore(new AuthenticationFilter(this.userService), BasicAuthenticationFilter.class)
				.exceptionHandling().accessDeniedHandler(this.accessDeniedHandler);
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(this.demoAuthenticationProvider);
	}

	@Bean
	public Filter corsFilter() {
		UrlBasedCorsConfigurationSource url = new UrlBasedCorsConfigurationSource();

		CorsConfiguration cc = new CorsConfiguration();
		cc.setAllowCredentials(true);
		cc.addAllowedHeader("*");
		cc.addAllowedMethod("*");
		cc.addAllowedOrigin("*");

		url.registerCorsConfiguration("/**", cc);

		return new org.springframework.web.filter.CorsFilter(url);
	}
}