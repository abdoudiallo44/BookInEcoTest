package fr.dawan.projettest.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {

		return "login";
	}
	
	@GetMapping("/inscription")
	public String inscription() {
		
		return "inscription";
	}

	
	@PostMapping("/login/authentification")
	public String authentification(Model model, @RequestParam("login") String login, @RequestParam("pass") String pass,
			HttpSession session) {

		if (login.equals("admin") && pass.equals("admin")) {
			session.setAttribute("login", login);
			return "welcome";
		} else {
			model.addAttribute("msg", "Erreur d'authentification!!!");
			return "login";
		}

	}
	
	
	
	@GetMapping("/login/deconnexion")
	public String logout(HttpSession session, SessionStatus status) {

		// status.setComplete();
		session.invalidate();

		return "home";
	}
	
}
