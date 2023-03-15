package com.medassi.resto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.medassi.resto.entities.Menu;
import com.medassi.resto.entities.Plat;
import com.medassi.resto.entities.Role;
import com.medassi.resto.entities.Utilisateur;
import com.medassi.resto.repositories.IUtilisateurRepository;
import com.medassi.resto.services.IMenuService;
import com.medassi.resto.services.IPlatService;
import com.medassi.resto.services.UtilisateurServiceImpl;

@Component
public class DataInject implements CommandLineRunner{
	@Autowired IPlatService platService ;
	@Autowired IMenuService menuService ;
	@Autowired UtilisateurServiceImpl utilisateurService ;
	
	@Override
	public void run(String... args) throws Exception {
		Plat p1 = new Plat("Couscous",18) ;
		Plat p2 = new Plat("Boeuf bourguignon",21) ;
		Plat p3 = new Plat("Aligot",17) ;
		Plat p4 = new Plat("Oeuf mimosa",7) ;
		Plat p5 = new Plat("Tiramisu",6) ;
		platService.sauvegarder(p1);
		platService.sauvegarder(p2);
		platService.sauvegarder(p3);
		platService.sauvegarder(p4);
		platService.sauvegarder(p5);
		
		Menu mFrenchy = new Menu("Frenchy",30) ;
		mFrenchy.getLesPlats().add(p2) ;
		mFrenchy.getLesPlats().add(p4) ;
		mFrenchy.getLesPlats().add(p5) ;
		menuService.sauvegarder(mFrenchy);
		
		/*Menu mAuv = new Menu("Auvergnat",10) ;
		mAuv.getLesPlats().add(p3) ;
		mAuv.getLesPlats().add(p4) ;
		menuService.sauvegarder(mAuv);*/
		
		creerUtilisateurs() ;
		
	}
	private void creerUtilisateurs() {
		Utilisateur u1 = new Utilisateur("toto", "TOTO", "Toto", "pass", Role.CUISTO) ;
		Utilisateur u2 = new Utilisateur("titi", "TITI", "Titi", "pass", Role.PROPRIO) ;
		utilisateurService.sauvegarder(u1);
		utilisateurService.sauvegarder(u2); 
	}

}
