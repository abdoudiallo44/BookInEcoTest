package fr.dawan.projettest.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import fr.dawan.projettest.entite.Utilisateur;

//cette annotation permet de faire savoir à spring que cette classe est un composant de type DAO
@Repository
public class UtilisateurDAO extends GenericDAO<Utilisateur> {

	// faire comprendre à spring que j'utilise la Persistence de JPA
	// Objet Entity Manager avec les infos de connexion à la BD
	@PersistenceContext
	private EntityManager em;


	// recherhce d'un utilisateur par som nom
	public List<Utilisateur> findByName(String key) {
		return em.createQuery("From Utilisateur u WHERE u.nom LIKE :key").setParameter("key", "%" + key + "%")
				.getResultList();
	}

	public Utilisateur findUserByEmailAndPwd(String email, String mdp) {
		
//		return (Utilisateur) em.createQuery(
//				"FROM Utilisateur u"
//				+ " WHERE u.email='" + email
//				+ "' AND u.mdp='" + mdp +"'").getSingleResult();
		
		try {
			return (Utilisateur) em.createQuery(
					"FROM Utilisateur u WHERE (u.email=:email OR u.pseudo=:email) AND u.mdp=:pass")
					.setParameter("email", email)
					.setParameter("email", email)
					.setParameter("pass", mdp)
					.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
