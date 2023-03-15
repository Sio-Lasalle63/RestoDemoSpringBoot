package com.medassi.resto.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String nom ;
	private float px ;
	@OneToMany
	@JoinColumn(name="id_menu")
	private List<Plat> lesPlats = new ArrayList<>();
	
	public Menu(String nom, float px) {
		super();
		this.nom = nom;
		this.px = px;
	}


	public String getNom() {
		return nom;
	}
	public float getPx() {
		return px;
	}

	public Menu() {
		super();
	}

	public List<Plat> getLesPlats() {
		return lesPlats;
	}
	
	public float getPxALaCarte() {
		float total = 0 ;
		for( Plat p : this.lesPlats) {
			total+=p.getPx() ;
		}
		return total ;
		
	}

}
