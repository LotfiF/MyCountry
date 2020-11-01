package com.projet.controleurs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.modeles.Pays;
import com.projet.services.IPaysService;

@Controller
@RequestMapping("/listePays")
public class AfficherListePays {
	
	@Autowired
	private IPaysService paysService;
	
	public IPaysService getPaysService() { 
		return paysService; 
	}

	public void setPaysService(IPaysService paysService) {
		this.paysService = paysService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String recupererListePays(final ModelMap map) {
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
		
		return "listePays";
	}
}
