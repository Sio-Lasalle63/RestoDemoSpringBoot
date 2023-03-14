package com.medassi.resto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medassi.resto.entities.Plat;

public interface IPlatRepository  extends JpaRepository<Plat, Integer>{
	
}
