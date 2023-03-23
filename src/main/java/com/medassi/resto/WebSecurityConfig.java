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

import static org.springframework.security.config.Customizer.withDefaults;
import com.medassi.resto.services.UtilisateurServiceImpl;

@Configuration
public class WebSecurityConfig {
	@Autowired UtilisateurServiceImpl utilisateurServiceImpl ;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider() ;
		dao.setUserDetailsService( utilisateurServiceImpl);
		dao.setPasswordEncoder(encoder());
		return dao ;
	}
    @Bean
	BCryptPasswordEncoder encoder() {
		return encoder ;
	}
	

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(a -> a.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll())
		.headers(headers -> headers.frameOptions().disable())
		.csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")));
		
		http.authorizeHttpRequests(a -> a.requestMatchers(AntPathRequestMatcher.antMatcher("/")).permitAll() )
		.authorizeHttpRequests(a -> a.requestMatchers(AntPathRequestMatcher.antMatcher("/menus/**")).permitAll() ) 
		.authorizeHttpRequests(a -> a.requestMatchers(AntPathRequestMatcher.antMatcher("/plats")).permitAll() )
		.authorizeHttpRequests(a -> a.requestMatchers(AntPathRequestMatcher.antMatcher("/addMenu")).hasAuthority(Role.PROPRIO.toString()))
		.authorizeHttpRequests(a -> a.requestMatchers(AntPathRequestMatcher.antMatcher("/addPlat")).hasAnyAuthority(Role.PROPRIO.toString(),Role.CUISTO.toString())
				.anyRequest().denyAll());
        http.logout(withDefaults()) ;
        http.formLogin(withDefaults()) ;
		return http.build();
	}
}
