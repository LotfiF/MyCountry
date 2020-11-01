package com.projet.modeles;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pays")
public class Pays implements Serializable {
	
	@Id
	@GeneratedValue
	private int idPays;
	private String codeIso;
	private String nomPays;
	private String capitale;
	private String langue;
	private double surface;
	private double population;
	
	@OneToMany(mappedBy = "pays", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Region> regionsPays;
	
    public int getIdPays() { 
		return idPays; 
	}
	
	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}
	
	public String getCodeIso() { 
		return codeIso; 
	}
	
	public void setCodeIso(String codeIso) {
		this.codeIso = codeIso;
	}
	
	public String getNomPays() { 
		return nomPays; 
	}
	
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}
	
	public String getCapitale() { 
		return capitale; 
	}
	
	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}
	
	public String getLangue() { 
		return langue; 
	}
	
	public void setLangue(String langue) {
		this.langue = langue;
	}
	
	public double getSurface() { 
		return surface; 
	}
	
	public void setSurface(double surface) {
		this.surface = surface;
	}
	
	public double getPopulation() { 
		return population; 
	}
	
	public void setPopulation(double population) {
		this.population = population;
	}

	public List<Region> getRegionsPays() { 
		return regionsPays; 
	}

	public void setRegionsPays(List<Region> regionsPays) {
		this.regionsPays = regionsPays;
	}
	
}