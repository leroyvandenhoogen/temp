package nl.rsvier.icaras.controller.home;

import nl.rsvier.icaras.core.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Algemene controller voor de domeinen van ICARAS
 */
@Controller
public class HomeController {
	
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
	public String creeerAccount(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {

		return "bevestigaccount";
	}

}


