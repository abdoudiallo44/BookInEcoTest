package fr.dawan.projettest.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author adial
 *
 */
@Entity
@Table(name = "modeLivraison")
public class ModeLivraison extends DbObject {

	private TypeLivraison typeLivraison;

	@OneToMany(mappedBy = "modeLivraison")
	private List<Commande> commande;

	public TypeLivraison getTypeLivraison() {
		return typeLivraison;
	}

	public void setTypeLivraison(TypeLivraison typeLivraison) {
		this.typeLivraison = typeLivraison;
	}

	public List<Commande> getCommande() {
		return commande;
	}

	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}

	public ModeLivraison(TypeLivraison typeLivraison) {
		super();
		this.typeLivraison = typeLivraison;
	}

	public ModeLivraison() {
		super();
	}

	@Override
	public String toString() {
		return super.toString() + " ModeLivraison [typeLivraison=" + typeLivraison + ", commande=" + commande + "]";
	}

	

}
