package fr.dawan.projettest.entite;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.Nullable;

@Entity
@Table(name = "utilisateur")
public class Utilisateur extends DbObject{
	// Les attributs

	private String prenom;

	private String nom;

	@Nullable
	private LocalDate dateDenaissance;

	private String email;

	private String pseudo;

	private String mdp;

	@Nullable
	private String photoProfil;

	@Nullable
	private int nombreDePoint;

	@Nullable
	private RoleUtilisateur role;
	
	@Nullable
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ThemeLivre> preferenceLitteraire;

	@Nullable
	// Une personne possède plusieurs livres
	@OneToMany(mappedBy = "proprietaire", fetch = FetchType.LAZY)
	private List<Livre> listeLivreUtil;

	@Nullable
	@OneToOne( fetch = FetchType.EAGER)
	private Panier panierUtilisateur;

	@Nullable
	@OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
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
		return listeLivreUtil;
	}

	public void setListeLivreUtil(List<Livre> listeLivreUtil) {
		this.listeLivreUtil = listeLivreUtil;
	}

	public Utilisateur(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public Utilisateur() {
		super();
	}

	public Utilisateur( String prenom, String nom, LocalDate dateDenaissance, String email,
			String pseudo, String mdp) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.dateDenaissance = dateDenaissance;
		this.email = email;
		this.pseudo = pseudo;
		this.mdp = mdp;
	}
	
	public Utilisateur( String prenom, String nom, String email, String pseudo, String mdp,
			int nombreDePoint, RoleUtilisateur role) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.nombreDePoint = nombreDePoint;
		this.role = role;
	}

	public Utilisateur( String prenom, String nom, LocalDate dateDenaissance, String email,
			String pseudo, String mdp, String photoProfil, int nombreDePoint, RoleUtilisateur role,
			List<ThemeLivre> preferenceLitteraire, List<Livre> listeLivreUtil) {
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
		return "Utilisateur [prenom=" + prenom + ", nom=" + nom
				+ ", dateDenaissance=" + dateDenaissance + ", email=" + email + ", pseudo=" + pseudo + ", mdp=" + mdp
				+ ", photoProfil=" + photoProfil + ", nombreDePoint=" + nombreDePoint + ", role=" + role
				+ ", preferenceLitteraire=" + preferenceLitteraire + ", listeLivreUtil=" + listeLivreUtil
				+ ", panierUtilisateur=" + panierUtilisateur + ", adresseLivraison=" + adresseLivraison + "]";
	}

}
