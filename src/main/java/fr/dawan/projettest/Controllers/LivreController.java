package fr.dawan.projettest.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.projettest.Beans.LivreForm;
import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.service.LivreService;

@Controller
public class LivreController {
	
	@Autowired
	LivreService livreService;
	
	@GetMapping("/gestionLivre")
	public String gestionLivre() {
		return "livres";
	}
	
	@PostMapping("/ajouterLivre")
	public String ajouter(Model model, @Valid @ModelAttribute("livreForm") LivreForm livreForm,
			BindingResult bindingResult) {

		Livre l = new Livre(livreForm.getAuteur(), livreForm.getTitre(), livreForm.getDescription(), livreForm.getPoidsLivre(), livreForm.getFormatLivre(), true);
		if (bindingResult.hasErrors()) {
			//model.addAttribute("livreForm", livreService.findById(livreForm.getId()));
			//model.addAttribute("listeLivre", livreService.readAll());
			return "livres";
		}
//		if (l.getId() != 0) {
//			livreService.update(l,false);
//		} else {
			livreService.create(l,false);
		//}
		model.addAttribute("listeLivre", livreService.findAll(Livre.class, true));
		return "livres";
	}
	
	@RequestMapping(value="livres/findByKey",method=RequestMethod.POST)
	public String findByKey(Model model,@RequestParam("motCle") String recherche) {

		List<Livre> livres = livreService.findByKey(recherche,true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
	
	@RequestMapping(value="livres/supprimer/{id}",method=RequestMethod.GET)
	public String deleteById(Model model,@PathVariable("id") long id) {

		livreService.deleteById(Livre.class, id, false);
		List<Livre> livres = livreService.findAll(Livre.class,true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
	
	@RequestMapping(value="livres/modifier/{id}",method=RequestMethod.GET)
	public String update(Model model,@PathVariable("id") long id) {
		List<Livre> livres = livreService.findAll(Livre.class,true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
}
