package nl.rsvier.icaras.controller.relatiebeheer;

import nl.rsvier.icaras.core.relatiebeheer.AdresType;
import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.service.relatiebeheer.AdresTypeService;
import nl.rsvier.icaras.util.relatiebeheer.OnderhoudDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/relatiebeheer/onderhoud")
public class OnderhoudController {
	
	@Autowired
	AdresTypeService adresTypeService;
	
	@RequestMapping(value={"/adrestypes"}, method= RequestMethod.GET)
	public String toonAdresTypes(ModelMap model) {
		OnderhoudDTO dto = new OnderhoudDTO();
		dto.setAdresTypes(adresTypeService.getAllTypes());
		model.addAttribute("dto", dto);
		return "relatiebeheer/onderhoud/adrestypes";
	}
	
	@RequestMapping(value={"/adrestypes"}, method = RequestMethod.POST, params="add")
	public String nieuwAdresType(@ModelAttribute("dto") OnderhoudDTO dto, BindingResult result, ModelMap model) {
		AdresType type = new AdresType();
		type.setType(dto.getInput());
		adresTypeService.save(type);
		
		dto.setAdresTypes(adresTypeService.getAllTypes());
		
		return "relatiebeheer/onderhoud/adrestypes";
	}
	
	@RequestMapping(value={"/adrestypes"}, method = RequestMethod.POST, params="update")
	public String updateAdresTypes(@ModelAttribute("dto") OnderhoudDTO dto, BindingResult result, ModelMap model) {
		
		adresTypeService.updateList(dto.getAdresTypes());
		
		dto.setAdresTypes(adresTypeService.getAllTypes());
		
		return "relatiebeheer/onderhoud/adrestypes";
	}
	

}
