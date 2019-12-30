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
@Transactional
public class LivreService  extends GenericService<Livre>{

	// Spring crée l'objet DAO et l'injecte dans la classe service
	@Autowired
	private LivreDAO livreDao;

	public List<Livre> findByKey(String key,boolean close){
		return livreDao.findByKey(key,close);
	}

	
}
