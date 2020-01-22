package fr.dawan.projettest.Beans;

import fr.dawan.projettest.entite.DbObject;

public class AdresseForm extends DbObject {

	private String numEtRueAdresse;

	private int codePostal;

	private String ville;

	private String pays;

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

	public AdresseForm(String numEtRueAdresse, int codePostal, String ville, String pays) {
		super();
		this.numEtRueAdresse = numEtRueAdresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	public AdresseForm() {
		super();
	}
	
	
}
