package nl.rsvier.icaras.controller.relatiebeheer;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import nl.rsvier.icaras.core.relatiebeheer.Persoon;
import nl.rsvier.icaras.service.relatiebeheer.BedrijfService;
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
	PersoonsrolService service;

	@Autowired
	PersoonService persoonService;
	@Autowired
	BedrijfService bedrijfService;
	

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
	
    @RequestMapping(value = {"update-{id}-persoon"}, method = RequestMethod.POST)
    public String updatePersoon(@PathVariable int id, @Valid @ModelAttribute("persoon") Persoon persoon, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "contactpersoondetails";
        } else {
        	persoonService.update(persoon);
    		
    		model.addAttribute("persoon", persoon);
    		
            model.addAttribute("succes", persoon.getVoornaam() + " " + persoon.getTussenvoegsel() + " "
                    + persoon.getAchternaam() + " is gewijzigd");
            return "contactpersoondetails";
        }
    }
}