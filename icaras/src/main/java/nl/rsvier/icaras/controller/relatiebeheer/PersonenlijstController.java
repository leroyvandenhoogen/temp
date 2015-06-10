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
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdresType;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.service.relatiebeheer.AdresService;
import nl.rsvier.icaras.service.relatiebeheer.DigitaalAdresService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/personen")
//@SessionAttributes({"personen", "adresTypes"})
@SessionAttributes("personen")
public class PersonenlijstController {
	
	@Autowired
	PersoonService service;
	@Autowired
	AdresService adresService;
	@Autowired
	DigitaalAdresService digitaalAdresService;
	
	@RequestMapping(value ={"", "lijst"}, method = RequestMethod.GET)
	public String showPersonenLijst(@ModelAttribute("succes")String succes, ModelMap model) {
		List<Persoon> personen = service.getAll();
		model.addAttribute("personen", personen);
		
		return "personen";
	}

	@RequestMapping(value = "/update-{id}-persoon", method = RequestMethod.GET)
	public String detailPersoon(@PathVariable int id, ModelMap model) {
		Persoon persoon = service.get(id);
		model.addAttribute("persoon", persoon);
		
		ArrayList<AdresType> adresTypes = (ArrayList<AdresType>)adresService.getAllTypes();
		model.addAttribute("adresTypes", adresTypes);
		
		return "persoondetails";
	}
	
	@RequestMapping(value = "/update-{id}-persoon", method = RequestMethod.POST)
	public String updatePersoon(@PathVariable int id, @ModelAttribute("persoon")@Valid Persoon persoon, BindingResult result, 
//			@ModelAttribute("adresTypes")@Valid AdresType adresType, BindingResult result2,
			ModelMap model) {
		if(result.hasErrors()) {
			return "persoondetails";
		} else {
//			for(DigitaalAdres dAdres: persoon.getDigitaleAdressen()) {
//				dAdres.setPersoon(persoon);
//				digitaalAdresService.update(dAdres);
//			}
			
//			for(Adres adres: persoon.getAdressen()) {
//				System.out.println(adresType.getType());
//				adres.setAdresType(adresType);
//				adresService.addAdresType(adresType.getType(), adres);
//				persoon.addAdres(adres);
//				adresService.update(adres);
//			}
			
			for(Adres adres: persoon.getAdressen()) {
				System.out.println(adres.getAdresType());
				System.out.println(adres.getAdresType().getId());
				System.out.println(adres.getAdresType().getType());
				
//				System.out.println(adresType.getType());
//				System.out.println(adresType.getId());
////				adresService.addAdresType(adresType.getType(), adres);
////				adresService.addAdresType(adresType.getType(), adres);
//				adresService.addAdresType(adresType.getType(), adres);
				adres.setPersoon(persoon);
				adresService.save(adres);
			}
			
			service.update(persoon);
			
			Persoon persoon1 = service.get(id);
			model.addAttribute("persoon", persoon1);
			ArrayList<AdresType> adresTypes = (ArrayList<AdresType>)adresService.getAllTypes();
			model.addAttribute("adresTypes", adresTypes);
			return "persoondetails";
		}
	}
	
	
	@RequestMapping(value = "/nieuw", method = RequestMethod.GET)
	public String nieuwPersoon(ModelMap model){
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
	public String saveNieuwPersoon(@ModelAttribute("persoon")@Valid Persoon persoon, BindingResult result, 
			@ModelAttribute("adresTypes")@Valid AdresType adresType, BindingResult result2,
			ModelMap model) {
		if(result.hasErrors() || result2.hasErrors()) {
			return "nieuwpersoon";
		} else {
		Adres adres = persoon.getAdressen().get(0);
		persoon.addAdres(adres);
		service.save(persoon);
		adresService.save(adresType.getType(), adres);
		
		model.addAttribute("succes", persoon.getVoornaam() + " "
                + persoon.getAchternaam() + " is toegevoegd aan de database");
		return "redirect:";
		}
	}
}
