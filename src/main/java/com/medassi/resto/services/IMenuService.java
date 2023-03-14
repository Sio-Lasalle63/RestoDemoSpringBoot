package com.medassi.resto.services;

import java.util.List;

import com.medassi.resto.entities.Menu;

public interface IMenuService {
	public void sauvegarder(Menu m) ;

	public List<Menu> lister();
}
