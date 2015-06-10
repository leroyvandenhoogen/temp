package nl.rsvier.icaras.controller.relatiebeheer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.service.relatiebeheer.AdresService;
import nl.rsvier.icaras.service.relatiebeheer.BedrijfService;
import nl.rsvier.icaras.service.relatiebeheer.DigitaalAdresService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonsrolService;

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
@RequestMapping("/contactpersonen")
@SessionAttributes("contactpersonen")
public class ContactpersonenlijstController {

	@Autowired
	PersoonsrolService persoonsrolservice;

	@Autowired
	PersoonService persoonService;
	@Autowired
	BedrijfService bedrijfService;
	@Autowired
	DigitaalAdresService digitaaladresService;
	@Autowired
	AdresService adresService;


	@RequestMapping(value = { "", "lijst" }, method = RequestMethod.GET)
	public String showPersonenLijst(ModelMap model) {
		List<Persoon> personen = persoonService.getAll();
		List<Persoon> contactpersonen = new ArrayList<>();
		for (Persoon pers : personen) {
			if (pers.hasRol("contactpersoon"))
				contactpersonen.add(pers);
		}
		model.addAttribute("contactpersonen", contactpersonen);
		return "contactpersonen";
	}

	@RequestMapping(value = "/update-{id}-persoon", method = RequestMethod.GET)
	public String updatePersoon(@PathVariable int id, ModelMap model) {
		Persoon persoon = persoonService.get(id);

		model.addAttribute("persoon", persoon);
		return "contactpersoondetails";
	}

	@RequestMapping(value = { "update-{id}-persoon" }, method = RequestMethod.POST)
	public String updatePersoon(@PathVariable int id,
			@Valid @ModelAttribute("persoon") Persoon persoon,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "contactpersoondetails";
		} else {
			for(DigitaalAdres dAdres: persoon.getDigitaleAdressen()) {
				dAdres.setPersoon(persoon);
				digitaaladresService.update(dAdres);
			}
			for(Persoonsrol pRol: persoon.getPersoonsrollen()) {
				bedrijfService.update(pRol.getBedrijf());
				for(Adres adres: pRol.getBedrijf().getAdressen()) {
					System.out.println("///////" + adres.getAdresType().getType());
					adres.setBedrijf(pRol.getBedrijf());
					adresService.update(adres);
				}
			}
			persoonService.update(persoon);
			List<Persoon> personen = persoonService.getAll();
			List<Persoon> contactpersonen = new ArrayList<>();
			for (Persoon pers : personen) {
				if (pers.hasRol("contactpersoon"))
					contactpersonen.add(pers);
			}

			model.addAttribute("contactpersonen", contactpersonen);
			Persoon persoon1 = persoonService.get(id);
			model.addAttribute("persoon", persoon1);

			model.addAttribute("succes",
					persoon.getVoornaam() + " " + persoon.getTussenvoegsel()
							+ " " + persoon.getAchternaam() + " is gewijzigd");
			return "contactpersoondetails";
		}
	}
	
	@RequestMapping(value = "/nieuwcontactpersoon", method = RequestMethod.GET)
	public String newPersoon(ModelMap model){
		
		Persoon persoon = new Persoon();
		
		model.addAttribute("persoon", persoon);

		return "nieuwcontactpersoon";
	}
	
	@RequestMapping(value = "/nieuwcontactpersoon", method = RequestMethod.POST)
	public String savePersoon(@ModelAttribute("persoon")@Valid Persoon persoon, BindingResult result, ModelMap model) {
		Persoonsrol persoonsrol = new Persoonsrol();
		persoonsrol.setBegindatum(new Date());
		persoonsrol.setPersoon(persoon);
		persoonsrolservice.addRol("contactpersoon", persoonsrol);
		persoon.addPersoonsrol(persoonsrol);
		persoonService.save(persoon);
		
		List<Persoon> personen = persoonService.getAll();
		List<Persoon> contactpersonen = new ArrayList<>();
		for (Persoon pers : personen) {
			if (pers.hasRol("contactpersoon"))
				contactpersonen.add(pers);
		}

		model.addAttribute("contactpersonen", contactpersonen);
		
		
		model.addAttribute("succes", persoon.getVoornaam() + " "
                + persoon.getAchternaam() + " staat geregistreerd");
//		return "bevestiging";
		return "contactpersonen";
	}
	
}