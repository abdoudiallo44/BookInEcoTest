package fr.dawan.projettest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projettest.DAO.RegisterDAO;
import fr.dawan.projettest.DAO.UtilisateurDAO;
import fr.dawan.projettest.entite.Utilisateur;

@Service
public class RegisterService extends GenericService {

	// Spring crée l'objet DAO et l'injecte dans la classe service
	@Autowired
	private RegisterDAO registerDao; 
	
	public Utilisateur findUserByEmailAndPseudo(String email, String pseudo) {
		return registerDao.findUserByEmailAndPseudo(email, pseudo);
	}
	
	
}
