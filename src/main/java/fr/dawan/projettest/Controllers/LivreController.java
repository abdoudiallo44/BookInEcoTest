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
import org.springframework.web.bind.annotation.RequestParam;
import fr.dawan.projettest.Beans.LivreForm;
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

	@GetMapping("/supprimer/{id}")
	public String supprimer(Model model, @PathVariable("id") long id) {

		service.deleteById(id);

		List<Livre> liste = service.readAll();

		model.addAttribute("listeLivre", liste);
		return "livres";
	}
	//

	public String ajouterLivre(Model model, @Valid @ModelAttribute("livreForm") LivreForm livreForm,
			BindingResult bindingResult) {

		Livre livre = new Livre(livreForm.getIdLivre(), livreForm.getAuteur(), livreForm.getTitre(),
				livreForm.getDescription(), livreForm.getPhotoLivre(), livreForm.getPoidsLivre(),
				livreForm.getFormatLivre(), livreForm.getDateAjoutLivre(), livreForm.getDisponibilite());

		if (bindingResult.hasErrors()) {
			return "livres";
		} else {
			if (livre.getIdLivre() == 0) {
				service.create(livre);
				model.addAttribute("listeLivre", service.readAll());
			} else {
				service.update(livre);
				model.addAttribute("listeLivre", service.readAll());
			}
		}

		return "livres";
	}

	@PostMapping("/findByKey")
	public String findByKey(Model model, @RequestParam("motCle") String key) {

		List<Livre> liste = service.findByKey(key);
		model.addAttribute("listeLivre", liste);

		return "livres";
	}

	@GetMapping("/modifier/{id}")
	public String modifier(Model model, @PathVariable("id") long id) {

		model.addAttribute("livreForm", service.findById(id));
		model.addAttribute("listeLivre", service.readAll());

		return "livres";
	}

	// méthode qui initialise le formulaire lié à la classe produitForm dans la page
	// produits.jsp
	// cette annotation fait comprendre a spring que dans l'application un
	// formulaire est lié à une classe et
	// il se charge de l'initialiser
	@ModelAttribute("produitForm")
	public LivreForm getProduitForm() {
		return new LivreForm();
	}
}
