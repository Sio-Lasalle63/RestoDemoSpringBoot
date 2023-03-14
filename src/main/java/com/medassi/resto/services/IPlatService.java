package com.medassi.resto.services;

import java.util.List;

import com.medassi.resto.entities.Plat;

public interface IPlatService {
	public void sauvegarder(Plat p) ;

	public List<Plat> lister();
}
