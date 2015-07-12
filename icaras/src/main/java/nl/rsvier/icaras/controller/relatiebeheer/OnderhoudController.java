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
/**
 * OnderhoudController regelt de pagina's voor het onderhoudscherm
 */
@Controller
@RequestMapping("/relatiebeheer/onderhoud")
public class OnderhoudController {
	
	@Autowired
	AdresTypeService adresTypeService;
	
	/**
	 * Deze methode haalt alle adrestypes op uit de database en laat deze in het scherm zien
	 * @param model met daarin de OnderhoudDTO met alle adrestypes
	 * @return adrestypespagina
	 */
	@RequestMapping(value={"/adrestypes"}, method= RequestMethod.GET)
	public String toonAdresTypes(ModelMap model) {
		OnderhoudDTO dto = new OnderhoudDTO();
		dto.setAdresTypes(adresTypeService.getAllTypes());
		model.addAttribute("dto", dto);
		return "relatiebeheer/onderhoud/adrestypes";
	}
	
	/**
	 * Deze methode voegt een nieuw adrestype toe aan de database (input wordt niet gecheckt)
	 * @param dto OnderhoudDTO met daarin een input veld
	 * @param result om de input te controleren
	 * @param model
	 * @return adrestypespagina
	 */
	@RequestMapping(value={"/adrestypes"}, method = RequestMethod.POST, params="add")
	public String nieuwAdresType(@ModelAttribute("dto") OnderhoudDTO dto, BindingResult result, ModelMap model) {
		AdresType type = new AdresType();
		type.setType(dto.getInput());
		adresTypeService.save(type);		
		dto.setAdresTypes(adresTypeService.getAllTypes());
		
		return "relatiebeheer/onderhoud/adrestypes";
	}
	
	/**
	 * Met deze methode kan je de bestaande adrestypes wijzigen
	 * @param dto OnderhoudDTO
	 * @param result om de input te controleren
	 * @param model 
	 * @return
	 */
	@RequestMapping(value={"/adrestypes"}, method = RequestMethod.POST, params="update")
	public String updateAdresTypes(@ModelAttribute("dto") OnderhoudDTO dto, BindingResult result, ModelMap model) {	
		adresTypeService.updateList(dto.getAdresTypes());		
		dto.setAdresTypes(adresTypeService.getAllTypes());
		
		return "relatiebeheer/onderhoud/adrestypes";
	}
	

}
