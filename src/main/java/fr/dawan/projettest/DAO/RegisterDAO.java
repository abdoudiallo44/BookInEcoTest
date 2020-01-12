package fr.dawan.projettest.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.Utilisateur;

@Repository
public class RegisterDAO extends GenericDAO {

	// faire comprendre à spring que j'utilise la Persistence de JPA
	// Objet Entity Manager avec les infos de connexion à la BD
	@PersistenceContext
	private EntityManager em;
	
	public Utilisateur findUserByEmailAndPseudo(String email, String pseudo) {
		
		try {
			return (Utilisateur) em.createQuery(
					"FROM Utilisateur u WHERE u.email=:email OR u.pseudo=:pseudo")
					.setParameter("email", email)
					.setParameter("pseudo", pseudo)
					.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
