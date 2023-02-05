package com.percyku.restaurant.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//add our users for in memory authentication
//		UserBuilder users =User.withDefaultPasswordEncoder();
//
//		auth.inMemoryAuthentication()
//		.withUser(users.username("percy").password("test123").roles("Boss"))
//		.withUser(users.username("mary").password("test123").roles("Manager"))
//		.withUser(users.username("susan").password("test123").roles("admin"));

		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		UserDetails theManager = User.builder()
				.username("percy")
				.password(passwordEncoder.encode("test123"))
				.roles("Manager","Patron")
				.build();


		UserDetails thePatron = User.builder()
				.username("paul")
				.password(passwordEncoder.encode("test123"))
				.roles("Patron")
				.build();


		UserDetails thePerson = User.builder()
				.username("test")
				.password(passwordEncoder.encode("test123"))
				.roles("Manager")
				.build();



		auth.inMemoryAuthentication()
				.withUser(theManager)
				.withUser(thePatron)
				.withUser(thePerson);


	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/").hasAnyRole()
				.antMatchers("/order/**").hasRole("Patron")
				.antMatchers("/manage/processorder").hasRole("Manager")
				.and().formLogin().loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll()
				.and().logout().permitAll()
				.and().exceptionHandling().accessDeniedPage("/access-denied");
	}





}
