package com.iset.sante.controllers;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.iset.sante.entities.Activite;
import com.iset.sante.entities.Profil;
import com.iset.sante.service.ActiviteServices;

@Controller
public class ActiviteController {

    @Autowired
    private ActiviteServices activiteServices;

    @GetMapping("/activiteUser")
    public String getactiviteUserPage() {
        return "activiteUser"; // Ceci correspond au nom du fichier HTML sans l'extension
    }
    @PostMapping("/profil/{profilId}/ajouter-activite")
    public String ajouterActivite(@PathVariable int profilId, @ModelAttribute Activite activite) {
    	activiteServices.ajouterActivite(profilId, activite);
        return "redirect:/profil/{profilId}";
    }


    
    @GetMapping("/activite-admin")
    public String activiteAdminPage() {
        return "ActiviteAdmine"; 
    }
    @GetMapping("/showCreate3")
	public String showCreate(Model model) {
	    model.addAttribute("activite",new Activite());
	    return "ActiviteAdmine";
	}
    @PostMapping("/saveAc")
	public String saveActivite(@ModelAttribute("activite") Activite activite,
	                          ModelMap modelMap) throws ParseException {
	    
	       
    	Activite saveActivite = activiteServices.saveActivite(activite);
	        String msg = "Profil enregistré avec Id " + saveActivite.getIdActivite();
	        modelMap.addAttribute("msg", msg);
	    
	     

	    return "ActiviteAdmine";
	}

    
    @GetMapping("/activiteList")
	public String listeactivities(ModelMap modelMap)
	{
	List<Activite> prods =activiteServices.getAllActivites();
	modelMap.addAttribute("activites", prods);

	return "ActiviteList";
	}
    @GetMapping("/supprimerActivite")
	public String supprimerActivite(@RequestParam("id") int id, ModelMap modelMap)
	{

    	activiteServices.deleteActiviteById(id);
	List<Activite> prods = activiteServices.getAllActivites();
	modelMap.addAttribute("activites", prods);
	return "ActiviteList";
	}


    @GetMapping("/modifierActivite")
    public String editerActivite(@RequestParam("id") int id, ModelMap modelMap) {
        Activite activite = activiteServices.getActivite(id);
        modelMap.addAttribute("activite", activite);
        return "editerActivites";
    }



	@PostMapping("/updateActivite")
	public String updateActivite(@ModelAttribute("activite") Activite activite,
	
	ModelMap modelMap) throws ParseException
	{
	
		activiteServices.updateActivite(activite);
		List<Activite> prods =activiteServices.getAllActivites();
		modelMap.addAttribute("activites", prods);
		return "ActiviteList";
	}
   
}