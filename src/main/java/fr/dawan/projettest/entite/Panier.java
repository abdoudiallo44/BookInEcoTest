package fr.dawan.projettest.entite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="panier")
public class Panier extends DbObject{
	
	@OneToOne
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "panier",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Commande> commandes = new ArrayList();
	
	public void addCommande(Commande commande) {
		commandes.add(commande);
	}
	
	public void removeCommande(Commande commande) {
		commandes.remove(commande);
	}
	
	public List<Commande> getCommandes(){
		return new ArrayList(commandes);
	}

	public Panier() {
		super();
	}
	
	
	

}
