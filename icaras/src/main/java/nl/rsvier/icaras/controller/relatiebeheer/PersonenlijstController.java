package nl.rsvier.icaras.controller.relatiebeheer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.AdresType;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.Identiteitsbewijs;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.service.relatiebeheer.AdresService;
import nl.rsvier.icaras.service.relatiebeheer.DigitaalAdresService;
import nl.rsvier.icaras.service.relatiebeheer.IdentiteitsbewijsService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonsrolService;

import org.hibernate.Session;
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
	@Autowired
	PersoonsrolService persoonsrolService;
	@Autowired
	IdentiteitsbewijsService identiteitsbewijsService;
	
	@RequestMapping(value ={"", "lijst"}, method = RequestMethod.GET)
	public String showPersonenLijst(@ModelAttribute("succes")String succes, @ModelAttribute("verwijderd")String verwijderd,
			ModelMap model) {
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
	
	@RequestMapping(value = "/update-{id}-persoon", method = RequestMethod.POST, params="wijzig")
	public String updatePersoon(@PathVariable int id, @ModelAttribute("persoon")@Valid Persoon persoon, BindingResult result,
			@ModelAttribute("gewijzigd")String gewijzigd,
			ModelMap model) {
//		if(result.hasErrors()) {
//			model.addAttribute("gewijzigd", persoon.getVoornaam() + " "
//	                + persoon.getAchternaam() + " is NIET gewijzigd");
//			return "persoondetails";
//		} else {
			for(DigitaalAdres dAdres: persoon.getDigitaleAdressen()) {
				dAdres.setPersoon(persoon);
				digitaalAdresService.update(dAdres);
			}

			for(Persoonsrol persoonsrol: persoon.getPersoonsrollen()) {
				persoonsrol.setPersoon(persoon);
				persoonsrolService.update(persoonsrol);
			}
						
			for(Adres adres: persoon.getAdressen()) {
				adres.setPersoon(persoon);
				adresService.save(adres);
			}
			
			service.update(persoon);
			
			Persoon persoon1 = service.get(id);
			model.addAttribute("persoon", persoon1);
			ArrayList<AdresType> adresTypes = (ArrayList<AdresType>)adresService.getAllTypes();
			model.addAttribute("adresTypes", adresTypes);
			model.addAttribute("gewijzigd", persoon.getVoornaam() + " "
	                + persoon.getAchternaam() + " is gewijzigd");
			return "persoondetails";
		}
//	}
	
	@RequestMapping(value = "/update-{id}-persoon", method = RequestMethod.POST, params="verwijder")
	public String deletePersoon(@PathVariable int id, @ModelAttribute("persoon")@Valid Persoon persoon, BindingResult result,
			ModelMap model) {
		
		Iterator<DigitaalAdres> dAdresIterator = persoon.getDigitaleAdressen().iterator();
		while(dAdresIterator.hasNext()) {
			DigitaalAdres dAdres = dAdresIterator.next();
			dAdres.removePersoon();
			digitaalAdresService.delete(dAdres);
			dAdresIterator.remove();
		}
		
		Iterator<Adres> adresIterator = persoon.getAdressen().iterator();
		while(adresIterator.hasNext()) {
			Adres adres = adresIterator.next();
			adres.removePersoon();
			if(adres.getBedrijf() == null) {
				adresService.delete(adres);
			} else {
				adresService.update(adres);
			}
			adresIterator.remove();
		}
		
		Iterator<Persoonsrol> persoonsrolIterator= persoon.getPersoonsrollen().iterator();
		while(persoonsrolIterator.hasNext()) {
			Persoonsrol persoonsrol = persoonsrolIterator.next();
			persoonsrol.removePersoon();
			persoonsrol.removeBedrijf();
			persoonsrolService.delete(persoonsrol);
			persoonsrolIterator.remove();
		}
		
		service.delete(persoon);
		
		model.remove("persoon", persoon);
		model.addAttribute("verwijderd", persoon.getVoornaam() + " "
                + persoon.getAchternaam() + " is verwijderd");
		
		return "redirect:";
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
		model.addAttribute("gewijzigd", persoon.getVoornaam() + " "
                + persoon.getAchternaam() + " is gewijzigd");
		
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
