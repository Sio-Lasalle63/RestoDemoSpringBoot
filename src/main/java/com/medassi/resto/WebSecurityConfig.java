package com.medassi.resto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.medassi.resto.entities.Role;
import com.medassi.resto.services.UtilisateurServiceImpl;

import jakarta.servlet.FilterChain;

@Configuration
public class WebSecurityConfig {
	@Autowired UtilisateurServiceImpl utilisateurServiceImpl ;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider() ;
		dao.setUserDetailsService( utilisateurServiceImpl);
		dao.setPasswordEncoder(new BCryptPasswordEncoder());
		return dao ;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(a -> a.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll())
		.headers(headers -> headers.frameOptions().disable())
		.csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")));
		http.authorizeHttpRequests(a -> a.requestMatchers(AntPathRequestMatcher.antMatcher("/listMenus")).permitAll() ) ;
		http.authorizeHttpRequests(a -> a.requestMatchers(AntPathRequestMatcher.antMatcher("/listPlats")).permitAll() ) ;
		http.authorizeHttpRequests(a -> a.requestMatchers(AntPathRequestMatcher.antMatcher("/addMenu/**"))
				.hasAuthority(Role.PROPRIO.toString())) ;
		http.authorizeHttpRequests(a -> a.requestMatchers(AntPathRequestMatcher.antMatcher("/addPlat/**"))
				.hasAnyAuthority(Role.PROPRIO.toString(),Role.CUISTO.toString())) ;
		http.authorizeHttpRequests(a -> a.requestMatchers(AntPathRequestMatcher.antMatcher("/")).permitAll()) ;
		http.logout() ;
		http.formLogin() ;
		return http.build();
	}
}
