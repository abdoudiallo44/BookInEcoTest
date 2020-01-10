package fr.dawan.projettest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class RegisterController {

	@Autowired
	private UtilisateurService service;
	
	public String enregistrerUtilisateur() {
		
		return "";
	}
}
