package fr.dawan.projettest.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class LoginController {
	
	@Autowired
	private UtilisateurService service;
	
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
	   
	    
//		String pseudo = util.getPseudo();
//		String email = util.getEmail();
//		String mdp = util.getMdp();
		session.setAttribute("user", util);

		List<Livre> livres = service.findAll(Livre.class,true);
		model.addAttribute("listeLivre", livres);
		return "home";
		
//		if ((pseudo.equals(login) || email.equals(login)) && mdp.equals(pass)) {
//		}else
//		if (login.equals("admin") && pass.equals("admin")) {
//			session.setAttribute("login", login);
//			session.setAttribute("utilisateurName", util.getPrenom() + " " + util.getNom());
//			return "welcomeAdmin";
//		}
//		else {
//			model.addAttribute("msg", "Erreur d'authentification!!!");
//			return "login";
//		}

	}
	
	@PostMapping("/inscription/validation")
	public String validation(Model model, @RequestParam("email") String email, @RequestParam("pass") String pass, @RequestParam("pseudo") String pseudo,
			HttpSession session) {
		if (pseudo!= null && pass!= null && email!=null && !pseudo.trim().equals("") && !pass.trim().equals("") && !email.trim().equals("")) {
			Utilisateur user = new Utilisateur();
			user.setEmail(email);
			user.setMdp(pass);
			user.setPseudo(pseudo);
			service.create(user, true);
			session.setAttribute("user", user);
			return "home";
		}else {
			model.addAttribute("msg", "Erreur d'inscription!!!");
			return "inscription";
		}
	}
	
	@GetMapping("/login/deconnexion")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
	
}