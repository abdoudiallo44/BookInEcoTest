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
public class RegisterController {

	@Autowired
	private RegisterService service;

	@GetMapping("/inscription")
	public String inscription() {

		return "inscription";
	}
	
	@GetMapping("/inscription/validation")
	public String RedirectToInscription() {
		return "inscription";
	}

	@PostMapping("/inscription/validation")
	public String validation(Model model, @Valid @ModelAttribute("registerForm") RegisterForm registerForm, BindingResult bindingResult) {
		
		String password = registerForm.getMdp();
		String password2 = registerForm.getMdp2();
		
		// Si erreurs et mdp2 vide OU mdp null OU mdp vide OU mdp2 null OU mp2 vide
//		if ((bindingResult.hasErrors() && "".equals(password2)) || password == null ||  "".equals(password) || password2 == null ||  "".equals(password2)) {
		if (bindingResult.hasErrors()) {	
			// Si mdp et mdp2 sont différents passwordsNotEquals
			if (!password.equals(password2) || !password2.isEmpty()) {
				model.addAttribute("passwordsNotEquals", true);
			}
			if ("".equals(password2) && password.isEmpty()) {
				model.addAttribute("password2Empty", true);
			}
			return "inscription";
		}
		
		Utilisateur user = new Utilisateur();
		user.setEmail(registerForm.getEmail());
		user.setPseudo(registerForm.getPseudo());
		user.setMdp(registerForm.getMdp());
		
		
		if (user.getId() == 0 && service.findUserByEmailAndPseudo(user.getEmail(), user.getPseudo()) == null ) {
			service.create(user, true);
			model.addAttribute("user", user);
		} else {
			return "inscription";
		}
		
		return "home";
		
	}
	
	@ModelAttribute("registerForm")
	public RegisterForm getRegisterForm() {
		return new RegisterForm();
	}
}
