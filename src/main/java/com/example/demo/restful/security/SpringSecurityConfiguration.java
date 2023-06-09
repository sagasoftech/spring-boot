package com.example.demo.restful.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		//1. All request should be authenticated
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
		//2. If request is not authenticated, a web page will be shown
		http.httpBasic(withDefaults());
		
		//3. Disable CSRF - so that POST, PUT will work
		http.csrf().disable();
		
		return http.build();
	}
}
