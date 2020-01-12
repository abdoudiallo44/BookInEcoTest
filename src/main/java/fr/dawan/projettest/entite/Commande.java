package fr.dawan.projettest.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author adial
 *
 */
@Entity
@Table(name="commande")
public class Commande extends DbObject{
	
	private LocalDate dateCommande;
	
	private EtatCommande etat;
	
	@OneToOne
	private Utilisateur util;
	
	@OneToOne
	private ModeLivraison modeLivraison;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Livre> livresCommande = new ArrayList();
	
	public void addLivre(Livre livre) {
		livresCommande.add(livre);
	}
	
	public void removeLivre(Livre livre) {
		livresCommande.remove(livre);
	}
	
	public List<Livre> getlivresCommande(){
		return new ArrayList(livresCommande);
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

	public Utilisateur getUtil() {
		return util;
	}

	public void setUtil(Utilisateur util) {
		this.util = util;
	}

	public Commande() {
		super();
	}

	public Commande(LocalDate dateCommande, EtatCommande etat, Utilisateur util, ModeLivraison modeLivraison,
			List<Livre> livresCommande) {
		super();
		this.dateCommande = dateCommande;
		this.etat = etat;
		this.util = util;
		this.modeLivraison = modeLivraison;
		this.livresCommande = livresCommande;
	}

	@Override
	public String toString() {
		return "Commande [dateCommande=" + dateCommande + ", etat=" + etat + ", util=" + util + ", modeLivraison="
				+ modeLivraison + ", livresCommande=" + livresCommande + "]";
	}
	
}
