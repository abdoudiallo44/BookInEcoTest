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
	public String home(Model model, HttpSession session) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		if (user != null) {
			List<Livre> livres = livreService.findAllExceptUser(user.getId(), true);
			model.addAttribute("listeLivre", livres);
			return "home";
		}
		List<Livre> livres = livreService.findAll(Livre.class, true);
		model.addAttribute("listeLivre", livres);
		return "home";
	}

	@GetMapping(value = "/ajoutPanier/{id}")
	public String ajoutPanier(Model model, HttpSession session, @PathVariable("id") long id) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		Livre l = livreService.findById(Livre.class, id, false);
		commandeService.createCommande(user, l, false);
		List<Livre> livres = livreService.findAll(Livre.class, true);
		model.addAttribute("listeLivre", livres);
		return "home";
	}

	@GetMapping("/load")
	public String chargementLivre() {
		Utilisateur utilisateur1 = new Utilisateur("Abdoulaye", "DIALLO");
		utilisateur1.setPseudo("abdou");
		utilisateur1.setMdp("abdou");
		Utilisateur utilisateur2 = new Utilisateur("yo", "yo");
		Utilisateur utilisateur3 = new Utilisateur("Samson", "Charlonnnai");
		utilisateur3.setPseudo("samson");
		utilisateur3.setMdp("samson");
		Utilisateur utilisateur4 = new Utilisateur("Sarah", "Evain");
		utilisateur4.setPseudo("sarah");
		utilisateur4.setMdp("sarah");
		Livre livre1 = new Livre("Pierre Lemaitre", "Miroir de nos peines ",
				"Avril 1940. Louise, trente ans, court, nue, sur le boulevard du Montparnasse. Pour comprendre la scène tragique qu’elle vient de vivre, elle devra plonger dans la folie d’une période sans équivalent dans l’histoire où la France toute entière, saisie par la panique, sombre dans le chaos 1",
				"Miroir_de_nos_peines.jpg", true, 2, utilisateur1);
		Livre livre2 = new Livre("Maxime Chattam", "UN(e)SECTE",
				"Et si tous les insectes du monde se mettaient soudainement à communiquer entre eux ? À s'organiser ? Nous ne survivrions pas plus de quelques jours. Entre un crime spectaculaire et la disparition inexpliquée d'une jeune femme, les chemins du détective Atticus Gore et de la privée Kat Kordell... ",
				"UN_e_SECTE.jpg", true, 3, utilisateur1);
		Livre livre3 = new Livre("Christelle Dabos", "La Tempête des échos - La Passe-Miroir, tome 4",
				"Le monde est sens dessus dessous. L’effondrement des arches a bel et bien commencé. Une seule solution pour l’enrayer : trouver le responsable. Trouver l’Autre. Mais comment faire sans seulement savoir à quoi il ressemble ? Ophélie et Thorn se lancent ensemble sur la piste des échos, ces étranges...",
				"La_Tempete_des_echos_La_Passe_Miroir_tome_4.jpg", true, 4, utilisateur1);
		Livre livre4 = new Livre("André Aciman", "Find Me",
				"Samuel, le père d'Elio, tout juste divorcé, entreprend un voyage de Florence à Rome au cours duquel il fait une rencontre sur le point de changer sa vie, tandis que son fils, devenu pianiste classique, s'envole pour Paris. Oliver, désormais professeur dans une école aux États-Unis, songerait à...",
				"Find_Me.jpg", true, 5, utilisateur2);
		Livre livre5 = new Livre("James Ellroy", "La Tempête qui vient",
				"Janvier 1942. Los Angeles est encore sous le choc de l'attaque de Pearl Harbor. Les Américains d'origine japonaise sont massivement arrêtés tandis que des pluies torrentielles s'abattent sur la ville. Un corps est découvert dans Griffith Park à la faveur d'un glissement de terrain",
				"La_Tempete_qui_vient.jpg", true, 2, utilisateur2);
		Livre livre6 = new Livre("Jean-Philippe Jaworski", "Chasse royale IV (Rois du monde, 5) ",
				"Dans la Celtique ravagée par la guerre, le mystère plane sur le sort du haut roi. Ambigat est-il mort ? Est-il encore en vie ? L'incertitude excite les convoitises et ajoute au désordre. Par loyauté et par ambition, Bellovèse se lance à la recherche du roi caché. À travers les contrées écumées...",
				"Chasse_royale_IV_Rois_du_monde_5.jpg", true, 3, utilisateur3);
		Livre livre7 = new Livre("Eric Vuillard", "La Guerre des pauvres",
				"1524, les pauvres se soulèvent dans le sud de l'Allemagne. L'insurrection s'étend, gagne rapidement la Suisse et l'Alsace. Une silhouette se détache du chaos, celle d'un théologien, un jeune homme, en lutte parmi les insurgés. Il s'appelle Thomas Müntzer. Sa vie terrible est romanesque.",
				"La_Guerre_des_pauvres.jpg", true, 4, utilisateur3);
		Livre livre8 = new Livre("Benjamin Gottar", "À l'aube de la mort",
				"Retenu prisonnier par un tortionnaire désireux de vérité, Arnaud va devoir faire preuve de malice pour sortir de ce pétrin. Qu'a-t-il donc fait pour se retrouver dans une telle posture ? L'enquête menée parallèlement le sauvera-t-il ? Ce roman riche en rebondissements, construit tel un solide...",
				"A_l_aube_de_la_mort.jpg", true, 3, utilisateur4);
		Livre livre9 = new Livre("Antoine Volodine", "Frères sorcières",
				"Trois voix puissantes, toutes liées au théâtre, à la féminité, au chamanisme et à la mort. Dans un pays de montagnes et de désert, une petite troupe itinérante est attaquée par des bandits. Bien vite, l’unique survivante est entraînée dans la vie criminelle et sauvage de ses ravisseurs.",
				"Freres_sorcieres.jpg", true, 4, utilisateur4);
		Livre livre10 = new Livre("Sylvain Prudhomme", "Par les routes",
				"« J’ai retrouvé l’autostoppeur dans une petite ville du sud-est de la France, après des années sans penser à lui. Je l’ai retrouvé amoureux, installé, devenu père. Je me suis rappelé tout ce qui m’avait décidé, autrefois, à lui demander de sortir de ma vie. J’ai frappé à sa porte. J’ai rencontré...",
				"Par_les_routes.jpg", true, 3, utilisateur4);
		Livre livre11 = new Livre("Ken Liu", "Jardins de poussière",
				"Ken Liu est titulaire d'un doctorat en droit (Harvard). On doit à ses activités de traducteur l'éclosion de la science-fiction chinoise aux yeux du monde. En tant qu'auteur, il dynamite la littérature de genres américaines — science-fiction comme fantasy – depuis une quinzaine d'années,...",
				"Jardins_de_poussiere.jpg", true, 4, utilisateur4);
		utilisateur1.addLivre(livre1);
		utilisateur1.addLivre(livre2);
		utilisateur1.addLivre(livre3);
		utilisateur2.addLivre(livre4);
		utilisateur2.addLivre(livre5);
		utilisateur3.addLivre(livre6);
		utilisateur3.addLivre(livre7);
		utilisateur4.addLivre(livre8);
		utilisateur4.addLivre(livre9);
		utilisateur4.addLivre(livre10);
		utilisateur4.addLivre(livre11);
		utilisateur1.setNombreDePoint(20);
		utilService.create(utilisateur1, false);
		utilService.create(utilisateur3, false);
		utilService.create(utilisateur4, false);

//		utilisateur2.setPseudo("yo");
//		utilisateur2.setMdp("yo");
//		utilisateur2.addLivre(livre6);
//		utilisateur2.addLivre(livre7);
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
		// Commande c = commandeService.findById( 1);
		// commandeService.trueDelete(2);
		// commandeService.deleteById(Commande.class, 1, false);
		// commandeService.trueDelete();
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
