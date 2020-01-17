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

	public List<Livre> findByKey(String key, boolean close) {
		List<Livre> result = em.createQuery("From Livre l WHERE l.titre LIKE :titre")
				.setParameter("key", "%" + key + "%").getResultList();
		if (close)
			em.close();
		return result;
	}

	public List<Livre> findAllByUser(long userId, boolean close) {
		List<Livre> result = em.createQuery("From Livre WHERE proprietaire_id = :id").setParameter("id", userId)
				.getResultList();
		if (close)
			em.close();
		return result;
	}

	public List<Livre> findAllExceptUser(long userId, boolean close) {
		List<Livre> result = em.createQuery("From Livre WHERE NOT proprietaire_id = :id").setParameter("id", userId)
				.getResultList();
		if (close)
			em.close();
		return result;
	}

}
