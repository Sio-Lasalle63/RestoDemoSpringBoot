package com.medassi.resto.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.medassi.resto.entities.Plat;
import com.medassi.resto.services.IPlatService;

@RestController
public class RestoController {
	@Autowired IPlatService platService ;
	
	
	@GetMapping("/")
	public String index() {
		return "coucou" ;
	}
	@GetMapping("/listPlats")
	public String list() {
		String s = "" ;
		for(Plat p : platService.lister()) {
			s+=p.getNom()+" "+p.getPx() +"<br>" ;
		}
		return s ;
	}
	@GetMapping("/addPlat/{nom}/{px}")
	public String addPlat(@PathVariable(name = "nom") String nom ,
			@PathVariable(name = "px") float px ) {
		Plat p = new Plat(nom,px) ;
		platService.sauvegarder(p) ;
		return nom + "-" +px ;
	}


}
