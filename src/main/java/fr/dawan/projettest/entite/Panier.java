package fr.dawan.projettest.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="panier")
public class Panier {

	// Les attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPanier;
	
	@OneToOne
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "panier")
	private List<Commande> commande;

	public long getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(long idPanier) {
		this.idPanier = idPanier;
	}

	public Panier(long idPanier) {
		super();
		this.idPanier = idPanier;
	}

	public Panier() {
		super();
	}
	
	
	

}
