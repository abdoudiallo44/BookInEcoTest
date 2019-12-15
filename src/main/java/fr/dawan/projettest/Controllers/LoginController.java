package fr.dawan.projettest.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import fr.dawan.projettest.DAO.UtilisateurDAO;
import fr.dawan.projettest.entite.Utilisateur;

@Controller
public class LoginController {
	
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
		
//		UtilisateurDAO utilDAO = new UtilisateurDAO();
//		
//		// Récupération User BDD
//		Utilisateur utilisateur = (Utilisateur) utilDAO.findById(1);
//		System.out.println(utilisateur);
//		
//		String pseudo = utilisateur.getPseudo();
//		String email = utilisateur.getEmail();
//		String mdp = utilisateur.getMdp();
//		
//		if ((pseudo.equals(login) || email.equals(login)) && mdp.equals(pass)) {
//			session.setAttribute("login", login);
//			return "welcome";
//		}else {
//			model.addAttribute("msg", "Erreur d'authentification!!!");
//			return "login";
//		}
		

		if (login.equals("admin") && pass.equals("admin")) {
			session.setAttribute("login", login);
			return "welcome";
		} else {
			model.addAttribute("msg", "Erreur d'authentification!!!");
			return "login";
		}

	}
	
	
	
	@GetMapping("/login/deconnexion")
	public String logout(HttpSession session, SessionStatus status) {

		// status.setComplete();
		session.invalidate();

		return "home";
	}
	
}
