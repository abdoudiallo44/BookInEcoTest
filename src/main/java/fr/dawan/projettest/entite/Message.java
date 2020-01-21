package fr.dawan.projettest.entite;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message extends DbObject{

private LocalDateTime dateEnvoi;
private boolean messageLu;

@ManyToOne
private Utilisateur destinataire,expediteur;
private String titreMessage;
private String contenuMessage;


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
public Message() {
	super();
}


}
