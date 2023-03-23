package com.medassi.resto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.medassi.resto.entities.Utilisateur;
import com.medassi.resto.repositories.IUtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UserDetailsService{
	@Autowired private IUtilisateurRepository utilisateurRepository ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> optU = utilisateurRepository.findById(username) ;
		if( optU.isEmpty() ) {
			throw new UsernameNotFoundException("Personne ki s'appelle comme ça !!!") ;
		}else{
			return optU.get() ;
		}
	}

	public void sauvegarder(Utilisateur u) {
		utilisateurRepository.save(u) ;
	}

}
