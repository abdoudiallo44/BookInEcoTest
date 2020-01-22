package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.Commande;

@Repository
public class CommandeDAO extends GenericDAO<Commande>{

	@PersistenceContext
	private EntityManager em;
	
	public List<Commande> findByUser(long id,boolean close){
		 return em.createQuery("FROM Commande WHERE acheteur_id = :id").setParameter("id", id).getResultList();
	}

	public void trueDelete(long id,boolean close) {
		Query q = em.createNativeQuery("DELETE FROM commande WHERE id = :id").setParameter("id", id);
		q.executeUpdate();
		if(close) em.close();
	}

	public void acheter(long id, boolean close) {
		
		
	}
}
