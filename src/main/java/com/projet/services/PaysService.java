package com.projet.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.dao.IPaysDAO;
import com.projet.modeles.Pays;

@Service
public class PaysService implements IPaysService {
	
	@Autowired
	private IPaysDAO paysDao;
	
	public IPaysDAO getPaysDAO() { 
		return paysDao; 
	}

	public void setPaysDAO(IPaysDAO paysDao) {
		this.paysDao = paysDao;
	}
	
	@Transactional
	public List<Pays> recupererListePays() {
		return paysDao.recupererListePays();
	}

	@Transactional
	public void ajouterPays(Pays pays) {
		paysDao.ajouterPays(pays);
	}

	@Transactional
	public String supprimerPaysParCodeIso(String codeIso) {
		List<Pays> listePays = recupererListePays();
		
		int index = 0;
		for (index = 0; (index < listePays.size()) && !(codeIso.equals(listePays.get(index).getCodeIso())); ++index) {
			++index;
		}
		
		if (index < listePays.size()) {
			paysDao.supprimerPays(listePays.get(index));
			return "Pays trouvé et supprimé";
		} 
		else {
			return "Pays non trouvé";
		}
	}
	
	@Transactional
	public Pays trouverPays(int idPays) {
		return paysDao.trouverPays(idPays);
	}
	
	@Transactional
	public Pays trouverPaysParNom(String nomPays) {
		return paysDao.trouverPaysParNom(nomPays);
	}
	
	@Transactional
	public void updatePays(Pays pays) {
		paysDao.updatePays(pays);
	}
	
	
}
