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
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.projettest.entite.Commande;
import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.LivreService;

@Controller
public class LivreController {
	
	@Autowired
	LivreService livreService;
	
	@GetMapping("/gestionLivre")
	public String gestionLivre(Model model,HttpSession session) {

		Utilisateur user = (Utilisateur) session.getAttribute("user");
		List<Livre> livres = livreService.findAllByUser(user.getId(),true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}

	
	@RequestMapping(value="livres/findByKey",method=RequestMethod.POST)
	public String findByKey(Model model,@RequestParam("motCle") String recherche) {

		List<Livre> livres = livreService.findByKey(recherche,true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
	
	@RequestMapping(value="livres/supprimer/{id}",method=RequestMethod.GET)
	public String deleteById(Model model,@PathVariable("id") long id) {

		livreService.deleteById(Livre.class, id, false);
		List<Livre> livres = livreService.findAll(Livre.class,true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
	
	@RequestMapping(value="livres/modifier/{id}",method=RequestMethod.GET)
	public String update(Model model,@PathVariable("id") long id) {
		List<Livre> livres = livreService.findAll(Livre.class,true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
}
