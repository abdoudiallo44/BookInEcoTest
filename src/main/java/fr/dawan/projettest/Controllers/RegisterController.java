package fr.dawan.projettest.Controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dawan.projettest.Beans.RegisterForm;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.RegisterService;
import fr.dawan.projettest.service.UtilisateurService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService service;
	
	@GetMapping("/inscription")
	public String inscription() {
		
		return "inscription";
	}
	
//	@PostMapping("/inscription/validation")
//	public String validation(Model model, @RequestParam(defaultValue = "", name="email") String email,
//			@RequestParam(defaultValue = "", name="pass") String pass,
//			@RequestParam(defaultValue = "", name="pseudo") String pseudo,
//			HttpSession session) {
//		
//		Utilisateur user = new Utilisateur();
//		user.setEmail("samson@yyyy.fr");
//		user.setPseudo("samson");
//		user.setMdp("samson");
//		
//		service.create(user, true);
//		session.setAttribute("user", user);
//		
//		return "home";
//		
//		
//		if (pseudo!= null && pass!= null && email!=null && !pseudo.trim().equals("") && !pass.trim().equals("") && !email.trim().equals("")) {
//			Utilisateur user = new Utilisateur();
//			user.setEmail("samson@yahoo.fr");
//			user.setMdp("samson");
//			user.setPseudo("samson");
//			
//			Utilisateur utilisateurBDD = service.findUserByEmailAndPseudo(user.getEmail(), user.getPseudo());
//			
//			service.create(user, true);
//			session.setAttribute("user", user);
//			return "home";
//		}else {
//			model.addAttribute("msg", "Erreur d'inscription!!!");
//			return "inscription";
//		}
//	}
	
	
	
	
	@PostMapping("/inscription/validation")
	public String validation(Model model, @Valid @ModelAttribute("registerForm") RegisterForm registerForm, BindingResult bindingResult) {
		
		// userRegister = new RegisterForm(registerForm.getEmail(), registerForm.getPseudo(), registerForm.getMdp());
		Utilisateur user = new Utilisateur();
		user.setEmail(registerForm.getEmail());
		user.setPseudo(registerForm.getPseudo());
		user.setMdp(registerForm.getMdp());
		
		if (bindingResult.hasErrors()) {
			return "inscription";
		}else {
			if (user.getId() == 0 && service.findUserByEmailAndPseudo(user.getEmail(), user.getPseudo()) == null) {
				service.create(user, true);
				model.addAttribute("user", user);
			}
		}
		return "home";
		
	}
	
	@ModelAttribute("registerForm")
	public RegisterForm getRegisterForm() {
		return new RegisterForm();
	}
}
