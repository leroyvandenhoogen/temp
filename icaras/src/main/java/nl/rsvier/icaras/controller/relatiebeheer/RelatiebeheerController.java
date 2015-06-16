package nl.rsvier.icaras.controller.relatiebeheer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RelatiebeheerController {

	@RequestMapping("/relatiebeheer")
	public String showRelatiebeheer(){
		return "relatiebeheer";
	}
}
