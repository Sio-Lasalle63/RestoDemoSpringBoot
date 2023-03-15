package com.medassi.resto.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Utilisateur implements UserDetails{
	@Id
	private String login ;
	private String nom ;
	private String prenom ;
	private String pass ;
	private Role role ;
	public Utilisateur() {
		super() ;
	}
	
	
	
	public Utilisateur(String login, String nom, String prenom, String pass, Role role) {
		super();
		this.login = login;
		this.nom = nom;
		this.prenom = prenom;
		this.pass = new BCryptPasswordEncoder().encode(pass);
		this.role = role;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> sesHabilitations = new ArrayList<>() ;
		SimpleGrantedAuthority habilitation = new SimpleGrantedAuthority(role.toString()) ;
		sesHabilitations.add(habilitation) ;
		return sesHabilitations;
	}
	@Override
	public String getPassword() {
		return pass;
	}
	@Override
	public String getUsername() {
		return login;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	
}
