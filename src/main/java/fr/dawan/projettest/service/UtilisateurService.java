package fr.dawan.projettest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projettest.DAO.UtilisateurDAO;
import fr.dawan.projettest.entite.Utilisateur;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurDAO utilisateurDAO;

	@Transactional
	public void create(Utilisateur utilisateur) {
		utilisateurDAO.create(utilisateur);
	}

	@Transactional
	public List<Utilisateur> readAll() {
		return utilisateurDAO.findAll(Utilisateur.class);
	}

	@Transactional
	public Utilisateur findUserByEmailAndPwd(String email, String pswd) {
		return utilisateurDAO.findUserByEmailAndPwd(email, pswd);
	}

}
