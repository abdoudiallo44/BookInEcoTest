package fr.dawan.projettest.Beans;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

import fr.dawan.projettest.entite.DbObject;

public class RegisterForm extends DbObject{

	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String email;
	
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String pseudo;
	
	@NotEmpty(message = "Ce champs ne doit pas être vide")
	private String mdp;
	
	@ConfirmPassword(message = "Veuillez renseigner des mots de passe identiques !")
//	@NotEmpty(message = "Ce champs ne doit pas être vide")
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
	public RegisterForm(@NotEmpty(message = "Ce champs ne doit pas être vide") String email,
						@NotEmpty(message = "Ce champs ne doit pas être vide") String pseudo,
						@NotEmpty(message = "Ce champs ne doit pas être vide") String mdp,
						@ConfirmPassword(message = "Veuillez renseigner des mots de passe identiques !") String mdp2) {
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
		return "RegisterForm [email=" + email + ", pseudo=" + pseudo + ", mdp=" + mdp + "]";
	}
	
	public static String confirm(String mdp, String mdp2) {
		RegisterForm test = new RegisterForm();
		test.setMdp(mdp);
		test.setMdp2(mdp2);
		
		if(test.getMdp() != test.getMdp2()) {
			return "Veuillez renseigner des mots de passe identiques !";
		}
		
		return "";
		}
	
	
	
}
