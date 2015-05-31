package nl.rsvier.icaras.controller.relatiebeheer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/cursisten")
	public String showCursistenLijst() {
		return "cursisten";
	}
	
//	@RequestMapping("/personen")
//	public String showPersonenLijst() {
//		return "personen";
//	}

	@RequestMapping("/kandidaten")
	public String showKandidatenLijst() {
		return "kandidaten";
	}
	
	@RequestMapping("/stagiairs")
	public String showStagiairsLijst() {
		return "stagiairs";
	}
	
	@RequestMapping("/werknemers")
	public String showWerknemersLijst() {
		return "werknemers";
	}
	
	@RequestMapping("/contactpersonen")
	public String showContactPersonenLijst() {
		return "contactpersonen";
	}
	
	@RequestMapping("/prive")
	public String showPriveLijst() {
		return "prive";
	}
	
	@RequestMapping("/organisaties")
	public String showOrganisatieLijst() {
		return "organisaties";
	}
	
	@RequestMapping("/projectinfo")
	public String showProjectInfo() {
		return"projectinfo";
	}
	  
}


