package nl.rsvier.icaras.controller.relatiebeheer;

import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.service.relatiebeheer.BedrijfService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/organisaties")
public class OrganisatieslijstController {

	@Autowired
	BedrijfService service;

	@RequestMapping(value = { "", "lijst" }, method = RequestMethod.GET)
	public String showOrganisatiesLijst(ModelMap model) {
		List<Bedrijf> organisaties = service.getAll();
		model.addAttribute("organisaties", organisaties);
		return "organisaties";
	}
	
	@RequestMapping(value = "/update-{id}-organisatie", method = RequestMethod.GET)
	public String updateOrganisatie(@PathVariable int id, ModelMap model) {
		Bedrijf organisatie = service.get(id);
		model.addAttribute("organisatie", organisatie);
		List<Bedrijf> organisaties = service.getAll();
		model.addAttribute("organisaties", organisaties);
		return "organisatiedetails";
	}
}