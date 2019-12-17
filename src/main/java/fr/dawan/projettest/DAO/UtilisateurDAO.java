package fr.dawan.projettest.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;

//cette annotation permet de faire savoir à spring que cette classe est un composant de type DAO
@Repository
public class UtilisateurDAO extends GenericDAO<Utilisateur> {

	// faire comprendre à spring que j'utilise la Persistence de JPA
	// Objet Entity Manager avec les infos de connexion à la BD
	@PersistenceContext
	private EntityManager em;


	// recherhce d'un utilisateur par mot clé
	public List<Utilisateur> findByKey(String key) {
		return em.createQuery("From Utilisateur u WHERE u.auteur LIKE :key").setParameter("key", "%" + key + "%")
				.getResultList();
	}

	public Utilisateur findUserByEmailAndPwd(String email, String mdp) {
		
//		return (Utilisateur) em.createQuery(
//				"FROM Utilisateur u"
//				+ " WHERE u.email='" + email
//				+ "' AND u.mdp='" + mdp +"'").getSingleResult();
		
		return (Utilisateur) em.createQuery(
				"FROM Utilisateur u WHERE u.email=:email AND u.mdp=:pass")
				.setParameter("email", email)
				.setParameter("pass", mdp)
				.getSingleResult();
	}
}
