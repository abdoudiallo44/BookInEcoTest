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

import fr.dawan.projettest.entite.Commande;
import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.CommandeService;
import fr.dawan.projettest.service.GenericService;
import fr.dawan.projettest.service.LivreService;
import fr.dawan.projettest.service.UtilisateurService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UtilisateurService utilService;
	
	@Autowired
	private LivreService livreService;
	
	@Autowired
	private CommandeService commandeService;
	

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
		Livre l = livreService.findById(Livre.class, id, false);
		commandeService.createCommande(user,l,false);
		List<Livre> livres = livreService.findAll(Livre.class,true);
		model.addAttribute("listeLivre", livres);
		return "home";
	}

	@GetMapping("/load")
	public String chargementLivre() {
		Utilisateur utilisateur1 = new Utilisateur("Abdoulaye", "DIALLO");
		utilisateur1.setPseudo("abdou");
		utilisateur1.setMdp("abdou");

		Livre livre1 = new Livre("auteur1", "titre1", "description 1","Caraval.jpg",true,2,utilisateur1);
		Livre livre2 = new Livre("auteur2", "titre2", "description 2","Loperateur.jpg",true,3,utilisateur1);
		Livre livre3 = new Livre("auteur3", "titre3", "description 3","Nightfall.jpg",true,4,utilisateur1);
		Livre livre4 = new Livre("auteur4", "titre4", "description 4","Traqueurs.jpg",true,5,utilisateur1);
		Livre livre5 = new Livre("auteur5", "titre5", "description 5","Warren.jpg",true,2,utilisateur1);
		utilisateur1.addLivre(livre1);
		utilisateur1.addLivre(livre2);
		utilisateur1.addLivre(livre3);
		utilisateur1.addLivre(livre4);
		utilisateur1.addLivre(livre5);
		utilisateur1.setNombreDePoint(20);
		utilService.create(utilisateur1, false);
		Utilisateur utilisateur3 = new Utilisateur("oui", "oui");
		utilisateur3.setPseudo("oui");
		utilisateur3.setMdp("oui");
		utilService.create(utilisateur3, false);
		Utilisateur utilisateur2 = new Utilisateur("yo", "yo");
		Livre livre6 = new Livre("auteur6", "titre6", "description 6","Traqueurs.jpg",true,3,utilisateur2);
		Livre livre7 = new Livre("auteur7", "titre7", "description 7","Ferrari.jpg",true,4,utilisateur2);
		utilisateur2.setPseudo("yo");
		utilisateur2.setMdp("yo");
		utilisateur2.addLivre(livre6);
		utilisateur2.addLivre(livre7);
		utilisateur2.setNombreDePoint(20);
		utilService.create(utilisateur2, true);

		return "home";
}
	
//	@GetMapping("/insertUser")
//	public String insertUserTest() {
//		Utilisateur user = new Utilisateur();
//		user.setEmail("samson@yahoo.fr");
//		user.setMdp("samson");
//		user.setPseudo("samson");
//		
//		service.create(user, true);
//		
//		return "home";
//	}
	
	@GetMapping("/test")
	public String test() {
		//Commande c = commandeService.findById( 1);
		//commandeService.trueDelete(2);
		//commandeService.deleteById(Commande.class, 1, false);
		//commandeService.trueDelete();
		System.out.println("delete done");
//		Utilisateur user = utilService.findById(Utilisateur.class, 3, false);
//		Commande c = new Commande();
//		Livre l = livreService.findById(Livre.class, 2, false);
//		c.addLivre(l);
//		user.addCommande(c);
//		System.out.println(user);
//		utilService.update(user, false);
//		l = livreService.findById(Livre.class, 3, false);
//		service.deleteById(Commande.class, 1, false);
//		System.out.println(service.findById(Commande.class, 1, false));
//		user.removeCommande(c);
//		c.addLivre(l);
//		user.addCommande(c);
//		System.out.println(user);
//		utilService.update(user, true);
		return "home";
	}

}
