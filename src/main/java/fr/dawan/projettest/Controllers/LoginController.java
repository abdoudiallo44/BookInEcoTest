package fr.dawan.projettest.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import fr.dawan.projettest.DAO.UtilisateurDAO;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class LoginController {
	
	@Autowired
	private UtilisateurDAO service;
	
	@GetMapping("/login")
	public String login() {

		return "login";
	}
	
	@GetMapping("/inscription")
	public String inscription() {
		
		return "inscription";
	}

	
	@PostMapping("/login/authentification")
	public String authentification(Model model, @RequestParam("login") String login, @RequestParam("pass") String pass,
			HttpSession session) {
		
	    Utilisateur util = service.findUserByEmailAndPwd(login, pass); 
	    
	    System.out.println(util);
	    
		String pseudo = util.getPseudo();
		String email = util.getEmail();
		String mdp = util.getMdp();
		
		if ((pseudo.equals(login) || email.equals(login)) && mdp.equals(pass)) {
			session.setAttribute("login", login);
			return "welcome";
		}else {
			model.addAttribute("msg", "Erreur d'authentification!!!");
			return "login";
		}
		
		

//		if (login.equals("admin") && pass.equals("admin")) {
//			session.setAttribute("login", login);
//			return "welcome";
//		} else {
//			model.addAttribute("msg", "Erreur d'authentification!!!");
//			return "login";
//		}

	}
	
	
	
	@GetMapping("/login/deconnexion")
	public String logout(HttpSession session, SessionStatus status) {

		// status.setComplete();
		session.invalidate();

		return "home";
	}
	
}
