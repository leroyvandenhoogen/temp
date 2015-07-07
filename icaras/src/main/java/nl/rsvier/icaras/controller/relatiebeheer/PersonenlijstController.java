package nl.rsvier.icaras.controller.relatiebeheer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.AdresType;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdresType;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.service.relatiebeheer.AdresService;
import nl.rsvier.icaras.service.relatiebeheer.DigitaalAdresService;
import nl.rsvier.icaras.service.relatiebeheer.IdentiteitsbewijsService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonsrolService;
import nl.rsvier.icaras.util.relatiebeheer.AchternaamComparator;
import nl.rsvier.icaras.util.relatiebeheer.PersoonDTO;
import nl.rsvier.icaras.util.relatiebeheer.Zoekinput;

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
@RequestMapping("/relatiebeheer/personen")
@SessionAttributes({ "personen", "zoekinput", "adresTypes" })
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

	@ModelAttribute("zoekinput")
	public Zoekinput createZoekinput() {
		return new Zoekinput();
	}

	@ModelAttribute("adresTypes")
	public ArrayList<AdresType> createAdresTypeList() {
		ArrayList<AdresType> adresTypes = (ArrayList<AdresType>) adresService.getAllTypes();
		return adresTypes;
	}

	@RequestMapping(value = { "/zoeken" }, method = RequestMethod.GET)
	public String zoekPersoon(ModelMap model) {

		return "relatiebeheer/personen/zoeken";
	}

	@RequestMapping(value = { "/zoeken" }, method = RequestMethod.POST)
	public String zoekPersoonLijst(
			@ModelAttribute("zoekinput") Zoekinput zoekinput,
			BindingResult result, ModelMap model) {
		System.out.println(zoekinput.getInput());
		zoekinput.startTimer();
		List<Persoon> personen = service.search(zoekinput.getInput());
		model.addAttribute("personen", personen);
		zoekinput.stopTimer();
		Collections.sort(personen, new AchternaamComparator());
		model.addAttribute("zoekinput", zoekinput);
		return "relatiebeheer/personen/zoeken";
	}

	@RequestMapping(value = { "/zoekresultaat-{id}" }, method = RequestMethod.GET)
	public String zoekResultaat(@PathVariable int id, ModelMap model) {
		Persoon persoon = service.get(id);
		PersoonDTO persoonDTO = new PersoonDTO();
		persoonDTO.setPersoon(persoon);
		persoonDTO.setAdressen(persoon.getAdressen());
		persoonDTO.setDigitaleAdressen(persoon.getDigitaleAdressen());
		persoonDTO.setPersoonsrollen(persoon.getPersoonsrollen());
		
		model.addAttribute("persoonDTO", persoonDTO);

		return "relatiebeheer/personen/zoekresultaat";
	}
	
	@RequestMapping(value = { "/zoekresultaat-{id}" }, method = RequestMethod.POST, params="wijzigpersoon")
	public String zoekResultaat(@PathVariable int id, 
				@ModelAttribute("persoonDTO") PersoonDTO persoonDTO, BindingResult result1,
			ModelMap model) {
		
		Persoon tempPersoon = persoonDTO.getPersoon();
		Persoon wijzigPersoon = service.get(id);
		wijzigPersoon.setVoornaam(tempPersoon.getVoornaam());
		wijzigPersoon.setAchternaam(tempPersoon.getAchternaam());
		wijzigPersoon.setTussenvoegsel(tempPersoon.getTussenvoegsel());
		wijzigPersoon.setGeboortedatum(tempPersoon.getGeboortedatum());
		wijzigPersoon.setGeslacht(tempPersoon.getGeslacht());
		wijzigPersoon.setDigitaleAdressen(persoonDTO.getDigitaleAdressen());
		wijzigPersoon.setOpmerking(tempPersoon.getOpmerking());

		service.update(wijzigPersoon);
		persoonDTO.setPersoon(wijzigPersoon);
		persoonDTO.setAdressen(wijzigPersoon.getAdressen());
		persoonDTO.setDigitaleAdressen(wijzigPersoon.getDigitaleAdressen());
		persoonDTO.setPersoonsrollen(wijzigPersoon.getPersoonsrollen());
		
		model.addAttribute("persoonDTO", persoonDTO);

		return "relatiebeheer/personen/zoekresultaat";
	}
	
	
	

	@RequestMapping(value = { "/nieuw" }, method = RequestMethod.GET)
	public String nieuwPersoon(ModelMap model) {
		PersoonDTO persoonDTO = new PersoonDTO();
		persoonDTO.setAdresTypes(adresService.getAllTypes());

		model.addAttribute("persoonDTO", persoonDTO);

		return "relatiebeheer/personen/nieuw";
	}

	@RequestMapping(value = "/nieuw", method = RequestMethod.POST)
	public String saveNieuwPersoon(
			@ModelAttribute("persoonDTO") @Valid PersoonDTO persoonDTO,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "relatiebeheer/personen/nieuw";
		} else {
			Persoon persoon = persoonDTO.getPersoon();
			Adres adres = persoonDTO.getAdres();
			DigitaalAdres telefoonnummer = persoonDTO.getDigitaalAdres1();
			DigitaalAdres email = persoonDTO.getDigitaalAdres2();
			persoon.addAdres(adres);
			persoon.addDigitaalAdres(telefoonnummer);
			persoon.addDigitaalAdres(email);
			service.save(persoon);
			adresService.save(adres);
			digitaalAdresService.save(telefoonnummer);
			digitaalAdresService.save(email);

			model.addAttribute("persoonDTO", persoonDTO);
			// model.addAttribute("succes",
			// persoonDTO.getPersoon().getVolledigeNaam()
			// + " is toegevoegd");

			// return "relatiebeheer/personen/zoekresultaat-" + persoon.getId();
			// return zoekResultaat(persoon.getId(), model);
			return ("redirect:zoekresultaat-" + persoon.getId());
		}
	}

	@RequestMapping(value = { "/nieuwadres-{id}" }, method = RequestMethod.GET)
	public String adresToevoegen(@ModelAttribute("id") int id,
			BindingResult result, ModelMap model) {
		PersoonDTO persoonDTO = new PersoonDTO();
		persoonDTO.setPersoon(service.get(id));
		persoonDTO.setAdresTypes(adresService.getAllTypes());

		model.addAttribute("persoonDTO", persoonDTO);

		return "relatiebeheer/personen/nieuwadres";
	}

	@RequestMapping(value = { "/nieuwadres-{id}" }, method = RequestMethod.POST)
	public String adresToevoegen(@ModelAttribute("id") int id,
			BindingResult result,
			@ModelAttribute("persoonDTO") PersoonDTO persoonDTO,
			BindingResult result2, ModelMap model) {
		Persoon persoon = service.get(persoonDTO.getPersoon().getId());
		persoon.addAdres(persoonDTO.getAdres());
		adresService.save(persoonDTO.getAdres());
		service.update(persoon);

		model.addAttribute("succes",
				"Nieuw adres voor " + persoon.getVolledigeNaam()
						+ " toegevoegd!");
		model.addAttribute("persoonDTO", persoonDTO);

		return "relatiebeheer/personen/bevestig";
	}

	@RequestMapping(value = { "/nieuwpersoonsrol-{id}" }, method = RequestMethod.GET)
	public String persoonsrolToevoegen(@ModelAttribute("id") int id,
			BindingResult result, ModelMap model) {
		PersoonDTO persoonDTO = new PersoonDTO();
		persoonDTO.setPersoon(service.get(id));
		persoonDTO.setRollen(persoonsrolService.getAllRollen());

		model.addAttribute("persoonDTO", persoonDTO);

		return "relatiebeheer/personen/nieuwpersoonsrol";
	}

	@RequestMapping(value = { "/nieuwpersoonsrol-{id}" }, method = RequestMethod.POST)
	public String persoonsrolToevoegen(@ModelAttribute("id") int id,
			BindingResult result,
			@ModelAttribute("persoonDTO") PersoonDTO persoonDTO,
			BindingResult result2, ModelMap model) {
		Persoon persoon = service.get(persoonDTO.getPersoon().getId());
		persoon.addPersoonsrol(persoonDTO.getPersoonsrol());
		persoonsrolService.save(persoonDTO.getPersoonsrol());
		service.update(persoon);

		model.addAttribute("succes",
				"Nieuw persoonsrol voor " + persoon.getVolledigeNaam()
						+ " toegevoegd!");
		model.addAttribute("persoonDTO", persoonDTO);

		return "relatiebeheer/personen/bevestig";
	}

}
