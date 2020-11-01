package com.projet.modeles;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="region")
public class Region implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String monument;
	private double regionNumber; 

	@ManyToOne
	@JoinColumn(name="idPays")
	private Pays pays;

	public int getId() { 
		return id; 
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() { 
		return nom; 
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getMonument() {
		return monument;
	}

	public void setMonument(String monument) {
		this.monument = monument;
	}

	public double getRegionNumber() {
		return regionNumber;
	}

	public void setRegionNumber(double regionNumber) {
		this.regionNumber = regionNumber;
	}

	public Pays getPays() { 
		return pays; 
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}
}
