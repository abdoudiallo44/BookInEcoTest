package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;

//cette annotation permet de faire savoir à spring que cette classe est un composant de type DAO
@Repository
public class UtilisateurDAO {

	// faire comprendre à spring que j'utilise la Persistence de JPA
	// Objet Entity Manager avec les infos de connexion à la BD
	@PersistenceContext
	private EntityManager em;

	// ajout d'un utilisateur
	public  void create(Utilisateur utilisateur) {
		em.persist(utilisateur);
	}

	// liste des utilisateurs
	public List<Utilisateur> readAll() {
		return em.createQuery("From Utilisateur").getResultList();
	}

	// suppression d'un utilisateur
	public void delete(Utilisateur utilisateur) {
		em.remove(utilisateur);
	}

	// mise à jour d'un utilisateur
	public void update(Utilisateur utilisateur) {
		em.merge(utilisateur);
	}

	// recherhce d'un utilisateur par mot clé
	public List<Utilisateur> findByKey(String key) {
		return em.createQuery("From Utilisateur WHERE description LIKE :key").setParameter("key", "%" + key + "%")
				.getResultList();
	}

	// recherche d'un livre par ID
	public Utilisateur findById(long id) {
		return (Utilisateur) em.createQuery("From Utilisateur WHERE id= :id").setParameter("idLivre", id).getSingleResult();
	}
}
