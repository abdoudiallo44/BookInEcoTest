package fr.dawan.projettest.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.dawan.projettest.DAO.UtilisateurDAO;
import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;

/*Nouvelle couche service :
 *protège la couche DAO et donc la BD des attaaques externes 
 *Fait le lien entre la couche métier et la couche DAO
 */
//permet de dire à spring que c'est une couche intérmediaire
//entre le DAO et les Objets métier
@Service
public class UtilisateurService extends GenericService {

	// Spring crée l'objet DAO et l'injecte dans la classe service
	@Autowired
	private UtilisateurDAO utilisateurDao;

	// Annotation très importante
	// permet de gérer les flux de connexions (ouverture, fermeture et rollback en
	// cas d'erreurs
	// sur la requête)
	public void addToCart(Utilisateur user, long livreId, boolean close) {
		utilisateurDao.addToCart(user, livreId, close);
	}

	public Utilisateur findUserByEmailAndPwd(String email, String pswd) {
		return utilisateurDao.findUserByEmailAndPwd(email, pswd);
	}

	public List<Livre> getPanier(long id, boolean b) {
		return utilisateurDao.getPanier(id, b);
	}
}
