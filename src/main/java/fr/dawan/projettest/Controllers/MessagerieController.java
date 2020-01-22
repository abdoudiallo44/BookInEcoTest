package fr.dawan.projettest.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.dawan.projettest.entite.Message;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.MessageService;

@Controller
public class MessagerieController {
	@Autowired
	MessageService service;

	@GetMapping("/messagerie")
	public String affichageListeMessage(Model model, HttpSession session) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		long jeChoppeSonId = user.getId();
		List<Message> listeMessage = service.FindMessageById(jeChoppeSonId);
		model.addAttribute("listeMessage", listeMessage);
		return "accueilMessagerie";
	}
	
	@GetMapping("/contenuMessage/{id}")
	public String affichageContenuMessage(Model model, HttpSession session, @PathVariable("id")long id) {
		Message m2 = (Message) service.findById(Message.class, id, true);
		model.addAttribute("message", m2);
		return "contenuMessage";
	}
	
	@GetMapping("/supprimerMessage/{id}")
	public String supprimerMessage(Model model, HttpSession session, @PathVariable("id")long id) {
		service.deleteById(Message.class, id, true);
		String suppression = "Votre message a bien été supprimé";
		model.addAttribute("suppression", suppression);
		return "redirect:/messagerie";
	}
	
	@GetMapping("/reponseMessage") 
		public String allerSurReponseMessage() {
		return "reponseMessage";
	}
	
	@PostMapping("/reponseMessage")
	public String repondreMessage(Model model, HttpSession session) {
		Message m =  new Message();
		service.create(m, true);
		String confirmation = "Votre message a bien été envoyé";
		model.addAttribute("confirmation", confirmation);
		return "reponseMessage";
		
	}
	
}
