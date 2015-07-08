package nl.rsvier.icaras.controller.relatiebeheer;

import java.sql.Date;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.core.relatiebeheer.DigitaalAdres;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.service.relatiebeheer.AdresService;
import nl.rsvier.icaras.service.relatiebeheer.BedrijfService;
import nl.rsvier.icaras.service.relatiebeheer.DigitaalAdresService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonsrolService;
import nl.rsvier.icaras.util.relatiebeheer.AchternaamComparator;
import nl.rsvier.icaras.util.relatiebeheer.BedrijfComparator;
import nl.rsvier.icaras.util.relatiebeheer.BedrijfDTO;
import nl.rsvier.icaras.util.relatiebeheer.DAdresComparator;
import nl.rsvier.icaras.util.relatiebeheer.Zoekinput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/relatiebeheer/organisaties")
// @SessionAttributes("organisaties")
public class OrganisatieslijstController {

	@Autowired
	BedrijfService bedrijfService;
	@Autowired
	AdresService adresService;
	@Autowired
	PersoonsrolService persoonsrolService;
	@Autowired
	PersoonService persoonService;
	@Autowired
	DigitaalAdresService digitaalAdresService;

	@RequestMapping(value = { "/zoeken" }, method = RequestMethod.GET)
	public String zoekOrganisatie(
			@ModelAttribute("zoekinput") Zoekinput zoekinput,
			BindingResult result, ModelMap model) {
		Zoekinput zi = new Zoekinput("");
		model.addAttribute("zoekinput", zi);
		return "relatiebeheer/organisaties/zoeken";
	}

	@RequestMapping(value = { "/zoeken" }, method = RequestMethod.POST)
	public String zoekOrganisatieLijst(
			@ModelAttribute("zoekinput") Zoekinput zoekinput,
			BindingResult result, ModelMap model) {
		List<Bedrijf> organisaties = bedrijfService
				.search(zoekinput.getInput());
		if (organisaties != null)
			Collections.sort(organisaties, new BedrijfComparator());
		model.addAttribute("organisaties", organisaties);
		model.addAttribute("zoekinput", zoekinput);
		return "relatiebeheer/organisaties/zoeken";
	}

	@RequestMapping(value = { "/nieuw" }, method = RequestMethod.GET)
	public String organisatieToevoegen(ModelMap model) {
		BedrijfDTO bedrijfDTO = new BedrijfDTO();
		bedrijfDTO.setAdresTypes(adresService.getAllTypes());
		bedrijfDTO.setBedrijfTypes(bedrijfService.getAllTypes());
		model.addAttribute("bedrijfDTO", bedrijfDTO);
		return "relatiebeheer/organisaties/nieuw";
	}

	@RequestMapping(value = { "/nieuw" }, method = RequestMethod.POST)
	public String saveOrganisatie(
			@ModelAttribute("bedrijfDTO") BedrijfDTO bedrijfDTO,
			BindingResult result, ModelMap model) {
		Bedrijf bedrijf = bedrijfDTO.getBedrijf();
		Adres adres = bedrijfDTO.getAdres();
		bedrijf.addAdres(adres);
		bedrijfService.save(bedrijfDTO.getBedrijf());
		adresService.save(bedrijfDTO.getAdres());
		//return ("redirect:toon-" + bedrijfDTO.getBedrijf().getId() + "-organisatie");
		return ("redirect:" + organisatieDetails(bedrijfDTO.getBedrijf().getId(), result, model));
	}

	@RequestMapping(value = { "/nieuwAdres-{id}" }, method = RequestMethod.GET)
	public String adresToevoegen(@ModelAttribute("id") int id,
			BindingResult result, ModelMap model) {
		BedrijfDTO bedrijfDTO = new BedrijfDTO();
		bedrijfDTO.setBedrijf(bedrijfService.get(id));
		bedrijfDTO.setAdresTypes(adresService.getAllTypes());
		model.addAttribute("bedrijfDTO", bedrijfDTO);
		return "relatiebeheer/organisaties/nieuwAdres";
	}

	@RequestMapping(value = { "/nieuwAdres-{id}" }, method = RequestMethod.POST)
	public String adresToevoegen(@ModelAttribute("id") int id,
			BindingResult result,
			@ModelAttribute("bedrijfDTO") BedrijfDTO bedrijfDTO,
			BindingResult result2, ModelMap model) {
		Bedrijf bedrijf = bedrijfService.get(bedrijfDTO.getBedrijf().getId());
		bedrijf.addAdres(bedrijfDTO.getAdres());
		adresService.save(bedrijfDTO.getAdres());
		bedrijfService.update(bedrijf);
		model.addAttribute("bedrijfDTO", bedrijfDTO);
		model.addAttribute("succes", "Nieuw adres voor " + bedrijf.getNaam()
				+ " toegevoegd!");
		return "relatiebeheer/organisaties/bevestig";

	}

	@RequestMapping(value = { "/nieuwContactpersoon-{id}" }, method = RequestMethod.GET)
	public String contactpersoonToevoegen(@ModelAttribute("id") int id,
			BindingResult result, ModelMap model) {
		BedrijfDTO bedrijfDTO = new BedrijfDTO();
		bedrijfDTO.setDigitaalAdresTypes(digitaalAdresService.getAllTypes());
		bedrijfDTO.setBedrijf(bedrijfService.get(id));
		model.addAttribute("bedrijfDTO", bedrijfDTO);
		return "relatiebeheer/organisaties/nieuwContactpersoon";
	}

	@RequestMapping(value = { "/nieuwContactpersoon-{id}" }, method = RequestMethod.POST)
	public String contactpersoonToevoegen(@ModelAttribute("id") int id,
			BindingResult result,
			@ModelAttribute("bedrijfDTO") BedrijfDTO bedrijfDTO,
			BindingResult result2, ModelMap model) {
		Bedrijf bedrijf = bedrijfService.get(id);
		persoonService.save(bedrijfDTO.getPersoon());
		Persoonsrol persoonsrol = new Persoonsrol();
		persoonsrol.setPersoon(bedrijfDTO.getPersoon());
		persoonsrol.setBedrijf(bedrijf);
		persoonsrol.setBegindatum(new Date(Calendar.getInstance()
				.getTimeInMillis()));
		persoonsrolService.addRol("contactpersoon", persoonsrol);
		persoonsrolService.save(persoonsrol);
		bedrijf.addPersoonsrol(persoonsrol);
		bedrijfService.update(bedrijf);
		DigitaalAdres dAdres1 = bedrijfDTO.getdAdres1();
		DigitaalAdres dAdres2 = bedrijfDTO.getdAdres2();
		dAdres1.setPersoon(bedrijfDTO.getPersoon());
		dAdres2.setPersoon(bedrijfDTO.getPersoon());
		digitaalAdresService.save(dAdres1);
		digitaalAdresService.save(dAdres2);
		model.addAttribute("bedrijfDTO", bedrijfDTO);
		model.addAttribute("succes", bedrijfDTO.getPersoon().getVolledigeNaam()
				+ " is toegevoegd");
		return "relatiebeheer/organisaties/bevestig";
	}

	@RequestMapping(value = { "/toon-{id}-organisatie" }, method = RequestMethod.GET)
	public String organisatieDetails(@ModelAttribute("id") int id,
			BindingResult result, ModelMap model) {
		Bedrijf organisatie = bedrijfService.get(id);
		BedrijfDTO bedrijfDTO = new BedrijfDTO();
		bedrijfDTO.setBedrijf(organisatie);
		bedrijfDTO.setAdresTypes(adresService.getAllTypes());
		bedrijfDTO.setBedrijfTypes(bedrijfService.getAllTypes());
		model.addAttribute("bedrijfDTO", bedrijfDTO);

		return "relatiebeheer/organisaties/details";
	}

	@RequestMapping(value = { "/toon-{id}-organisatie" }, method = RequestMethod.POST, params="wijzigadres")
	public String updateAdres(@PathVariable int id,
			@ModelAttribute("bedrijfDTO") BedrijfDTO bedrijfDTO,
			BindingResult result, ModelMap model) {
		for (Adres adres : bedrijfDTO.getBedrijf().getAdressen()) {
			adres.setBedrijf(bedrijfDTO.getBedrijf());
			adresService.update(adres);
		}
		
		bedrijfService.update(bedrijfDTO.getBedrijf());
		//return ("redirect:" + organisatieDetails(bedrijfDTO.getBedrijf().getId(), result, model));
		return ("redirect:toon-" + bedrijfDTO.getBedrijf().getId() + "-organisatie");
	}
	
	@RequestMapping(value = { "/toon-{id}-organisatie" }, method = RequestMethod.POST, params="nieuwadres")
	public String nieuwAdres(@PathVariable int id,
			@ModelAttribute("bedrijfDTO") BedrijfDTO bedrijfDTO,
			BindingResult result, ModelMap model) {
			Adres adres = bedrijfDTO.getAdres();
			adres.setBedrijf(bedrijfDTO.getBedrijf());
			adresService.save(adres);
					
		//return ("redirect:" + organisatieDetails(bedrijfDTO.getBedrijf().getId(), result, model));
		return ("redirect:toon-" + bedrijfDTO.getBedrijf().getId() + "-organisatie");
	}
	
	@RequestMapping(value = { "/toon-{id}-organisatie" }, method = RequestMethod.POST, params="nieuwpersoon")
	public String nieuwPersoon(@PathVariable int id,
			@ModelAttribute("bedrijfDTO") BedrijfDTO bedrijfDTO,
			BindingResult result, ModelMap model) {

		Bedrijf bedrijf = bedrijfService.get(id);
		persoonService.save(bedrijfDTO.getPersoon());
		Persoonsrol persoonsrol = bedrijfDTO.getPersoonsrol();
		persoonsrol.setPersoon(bedrijfDTO.getPersoon());
		persoonsrol.setBedrijf(bedrijf);
		persoonsrol.setBegindatum(new Date(Calendar.getInstance()
				.getTimeInMillis()));
		persoonsrolService.addRol("contactpersoon", persoonsrol);
		persoonsrolService.save(persoonsrol);
		bedrijf.addPersoonsrol(persoonsrol);
		bedrijfService.update(bedrijf);
		DigitaalAdres dAdres1 = bedrijfDTO.getdAdres1();
		DigitaalAdres dAdres2 = bedrijfDTO.getdAdres2();
		dAdres1.setPersoon(bedrijfDTO.getPersoon());
		dAdres2.setPersoon(bedrijfDTO.getPersoon());
		digitaalAdresService.save(dAdres1);
		digitaalAdresService.save(dAdres2);

		//return ("redirect:" + organisatieDetails(bedrijfDTO.getBedrijf().getId(), result, model));
		return ("redirect:toon-" + bedrijf.getId() + "-organisatie");
	}
	
	@RequestMapping(value = { "/toon-{id}-organisatie" }, method = RequestMethod.POST)
	public String updateOrganisatie(@PathVariable int id,
			@ModelAttribute("bedrijfDTO") BedrijfDTO bedrijfDTO,
			BindingResult result, ModelMap model) {
		for (Adres adres : bedrijfDTO.getBedrijf().getAdressen()) {
			adres.setBedrijf(bedrijfDTO.getBedrijf());
			adresService.update(adres);
		}
		for (Persoonsrol pRol : bedrijfDTO.getBedrijf().getPersoonsrollen()) {

			pRol.setBedrijf(bedrijfDTO.getBedrijf());
			for (DigitaalAdres dAdres : pRol.getPersoon().getDigitaleAdressen()) {
				dAdres.setPersoon(pRol.getPersoon());
				digitaalAdresService.update(dAdres);
			}
			persoonService.update(pRol.getPersoon());
			persoonsrolService.update(pRol);
		}
		bedrijfService.update(bedrijfDTO.getBedrijf());

		model.addAttribute("bedrijfDTO", bedrijfDTO);
		model.addAttribute("succes", bedrijfDTO.getBedrijf().getNaam() + " is aangepast");

		return "relatiebeheer/organisaties/bevestig";

	}

	@RequestMapping(value = { "/verwijder-{id}" }, method = RequestMethod.GET)
	public String verwijderOrganisatieGET(@ModelAttribute("id") int id,
			BindingResult result, ModelMap model) {
		Bedrijf organisatie = bedrijfService.get(id);

		model.addAttribute("organisatie", organisatie);
		return "relatiebeheer/organisaties/delete";

	}

	@RequestMapping(value = { "/verwijder-{id}" }, method = RequestMethod.POST)
	public String verwijderOrganisatie(@ModelAttribute("id") int id,
			BindingResult result, ModelMap model) {
		Bedrijf organisatie = bedrijfService.get(id);
		String naam = organisatie.getNaam();
		for (Persoonsrol persoonsrol : organisatie.getPersoonsrollen()) {
			persoonsrol.removeBedrijf();
			persoonsrolService.delete(persoonsrol);
		}
		bedrijfService.delete(organisatie);

		model.addAttribute("succes", naam + " is verwijderd");
		return "relatiebeheer/organisaties/bevestigdelete";

	}
	
	@RequestMapping(value={"/verwijderadres-{id}" }, method= RequestMethod.GET)
	public String verwijderAdres(@ModelAttribute("id") int id, BindingResult result, ModelMap model) {
		Adres adres = adresService.get(id);
		int bedrijfId = adres.getBedrijf().getId();
		adresService.delete(adres);
		
		return ("redirect:toon-" + bedrijfId + "-organisatie");
		}

	@RequestMapping(value = { "/zoekContactpersoon-{id}" }, method = RequestMethod.GET)
	public String zoekContactpersoon(@ModelAttribute("id") int id,
			BindingResult result, ModelMap model) {
		BedrijfDTO bedrijfDTO = new BedrijfDTO();
		bedrijfDTO.setBedrijf(bedrijfService.get(id));

		model.addAttribute("bedrijfDTO", bedrijfDTO);
		return "relatiebeheer/organisaties/zoekContactpersoon";
	}

	@RequestMapping(value = { "/zoekContactpersoon-{id}" }, method = RequestMethod.POST)
	public String zoekContactpersoon(@ModelAttribute("id") int id,
			BindingResult result,
			@ModelAttribute("bedrijfDTO") BedrijfDTO bedrijfDTO,
			BindingResult result2, ModelMap model) {
		List<Persoon> personen = persoonService.search(bedrijfDTO
				.getInput());
		Collections.sort(personen, new AchternaamComparator());
		model.addAttribute("personen", personen);
		bedrijfDTO.setBedrijf(bedrijfService.get(id));

		model.addAttribute("bedrijfDTO", bedrijfDTO);
		return "relatiebeheer/organisaties/zoekContactpersoon";
	}

	@RequestMapping(value = { "/koppel-{bedrijfid}-{persoonid}" }, method = RequestMethod.GET)
	public String koppelPeroonBedrijf(
			@ModelAttribute("bedrijfid") int bedrijfid, BindingResult result,
			@ModelAttribute("persoonid") int persoonid, BindingResult result2,
			ModelMap model) {
		Bedrijf organisatie = bedrijfService.get(bedrijfid);
		Persoon persoon = persoonService.get(persoonid);
		Persoonsrol persoonsrol = new Persoonsrol();
		persoonsrol.setPersoon(persoon);
		persoonsrol.setBedrijf(organisatie);
		persoonsrol.setBegindatum(new Date(Calendar.getInstance()
				.getTimeInMillis()));
		persoonsrolService.addRol("contactpersoon", persoonsrol);
		persoonsrolService.save(persoonsrol);
		organisatie.addPersoonsrol(persoonsrol);
		bedrijfService.update(organisatie);
		BedrijfDTO bedrijfDTO = new BedrijfDTO();
		bedrijfDTO.setBedrijf(organisatie);
		bedrijfDTO.setPersoon(persoon);

		model.addAttribute("bedrijfDTO", bedrijfDTO);
		model.addAttribute("succes", bedrijfDTO.getPersoon().getVolledigeNaam()
				+ " is toegevoegd aan " + bedrijfDTO.getBedrijf().getNaam());
		return "relatiebeheer/organisaties/bevestig";
	}

}