package fr.dawan.projettest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.LivreService;
import fr.dawan.projettest.service.UtilisateurService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private LivreService livreService;
	
	@Autowired
	private UtilisateurService utilisateurService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@GetMapping("/load")
	public String chargementLivre() {
		Utilisateur utilisateur1 = new Utilisateur("Abdoulaye", "DIALLO");
		utilisateurService.create(utilisateur1);
		
		Livre livre1 = new Livre("auteur1", "titre1", "description 1",utilisateur1);
		livreService.create(livre1);
		Livre livre2 = new Livre("auteur2", "titre2", "description 2", utilisateur1);
		livreService.create(livre2);
		Livre livre3 = new Livre("auteur3", "titre3", "description 3", utilisateur1);
		livreService.create(livre3);
		Livre livre4 = new Livre("auteur1", "titre4", "description 4", utilisateur1);
		livreService.create(livre4);
		Livre livre5 = new Livre("auteur1", "titre5", "description 5",  utilisateur1);
		livreService.create(livre5);
		
		return "home";
	}
	
	
}