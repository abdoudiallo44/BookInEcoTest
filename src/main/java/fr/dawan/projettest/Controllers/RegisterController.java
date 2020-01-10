package fr.dawan.projettest.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.RegisterService;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService service;
	
	
	@PostMapping("/inscription/validation")
	public String validation(Model model, @RequestParam("email") String email, @RequestParam("pass") String pass, @RequestParam("pseudo") String pseudo,
			HttpSession session) {
		
		Utilisateur user = new Utilisateur();
		user.setEmail("samson@yahoo.fr");
		user.setMdp("samson");
		user.setPseudo("samson");
		
		service.create(user, true);
		session.setAttribute("user", user);
		return "home";
		
		
//		if (pseudo!= null && pass!= null && email!=null && !pseudo.trim().equals("") && !pass.trim().equals("") && !email.trim().equals("")) {
//			Utilisateur user = new Utilisateur();
//			user.setEmail("samson@yahoo.fr");
//			user.setMdp("samson");
//			user.setPseudo("samson");
//			
//			
//			//Utilisateur utilisateurBDD = service.findUserByEmailAndPseudo(user.getEmail(), user.getPseudo());
//			
//			
//			service.create(user, true);
//			session.setAttribute("user", user);
//			return "home";
//		}else {
//			model.addAttribute("msg", "Erreur d'inscription!!!");
//			return "inscription";
//		}
	}
}
