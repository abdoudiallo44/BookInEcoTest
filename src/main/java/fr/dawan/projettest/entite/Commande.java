package fr.dawan.projettest.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Commande extends DbObject{
	
	private LocalDate dateCommande;
	
	private EtatCommande etat;
	
	@ManyToOne
	private Utilisateur acheteur;
	
	@ManyToOne
	private Utilisateur vendeur;
	
	@OneToOne
	private ModeLivraison modeLivraison;
	
	@ManyToOne
	private Livre livre;
	
	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public LocalDate getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}

	public EtatCommande getEtat() {
		return etat;
	}

	public void setEtat(EtatCommande etat) {
		this.etat = etat;
	}


	public ModeLivraison getModeLivraison() {
		return modeLivraison;
	}

	public void setModeLivraison(ModeLivraison modeLivraison) {
		this.modeLivraison = modeLivraison;
	}
	
	@Override
	public String toString() {
		return "Commande [dateCommande=" + dateCommande + ", etat=" + etat + "]";
	}

	public Commande(LocalDate dateCommande, EtatCommande etat, Utilisateur acheteur, Utilisateur vendeur,
			ModeLivraison modeLivraison) {
		super();
		this.dateCommande = dateCommande;
		this.etat = etat;
		this.acheteur = acheteur;
		this.vendeur = vendeur;
		this.modeLivraison = modeLivraison;
	}

	public Commande() {
		super();
	}

	public Utilisateur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	public Utilisateur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	
}
