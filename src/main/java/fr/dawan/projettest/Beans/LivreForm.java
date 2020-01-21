package fr.dawan.projettest.Beans;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import fr.dawan.projettest.entite.Livre;


public class LivreForm {
	
	private long id;
	
	@NotEmpty
	private String auteur;
	@NotEmpty
	private String titre;
	@NotEmpty
	private String description;
	
	private String photo;
	@Min(value=0)
	private double poids;
	@NotEmpty
	private String format;
	@NotEmpty
	private String etat;
	
	
	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	private LocalDateTime dateAjout;
	
	
	private boolean disponibilite;
	
	public static LivreForm toForm(Livre livre) {
		LivreForm form = new LivreForm();
		form.setId(livre.getId());
		form.setAuteur(livre.getAuteur());
		form.setDescription(livre.getDescription());
		form.setTitre(livre.getTitre());
		form.setPoids(livre.getPoids());
		form.setFormat(livre.getFormat());
		form.setEtat(livre.getEtat());
		form.setPhoto(livre.getPhoto());
		return form;
	}
	



	public LivreForm(long id, String auteur, String titre, String description, String photo, double poids,
			String format, String etat, LocalDateTime dateAjout, boolean disponibilite) {
		super();
		this.id = id;
		this.auteur = auteur;
		this.titre = titre;
		this.description = description;
		this.photo = photo;
		this.poids = poids;
		this.format = format;
		this.etat = etat;
		this.dateAjout = dateAjout;
		this.disponibilite = disponibilite;
	}


	public LivreForm() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public double getPoids() {
		return poids;
	}


	public void setPoids(double poids) {
		this.poids = poids;
	}


	public String getFormat() {
		return format;
	}


	public void setFormat(String format) {
		this.format = format;
	}


	public LocalDateTime getDateAjout() {
		return dateAjout;
	}


	public void setDateAjout(LocalDateTime dateAjout) {
		this.dateAjout = dateAjout;
	}


	public boolean isDisponibilite() {
		return disponibilite;
	}


	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}


	@Override
	public String toString() {
		return "LivreForm [id=" + id + ", auteur=" + auteur + ", titre=" + titre + ", description="
				+ description + ", photo=" + photo + ", poids=" + poids + ", format="
				+ format + ", dateAjout=" + dateAjout + ", disponibilite=" + disponibilite + "]";
	}
	
}
