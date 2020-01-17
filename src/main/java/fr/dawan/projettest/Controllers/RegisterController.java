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
	
	public static String compareMdp(String mdp1, String mdp2) {
		if (mdp1.equals(mdp2)) {
			return "Mots de passe identique";
		}
		return "Mots de passe différents";
	}

	@PostMapping("/inscription/validation")
	public String validation(Model model, @Valid @ModelAttribute("registerForm") RegisterForm registerForm,
			BindingResult bindingResult) {

		RegisterForm userRegister = new RegisterForm(registerForm.getEmail(), registerForm.getPseudo(),
				registerForm.getMdp(), registerForm.getMdp2());

		Utilisateur user = new Utilisateur();

		user.setEmail(registerForm.getEmail());
		user.setPseudo(registerForm.getPseudo());
		user.setMdp(registerForm.getMdp());
		
		String messageErreur = compareMdp(userRegister.getMdp(), userRegister.getMdp2());
		

		if (userRegister.getMdp().equals(userRegister.getMdp2())) {
			if (bindingResult.hasErrors()) {
				return "inscription";
			} else {
				if (user.getId() == 0 && service.findUserByEmailAndPseudo(user.getEmail(), user.getPseudo()) == null) {
					service.create(user, true);
					model.addAttribute("user", user);
				}
			}
			return "home";
		}
		return "";

	}

	@ModelAttribute("registerForm")
	public RegisterForm getRegisterForm() {
		return new RegisterForm();
	}
}
