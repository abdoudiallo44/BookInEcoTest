package fr.dawan.projettest.Beans;

import java.time.LocalDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import fr.dawan.projettest.entite.DbObject;

public class RegisterForm extends DbObject{
	
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String prenom;
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String nom;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDenaissance;
	
	@Email
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String email;
	
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String pseudo;
	
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String mdp;
	
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String mdp2;
	
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public LocalDate getDateDenaissance() {
		return dateDenaissance;
	}
	public void setDateDenaissance(LocalDate dateDenaissance) {
		this.dateDenaissance = dateDenaissance;
	}
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
	
	
	
	public String getMdp2() {
		return mdp2;
	}
	public void setMdp2(String mdp2) {
		this.mdp2 = mdp2;
	}
	
	
	public RegisterForm(@NotEmpty(message = "Ce champs ne doit pas être vide") String prenom,
			@NotEmpty(message = "Ce champs ne doit pas être vide") String nom,
			@Email @NotEmpty(message = "Ce champs ne doit pas être vide") String email,
			@NotEmpty(message = "Ce champs ne doit pas être vide") String pseudo,
			@NotEmpty(message = "Ce champs ne doit pas être vide") String mdp,
			@NotEmpty(message = "Ce champs ne doit pas être vide") String mdp2) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.mdp2 = mdp2;
	}
	
	public RegisterForm(@NotEmpty(message = "Ce champs ne doit pas être vide") String prenom,
			@NotEmpty(message = "Ce champs ne doit pas être vide") String nom,
			@Email @NotEmpty(message = "Ce champs ne doit pas être vide") String email,
			@NotEmpty(message = "Ce champs ne doit pas être vide") String pseudo,
			@NotEmpty(message = "Ce champs ne doit pas être vide") String mdp) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.pseudo = pseudo;
		this.mdp = mdp;
	}
	
	public RegisterForm() {
		super();
	}
	
	@Override
	public String toString() {
		return "RegisterForm [email=" + email + ", pseudo=" + pseudo + ", mdp=" + mdp + "]";
	}
	
	
	
}
