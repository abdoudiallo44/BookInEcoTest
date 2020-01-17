package fr.dawan.projettest;

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
import fr.dawan.projettest.service.LivreService;
import fr.dawan.projettest.service.RegisterService;
import fr.dawan.projettest.service.UtilisateurService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	UtilisateurService utilService;
	
	@Autowired
	private RegisterService service;
	
	@Autowired
	private LivreService livreService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,HttpSession session) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		if(user != null) {
			List<Livre> livres = livreService.findAllExceptUser(user.getId(), true);
			model.addAttribute("listeLivre", livres);
			return "home";
		}
		List<Livre> livres = livreService.findAll(Livre.class,true);
		model.addAttribute("listeLivre", livres);
		return "home";
	}
	
	@GetMapping(value = "/ajoutPanier/{id}")
	public String ajoutPanier(Model model,HttpSession session,@PathVariable("id") long id) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		utilService.addToCart(user, id, false);
		List<Livre> livres = utilService.findAll(Livre.class,true);
		model.addAttribute("listeLivre", livres);
		return "home";
	}

	@GetMapping("/load")
	public String chargementLivre() {
		Utilisateur utilisateur1 = new Utilisateur("Abdoulaye", "DIALLO");
		utilisateur1.setPseudo("abdou");
		utilisateur1.setMdp("abdou");

		Livre livre1 = new Livre("auteur1", "titre1", "description 1",utilisateur1);
		livre1.setPhoto("Caraval.jpg");
		Livre livre2 = new Livre("auteur2", "titre2", "description 2",utilisateur1);
		livre2.setPhoto("Loperateur.jpg");
		Livre livre3 = new Livre("auteur3", "titre3", "description 3",utilisateur1);
		livre3.setPhoto("Nightfall.jpg");
		Livre livre4 = new Livre("auteur4", "titre4", "description 4",utilisateur1);
		livre4.setPhoto("Traqueurs.jpg");
		Livre livre5 = new Livre("auteur5", "titre5", "description 5",utilisateur1);
		livre5.setPhoto("Warren.jpg");
		utilisateur1.addLivre(livre1);
		utilisateur1.addLivre(livre2);
		utilisateur1.addLivre(livre3);
		utilisateur1.addLivre(livre4);
		utilisateur1.addLivre(livre5);
		utilService.create(utilisateur1, false);
		Utilisateur utilisateur2 = new Utilisateur("yo", "yo");
		Livre livre6 = new Livre("auteur6", "titre6", "description 6",utilisateur2);
		livre6.setPhoto("Traqueurs.jpg");
		Livre livre7 = new Livre("auteur7", "titre7", "description 7",utilisateur2);
		livre7.setPhoto("Ferrari.jpg");
		utilisateur2.setPseudo("yo");
		utilisateur2.setMdp("yo");
		utilisateur2.addLivre(livre6);
		utilisateur2.addLivre(livre7);
		utilService.create(utilisateur2, true);

		return "home";
}
	
	@GetMapping("/insertUser")
	public String insertUserTest() {
		Utilisateur user = new Utilisateur();
		user.setEmail("samson@yahoo.fr");
		user.setMdp("samson");
		user.setPseudo("samson");
		
		service.create(user, true);
		
		return "home";
	}

}
