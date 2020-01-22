package fr.dawan.projettest.Controllers;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class AchatPointsController {
	
		
		@Autowired
		UtilisateurService service;

		
		//une méthode qui revoit à la jsp
		//une méthode qui consulte les points de l'utilisateur
		@GetMapping("/achatPoints")
		public String vosPoints(Model model,HttpSession session) {
			Utilisateur user = (Utilisateur) session.getAttribute("user");
			int vosPoints = user.getNombreDePoint();
			model.addAttribute("vosPoints", vosPoints);
		return "achatPoints";	
		
		
		}		@GetMapping("/achatPoints/{points}")
		public String vosPoints(Model model,HttpSession session,@PathVariable("points") int points) {
			Utilisateur user = (Utilisateur) session.getAttribute("user");
			int vosPoints = user.getNombreDePoint();
			vosPoints = vosPoints + points;
			model.addAttribute("vosPoints", vosPoints);
			//mettre à jour l'objet dans la méthode
			user.setNombreDePoint(vosPoints);
			//mettre à jour l'utilisateur dans la BDD
			service.update(user, true);
			//mettre à jour l'objet utilisateur dans la session
			session.setAttribute("points", vosPoints);
		return "achatPoints";	
		}
		//une méthode qui ajoute des points à l'utilisateur
		}
		
		


