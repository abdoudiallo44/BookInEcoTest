package fr.dawan.projettest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.RegisterService;

@Controller
public class UtilisateurTest {
	@Autowired
	private RegisterService service;

	@Test
	public void insertUserTest() {
		Utilisateur user = new Utilisateur();
		user.setEmail("samson@yahoo.fr");
		user.setMdp("samson");
		user.setPseudo("samson");
		
		service.create(user, true);
	}

}
