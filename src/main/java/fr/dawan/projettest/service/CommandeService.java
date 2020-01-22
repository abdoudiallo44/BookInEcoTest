package fr.dawan.projettest.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.projettest.DAO.CommandeDAO;
import fr.dawan.projettest.DAO.LivreDAO;
import fr.dawan.projettest.DAO.UtilisateurDAO;
import fr.dawan.projettest.entite.Commande;
import fr.dawan.projettest.entite.EtatCommande;
import fr.dawan.projettest.entite.Livre;
import fr.dawan.projettest.entite.Utilisateur;

@Service
@Transactional
public class CommandeService extends GenericService<Commande>{
	
	@Autowired
	private CommandeDAO dao;
	
	@Autowired
	private LivreDAO livreDao;
	
	@Autowired
	private UtilisateurDAO utilDao;
	

	public void createCommande(Utilisateur user, Livre l, boolean close) {
		LocalDate date = LocalDate.now();
		Commande c = new Commande();
		c.setAcheteur(user);
		c.setLivre(l);
		c.setVendeur(l.getProprietaire());
		c.setDateCommande(date);
		create(c, close);
	}
	
	public void trueDelete(long id ,boolean close) {
		dao.trueDelete(id,close);
	}

	public void acheter(long id,boolean close) {
		Commande c = findById(Commande.class, id, false);
		Utilisateur acheteur = c.getAcheteur();
		Utilisateur vendeur = c.getVendeur();
		Livre l = c.getLivre();
		if(acheteur.debit(l.getValeurPoints())) {
			vendeur.credit(l.getValeurPoints());
			l.setDisponibilite(false);
			c.setEtat(EtatCommande.EN_COURS_DE_LIVRAISON);
			utilDao.update(acheteur, false);
			utilDao.update(vendeur, true);
			livreDao.update(l, false);
			dao.update(c, close);
		}
		
	}

}
