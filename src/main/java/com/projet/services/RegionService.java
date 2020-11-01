package com.projet.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.dao.IRegionDAO;
import com.projet.modeles.Pays;
import com.projet.modeles.Region;

@Service
public class RegionService implements IRegionService {
	
	@Autowired
	private IRegionDAO regionDao;
	
	public IRegionDAO getRegionDAO() { 
		return regionDao; 
	}

	public void setRegionDAO(IRegionDAO regionDAO) {
		this.regionDao = regionDAO;
	}

	@Transactional
	public List<Region> recupererListeRegions() {
		return regionDao.recupererListeRegions();
	}
	
	@Transactional
	public void ajouterRegion(Region region) {
		regionDao.ajouterRegion(region);
	}

	@Transactional
	public String supprimerRegionParNom(String nom) {
		List<Region> listeRegions = recupererListeRegions();
		
		int index = 0;
		for (index = 0; (index < listeRegions.size()) && !(nom.equals(listeRegions.get(index).getNom())); ++index) {
			++index;
		}
		
		if (index < listeRegions.size()) {
			regionDao.supprimerRegion(listeRegions.get(index));
			return "Région trouvé et supprimé";
		} 
		else {
			return "Région non trouvé";
		}
	}
	
	@Transactional
	public Region trouverRegion(int id) {
		return regionDao.trouverRegion(id);
	}
	
	@Transactional
	public void updateRegion(Region region) {
		regionDao.updateRegion(region);
	}

	@Transactional
	public List<Region> recupererListeRegionsParPays(Pays pays) {
		return regionDao.recupererListeRegionsParPays(pays);
	}

}
