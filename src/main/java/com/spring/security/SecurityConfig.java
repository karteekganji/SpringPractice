package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;

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
	private AccessDeniedHandler accessDeniedHandler;

	@Override
	public void configure(final WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/signup", "/login","/logout","/get-cities");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());

		http.csrf().disable().authorizeRequests()

				.antMatchers("/api/admin/**").hasAnyAuthority("ADMIN")

				.antMatchers("/api/**").hasAnyAuthority("USER", "AUTHOR", "ADMIN").anyRequest()
				.authenticated().and()

				.addFilterBefore(new AuthenticationFilter(this.userService), BasicAuthenticationFilter.class)
				.exceptionHandling().accessDeniedHandler(this.accessDeniedHandler);

	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(this.demoAuthenticationProvider);
	}
}