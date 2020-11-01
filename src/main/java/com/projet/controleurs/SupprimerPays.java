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

import com.projet.modeles.Pays;
import com.projet.services.IPaysService;

@Controller
@RequestMapping("/supprimerPays")
public class SupprimerPays {
	
	@Autowired
	private IPaysService paysService;
	
	public IPaysService getPaysService() { 
		return paysService; 
	}

	public void setPaysService(IPaysService paysService) {
		this.paysService = paysService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String afficherFormulaire(ModelMap map) {		
		List<Pays> listePays = new ArrayList<Pays>();
		String messageInfo = "";
		try {
			listePays = paysService.recupererListePays();
			messageInfo = "Requête réussie";
		} 
		catch (Exception e) {
			messageInfo = e.getMessage();
		}
		
		map.addAttribute("messageInfo", messageInfo);
		map.addAttribute("listePays", listePays);
		
		return "formulaireSupprimerPays";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String supprimerPays(ModelMap map, @RequestParam String codeIso) {
		String messageInfo = "";
		String responce = "";
		List<Pays> listePays = new ArrayList<Pays>();
		
		try {
			responce = paysService.supprimerPaysParCodeIso(codeIso);			
			listePays = paysService.recupererListePays();
			messageInfo = "Requête réussie";
		} 
		catch (Exception e) {
			messageInfo = e.getMessage();
		}
		
		map.addAttribute("responce", responce);
		map.addAttribute("messageInfo", messageInfo);
		map.addAttribute("listePays", listePays);
		
		return "listePays";
	}
}
