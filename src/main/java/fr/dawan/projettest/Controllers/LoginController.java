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
import fr.dawan.projettest.service.LivreService;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class LoginController {
	
	@Autowired
	private UtilisateurService service;
	@Autowired
	private LivreService livreService;
	
	@GetMapping("/login")
	public String login() {

		return "login";
	}
	
	

	
	@PostMapping("/login/authentification")
	public String authentification(Model model, @RequestParam("login") String login, @RequestParam("pass") String pass,
			HttpSession session) {
		
	    Utilisateur util = service.findUserByEmailAndPwd(login, pass); 
	    
	    //System.out.println(util);
	    if (util == null) {
	    	model.addAttribute("msg", "Erreur d'authentification!!!");
	    	return "redirect:/login";
		}
	    
		String pseudo = util.getPseudo();
		String email = util.getEmail();
		String mdp = util.getMdp();
		String prenom = util.getPrenom();
		
		if ((pseudo.equals(login) || email.equals(login)) && mdp.equals(pass)) {
			session.setAttribute("user", util);
			session.setAttribute("prenom", prenom);

			List<Livre> livres = livreService.findAll(Livre.class,true);
			model.addAttribute("listeLivre", livres);
			return "home";
		}else
		if (login.equals("admin") && pass.equals("admin")) {
			session.setAttribute("user", util);
			session.setAttribute("login", login);
			session.setAttribute("utilisateurName", util.getPrenom() + " " + util.getNom());
			return "welcomeAdmin";
		}
		else {
			model.addAttribute("msg", "Erreur d'authentification!!!");
			return "redirect:/";
		}

	}
	
	
	
	@GetMapping("/login/deconnexion")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
	
}