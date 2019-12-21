package fr.dawan.projettest;

import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.GenericService;
import fr.dawan.projettest.service.LivreService;
import fr.dawan.projettest.service.UtilisateurService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {


	@Autowired
	UtilisateurService service;
	
	@Autowired
	LivreService livreService;
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}
	
	

	@GetMapping("/load")
	public String chargementLivre() {
		Utilisateur utilisateur1 = new Utilisateur("Abdoulaye", "DIALLO", LocalDate.now(), "a.diallo7@hotmail", "abdou", "abdou44");
		service.create(utilisateur1, false);
		Livre livre1 = new Livre("auteur1", "titre1", "description 1",utilisateur1);
		livreService.create(livre1, false);
		Livre livre2 = new Livre("auteur2", "titre2", "description 2", utilisateur1);
		livreService.create(livre2, false);
		Livre livre3 = new Livre("auteur3", "titre3", "description 3", utilisateur1);
		livreService.create(livre3, false);
		Livre livre4 = new Livre("auteur1", "titre4", "description 4", utilisateur1);
		livreService.create(livre4, false);
		Livre livre5 = new Livre("auteur1", "titre5", "description 5",  utilisateur1);
		livreService.create(livre5, false);
		
		return "home";
	}
	
	
}
