package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;

//cette annotation permet de faire savoir à spring que cette classe est un composant de type DAO
@Repository
public class UtilisateurDAO extends GenericDAO{

	// faire comprendre à spring que j'utilise la Persistence de JPA
	// Objet Entity Manager avec les infos de connexion à la BD
	@PersistenceContext
	private EntityManager em;

	public void addToCart(Utilisateur user, long livreId, boolean close) {
			if (user.getId() > 0) {
				Livre livre = (Livre) findById(Livre.class, livreId, close);
				user.addToCart(livre);
					// On met à jour la formation
					em.merge(user);

					if(close) em.close();
			}
		
	}
	
	public Utilisateur findUserByEmailAndPwd(String email, String mdp) {
		
		
		try {
			return (Utilisateur) em.createQuery(
					"FROM Utilisateur u WHERE (u.email=:email OR u.pseudo=:pseudo) AND u.mdp=:pass")
					.setParameter("email", email)
					.setParameter("pseudo", email)
					.setParameter("pass", mdp)
					.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Livre> getPanier(long id, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}
}
