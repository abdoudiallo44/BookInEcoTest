package fr.dawan.projettest.Beans;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;


public class LivreForm {
	
	private long idLivre;
	
	@NotEmpty(message="ce champs ne doit pas être vide")
	private String auteur;
	
	@NotEmpty(message="ce champs ne doit pas être vide")
	private String titre;
	
	@NotEmpty(message="ce champs ne doit pas être vide")
	private String description;
	
	private String photoLivre;
	
	@NotEmpty(message="ce champs ne doit pas être vide")
	private double poidsLivre;
	
	@NotEmpty(message="ce champs ne doit pas être vide")
	private String formatLivre;
	
	
	private LocalDateTime dateAjoutLivre;
	
	
	private boolean disponibilite;


	public LivreForm(long idLivre, String auteur, String titre, String description, String photoLivre,
			double poidsLivre, String formatLivre, LocalDateTime dateAjoutLivre, boolean disponibilite) {
		super();
		this.idLivre = idLivre;
		this.auteur = auteur;
		this.titre = titre;
		this.description = description;
		this.photoLivre = photoLivre;
		this.poidsLivre = poidsLivre;
		this.formatLivre = formatLivre;
		this.dateAjoutLivre = dateAjoutLivre;
		this.disponibilite = disponibilite;
	}


	public LivreForm() {
		super();
	}


	public long getIdLivre() {
		return idLivre;
	}


	public void setIdLivre(long idLivre) {
		this.idLivre = idLivre;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPhotoLivre() {
		return photoLivre;
	}


	public void setPhotoLivre(String photoLivre) {
		this.photoLivre = photoLivre;
	}


	public double getPoidsLivre() {
		return poidsLivre;
	}


	public void setPoidsLivre(double poidsLivre) {
		this.poidsLivre = poidsLivre;
	}


	public String getFormatLivre() {
		return formatLivre;
	}


	public void setFormatLivre(String formatLivre) {
		this.formatLivre = formatLivre;
	}


	public LocalDateTime getDateAjoutLivre() {
		return dateAjoutLivre;
	}


	public void setDateAjoutLivre(LocalDateTime dateAjoutLivre) {
		this.dateAjoutLivre = dateAjoutLivre;
	}


	public boolean isDisponibilite() {
		return disponibilite;
	}


	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}


	@Override
	public String toString() {
		return "LivreForm [idLivre=" + idLivre + ", auteur=" + auteur + ", titre=" + titre + ", description="
				+ description + ", photoLivre=" + photoLivre + ", poidsLivre=" + poidsLivre + ", formatLivre="
				+ formatLivre + ", dateAjoutLivre=" + dateAjoutLivre + ", disponibilite=" + disponibilite + "]";
	}
	
}
