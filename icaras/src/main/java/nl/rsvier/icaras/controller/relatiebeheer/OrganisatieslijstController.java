package nl.rsvier.icaras.controller.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.core.relatiebeheer.Zoekinput;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/relatiebeheer/organisaties")
//@SessionAttributes("organisaties")
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
	
	@RequestMapping(value= {"/zoeken"}, method= RequestMethod.GET)
	public String zoekOrganisatie(@ModelAttribute("zoekinput") Zoekinput zoekinput, BindingResult result, ModelMap model) {
		Zoekinput zi = new Zoekinput("test");
		model.addAttribute("zoekinput", zi);
		return "relatiebeheer/organisaties/zoeken";
	}
	
	@RequestMapping(value={"/zoeken"}, method = RequestMethod.POST)
	public String zoekOrganisatieLijst(@ModelAttribute("zoekinput") Zoekinput zoekinput, BindingResult result, ModelMap model) {
		List<Bedrijf> organisaties = bedrijfService.search(zoekinput.getInput());
		model.addAttribute("organisaties", organisaties);
		model.addAttribute("zoekinput", zoekinput);
		return "relatiebeheer/organisaties/zoeken";
	}
	@RequestMapping(value= {"/nieuw"}, method= RequestMethod.GET)
	public String organisatieToevoegen(ModelMap model) {
		return "relatiebeheer/organisaties/nieuw";
	}

//	@RequestMapping(value = { "", "lijst" }, method = RequestMethod.GET)
//	public String showOrganisatiesLijst(ModelMap model) {
//		List<Bedrijf> organisaties = bedrijfService.getAll();
//		model.addAttribute("organisaties", organisaties);
//		return "organisaties";
//	}
//
//	@RequestMapping(value = "/update-{id}-organisatie", method = RequestMethod.GET)
//	public String updateOrganisatie(@PathVariable int id, ModelMap model) {
//		ArrayList<AdresType> adresTypes = (ArrayList<AdresType>) adresService
//				.getAllTypes();
//		model.addAttribute("adresTypes", adresTypes);
//		Bedrijf organisatie = bedrijfService.get(id);
//		model.addAttribute("organisatie", organisatie);
//		return "organisatiedetails";
//	}
//
//	@RequestMapping(value = "/update-{id}-organisatie", method = RequestMethod.POST)
//	public String updateOrganisatie(@PathVariable int id,
//			@Valid @ModelAttribute("organisatie") Bedrijf organisatie,
//			BindingResult result, ModelMap model) {
//		for (Adres adres : organisatie.getAdressen()) {
//			adres.setBedrijf(organisatie);
//			adresService.update(adres);
//		}
//		for (Persoonsrol pRol : organisatie.getPersoonsrollen()) {
//			
//			pRol.setBedrijf(organisatie);
//			for (DigitaalAdres dAdres : pRol.getPersoon().getDigitaleAdressen()) {
//				dAdres.setPersoon(pRol.getPersoon());
//				digitaalAdresService.update(dAdres);
//			}
//			persoonService.update(pRol.getPersoon());
//			persoonsrolService.update(pRol);
//		}
//		bedrijfService.update(organisatie);
//
//		List<Bedrijf> organisaties = bedrijfService.getAll();
//		model.addAttribute("organisaties", organisaties);
//
//		ArrayList<AdresType> adresTypes = (ArrayList<AdresType>) adresService
//				.getAllTypes();
//		model.addAttribute("adresTypes", adresTypes);
//
//		Bedrijf organisatie1 = bedrijfService.get(id);
//		model.addAttribute("organisatie", organisatie1);
//
//		return "organisatiedetails";
//
//	}
}