package nl.rsvier.icaras.controller.relatiebeheer;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.AdresType;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.service.relatiebeheer.AdresService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/personen")
public class PersonenlijstController {
	
	@Autowired
	PersoonService service;
	@Autowired
	AdresService adresService;
	
	@RequestMapping(value ={"", "lijst"}, method = RequestMethod.GET)
	public String showPersonenLijst(ModelMap model) {
		List<Persoon> personen = service.getAll();
		model.addAttribute("personen", personen);
		return "personen";
	}

	@RequestMapping(value = "/update-{id}-persoon", method = RequestMethod.GET)
	public String updatePersoon(@PathVariable int id, ModelMap model) {
		Persoon persoon = service.get(id);
		model.addAttribute("persoon", persoon);
		List<Persoon> personen = service.getAll();
		model.addAttribute("personen", personen);
		List<AdresType> adresTypes = adresService.getAllTypes();
		model.addAttribute("adresTypes", adresTypes);
	
		
		return "persoondetails";
	}
	
	@RequestMapping(value = "/nieuw", method = RequestMethod.GET)
	public String nieuwPersoon(ModelMap model){
		List<Persoon> personen = service.getAll();
		model.addAttribute("personen", personen);
		
		List<AdresType> adresTypes = adresService.getAllTypes();
		model.addAttribute("adresTypes", adresTypes);
		
		Persoon persoon = new Persoon();
		Adres adres = new Adres();
		AdresType adresType = new AdresType();
		adres.setAdresType(adresType);

		persoon.addAdres(adres);
		
		model.addAttribute("persoon", persoon);

		return "nieuwpersoon";
	}
	
	@RequestMapping(value = "/nieuw", method = RequestMethod.POST)
	public String savePersoon(@ModelAttribute("persoon")@Valid Persoon persoon, BindingResult result, 
			@ModelAttribute("adresTypes")@Valid AdresType adresType, BindingResult result2,
			ModelMap model) {
//		if(result.hasErrors()) {
//			return "nieuwpersoon";
//		}

		Adres adres = persoon.getAdressen().get(0);
		adresService.addAdresType(adresType.getType(), adres);
		persoon.addAdres(adres);
		service.save(persoon);
		
		model.addAttribute("succes", persoon.getVoornaam() + " "
                + persoon.getAchternaam() + " staat geregistreerd");
//		return "bevestiging";
		return "personen";
	}
	
}
