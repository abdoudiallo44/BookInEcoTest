package fr.dawan.projettest.Controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.service.LivreService;

@Controller
@RequestMapping("livres")
public class LivreController {
	
	@Autowired
	private LivreService service;
	
	@GetMapping("/display")
	public String display(Model model) {

		List<Livre> livres = service.readAll();
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
	
	@RequestMapping(value="/findByKey",method=RequestMethod.POST)
	public String findByKey(Model model,@RequestParam("motCle") String recherche) {

		
		List<Livre> livres = service.findByKey(recherche);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
}
