package com.medassi.resto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medassi.resto.entities.Menu;

public interface IMenuRepository  extends JpaRepository<Menu, Integer>{
	
}
