package fr.dawan.projettest.Controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.service.LivreService;

@Controller
@RequestMapping("livre")
public class LivreController {
	
	@Autowired
	private LivreService service;
	
	@GetMapping("/display")
	public String display(Model model) {

		List<Livre> livres = service.readAll();
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
	
	
	// A finir
	@GetMapping("/supprimer/{id}")
	public String supprimer() {
		return "livres";
	}
	//
}
