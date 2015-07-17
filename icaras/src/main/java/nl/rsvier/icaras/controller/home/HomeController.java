package nl.rsvier.icaras.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}


