package com.EmployeeManagementRest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.EmployeeManagementRest.service.UserDetailsService;

@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers("/api/roles/**").hasRole("ADMIN")
		.antMatchers("/api/users/**").hasRole("ADMIN")
		.antMatchers("/api/employees/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.httpBasic();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
	}

}
