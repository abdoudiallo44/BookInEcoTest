package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.DbObject;

@Repository
public abstract class GenericDAO<T extends DbObject>  {

	@PersistenceContext
	private EntityManager em;

	public void create(T entity) {
		if (entity != null && entity.getId() == 0) {
			em.persist(entity);
		}
	}

	public T findById(Class<T> clazz, long id) {

		T entity = em.find(clazz, id);
		return entity;
	}

	public void update(T entity) {
		if (entity.getId() > 0) {
			// On met à jour la formation
			em.merge(entity);
		}
	}

	public void deleteById(Class<T> clazz, long id) {
		T entity = em.find(clazz, id);
		em.remove(entity);
	}

	public List<T> findAll(Class<T> clazz) {
		List<T> resultat = null;

		// on crée la requête
		TypedQuery<T> query = em.createQuery("SELECT entity FROM " + clazz.getName() + " entity", clazz);

		// on exécute la requête et on récupère le résultat
		resultat = query.getResultList();

		return resultat;
	}

	/**
	 * Permet de récupérer toutes les entrées pour une table données à partir d'une
	 * entrée, pour un nombre de résultat donné
	 * 
	 * @param clazz    : le type que l'on souhaite récupérer
	 * @param begin    : l'index du premier résultat
	 * @param nbResult : le nombre de résultat que l'on souhaite récupérer
	 * @return une liste d'entrées paginée
	 */
	public List<T> findAll(Class<T> clazz, int begin, int nbResult) {
		List<T> resultat = null;

		// on crée la requête
		TypedQuery<T> query = em.createQuery("SELECT entity FROM " + clazz.getName() + " entity", clazz);

		// on paramètre et on exécute la requête, et on récupère le résultat
		resultat = query.setFirstResult(begin) // On commence à ce numéro (begin) - au Nième résultat
				.setMaxResults(nbResult) // on charge nbResult résultats
				.getResultList();
		
		return resultat;
	}

	public <T extends DbObject> void deleteAll(Class<T> clazz) {

		Query query = em.createQuery("Delete FROM " + clazz.getName());
		query.executeUpdate();
	}

}
