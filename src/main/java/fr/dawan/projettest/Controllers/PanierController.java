package fr.dawan.projettest.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.projettest.entite.Commande;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.CommandeService;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
@RequestMapping("/panier")
public class PanierController {
	
	@Autowired
	UtilisateurService utilService;
	@Autowired
	CommandeService commandeService;

	@GetMapping("")
	public String panier(Model model,HttpSession session) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		List<Commande> commandes = utilService.getPanier(user.getId(),true);
		model.addAttribute("listeCommande", commandes);

		return "panier";
	}
	
	@GetMapping("/supprimer/{id}")
	public String supprimer(Model model,@PathVariable("id") long id) {
		commandeService.trueDelete(id, false);
		return "redirect:/panier";
	}
	
	@GetMapping("/acheter/{id}")
	public String acheter(Model model,@PathVariable("id") long id) {
		commandeService.acheter(id,false);
		return "redirect:/panier";
	}
}
