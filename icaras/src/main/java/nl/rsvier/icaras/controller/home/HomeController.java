package nl.rsvier.icaras.controller.home;

import javax.validation.Valid;

import nl.rsvier.icaras.core.User;
import nl.rsvier.icaras.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Algemene controller voor de domeinen van ICARAS
 */
@Controller
public class HomeController {
	@Autowired
	UserService userService;
	/**
	 * Beginpunt van de site
	 * @return home
	 */
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
	/**
	 * relatiebeheer domein
	 * @return relatiebeheer 
	 */
	@RequestMapping("/relatiebeheer")
	public String showRelatiebeheer(){
		return "relatiebeheer";
	}
	
	/**
	 * project info 
	 * @return projectinfo
	 */
	@RequestMapping("/projectinfo")
	public String showProjectInfo() {
		return"projectinfo";
	}
	
	/**
	 * login pagina
	 * @return
	 */
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	/**
	 * account creeren
	 * @return
	 */
	@RequestMapping(value={"/nieuwaccount"}, method=RequestMethod.GET)
	public String showNieuwaccount(ModelMap model) {
		model.addAttribute("user", new User());
		return "nieuwaccount";
	}
	
	@RequestMapping(value={"/nieuwaccount"}, method=RequestMethod.POST)
	public String creeerAccount(@Valid User user, BindingResult result) {

		if(result.hasErrors()) {
			return "nieuwaccount";
		}
		user.setEnabled(true);
		
		if(userService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username", "Deze gebruikersnaam is al in gebruik");
			return "nieuwaccount";
		}
		userService.save(user, "nieuw");
		return "bevestigaccount";
	}

}


