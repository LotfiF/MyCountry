package com.projet.controleurs;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet.modeles.Pays;
import com.projet.services.IPaysService;
@Controller
@RequestMapping("/ajouterPays")
public class AjouterPays {
	
	@Autowired
	private IPaysService paysService;	
	
	public IPaysService getPaysService() { 
		return paysService; 
	}
	public void setPaysService(IPaysService paysService) {
		this.paysService = paysService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String afficherFormulaire() {
		return "formulaireAjouterPays";
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public String ajouterPays(ModelMap map, @RequestParam(value="codeIso") String codeIso, 
							  @RequestParam(value="nomPays") String nomPays, 
							  @RequestParam(value="capitale") String capitale, 
							  @RequestParam(value="langue") String langue, 
							  @RequestParam(value="surface") double surface, 
							  @RequestParam(value="population") double population) 
	                          {
		Pays pays = new Pays();
		pays.setCodeIso(codeIso);
		pays.setNomPays(nomPays);
		pays.setCapitale(capitale);
		pays.setLangue(langue);
		pays.setSurface(surface);
		pays.setPopulation(population);		
		
		String messageInfo = "";
		List<Pays> listePays = new ArrayList<Pays>();	
		
		try {
			paysService.ajouterPays(pays);
			listePays = paysService.recupererListePays();
			messageInfo = "Requête réussie";
		} 
		catch (Exception e) {
			messageInfo = e.getMessage();
		}
		
		map.addAttribute("messageInfo", messageInfo);
		map.addAttribute("listePays", listePays);	
		
		return "listePays";
	}
}
