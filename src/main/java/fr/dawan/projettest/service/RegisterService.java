package fr.dawan.projettest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projettest.DAO.RegisterDAO;
import fr.dawan.projettest.DAO.UtilisateurDAO;
import fr.dawan.projettest.entite.Utilisateur;

@Service
@Transactional
public class RegisterService extends GenericService<Utilisateur> {

	// Spring crée l'objet DAO et l'injecte dans la classe service
	@Autowired
	private RegisterDAO registerDao; 
	
	public Utilisateur findUserByEmailAndPseudo(String email, String pseudo) {
		return registerDao.findUserByEmailAndPseudo(email, pseudo);
	}
	
	public Utilisateur findUserByEmail(String email) {
		return registerDao.findUserByEmail(email);
	}
	
	public Utilisateur findUserByPseudo(String pseudo) {
		return registerDao.findUserByPseudo(pseudo);
	}
	
}
