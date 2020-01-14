package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.Commande;

@Repository
public class CommandeDAO extends GenericDAO{

	@PersistenceContext
	private EntityManager em;
	
	public List<Commande> findByUser(long id,boolean close){
		 return em.createQuery("FROM Commande WHERE util_id = :id").setParameter("id", id).getResultList();
	}
}
