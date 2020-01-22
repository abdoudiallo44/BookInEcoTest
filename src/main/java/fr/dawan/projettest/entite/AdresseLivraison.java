package fr.dawan.projettest.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author adial
 *
 */
@Entity
@Table(name="adresseLivraison")
public class AdresseLivraison extends DbObject {
	
	private String numEtRueAdresse;
	
	private int codePostal;
	
	private String ville;
	
	private String pays;
	
	@OneToOne
	private Utilisateur utilisateur;

	public String getNumEtRueAdresse() {
		return numEtRueAdresse;
	}

	public void setNumEtRueAdresse(String numEtRueAdresse) {
		this.numEtRueAdresse = numEtRueAdresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public AdresseLivraison(String numEtRueAdresse, int codePostal, String ville, String pays,
			Utilisateur utilisateur) {
		super();
		this.numEtRueAdresse = numEtRueAdresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.utilisateur = utilisateur;
	}

	public AdresseLivraison() {
		super();
	}

	@Override
	public String toString() {
		return "AdresseLivraison [numEtRueAdresse=" + numEtRueAdresse + ", codePostal=" + codePostal + ", ville="
				+ ville + ", pays=" + pays + ", utilisateur=" + utilisateur + "]";
	}
	
}
