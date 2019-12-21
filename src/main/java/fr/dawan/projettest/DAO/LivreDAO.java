package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;

//cette annotation permet de faire savoir à spring que cette classe est un composant de type DAO
@Repository
public class LivreDAO extends GenericDAO<Livre>{
	
	@PersistenceContext
	private EntityManager em;

	public List<Livre> findByKey(Class<Livre> clazz, String titre, boolean fermerEntityManager) {
		List<Livre> liste = null;

		//TypedQuery<Livre> query = (em.createQuery("SELECT l FROM Utilisateur l WHERE l.titre LIKE :titre")
		//		.setParameter("titre", "%" + titre + "%");
		
		TypedQuery<Livre> query = em.createQuery("SELECT l FROM " + clazz.getName() + " l WHERE l.titre LIKE :titre", clazz)
				.setParameter("titre", "%" + titre + "%");
		
		liste = query.getResultList();

		if (fermerEntityManager) {
			em.close();
		}

		return liste;

	}
}
