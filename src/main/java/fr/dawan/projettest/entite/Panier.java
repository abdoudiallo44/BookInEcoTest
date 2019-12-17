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
public class Panier extends DbObject {
	
	@OneToOne
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "panier")
	private List<Commande> commande;

	public Panier() {
		super();
	}
	
	

}
