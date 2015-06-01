package nl.rsvier.icaras.controller.relatiebeheer;

import java.util.List;
import java.util.Set;

import nl.rsvier.icaras.core.relatiebeheer.Adres;
import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/personen")
public class PersonenlijstController {
	
	@Autowired
	PersoonService service;
	
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
		return "persoondetails";
	}
}
