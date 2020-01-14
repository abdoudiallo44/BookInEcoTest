package fr.dawan.projettest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class ModifProfilController {
	
	@Autowired
	private UtilisateurService service;
	
//	@GetMapping("login/authentification/")
//	public String modifierProfil() {
//		return "";
//	}

}
