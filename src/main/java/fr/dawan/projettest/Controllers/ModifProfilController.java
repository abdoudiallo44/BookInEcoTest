package fr.dawan.projettest.Controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.dawan.projettest.entite.AdresseLivraison;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class ModifProfilController {

	@Autowired
	private UtilisateurService service;

//	@GetMapping("/modifierProfil")
//	public String modifierProfil(Model model, HttpSession session) {
//		
//		return "profil";
//	}

	@GetMapping("/displayProfil")
	public String displayProfil(Model model, HttpSession session) {
		
		Utilisateur util = (Utilisateur) session.getAttribute("user");
		
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
	
	@GetMapping("profil/modifierProfil/{id}")
	public String modifierProfil(Model model, HttpSession session, @PathVariable("id") long id) {
		
//		model.addAttribute("profilForm", service.findById(Utilisateur.class, id, true));
//		model.addAttribute("profilForm", service.readAll());
		Utilisateur util = (Utilisateur) session.getAttribute("user");
		List<AdresseLivraison> listeAdresse = util.getAdresseLivraison();
		
		
		model.addAttribute("profilForm", service.findById(Utilisateur.class, id, true));
		model.addAttribute("listeAdresse", listeAdresse);
		model.addAttribute("user", util);
		
		return "modifierProfil";
	}
	
	@GetMapping("profil/modifierAdresse/{id}")
	public String modifierAdresse(Model model) {

		
		return "modifierProfil";
	}
	
	@GetMapping("profil/supprimerAdresse/{id}")
	public String SupprimerAdresse(Model model, @PathVariable("id") long id) {
		
//		service.deleteById(AdresseLivraison.class, id, false);
//		
//		List<AdresseLivraison> lst = service.findAll(AdresseLivraison.class, true);
//		
//		model.addAttribute("listeAdresse", lst);
		
		return "profil";
	}

}
