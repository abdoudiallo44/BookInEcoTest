package fr.dawan.projettest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.LivreService;

public class UtilisateurTest {

	@Autowired
	LivreService service;

	@Test
	public void insertTest() {

//		Utilisateur utilisateur = new Utilisateur();
//		utilisateur.setPrenom("Abdoulaye");
//		utilisateur.setNom("DIALLO");
//		utilisateur.setEmail("a.diallo7@gmail.com");
//		utilisateur.setPseudo("abdou44340");
//		utilisateur.setMdp("abdou44340");
//
//		Livre livre5 = new Livre("auteur1", "titre5", "description 5", utilisateur);
//		new LivreService().create(livre5);
//
//		assertNotEquals(0, livre5.getIdLivre());
	}

}
