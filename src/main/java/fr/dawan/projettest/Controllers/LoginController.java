package fr.dawan.projettest.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.LivreService;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UtilisateurService service;
	@Autowired
	private LivreService livreService;

	@GetMapping("")
	public String login() {
		return "login";
	}

	@PostMapping("/authentification")
	public String authentification(Model model, @RequestParam("login") String login, @RequestParam("pass") String pass,
			HttpSession session) {

		Utilisateur util = service.findUserByEmailAndPwd(login, Utilisateur.getEncrytedPassword(pass));

		// L'utilisateur n'existe pas, ou il n'a pas le bon mdp
		if (util == null) {
			model.addAttribute("UnknownUser", true);
			return "redirect:/login";
		}

		session.setAttribute("user", util);

		if (login.equals("admin") && pass.equals("admin")) {			
			return "redirect:/admin";
		} else {
			return "redirect:/";
		}

	}

	@GetMapping("/deconnexion")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}

}