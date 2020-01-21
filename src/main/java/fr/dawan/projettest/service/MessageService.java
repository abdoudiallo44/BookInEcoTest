package fr.dawan.projettest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projettest.DAO.MessageDAO;
import fr.dawan.projettest.entite.Commande;
import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Message;
import fr.dawan.projettest.entite.Utilisateur;

@Service
public class MessageService extends GenericService {

	// Spring crée l'objet DAO et l'injecte dans la classe service
	@Autowired
	private MessageDAO messageDao;
	
	public List<Message> FindMessageById(long utilisateurId){
		return messageDao.FindMessageById(utilisateurId);
	}

}