package fr.dawan.projettest.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class PanierController {
	
	@Autowired
	UtilisateurService service;

	@GetMapping("/panier")
	public String panier(Model model,HttpSession session) {

		Utilisateur user = (Utilisateur) session.getAttribute("user");
		List<Livre> livres = service.getPanier(user.getId(),true);
		model.addAttribute("listeLivre", livres);

		return "panier";
	}
}
