package nl.rsvier.icaras.controller.relatiebeheer;

import java.util.ArrayList;
import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;
import nl.rsvier.icaras.service.relatiebeheer.PersoonsrolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contactpersonen")
public class ContactpersonenlijstController {

	@Autowired
	PersoonsrolService service;

	@Autowired
	PersoonService persoonService;

	@RequestMapping(value = { "", "lijst" }, method = RequestMethod.GET)
	public String showPersonenLijst(ModelMap model) {
		List<Persoonsrol> persoonsrollen = service.getAll();
		List<Persoonsrol> contactpersonen = new ArrayList<>();
		for (Persoonsrol persoonsrol : persoonsrollen) {
			if (persoonsrol.getRol().getType().equals("contactpersoon"))
				contactpersonen.add(persoonsrol);
		}
		model.addAttribute("contactpersonen", contactpersonen);
		return "contactpersonen";
	}

	@RequestMapping(value = "/update-{id}-persoon", method = RequestMethod.GET)
	public String updatePersoon(@PathVariable int id, ModelMap model) {
		Persoon persoon = persoonService.get(id);
		Persoonsrol persoonsrol = new Persoonsrol();
		List<Persoonsrol> persoonsrollen = service.getAll();
		List<Persoonsrol> contactpersonen = new ArrayList<>();
		for (Persoonsrol rol : persoonsrollen) {
			if (rol.getRol().getType().equals("contactpersoon")) {
				contactpersonen.add(rol);
				if(rol.getPersoon().equals(persoon))
					persoonsrol = rol;
			}
		}
//		Bedrijf bedrijf = persoonsrol.getBedrijf();
//		model.addAttribute("bedrijf", bedrijf);
//		model.addAttribute("persoon", persoon);
		model.addAttribute("persoonsrol", persoonsrol);
		model.addAttribute("contactpersonen", contactpersonen);
		return "contactpersoondetails";
	}
}