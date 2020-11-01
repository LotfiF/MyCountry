package com.projet.dao;

import java.util.List;

import com.projet.modeles.Pays;

public interface IPaysDAO {
	
	public List<Pays> recupererListePays();
	
	public void ajouterPays(Pays pays);
	
	public void supprimerPays(Pays pays);
	
	public Pays trouverPays(int idPays);
	
	public Pays trouverPaysParNom(String nomPays);
	
	public void updatePays(Pays pays);
}
