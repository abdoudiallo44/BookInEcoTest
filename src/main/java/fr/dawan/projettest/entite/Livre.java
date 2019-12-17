package fr.dawan.projettest.entite;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author adial
 *
 */
@Entity
@Table(name = "livre")
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLivre;

	private String auteur;

	private String titre;

	private String description;

	private String photoLivre;

	private double poidsLivre;

	private String formatLivre;

	private LocalDate dateAjoutLivre;

	private boolean disponibilite;

	@ManyToOne
	private Utilisateur proprietaire;

	@ManyToOne
	private ThemeLivre idTheme;

	// Getters and Setters
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

	public Livre(String auteur, String titre, String description, Utilisateur proprietaire) {
		super();
		this.auteur = auteur;
		this.titre = titre;
		this.description = description;
		this.proprietaire = proprietaire;
	}

	public Livre() {
		super();
	}

	public Livre(long idLivre, String auteur, String titre, String description, double poidsLivre, String formatLivre,
			boolean disponibilite) {
		super();
		this.idLivre = idLivre;
		this.auteur = auteur;
		this.titre = titre;
		this.description = description;
		this.poidsLivre = poidsLivre;
		this.formatLivre = formatLivre;
		this.disponibilite = disponibilite;
	}

	public Livre(long idLivre, String auteur, String titre, String description, String photoLivre, double poidsLivre,
			String formatLivre, LocalDate dateAjoutLivre, boolean disponibilite, Utilisateur proprietaire,
			ThemeLivre idTheme) {
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
		this.proprietaire = proprietaire;
		this.idTheme = idTheme;
	}

	@Override
	public String toString() {
		return "Livre [idLivre=" + idLivre + ", auteur=" + auteur + ", titre=" + titre + ", description=" + description
				+ ", photoLivre=" + photoLivre + ", poidsLivre=" + poidsLivre + ", formatLivre=" + formatLivre
				+ ", dateAjoutLivre=" + dateAjoutLivre + ", disponibilite=" + disponibilite + ", proprietaire="
				+ proprietaire + ", idTheme=" + idTheme + "]";
	}

	
	
	

}
