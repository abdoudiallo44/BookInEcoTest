package fr.dawan.projettest.Beans;

import java.time.LocalDateTime;

import fr.dawan.projettest.entite.Utilisateur;


public class MessageForm {

private LocalDateTime dateEnvoi;
private boolean messageLu;
private Utilisateur destinataire,expediteur;
private String titreMessage;
private String contenuMessage;



public MessageForm() {
	super();
}
public MessageForm(LocalDateTime dateEnvoi, boolean messageLu, Utilisateur destinataire, Utilisateur expediteur,
		String titreMessage, String contenuMessage) {
	super();
	this.dateEnvoi = dateEnvoi;
	this.messageLu = messageLu;
	this.destinataire = destinataire;
	this.expediteur = expediteur;
	this.titreMessage = titreMessage;
	this.contenuMessage = contenuMessage;
}
public LocalDateTime getDateEnvoi() {
	return dateEnvoi;
}
public void setDateEnvoi(LocalDateTime dateEnvoi) {
	this.dateEnvoi = dateEnvoi;
}
public boolean isMessageLu() {
	return messageLu;
}
public void setMessageLu(boolean messageLu) {
	this.messageLu = messageLu;
}
public Utilisateur getDestinataire() {
	return destinataire;
}
public void setDestinataire(Utilisateur destinataire) {
	this.destinataire = destinataire;
}
public Utilisateur getExpediteur() {
	return expediteur;
}
public void setExpediteur(Utilisateur expediteur) {
	this.expediteur = expediteur;
}
public String getTitreMessage() {
	return titreMessage;
}
public void setTitreMessage(String titreMessage) {
	this.titreMessage = titreMessage;
}
public String getContenuMessage() {
	return contenuMessage;
}
public void setContenuMessage(String contenuMessage) {
	this.contenuMessage = contenuMessage;
}


}



