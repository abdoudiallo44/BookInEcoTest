package fr.dawan.projettest.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class RegisterController {

	@Autowired
	private UtilisateurService service;
	
//	@GetMapping("/login")
//	public String login() {
//
//		return "login";
//	}
	
	@PostMapping("/inscription")
	public String register(Model model, @RequestParam("mail") String mail, @RequestParam("login") String login, @RequestParam("pass") String pass,
			HttpSession session) {

	    Utilisateur util = service.findUserByEmailAndLogin(mail, login);
	    
	    
	    service.create(util, true);
	    System.out.println(util);

			return "login";
	}
	
}
