package fr.dawan.projettest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.UtilisateurService;

public class UtilisateurTest {

	@Autowired
	UtilisateurService service;

	@Test
	public void insertTest() {

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPrenom("Abdoulaye");
		utilisateur.setNom("DIALLO");
		utilisateur.setEmail("a.diallo7@gmail.com");
		utilisateur.setPseudo("abdou44340");
		utilisateur.setMdp("abdou44340");

		assertNotNull(service);

		service.create(utilisateur);
		assertNotEquals(0, utilisateur.getId());
	}

}
