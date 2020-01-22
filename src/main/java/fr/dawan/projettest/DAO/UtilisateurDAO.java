package fr.dawan.projettest.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projettest.entite.AdresseLivraison;
import fr.dawan.projettest.entite.Commande;
import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;

//cette annotation permet de faire savoir à spring que cette classe est un composant de type DAO
@Repository
public class UtilisateurDAO extends GenericDAO {

	// faire comprendre à spring que j'utilise la Persistence de JPA
	// Objet Entity Manager avec les infos de connexion à la BD
	@PersistenceContext
	private EntityManager em;

//	public void addToCart(Utilisateur user, long livreId, boolean close) {
//		if (user.getId() > 0) {
//			Livre livre = (Livre) findById(Livre.class, livreId, close);
//			user.addToCart(livre);
//			// On met à jour la formation
//			em.merge(user);
//
//			if (close)
//				em.close();
//		}
//
//	}
//	public void addToCart(Utilisateur user, long livreId, boolean close) {
//	if (user.getId() > 0) {
//		Livre livre = (Livre) findById(Livre.class, livreId, false);
//		Commande commande = user.addToCart(livre);
//		// On met à jour la formation
//		if (commande.getId() > 0) {
//			Commande commandeDel = (Commande) findById(Commande.class, commande.getId(),false);
//			em.remove(commandeDel);
//			em.persist(user);
//		}else {
//			em.persist(commande);
//		}
//		if (close)
//			em.close();
//	}
//
//}

	public Utilisateur findUserByEmailAndPwd(String email, String mdp) {

		try {
			return (Utilisateur) em
					.createQuery("FROM Utilisateur u WHERE (u.email=:email OR u.pseudo=:pseudo) AND u.mdp=:pass")
					.setParameter("email", email).setParameter("pseudo", email).setParameter("pass", mdp)
					.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Utilisateur> readAll() {
		return em.createQuery("From Utilisateur").getResultList();
	}
	
	public Utilisateur findUserByEmailAndPwd(String email, String mdp) {
			
		try {
			return (Utilisateur) em.createQuery(
					"FROM Utilisateur u WHERE u.pseudo=:pseudo ")
					.setParameter("pseudo", pseudo)
					.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Commande> findCommandes(long id, boolean close) {
		return em.createQuery("FROM Commande WHERE acheteur_id = :id").setParameter("id", id).getResultList();
	}

	public void addLivre(Utilisateur util) {
		em.merge(util);
	}
	public void deleteUserAdresse(long idUtilisateur, long idAdresse) {
		
//		em.createQuery(
//				"DELETE FROM AdresseLivraison adr WHERE adr.utilisateur_id=:idUtilisateur AND adr.id=:id"
//				.setParameter("", )
//				.setParameter("", )
//				.getSingleResult();

	}
	
	public List<AdresseLivraison> findAllByUser(long userId, boolean close) {
		List<AdresseLivraison> result = em.createQuery("From AdresseLivraison WHERE utilisateur_id = :id").setParameter("id", userId)
				.getResultList();
		if (close)
			em.close();
		return result;
	}

	public Utilisateur findUserByEmailOrPseudo(String identifiant) {
			
		try {
			return (Utilisateur) em.createQuery(
					"FROM Utilisateur u WHERE (u.email=:email OR u.pseudo=:pseudo)")
					.setParameter("email", identifiant)
					.setParameter("pseudo", identifiant)
					.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * SELECT l.auteur,l.description,l.titre,l.proprietaire_id,l.photoLivre FROM
	 * commande c inner join commande_livre cl on c.id = cl.Commande_id inner join
	 * livre l on l.id = cl.livresCommande_id where c.panier_id = 1 select Livre
	 * from Commande inner join Commande. SELECT Livre FROM Commande join
	 * Commande.livresCommande where Commande.id = 1
	 */

	// on crée la requête
	// Query query = em.createQuery("FROM Livre join Livre.proprietaire where
	// Livre.id = 1");
}
