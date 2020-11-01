package com.projet.controleurs;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet.modeles.Pays;
import com.projet.modeles.Region;
import com.projet.services.IPaysService;
import com.projet.services.IRegionService;
@Controller
@RequestMapping("/ajouterRegion")
public class AjouterRegion {	
	
	@Autowired
	private IPaysService paysService;
	
	@Autowired
	private IRegionService regionService;
	
	public IPaysService getPaysService() {
		return paysService; 
	}
	public void setPaysService(IPaysService paysService) {
		this.paysService = paysService;
	}	
	public IRegionService getRegionService() {
		return regionService;
	}
	public void setRegionService(IRegionService regionService) {
		this.regionService = regionService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String afficherFormulaire(ModelMap map) {
		
		List<Pays> listePays = new ArrayList<Pays>();
		try {
		listePays = paysService.recupererListePays();
	    } 
		catch (Exception e) {
        }
		
		map.addAttribute("listePays", listePays);
		return "formulaireAjouterRegion";
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public String ajouterRegion(ModelMap map, @RequestParam(value="nom") String nom, 
							  @RequestParam(value="monument") String monument, 
							  @RequestParam(value="regionNumber") double regionNumber,
							  @RequestParam(value="pays") int idPays) {
							  				
		Region region = new Region();		
		String messageInfo = "";			
		List<Region> listeRegions = new ArrayList<Region>();		
		try {
			region.setNom(nom);
			region.setMonument(monument);
			region.setRegionNumber(regionNumber);
			Pays p = paysService.trouverPays(idPays);
			region.setPays(p);				
			regionService.ajouterRegion(region);
			listeRegions = regionService.recupererListeRegions();
			messageInfo = "Requête réussie";
		} catch (Exception e) {
			messageInfo = e.getMessage();
		}				
		map.addAttribute("messageInfo", messageInfo);	
		map.addAttribute("listeRegions", listeRegions);	
		
		return "listeRegions";
	}
}
