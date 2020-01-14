package fr.dawan.projettest.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.dawan.projettest.Beans.RegisterForm;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.RegisterService;

@Controller
public class ProfilController {
	
	@Autowired
	private RegisterService service;
	
	@GetMapping("/gestion-profil")
	public String GestionDuProfil() {
		
		return "profil";
	}
	
	@PostMapping("/gestion-profil/validation")
	public String validation(Model model, @Valid @ModelAttribute("registerForm") RegisterForm registerForm, BindingResult bindingResult) {
		
		// userRegister = new RegisterForm(registerForm.getEmail(), registerForm.getPseudo(), registerForm.getMdp());
		Utilisateur user = new Utilisateur();
		user.setEmail(registerForm.getEmail());
		user.setPseudo(registerForm.getPseudo());
		user.setMdp(registerForm.getMdp());
		user.setNom(registerForm.getNom());
		user.setPrenom(registerForm.getPrenom());
		
		if (bindingResult.hasErrors()) {
			return "inscription";
		}else {
			if (user.getId() == 0 && service.findUserByEmailAndPseudo(user.getEmail(), user.getPseudo()) == null) {
				service.update(user, true);
				model.addAttribute("user", user);
			}
		}
		return "home";
		
	}
}
