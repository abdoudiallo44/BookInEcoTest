package fr.dawan.projettest.Beans;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

import fr.dawan.projettest.entite.DbObject;

public class RegisterForm extends DbObject{

	@NotEmpty(message = "Ce champ ne doit pas être vide")
	private String email;
	
	@NotEmpty(message = "Ce champ ne doit pas être vide")
	private String pseudo;
	
	@NotEmpty(message = "Ce champ ne doit pas être vide")
	private String mdp;
	
	@NotEmpty(message = "Ce champ ne doit pas être vide")
	private String mdp2;
	
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
	public RegisterForm(@NotEmpty(message = "Ce champ ne doit pas être vide") String email,
						@NotEmpty(message = "Ce champ ne doit pas être vide") String pseudo,
						@NotEmpty(message = "Ce champ ne doit pas être vide") String mdp,
						@NotEmpty(message = "Ce champ ne doit pas être vide") String mdp2) {
		super();
		this.email = email;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.mdp2 = mdp2;
	}
	
	public RegisterForm() {
		super();
	}
	
	@Override
	public String toString() {
		return "RegisterForm [email=" + email + ", pseudo=" + pseudo + ", mdp=" + mdp + ", mdp2=" + mdp2 + "]";
	}
		
}
