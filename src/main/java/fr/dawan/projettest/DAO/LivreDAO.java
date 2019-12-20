package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import fr.dawan.projettest.entite.Livre;

//cette annotation permet de faire savoir à spring que cette classe est un composant de type DAO
@Repository
public class LivreDAO extends GenericDAO<Livre>{
	
	@PersistenceContext
	private EntityManager em;

	public List<Livre> findByKey(String titre, boolean fermerEntityManager) {

		List<Livre> liste = (List<Livre>) em.createQuery("From Utilisateur l WHERE l.titre LIKE :key")
				.setParameter("key", "%" + titre + "%");

		if (fermerEntityManager) {
			em.close();
		}

		return liste;

	}
}
