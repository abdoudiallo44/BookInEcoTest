package fr.dawan.projettest.Controllers;

import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import fr.dawan.projettest.Beans.AdresseForm;
import fr.dawan.projettest.Beans.ProfilForm;
import fr.dawan.projettest.DAO.AdresseDAO;
import fr.dawan.projettest.entite.AdresseLivraison;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.AdresseService;
import fr.dawan.projettest.service.GenericService;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class ModifProfilController {

	@Autowired
	private UtilisateurService service;

	@Autowired
	private AdresseService adresseService;
	
//	@Autowired
//	private AdresseService adresseService;

//	@GetMapping("/modifierProfil")
//	public String modifierProfil(Model model, HttpSession session) {
//		
//		return "profil";
//	}

	/**
	 * Methode permettant d'afficher le profil de l'utilisateur avec la liste de ses
	 * adresses
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("displayProfil")
	public String displayProfil(Model model, HttpSession session) {

		Utilisateur util = (Utilisateur) session.getAttribute("user");
		util = service.findById(Utilisateur.class, util.getId(), true);
		session.setAttribute("user", util);

		List<AdresseLivraison> listeAdresse = util.getAdresseLivraison();

//		List<Utilisateur> liste = service.readAll();
//		session.setAttribute("prenom", util.getPrenom());
//		session.setAttribute("nom", util.getNom());
//		session.setAttribute("dateDeNaissance", util.getDateDenaissance());
//		String adress = listeAdresse.get(0).getNumEtRueAdresse() + " " 
//						+ listeAdresse.get(0).getCodePostal() 
//						+ " - " + listeAdresse.get(0).getVille()
//						+ " (" + listeAdresse.get(0).getPays() + ")";
//		session.setAttribute("adresse", adress);
//		session.setAttribute("nbrePoint", util.getNombreDePoint());

		model.addAttribute("listeAdresse", listeAdresse);
		model.addAttribute("user", util);

		return "profil";
	}

	/**
	 * Méthode permettant de modifier les informations personnelles de l'utilisateur
	 * 
	 * @param model
	 * @param profilForm
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("displayProfil")
	public String modifierProfil(Model model, @Valid @ModelAttribute("profilForm") ProfilForm profilForm,
			HttpSession session, BindingResult bindingResult) {

		Utilisateur user = (Utilisateur) session.getAttribute("user");
		;
		System.out.println(user.getId());

		if (user != null) {
			user.setPrenom(profilForm.getPrenom());
			user.setNom(profilForm.getNom());
			user.setPseudo(profilForm.getPseudo());
			user.setMdp(profilForm.getMdp());

			if (user.getId() > 0) {

				service.update(user, true);

				// user = (Utilisateur) service.findById(Utilisateur.class, user.getId(), true);

				List<AdresseLivraison> listeAdresse = user.getAdresseLivraison();

				model.addAttribute("listeAdresse", listeAdresse);
				model.addAttribute("user", user);
			}

			return "redirect:displayProfil";
		}

		return "redirect:/";
	}

	/**
	 * Méthode permettant d'affichier le profil de l'utilisateur pour modification
	 * 
	 * @param model
	 * @param session
	 * @param id
	 * @return
	 */
	@GetMapping("profil/modifierProfil")
	public String modifierProfil(Model model, HttpSession session) {

		Utilisateur user = (Utilisateur) session.getAttribute("user");
		if (user != null) {
			model.addAttribute("profilForm", service.findById(Utilisateur.class, user.getId(), true));

			Utilisateur util = (Utilisateur) session.getAttribute("user");
//			List<AdresseLivraison> listeAdresse = util.getAdresseLivraison();
//			
//			
//			model.addAttribute("profilForm", service.findById(Utilisateur.class, id, true));
//			model.addAttribute("listeAdresse", listeAdresse);
			model.addAttribute("user", util);

			return "modifierProfil";
		}

		return "redirect:/";

	}


	@GetMapping("profil/ajouteradresse")
	public String ajouterAdresse(Model model, @Valid @ModelAttribute("adresseForm") AdresseForm adresseForm) {

		return "ajouteradresse";
	}

	
	@PostMapping("profil/ajouteradresse")
	public String ajouterAdresse(Model model, HttpSession session,
			@Valid @ModelAttribute("adresseForm") AdresseForm adresseForm) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");

		AdresseLivraison adresse = new AdresseLivraison();

		adresse.setNumEtRueAdresse(adresseForm.getNumEtRueAdresse());
		adresse.setCodePostal(adresseForm.getCodePostal());
		adresse.setVille(adresseForm.getVille());
		adresse.setPays(adresseForm.getPays());

		user.addAdresse(adresse);
		
		System.out.println(adresse);
		List<AdresseLivraison> listeAdresse = user.getAdresseLivraison();

		adresseService.create(adresse, true);

		model.addAttribute("listeAdresse", listeAdresse);
		model.addAttribute("user", user);
		return "redirect:/displayProfil";
	}
	
	@GetMapping("profil/supprimerAdresse/{id}")
	public String supprimerAdresse(Model model, HttpSession session, @PathVariable("id") long id) {
		
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		
		
		adresseService.deleteAdresseById(id);
		//adresseService.deleteById(id);
//		List<AdresseLivraison> listeAdresse = service.findAllByUser(user.getId(), true);
//		
//		model.addAttribute("listeAdresse", listeAdresse);
//		model.addAttribute("user", user);
		
		return "redirect:/displayProfil";
	}
	
	@GetMapping("profil/modifierAdresse/${id}")
	public String modifierAdresse(Model model, HttpSession session, @PathVariable("id") long id) {
		
		
		return "";
	}
}
