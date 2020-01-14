package fr.dawan.projettest.Beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import fr.dawan.projettest.entite.DbObject;

public class RegisterForm extends DbObject{
	
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String email;
	
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String pseudo;
	
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String nom;
	
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String prenom;
	
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String mdp;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	
	
	public RegisterForm(@NotEmpty(message = "Ce champs ne doit pas être vide") String email,
						@NotEmpty(message = "Ce champs ne doit pas être vide") String pseudo,
						@NotEmpty(message = "Ce champs ne doit pas être vide") String mdp,
						@NotEmpty(message = "Ce champs ne doit pas être vide") String nom,
						@NotEmpty(message = "Ce champs ne doit pas être vide") String prenom) {
		super();
		this.email = email;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public RegisterForm() {
		super();
	}
	
	@Override
	public String toString() {
		return "RegisterForm [email=" + email + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom + ", mdp="
				+ mdp + "]";
	}
	
	
	
	
	
}
