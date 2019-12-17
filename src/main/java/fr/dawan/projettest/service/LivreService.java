package fr.dawan.projettest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projettest.DAO.LivreDAO;
import fr.dawan.projettest.entite.Livre;

/*Nouvelle couche service :
 *protège la couche DAO et donc la BD des attaaques externes 
 *Fait le lien entre la couche métier et la couche DAO
 */
//permet de dire à spring que c'est une couche intérmediaire
//entre le DAO et les Objets métier
@Service
public class LivreService {

	// Spring crée l'objet DAO et l'injecte dans la classe service
	@Autowired
	private LivreDAO livreDao;
	
	//Annotation très importante
	//permet de gérer les flux de connexions (ouverture, fermeture et rollback en cas d'erreurs 
	//sur la requête)
	@Transactional
	public void create(Livre livre) {
		livreDao.create(livre);
	}
	
	@Transactional
	public List<Livre> readAll(){
		return livreDao.findAll(Livre.class);
	}
//	
//	@Transactional
//	public void delete(Livre livre) {
//		livreDao.delete(livre);
//	}
	
	@Transactional
	public void update(Livre livre) {
		livreDao.update(livre);
	}
	
	@Transactional
	public List<Livre> findByKey(String key){
		return livreDao.findByKey(key);
	}
	
	@Transactional
	public Livre findById(long id) {
		return livreDao.findById(Livre.class, id);
	}
	
	@Transactional
	public void deleteById(long id) {
		livreDao.deleteById(Livre.class, id);
	}
	
}
