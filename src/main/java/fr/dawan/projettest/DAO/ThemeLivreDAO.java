package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.ThemeLivre;

public class ThemeLivreDAO {

	// faire comprendre à spring que j'utilise la Persistence de JPA
	// Objet Entity Manager avec les infos de connexion à la BD
	@PersistenceContext
	private EntityManager th;

	// ajout d'un thème
	public void create(ThemeLivre theme) {
		th.persist(theme);
	}

	// liste des thèmes de livre
	public List<ThemeLivre> readAll() {
		return th.createQuery("From ThemeLivre").getResultList();
	}

	// suppression d'un theme de livre
	public void delete(ThemeLivre theme) {
		th.remove(theme);
	}

	// mise à jour d'un theme de livre
	public void update(ThemeLivre theme) {
		th.merge(theme);
	}

	// recherhce d'un theme par mot clé
	public List<Livre> findByKey(String key) {
		return th.createQuery("From ThemeLivre WHERE description LIKE :key").setParameter("key", "%" + key + "%")
				.getResultList();
	}

	// recherche d'un theme par ID
	public Livre findById(long id) {
		return (Livre) th.createQuery("From ThemeLivre WHERE id= :id").setParameter("id", id).getSingleResult();
	}
}
