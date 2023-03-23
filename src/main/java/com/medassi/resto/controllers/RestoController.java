package com.medassi.resto.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medassi.resto.entities.Plat;
import com.medassi.resto.services.IMenuService;
import com.medassi.resto.services.IPlatService;

@Controller
public class RestoController {
	@Autowired IPlatService platService ;
	@Autowired IMenuService menuService ;

	@GetMapping(value = {"/","/index"})
	public String index() {
		return "index" ;
	}
	@GetMapping("/plats")
	public String listPlats(Model m) {
		m.addAttribute("plats", platService.lister());
		return "plats" ;
	}
	
	@GetMapping("/menus")
	public String listMenus(Model m) {
		m.addAttribute("menus", menuService.lister());
		return "menus" ;
	}
	
	@GetMapping("/menus/{id}")
	public String listMenusPlats(@PathVariable int id , Model  m) {
		m.addAttribute("plats", menuService.rechercher(id).getLesPlats());
		return "plats" ;
	}
	
	@PostMapping("/addPlat")
	public String addPlat(@RequestParam String nom ,
			@RequestParam Float px ) {
		Plat p = new Plat(nom,px) ;
		System.out.println("On ajoute le plat");
		platService.sauvegarder(p) ;
		return "index" ;
	}
	
}
