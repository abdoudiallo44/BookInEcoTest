package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.Livre;

//cette annotation permet de faire savoir à spring que cette classe est un composant de type DAO
@Repository
public class LivreDAO {

	// faire comprendre à spring que j'utilise la Persistence de JPA
	// Objet Entity Manager avec les infos de connexion à la BD
	@PersistenceContext
	private EntityManager em;

	// ajout d'un livre
	public void create(Livre livre) {
		em.persist(livre);
	}

	// liste des livres
	public List<Livre> readAll() {
		return em.createQuery("From Livre").getResultList();
	}

	// suppression d'un livre
	public void delete(Livre livre) {
		em.remove(livre);
	}

	// mise à jour d'un livre
	public void update(Livre livre) {
		em.merge(livre);
	}

	// recherhce d'un livre par mot clé

	public List<Livre> findByKey(String key) {
		return em.createQuery("From Livre WHERE description LIKE :key").setParameter("key", "%" + key + "%")
				.getResultList();
	}

	// recherche d'un produit par ID
	public Livre findById(long id) {
		return (Livre) em.createQuery("From Livre WHERE id= :id").setParameter("id", id).getSingleResult();
	}
}
