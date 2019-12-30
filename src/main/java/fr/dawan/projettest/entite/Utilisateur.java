package fr.dawan.projettest.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur extends DbObject {
	// Les attributs

	private String prenom;

	private String nom;

	private LocalDate dateDenaissance;

	private String email;

	private String pseudo;

	private String mdp;

	private String photoProfil;

	private int nombreDePoint;

	private RoleUtilisateur role;

	@ManyToMany
	private List<ThemeLivre> preferenceLitteraire;

	// Une personne possède plusieurs livres
	@OneToMany(mappedBy = "proprietaire",cascade = CascadeType.PERSIST)
	private List<Livre> listeLivreUtil = new ArrayList();

	@OneToOne
	private Panier panierUtilisateur;

	@OneToMany(mappedBy = "utilisateur")
	private List<AdresseLivraison> adresseLivraison;

	public Panier getPanierUtilisateur() {
		return panierUtilisateur;
	}

	public void setPanierUtilisateur(Panier panierUtilisateur) {
		this.panierUtilisateur = panierUtilisateur;
	}

	public List<AdresseLivraison> getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(List<AdresseLivraison> adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

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

	public String getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(String photoProfil) {
		this.photoProfil = photoProfil;
	}

	public int getNombreDePoint() {
		return nombreDePoint;
	}

	public void setNombreDePoint(int nombreDePoint) {
		this.nombreDePoint = nombreDePoint;
	}

	public RoleUtilisateur getRole() {
		return role;
	}

	public void setRole(RoleUtilisateur role) {
		this.role = role;
	}

	public List<ThemeLivre> getPreferenceLitteraire() {
		return preferenceLitteraire;
	}

	public void setPreferenceLitteraire(List<ThemeLivre> preferenceLitteraire) {
		this.preferenceLitteraire = preferenceLitteraire;
	}

	public List<Livre> getListeLivreUtil() {
		return new ArrayList(listeLivreUtil);
	}

	public void addLivre(Livre livre) {
		if (livre != null) {
			listeLivreUtil.add(livre);
		}
	}
	
	public void removeLivre(Livre livre) {
			listeLivreUtil.remove(livre);
	}

	public Utilisateur(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public Utilisateur() {
		super();
	}

	public Utilisateur(String prenom, String nom, LocalDate dateDenaissance, String email, String pseudo, String mdp) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.dateDenaissance = dateDenaissance;
		this.email = email;
		this.pseudo = pseudo;
		this.mdp = mdp;
	}

	public Utilisateur(String prenom, String nom, String email, String pseudo, String mdp, int nombreDePoint,
			RoleUtilisateur role) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.nombreDePoint = nombreDePoint;
		this.role = role;
	}

	public Utilisateur(String prenom, String nom, LocalDate dateDenaissance, String email, String pseudo, String mdp,
			String photoProfil, int nombreDePoint, RoleUtilisateur role, List<ThemeLivre> preferenceLitteraire,
			List<Livre> listeLivreUtil) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.dateDenaissance = dateDenaissance;
		this.email = email;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.photoProfil = photoProfil;
		this.nombreDePoint = nombreDePoint;
		this.role = role;
		this.preferenceLitteraire = preferenceLitteraire;
		this.listeLivreUtil = listeLivreUtil;
	}

	@Override
	public String toString() {
		return "Utilisateur [prenom=" + prenom + ", nom=" + nom + ", dateDenaissance=" + dateDenaissance + ", email="
				+ email + ", pseudo=" + pseudo + ", mdp=" + mdp + ", photoProfil=" + photoProfil + ", nombreDePoint="
				+ nombreDePoint + ", role=" + role + ", preferenceLitteraire=" + preferenceLitteraire
				+ ", listeLivreUtil=" + listeLivreUtil + ", panierUtilisateur=" + panierUtilisateur
				+ ", adresseLivraison=" + adresseLivraison + "]";
	}

}
