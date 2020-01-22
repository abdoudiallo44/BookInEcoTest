package fr.dawan.projettest.Beans;

import java.time.LocalDate;

import fr.dawan.projettest.entite.AdresseLivraison;
import fr.dawan.projettest.entite.DbObject;

public class ProfilForm extends DbObject {

	private String nom;
	
	private String prenom;
	
	private String pseudo;
	
	private String mdp;
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	private LocalDate dateDenaissance;
	
	private int nombreDePoint;

	public int getNombreDePoint() {
		return nombreDePoint;
	}

	public void setNombreDePoint(int nombreDePoint) {
		this.nombreDePoint = nombreDePoint;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateDenaissance() {
		return dateDenaissance;
	}

	public void setDateDenaissance(LocalDate dateDenaissance) {
		this.dateDenaissance = dateDenaissance;
	}

	public ProfilForm(String nom, String prenom, String pseudo, String mdp, LocalDate dateDenaissance,
			int nombreDePoint) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.dateDenaissance = dateDenaissance;
		this.nombreDePoint = nombreDePoint;
	}

	public ProfilForm() {
		super();
	}

	@Override
	public String toString() {
		return "ProfilForm [nom=" + nom + ", prenom=" + prenom + ", dateDenaissance=" + dateDenaissance
				+ ", nombreDePoint=" + nombreDePoint + "]";
	}
	
}