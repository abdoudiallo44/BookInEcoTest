package fr.dawan.projettest.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class ModifProfilController {
	
	@Autowired
	private UtilisateurService service;
	
	@GetMapping("/modifierProfil")
	public String modifierProfil(Model model, HttpSession session) {
		
		//session.get
		
		return "profil";
	}

}
