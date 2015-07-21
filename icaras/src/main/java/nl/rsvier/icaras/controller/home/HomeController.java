package nl.rsvier.icaras.controller.home;

import java.security.Principal;

import javax.validation.Valid;

import nl.rsvier.icaras.core.User;
import nl.rsvier.icaras.service.UserService;
import nl.rsvier.icaras.util.relatiebeheer.Zoekinput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Algemene controller voor de domeinen van ICARAS
 */
@Controller
@SessionAttributes("inlognaam")
public class HomeController {
	@Autowired
	UserService userService;

	// @ModelAttribute("username")
	// public String createUsername() {
	// return new String("wablu");
	// }

	/**
	 * Beginpunt van de site
	 * 
	 * @return home
	 */
	@RequestMapping("/")
	public String showHome(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("inlognaam", name);
		return "home";
	}

	/**
	 * relatiebeheer domein
	 * 
	 * @return relatiebeheer
	 */
	@RequestMapping("/relatiebeheer")
	public String showRelatiebeheer(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("inlognaam", name);

		return "relatiebeheer";
	}

	/**
	 * project info
	 * 
	 * @return projectinfo
	 */
	@RequestMapping("/projectinfo")
	public String showProjectInfo() {
		return "projectinfo";
	}

	/**
	 * login pagina
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/login" })
	public String showLogin() {

		return "login";
	}

	/**
	 * account creeren
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/nieuwaccount" }, method = RequestMethod.GET)
	public String showNieuwaccount(ModelMap model) {
		model.addAttribute("user", new User());
		return "nieuwaccount";
	}

	@RequestMapping(value = { "/nieuwaccount" }, method = RequestMethod.POST)
	public String creeerAccount(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "nieuwaccount";
		}

		if (userService.exists(user.getUsername())) {
			result.rejectValue("username", "DuplicateKey.user.username",
					"Deze gebruikersnaam is al in gebruik");
			return "nieuwaccount";
		}
		userService.save(user);
		return "bevestigaccount";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
 
		ModelAndView model = new ModelAndView();
 
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}
 
		model.setViewName("403");
		return model;
 
	}
	
}


