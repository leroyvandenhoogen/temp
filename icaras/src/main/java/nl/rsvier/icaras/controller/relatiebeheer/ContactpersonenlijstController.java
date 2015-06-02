package nl.rsvier.icaras.controller.relatiebeheer;

import java.util.ArrayList;
import java.util.List;

import nl.rsvier.icaras.core.relatiebeheer.Persoonsrol;
import nl.rsvier.icaras.service.relatiebeheer.PersoonsrolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contactpersonen")
public class ContactpersonenlijstController {

	@Autowired
	PersoonsrolService service;
	
	@RequestMapping(value ={"", "lijst"}, method = RequestMethod.GET)
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
//	@RequestMapping(value = "/update-{id}-persoon", method = RequestMethod.GET)
//	public String updatePersoon(@PathVariable int id, ModelMap model) {
//		Persoon persoon = service.get(id);
//		model.addAttribute("persoon", persoon);
//		List<Persoon> personen = service.getAll();
//		List<Persoon> contactpersonen = new ArrayList<>();
//		for (Persoon persoon1 : personen) {
//			if (persoon1.hasRol("contactpersoon"))
//				contactpersonen.add(persoon1);		
//		}
//		model.addAttribute("contactpersonen", contactpersonen);
//		return "contactpersoondetails";
//	}
}