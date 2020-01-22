package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.Message;

@Repository
public class MessageDAO extends GenericDAO {

	// faire comprendre à spring que j'utilise la Persistence de JPA
	// Objet Entity Manager avec les infos de connexion à la BD
	@PersistenceContext
	private EntityManager em;

	public List<Message> FindMessageById(long utilisateurId) {
		List<Message> result = em.createQuery("From Message WHERE destinataire_id = :id")
				.setParameter("id", utilisateurId).getResultList();
		return result;
	}

}
