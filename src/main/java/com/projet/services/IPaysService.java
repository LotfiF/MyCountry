package com.projet.services;

import java.util.List;

import com.projet.modeles.Pays;

public interface IPaysService {
	
	public List<Pays> recupererListePays() throws Exception;
	
	public void ajouterPays(Pays pays) throws Exception;
	
	public String supprimerPaysParCodeIso(String codeIso) throws Exception;
	
	public Pays trouverPays(int idPays) throws Exception;
	
	public Pays trouverPaysParNom(String nomPays) throws Exception;
	
	public void updatePays(Pays pays) throws Exception;
	
}
