package com.projet.dao;

import java.util.List;

import com.projet.modeles.Pays;
import com.projet.modeles.Region;

public interface IRegionDAO {
	
	public List<Region> recupererListeRegions();
	
	public void ajouterRegion(Region region);
	
	public void supprimerRegion(Region region);
	
	public Region trouverRegion(int idPays);
	
	public void updateRegion(Region region);
	
	public List<Region> recupererListeRegionsParPays(Pays pays);
	
}
