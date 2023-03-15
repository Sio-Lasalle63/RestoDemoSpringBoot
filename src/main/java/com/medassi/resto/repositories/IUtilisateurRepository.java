package com.medassi.resto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medassi.resto.entities.Menu;
import com.medassi.resto.entities.Utilisateur;

public interface IUtilisateurRepository  extends JpaRepository<Utilisateur, String>{
	
}
