package com.projet.services;

import java.util.List;

import com.projet.modeles.Pays;
import com.projet.modeles.Region;

public interface IRegionService {
	
	public List<Region> recupererListeRegions() throws Exception;
	
	public void ajouterRegion(Region region) throws Exception;
	
	public String supprimerRegionParNom(String nom) throws Exception;
	
	public Region trouverRegion(int id) throws Exception;
	
	public void updateRegion(Region region) throws Exception;
	
	public List<Region> recupererListeRegionsParPays(Pays pays) throws Exception;
	
}
