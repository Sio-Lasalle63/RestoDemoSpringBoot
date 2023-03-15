package com.medassi.resto.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.medassi.resto.entities.Menu;
import com.medassi.resto.entities.Plat;
import com.medassi.resto.services.IMenuService;
import com.medassi.resto.services.IPlatService;

@RestController
public class RestoController {
	@Autowired IPlatService platService ;
	@Autowired IMenuService menuService ;

	@GetMapping("/")
	public String index() {
		return "Bienvenue au resto" ;
	}
	@GetMapping("/listPlats")
	public String listP() {
		/*String s = "<ul>" ;
		for(Plat p : platService.lister()) {
			s+="<li>"+p.getNom()+" "+p.getPx() +"</li>" ;
		}
		return s+"</ul>" ;*/
		return "listPlats" ;
	}
	@GetMapping("/listMenus")
	public String listM() {
		/*String s = "<ul>" ;
		for(Menu m : menuService.lister()) {
			s+="<li>"+m.getNom()+" "+m.getPx() +" ("+m.getPxALaCarte()+") </li>" ;
		}
		return s+"</ul>" ;*/
		return "listMenus" ;
	}
	@GetMapping("/addPlat/{nom}/{px}")
	public String addPlat(@PathVariable(name = "nom") String nom ,
			@PathVariable(name = "px") float px ) {
		Plat p = new Plat(nom,px) ;
		platService.sauvegarder(p) ;
		return nom + "-" +px ;
	}
	@GetMapping("/addMenu")
	public String addMenu( ) {
		return "Ajout menu";
	}



}
