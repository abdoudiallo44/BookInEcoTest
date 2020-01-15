package fr.dawan.projettest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.projettest.service.UtilisateurService;

@Controller
@RequestMapping("login")
public class ModifProfilController {
	
	@Autowired
	private UtilisateurService service;
	
	@GetMapping("/authentification/modifierProfil/{id}")
	public String modifierProfil(Model model, @PathVariable ("id") long id) {
		
		
		return "profil";
	}

}
