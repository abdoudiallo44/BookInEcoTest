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
	
	public RegisterForm(@NotEmpty(message = "Ce champs ne doit pas être vide") String email,
						@NotEmpty(message = "Ce champs ne doit pas être vide") String pseudo,
						@NotEmpty(message = "Ce champs ne doit pas être vide") String mdp) {
		super();
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
