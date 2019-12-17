package fr.dawan.projettest.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.dawan.projettest.DAO.UtilisateurDAO;
import fr.dawan.projettest.entite.Utilisateur;

/*Nouvelle couche service :
 *protège la couche DAO et donc la BD des attaaques externes 
 *Fait le lien entre la couche métier et la couche DAO
 */
//permet de dire à spring que c'est une couche intérmediaire
//entre le DAO et les Objets métier
@Service
public class UtilisateurService {

	// Spring crée l'objet DAO et l'injecte dans la classe service
	@Autowired
	private UtilisateurDAO utilisateurDao;
	
	//Annotation très importante
	//permet de gérer les flux de connexions (ouverture, fermeture et rollback en cas d'erreurs 
	//sur la requête)
	@Transactional
	public void create(Utilisateur utilisateur) {
		utilisateurDao.create(utilisateur);
	}
	
	@Transactional
	public List<Utilisateur> readAll(){
		return utilisateurDao.readAll();
	}
	
	@Transactional
	public void delete(Utilisateur utilisateur) {
		utilisateurDao.delete(utilisateur);
	}
	
	@Transactional
	public void update(Utilisateur utilisateur) {
		utilisateurDao.update(utilisateur);
	}
	
	@Transactional
	public List<Utilisateur> findByKey(String key){
		return utilisateurDao.findByKey(key);
	}
	
	@Transactional
	public Utilisateur findById(long id) {
		return utilisateurDao.findById(id);
	}
	
	@Transactional
	public void deleteById(long id) {
		Utilisateur p = utilisateurDao.findById(id);
		utilisateurDao.delete(p);
	}
	
}
