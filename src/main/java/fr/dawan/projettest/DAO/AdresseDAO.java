package fr.dawan.projettest.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import fr.dawan.projettest.entite.AdresseLivraison;

@Repository
public class AdresseDAO extends GenericDAO<AdresseLivraison> {
	
	@PersistenceContext
	private EntityManager em;

	public void deleteAdresseById(long id) {
		Query q = em.createNativeQuery("DELETE FROM adresselivraison WHERE id = :id").setParameter("id", id);
		q.executeUpdate();
	}
}
