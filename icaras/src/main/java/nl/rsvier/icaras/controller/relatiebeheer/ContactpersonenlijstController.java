package nl.rsvier.icaras.controller.relatiebeheer;

import java.util.ArrayList;
import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.service.relatiebeheer.PersoonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contactpersonen")
public class ContactpersonenlijstController {

	@Autowired
	PersoonService service;
	
	@RequestMapping(value ={"", "lijst"}, method = RequestMethod.GET)
	public String showPersonenLijst(ModelMap model) {
		List<Persoon> personen = service.getAll();
		List<Persoon> contactpersonen = new ArrayList<>();
		for (Persoon persoon : personen) {
			if (persoon.hasRol("contactpersoon"))
				contactpersonen.add(persoon);		
		}
		model.addAttribute("contactpersonen", contactpersonen);
		return "contactpersonen";
	}
}