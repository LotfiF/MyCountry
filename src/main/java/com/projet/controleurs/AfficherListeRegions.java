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
@RequestMapping("/listeRegions")
public class AfficherListeRegions {
	
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
	
	@RequestMapping(method = RequestMethod.GET)
	public String recupererListeRegions(final ModelMap map) {
		List<Region> listeRegions = new ArrayList<Region>();
		String messageInfo = "";		
		try	{
			listeRegions = regionService.recupererListeRegions();
			messageInfo = "Requête réussie";
		} 
		catch (Exception e) {
			messageInfo = e.getMessage();
		}		
		map.addAttribute("messageInfo", messageInfo);
		map.addAttribute("listeRegions", listeRegions);
		
		return "listeRegions";
	}
	
	@RequestMapping(value="{idPays}", method = RequestMethod.GET)
	public String recupererListeRegionsParPays(final ModelMap map, @PathVariable int idPays, Pays pays) {
		
		List<Region> listeRegions = new ArrayList<Region>();
		String messageInfo = "";		
		try	{
			pays = paysService.trouverPays(idPays);
			listeRegions = regionService.recupererListeRegionsParPays(pays);
			messageInfo = "Requête réussie";
		} 
		catch (Exception e) {
			messageInfo = e.getMessage();
		}		
		map.addAttribute("messageInfo", messageInfo);
		map.addAttribute("listeRegions", listeRegions);
		
		return "listeRegions";
	}
}
