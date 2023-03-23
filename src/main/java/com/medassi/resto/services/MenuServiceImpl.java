package com.medassi.resto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medassi.resto.entities.Menu;
import com.medassi.resto.entities.Plat;
import com.medassi.resto.repositories.IMenuRepository;
import com.medassi.resto.repositories.IPlatRepository;

@Service
public class MenuServiceImpl implements IMenuService {
	@Autowired IMenuRepository menuRepository ;
	@Override
	public void sauvegarder(Menu m) {
		menuRepository.save(m) ;
	}
	@Override
	public List<Menu> lister() {
		return menuRepository.findAll() ;
	}
	@Override
	public Menu rechercher(int id) {
		return menuRepository.findById(id).get() ;
	}
	

}
