package com.medassi.resto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medassi.resto.entities.Plat;
import com.medassi.resto.repositories.IPlatRepository;

@Service
public class PlatServiceImpl implements IPlatService {
	@Autowired IPlatRepository platRepository ;
	@Override
	public void sauvegarder(Plat p) {
		platRepository.save(p) ;
	}
	@Override
	public List<Plat> lister() {
		return platRepository.findAll() ;
	}
	

}
