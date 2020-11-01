package com.projet.controleurs;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet.modeles.Pays;
import com.projet.services.IPaysService;

@Controller
@RequestMapping("/updatePays")
public class UpdatePays {	
	
	@Autowired
	private IPaysService paysService;	
	public IPaysService getPaysService() { return paysService; }	
	public void setPaysService(IPaysService paysService) {this.paysService = paysService;}
	
	@RequestMapping(value="{idPays}", method = RequestMethod.GET)
	public String afficherFormulaire(ModelMap map, @PathVariable int idPays) {
		String messageInfo = "";
		Pays pays = null;
		try {
			pays = paysService.trouverPays(idPays);
			messageInfo = "Pays mis à jour";
		}
		catch (Exception e) {
			messageInfo = e.getMessage();
		} 
		map.addAttribute("pays", pays);
		return "formulaireUpdatePays";		
	}
	
	@RequestMapping(value="{idPays}", method = RequestMethod.POST)	
	public String modifierPays(ModelMap map, @PathVariable int idPays, 
			                                 @RequestParam(value="codeIso") String codeIso, 
			                                 @RequestParam(value="nomPays") String nomPays, 
		                                     @RequestParam(value="capitale") String capitale, 
		                                     @RequestParam(value="langue") String langue, 
	                                    	 @RequestParam(value="surface") double surface, 
		                                     @RequestParam(value="population") double population, 
		                                     Pays pays) {
	
		String messageInfo = "";
		List<Pays> listePays = new ArrayList<Pays>();	
		
		try {
			pays = paysService.trouverPays(idPays);
			pays.setCodeIso(codeIso);
			pays.setNomPays(nomPays);
			pays.setCapitale(capitale);
			pays.setLangue(langue);
			pays.setSurface(surface);
			pays.setPopulation(population);	
			paysService.updatePays(pays);
			listePays = paysService.recupererListePays();
			messageInfo = "Pays mis à jour";
		} 
		catch (Exception e) {
			messageInfo = e.getMessage();
		}		
		map.addAttribute("messageInfo", messageInfo);
		map.addAttribute("listePays", listePays);	
		
		return "listePays";
	}
}
