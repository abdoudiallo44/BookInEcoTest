package fr.dawan.projettest.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class PanierController {
	
	@Autowired
	UtilisateurService service;
	
	@RequestMapping(value = "/ajoutPanier/{idLivre}", method = RequestMethod.GET)
	public String ajoutPanier(Model model,HttpSession session,@PathVariable("idLivre") long idLivre) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		user = (Utilisateur) service.findById(Utilisateur.class, user.getId(), false);
		service.addToCart(user, idLivre, false);
		List<Livre> livres = service.findAll(Livre.class,true);
		model.addAttribute("listeLivre", livres);
		return "home";
	}

	@GetMapping("/panier")
	public String panier(Model model,HttpSession session) {
		// pour probleme commande getcommande where utl-id = id devrait le faire
		// sinon remplacer List par set
		// sinon doit y avoir une erreur quelque part et je voit pas
		// si le probleme se regle go remettre addall pour la liste de livre
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		List<Livre> livres = service.getPanier(user.getId(), true);
		model.addAttribute("listeLivre", livres);

		return "panier";
	}
}
