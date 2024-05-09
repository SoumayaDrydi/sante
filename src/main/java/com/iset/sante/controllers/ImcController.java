package com.iset.sante.controllers;
import java.text.ParseException;
import java.util.List;

//import java.text.SimpleDateFormat;

//import java.util.Date;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestParam;

import com.iset.sante.entities.Profil;
import com.iset.sante.entities.Regime;
import com.iset.sante.service.RegimeService;




@Controller
public class ImcController {
@Autowired
RegimeService regimeService;
@GetMapping("/showCreate1")
public String showCreate(Model model) {
    model.addAttribute("regime", new Regime());
    return "regime/createRegime";
}

@PostMapping("/saveRegime")
public String saveRegime(@ModelAttribute("regime") Regime regime,
                        
                          ModelMap modelMap) throws ParseException {
    
   
        Regime saveRegime = regimeService.saveRegime(regime);
        String msg = "Regime enregistré avec Id " + saveRegime.getIdregime();
        modelMap.addAttribute("msg", msg);
    
     

    return "regime/createRegime";
}



@GetMapping("/ListeRegimes")
public String listeRegimes(ModelMap modelMap)
{
List<Regime> reg = regimeService.getAllRegimes();
modelMap.addAttribute("regimes", reg);

return "regime/listeRegimes";
}




@GetMapping("/supprimerRegime")
public String supprimerRegime(@RequestParam("id")int id, ModelMap modelMap)
{
	
regimeService.deleteRegimeById(id);
List<Regime> reg = regimeService.getAllRegimes();
modelMap.addAttribute("regimes", reg);
return "regime/listeRegimes";
}





@GetMapping("/modifierRegime")
public String editerRegime(@RequestParam("id") int id,ModelMap modelMap)
{
Regime r= regimeService.getRegime(id);
modelMap.addAttribute("regime", r);
return "regime/editerRegimes";
}


@PostMapping("/updateRegime")
public String updateRegime(@ModelAttribute("regime") Regime regime,

ModelMap modelMap) throws ParseException
{

regimeService.updateRegime(regime);
List<Regime> reg = regimeService.getAllRegimes();
modelMap.addAttribute("regimes", reg);
return "regime/listeRegimes";
}
}

