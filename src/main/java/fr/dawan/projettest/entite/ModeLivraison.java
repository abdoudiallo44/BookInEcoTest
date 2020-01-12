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
public class ModeLivraison {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idModeLivraison;

	private TypeLivraison typeLivraison;

	@OneToMany(mappedBy = "modeLivraison")
	private List<Commande> commande;

	public long getIdModeLivraison() {
		return idModeLivraison;
	}

	public void setIdModeLivraison(long idModeLivraison) {
		this.idModeLivraison = idModeLivraison;
	}

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

	public ModeLivraison(long idModeLivraison, TypeLivraison typeLivraison) {
		super();
		this.idModeLivraison = idModeLivraison;
		this.typeLivraison = typeLivraison;
	}

	public ModeLivraison() {
		super();
	}

	@Override
	public String toString() {
		return "ModeLivraison [idModeLivraison=" + idModeLivraison + ", typeLivraison=" + typeLivraison + ", commande="
				+ commande + "]";
	}

}
