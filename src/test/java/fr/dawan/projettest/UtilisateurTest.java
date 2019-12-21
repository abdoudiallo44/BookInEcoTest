package fr.dawan.projettest;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;
import fr.dawan.projettest.service.LivreService;
import fr.dawan.projettest.service.UtilisateurService;

public class UtilisateurTest {
	
	@Autowired
	UtilisateurService service;

	@Autowired
	LivreService livreService;

	@Test
	public void insertTest() {

		Utilisateur utilisateur1 = new Utilisateur("Abdoulaye", "DIALLO", LocalDate.now(), "a.diallo7@hotmail", "abdou", "abdou44");
		service.create(utilisateur1, false);
		Livre livre1 = new Livre("auteur1", "titre1", "description 1",utilisateur1);
		assertNotNull(livre1);
		livreService.create(livre1, false);
		Livre livre2 = new Livre("auteur2", "titre2", "description 2", utilisateur1);
		livreService.create(livre2, false);
		Livre livre3 = new Livre("auteur3", "titre3", "description 3", utilisateur1);
		livreService.create(livre3, false);
		Livre livre4 = new Livre("auteur1", "titre4", "description 4", utilisateur1);
		livreService.create(livre4, false);
		Livre livre5 = new Livre("auteur1", "titre5", "description 5",  utilisateur1);
		livreService.create(livre5, false);
	}

}
