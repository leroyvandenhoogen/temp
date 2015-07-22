package nl.rsvier.icaras.controller.relatiebeheer;

import java.security.Principal;

import javax.validation.Valid;

import nl.rsvier.icaras.core.User;
import nl.rsvier.icaras.core.relatiebeheer.AdresType;
import nl.rsvier.icaras.core.relatiebeheer.Bedrijf;
import nl.rsvier.icaras.service.UserService;
import nl.rsvier.icaras.service.relatiebeheer.AdresTypeService;
import nl.rsvier.icaras.util.relatiebeheer.OnderhoudDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@RequestMapping("/onderhoud")
public class OnderhoudController {
	
	@Autowired
	AdresTypeService adresTypeService;
	@Autowired
	UserService userService;
	
	/**
	 * account creeren
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/gebruiker/nieuw" }, method = RequestMethod.GET)
	public String showNieuwaccount(ModelMap model) {
		model.addAttribute("user", new User());
		return "onderhoud/gebruiker/nieuw";
	}

	@RequestMapping(value = { "/gebruiker/nieuw" }, method = RequestMethod.POST)
	public String creeerAccount(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "onderhoud/gebruiker/nieuw";
		}
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		user.setEnabled(true);

		if (userService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username",
					"Deze gebruikersnaam is al in gebruik");
			return "onderhoud/gebruiker/nieuw";
		}
		userService.save(user);
		return "onderhoud/gebruiker/bevestig";
	}
	/**
	 * Deze methode haalt alle adrestypes op uit de database en laat deze in het scherm zien
	 * @param model met daarin de OnderhoudDTO met alle adrestypes
	 * @return adrestypespagina
	 */
	@RequestMapping(value={"/lookuptable/adrestypes"}, method= RequestMethod.GET)
	public String toonAdresTypes(ModelMap model) {
		OnderhoudDTO dto = new OnderhoudDTO();
		dto.setAdresTypes(adresTypeService.getAllTypes());
		model.addAttribute("dto", dto);
		return "onderhoud/lookuptable/adrestypes";
	}
	
	/**
	 * Deze methode voegt een nieuw adrestype toe aan de database (input wordt niet gecheckt)
	 * @param dto OnderhoudDTO met daarin een input veld
	 * @param result om de input te controleren
	 * @param model
	 * @return adrestypespagina
	 */
	@RequestMapping(value={"/lookuptable/adrestypes"}, method = RequestMethod.POST, params="add")
	public String nieuwAdresType(@ModelAttribute("dto") OnderhoudDTO dto, BindingResult result, ModelMap model) {
		AdresType type = new AdresType();
		type.setType(dto.getInput());
		adresTypeService.save(type);		
		dto.setAdresTypes(adresTypeService.getAllTypes());
		
		return "onderhoud/lookuptable/adrestypes";
	}
	
	/**
	 * Met deze methode kan je de bestaande adrestypes wijzigen
	 * @param dto OnderhoudDTO
	 * @param result om de input te controleren
	 * @param model 
	 * @return
	 */
	@RequestMapping(value={"/lookuptable/adrestypes"}, method = RequestMethod.POST, params="update")
	public String updateAdresTypes(@ModelAttribute("dto") OnderhoudDTO dto, BindingResult result, ModelMap model) {	
		adresTypeService.updateList(dto.getAdresTypes());		
		dto.setAdresTypes(adresTypeService.getAllTypes());
		
		return "onderhoud/lookuptable/adrestypes";
	}
	

}
