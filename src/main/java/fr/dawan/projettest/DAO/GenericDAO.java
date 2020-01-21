package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.DbObject;

@Repository
public class GenericDAO<T extends DbObject> {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(T entity, boolean close) {
		if (entity != null && entity.getId() == 0) {

			// On insère la formation dans la BDD
			entityManager.persist(entity);

			if (close)
				entityManager.close();
		}
	}

	public List<T> findAll(Class<T> clazz, boolean close) {
		List<T> resultat = null;

		// on crée la requête
		TypedQuery<T> query = entityManager.createQuery("SELECT entity FROM " + clazz.getName() + " entity", clazz);

		// on exécute la requête et on récupère le résultat
		resultat = query.getResultList();

		if (close)
			entityManager.close();

		return resultat;
	}

	public T findById(Class<T> clazz, long id, boolean close) {
		T entity = null;

		// On charge la formation depuis la BDD, selon son ID
		entity = entityManager.find(clazz, id);
		if (close)
			entityManager.close();

		return entity;
	}

	public void update(T entity, boolean close) {
		if (entity.getId() > 0) {

			// On met à jour la formation
			entityManager.merge(entity);

			if (close)
				entityManager.close();
		}
	}

	public void delete(Class<T> clazz, long id, boolean close) {

		T entity = entityManager.find(clazz, id);
		
		entityManager.remove(entity);

		if (close)
			entityManager.close();

	}

	/**
	 * Permet de récupérer toutes les entrées pour une table données à partir d'une
	 * entrée, pour un nombre de résultat donné
	 * 
	 * @param clazz    : le type que l'on souhaite récupérer
	 * @param begin    : l'index du prentityManagerier résultat
	 * @param nbResult : le nombre de résultat que l'on souhaite récupérer
	 * @return une liste d'entrées paginée
	 */
	public List<T> findAll(Class<T> clazz, int begin, int nbResult, boolean close) {
		List<T> resultat = null;

		// on crée la requête
		TypedQuery<T> query = entityManager.createQuery("SELECT entity FROM " + clazz.getName() + " entity", clazz);

		// on paramètre et on exécute la requête, et on récupère le résultat
		resultat = query.setFirstResult(begin) // On commence à ce numéro (begin) - au Nième résultat
				.setMaxResults(nbResult) // on charge nbResult résultats
				.getResultList();

		if (close)
			entityManager.close();

		return resultat;
	}

	public void deleteAll(Class<T> clazz, boolean close) {

		Query query = entityManager.createQuery("Delete FROM " + clazz.getName());
		query.executeUpdate();

		if (close)
			entityManager.close();
	}

}
