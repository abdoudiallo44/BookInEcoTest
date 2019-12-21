package fr.dawan.projettest.Controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import fr.dawan.projettest.Beans.LivreForm;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.service.GenericService;
import fr.dawan.projettest.service.LivreService;

@Controller
@RequestMapping("livres")
public class LivreController {

	@Autowired
	private LivreService service;
	
	@GetMapping("/display")
	public String display(Model model) {

		List<Livre> livres = service.findAll(Livre.class, true);
		model.addAttribute("listeLivre", livres);

		return "livres";
	}
	
	@RequestMapping(value="/findByKey",method=RequestMethod.POST)
	public String findByKey(Model model,@RequestParam("motCle") String recherche) {

		List<Livre> livres = new ArrayList<Livre>();
		livres.addAll(service.findByKey(Livre.class, recherche, true));
		//addAll(service.findByKey(Livre.class, true));
		model.addAttribute("listeLivre", livres);

		return "livres";
	}

	@GetMapping("/supprimer/{id}")
	public String supprimer(Model model, @PathVariable("id") long id) {

		service.delete(Livre.class, id, false);;

		List<Livre> liste = service.findAll(Livre.class, true);

		model.addAttribute("listeLivre", liste);
		return "livres";
	}
	//

	@PostMapping("/ajouterLivre")
	public String ajouterLivre(Model model, @Valid @ModelAttribute("livreForm") LivreForm livreForm,
			BindingResult bindingResult) {

		Livre livre = new Livre(livreForm.getId(), livreForm.getAuteur(), livreForm.getTitre(),
				livreForm.getDescription(), livreForm.getPhotoLivre(), livreForm.getPoidsLivre(),
				livreForm.getFormatLivre(), livreForm.getDateAjoutLivre(), livreForm.getDisponibilite());

		if (bindingResult.hasErrors()) {
			return "livres";
		} else {
			if (livre.getId() == 0) {
				service.create(livre, false);
				model.addAttribute("listeLivre", service.findAll(Livre.class, true));
			} else {
				service.update(livre, false);
				model.addAttribute("listeLivre", service.findAll(Livre.class, true));
			}
		}

		return "livres";
	}

	@GetMapping("/modifier/{id}")
	public String modifier(Model model, @PathVariable("id") long id) {
		model.addAttribute("livreForm", service.findById(Livre.class, id, false));
		model.addAttribute("listeLivre", service.findAll(Livre.class, true));

		return "livres";
	}

	// méthode qui initialise le formulaire lié à la classe produitForm dans la page
	// produits.jsp
	// cette annotation fait comprendre a spring que dans l'application un
	// formulaire est lié à une classe et
	// il se charge de l'initialiser
	@ModelAttribute("livreForm")
	public LivreForm getProduitForm() {
		return new LivreForm();
	}
	
	
	
}
