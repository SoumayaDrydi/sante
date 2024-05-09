package com.iset.sante.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
@Entity
public class Regime {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name="idregime")
	private int idregime;
	private String typeregime;
	public Regime() {}
	public Regime(int idregime, String typeregime) {
		super();
		this.idregime = idregime;
		this.typeregime = typeregime;
	}
	public int getIdregime() {
		return idregime;
	}
	public void setIdregime(int idregime) {
		this.idregime = idregime;
	}
	
	@ManyToMany(mappedBy = "regimes")
    private Set<Profil> Profil = new HashSet<>();
	public String getTyperegime() {
		return typeregime;
	}
	public void setTyperegime(String typeregime) {
		this.typeregime = typeregime;
	}
}
