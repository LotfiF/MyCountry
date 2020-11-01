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
import com.projet.modeles.Region;
import com.projet.services.IPaysService;
import com.projet.services.IRegionService;
@Controller
@RequestMapping("/updateRegion")
public class UpdateRegion {	
	
	@Autowired
	private IRegionService regionService;
	
	public IRegionService getRegionService() {
		return regionService; 
	}	
	public void setRegionService(IRegionService regionService) {
		this.regionService = regionService;
	}
	
	@Autowired
	private IPaysService paysService;	
	
	public IPaysService getPaysService() { 
		return paysService; 
	}
	public void setPaysService(IPaysService paysService) {
		this.paysService = paysService;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	public String afficherFormulaire(ModelMap map, @PathVariable int id) {
		String messageInfo = "";
		Region region = null;
		List<Pays> listePays = new ArrayList<Pays>();
		try {		
			region = regionService.trouverRegion(id);
			listePays = paysService.recupererListePays();
			messageInfo = "Région mis à jour";
		} catch (Exception e) {
			messageInfo = e.getMessage();
		} 
		map.addAttribute("region", region);
		map.addAttribute("listePays", listePays);
		return "formulaireUpdateRegion";		
	}	
	@RequestMapping(value="{id}", method = RequestMethod.POST)	
	public String modifierRegion(ModelMap map, @PathVariable int id, 
                                 @RequestParam(value="nom") String nom, 
                                 @RequestParam(value="monument") String monument, 
                                 @RequestParam(value="regionNumber") double regionNumber, 
                                 @RequestParam(value="pays") int idPays, Region region) {	
		String messageInfo = "";
		List<Region> listeRegions = new ArrayList<Region>();
		try {
			region = regionService.trouverRegion(id);
			region.setNom(nom);
			region.setMonument(monument);
			region.setRegionNumber(regionNumber);
			Pays p = paysService.trouverPays(idPays);
			region.setPays(p);
			regionService.updateRegion(region);
			listeRegions = regionService.recupererListeRegions();
			messageInfo = "Region mis à jour";
		} catch (Exception e) {
			messageInfo = e.getMessage();
		}		
		map.addAttribute("messageInfo", messageInfo);
		map.addAttribute("listeRegions", listeRegions);
		
		return "listeRegions";
	}
}
