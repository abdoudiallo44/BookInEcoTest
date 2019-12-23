package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.Livre;

//cette annotation permet de faire savoir à spring que cette classe est un composant de type DAO
@Repository
public class LivreDAO extends GenericDAO<Livre> {

	// faire comprendre à spring que j'utilise la Persistence de JPA
	// Objet Entity Manager avec les infos de connexion à la BD
	@PersistenceContext
	private EntityManager em;

	public List<Livre> findByKey(String key) {
		return em.createQuery("From Livre WHERE auteur LIKE :key").setParameter("key", "%" + key + "%")
				.getResultList();
	}

}