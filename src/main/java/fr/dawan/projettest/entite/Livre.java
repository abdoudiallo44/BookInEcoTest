package fr.dawan.projettest.entite;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * 
 * @author adial
 *
 */
@Entity
@Table(name = "livre")
public class Livre extends DbObject{


	private String auteur;

	private String titre;

	@Type(type="text")
	private String description;

	private String photo;

	private double poids;

	private String format;

	private LocalDate dateAjout;

	private boolean disponibilite;
	
	private String etat;

	@ManyToOne
	private Utilisateur proprietaire;

	@ManyToOne
	private ThemeLivre idTheme;


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

	public void setPhoto(String photoLivre) {
		this.photo = photoLivre;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poidsLivre) {
		this.poids = poidsLivre;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String formatLivre) {
		this.format = formatLivre;
	}

	public LocalDate getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(LocalDate dateAjoutLivre) {
		this.dateAjout = dateAjoutLivre;
	}

	public boolean isDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	public Utilisateur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public ThemeLivre getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(ThemeLivre idTheme) {
		this.idTheme = idTheme;
	}
	
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Livre(String auteur, String titre, String description, Utilisateur utilisateur) {
		super();
		this.auteur = auteur;
		this.titre = titre;
		this.description = description;
		this.proprietaire = utilisateur;
	}

	public Livre() {
		super();
	}

	public Livre(String auteur, String titre, String description, double poidsLivre, String formatLivre,
			boolean disponibilite) {
		super();
		this.auteur = auteur;
		this.titre = titre;
		this.description = description;
		this.poids = poidsLivre;
		this.format = formatLivre;
		this.disponibilite = disponibilite;
	}

	public Livre(String auteur, String titre, String description, String photoLivre, double poidsLivre,
			String formatLivre, LocalDate dateAjoutLivre, boolean disponibilite, Utilisateur proprietaire,
			ThemeLivre idTheme) {
		super();
		this.auteur = auteur;
		this.titre = titre;
		this.description = description;
		this.photo = photoLivre;
		this.poids = poidsLivre;
		this.format = formatLivre;
		this.dateAjout = dateAjoutLivre;
		this.disponibilite = disponibilite;
		this.proprietaire = proprietaire;
		this.idTheme = idTheme;
	}

	@Override
	public String toString() {
		return "Livre [auteur=" + auteur + ", titre=" + titre + ", description=" + description + ", photo=" + photo
				+ ", poids=" + poids + ", format=" + format + ", dateAjout=" + dateAjout + ", disponibilite="
				+ disponibilite + ", etat=" + etat + ", idTheme=" + idTheme + ", getId()=" + getId() + "]";
	}

	

}
