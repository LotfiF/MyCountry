package com.projet.controleurs;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet.modeles.Region;
import com.projet.services.IRegionService;

@Controller
@RequestMapping("/supprimerRegion")
public class SupprimerRegion {
	
	@Autowired
	private IRegionService regionService;
	
	public IRegionService getRegionService() { 
		return regionService; 
	}

	public void setRegionService(IRegionService regionService) {
		this.regionService = regionService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String afficherFormulaire(ModelMap map) {		
		List<Region> listeRegions = new ArrayList<Region>();
		String messageInfo = "";
		try {
			listeRegions = regionService.recupererListeRegions();
			messageInfo = "Requête réussie";
		} 
		catch (Exception e) {
			messageInfo = e.getMessage();
		}
		
		map.addAttribute("messageInfo", messageInfo);
		map.addAttribute("listeRegions", listeRegions);
		
		return "formulaireSupprimerRegion";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String supprimerRegion(ModelMap map, @RequestParam String nom) {
		String messageInfo = "";
		String responce = "";
		List<Region> listeRegions = new ArrayList<Region>();
		
		try {
			responce = regionService.supprimerRegionParNom(nom);			
			listeRegions = regionService.recupererListeRegions();
			messageInfo = "Requête réussie";
		} 
		catch (Exception e) {
			messageInfo = e.getMessage();
		}
		
		map.addAttribute("responce", responce);
		map.addAttribute("messageInfo", messageInfo);
		map.addAttribute("listeRegions", listeRegions);
		
		return "listeRegions";
	}
}
