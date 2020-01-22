package fr.dawan.projettest.entite;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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

	@Enumerated(EnumType.STRING)
	private RoleUtilisateur role;

	@ManyToMany
	private List<ThemeLivre> preferenceLitteraire;

	// Une personne possède plusieurs livres
	@OneToMany(mappedBy = "proprietaire", cascade = CascadeType.PERSIST)
	private List<Livre> listeLivreUtil = new ArrayList();

	@OneToMany(mappedBy = "acheteur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Commande> commandes = new ArrayList();

	public void addCommande(Commande commande) {
		commandes.add(commande);
	}

	public void removeCommande(Commande commande) {
		commandes.remove(commande);
	}

	public List<Commande> getCommandes() {
		return new ArrayList(commandes);
	}

	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AdresseLivraison> adresseLivraison;

	
	public void addAdresse(AdresseLivraison adresse) {
		adresseLivraison.add(adresse);
		adresse.setUtilisateur(this);
	}
	
	public void removeAdresse(AdresseLivraison adresse) {
		adresseLivraison.remove(adresse);
		adresse.setUtilisateur(null);
	}

	public List<AdresseLivraison> getAdresseLivraison() {
		return new ArrayList<AdresseLivraison>(adresseLivraison);
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
	public String checkPassword(String motDepasse) {
		if (motDepasse == null) {
			return "Erreur Mot de passe";
		}
		
		return getEncrytedPassword(motDepasse);
	}

	public void setMdp(String pass) {
		this.mdp = getEncrytedPassword(pass);
	}

	public static String getEncrytedPassword(String pass) {
		byte[] hash = null;
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new String(hash);
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
				+ nombreDePoint + ", role=" + role + ", commandes=" + commandes;
	}
	

	public boolean debit(int valeurLivre) {
		if(valeurLivre > nombreDePoint) {
			return false;
		}
		nombreDePoint -= valeurLivre;
		return true;
	}

	public void credit(int valeurLivre) {
		nombreDePoint += valeurLivre;
		
	}

}
