package com.medassi.resto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String nom ;
	private Float px ;
	public Plat(String nom, Float px) {
		super();
		this.nom = nom;
		this.px = px;
	}
	public Plat() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNom() {
		return nom;
	}
	public Float getPx() {
		return px;
	}
	
	
}
