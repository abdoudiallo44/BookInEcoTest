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

	private static final int NOMBRE_DE_POINT = 10;

	@GetMapping("/inscription")
	public String inscription() {

		return "inscription";
	}

	@GetMapping("/inscription/validation")
	public String RedirectToInscription() {
		return "inscription";
	}

	@PostMapping("/inscription/validation")
	public String validation(Model model, @Valid @ModelAttribute("registerForm") RegisterForm registerForm,
			BindingResult bindingResult) {

		String password = registerForm.getMdp();
		String password2 = registerForm.getMdp2();

		Utilisateur user = new Utilisateur();
		user.setEmail(registerForm.getEmail());
		user.setPseudo(registerForm.getPseudo());
		user.setMdp(registerForm.getMdp());
		user.setPrenom(registerForm.getPrenom());
		user.setNom(registerForm.getNom());
		user.setNombreDePoint(NOMBRE_DE_POINT);

		if (bindingResult.hasErrors() && "".equals(password2)) {
			if (!password.equals(password2)) {
				model.addAttribute("passwordsNotEquals", true);
			}
			if ("".equals(password2) && password.isEmpty()) {
				model.addAttribute("password2Empty", true);
			}
			return "inscription";
		} else {

			if (user.getId() == 0 && service.findUserByEmailAndPseudo(user.getEmail(), user.getPseudo()) == null) {

				if (password.equals(password2)) {
					service.create(user, true);
					model.addAttribute("user", user);
				}
				if (!password.equals(password2)) {
					model.addAttribute("passwordsNotEquals", true);
					return "inscription";
				}
			} else {

				if (user.getId() == 0 && service.findUserByEmail(user.getEmail()) != null) {
					model.addAttribute("EmailAlreadyExists", true);
					return "inscription";
				}
				if (user.getId() == 0 && service.findUserByPseudo(user.getPseudo()) != null) {
					model.addAttribute("PseudoAlreadyExists", true);
					return "inscription";
				}
			}
		}

		return "redirect:/";

	}

	@ModelAttribute("registerForm")
	public RegisterForm getRegisterForm() {
		return new RegisterForm();
	}
}

