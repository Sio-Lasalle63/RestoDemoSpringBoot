package com.medassi.resto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.medassi.resto.entities.Role;
import com.medassi.resto.entities.Utilisateur;
import com.medassi.resto.services.IMenuService;
import com.medassi.resto.services.IPlatService;
import com.medassi.resto.services.UtilisateurServiceImpl;

@Component
public class UsersInjection implements CommandLineRunner{
	@Autowired IPlatService platService ;
	@Autowired IMenuService menuService ;
	@Autowired UtilisateurServiceImpl utilisateurService ;
	@Autowired BCryptPasswordEncoder encoder ;
	
	@Override
	public void run(String... args) throws Exception {
		creerUtilisateurs() ;
	}
	private void creerUtilisateurs() {
		Utilisateur u1 = new Utilisateur("toto", "TOTO", "Toto", encoder.encode("toto"), Role.CUISTO) ;
		Utilisateur u2 = new Utilisateur("titi", "TITI", "Titi", encoder.encode("titi"), Role.PROPRIO) ;
		utilisateurService.sauvegarder(u1);
		utilisateurService.sauvegarder(u2); 
	}

}
