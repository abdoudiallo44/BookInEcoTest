package fr.dawan.projettest.Beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;


public class LivreForm {
	
	private long idLivre;
	
	@NotEmpty(message="Ce champs ne doit pas être vide")
	private String auteur;
	
	@NotEmpty(message="Ce champs ne doit pas être vide")
	private String titre;
	
	private String description;
	
	private String photoLivre;
	
	private double poidsLivre;
	
	@NotEmpty(message="Ce champs ne doit pas être vide")
	private String formatLivre;
	
	private LocalDate dateAjoutLivre;
	
	private boolean disponibilite;


	
	
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

	public LocalDate getDateAjoutLivre() {
		return dateAjoutLivre;
	}

	public void setDateAjoutLivre(LocalDate dateAjoutLivre) {
		this.dateAjoutLivre = dateAjoutLivre;
	}

	public boolean getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}


	
	
	
	public LivreForm(long idLivre, @NotEmpty(message = "Ce champs ne doit pas être vide") String auteur,
			@NotEmpty(message = "Ce champs ne doit pas être vide") String titre, String description, String photoLivre,
			@NotEmpty(message = "Ce champs ne doit pas être vide") double poidsLivre,
			@NotEmpty(message = "Ce champs ne doit pas être vide") String formatLivre, LocalDate dateAjoutLivre,
			boolean disponibilite) {
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

	

	@Override
	public String toString() {
		return "LivreForm [idLivre=" + idLivre + ", auteur=" + auteur + ", titre=" + titre + ", description="
				+ description + ", photoLivre=" + photoLivre + ", poidsLivre=" + poidsLivre + ", formatLivre="
				+ formatLivre + ", dateAjoutLivre=" + dateAjoutLivre + ", disponibilite=" + disponibilite + "]";
	}

		
}
