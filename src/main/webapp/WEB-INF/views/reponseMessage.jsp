<%@include file="header.jsp"%>
<h2>Répondre à : ${message.expediteur.pseudo}</h2>

<form action="/reponseMessage" method="post" modelAttribute="messageForm">
					<table>
						<tr>
							<td>Destinataire : </td>
							<td><input type="text" name="destinataire"
								value="${messageForm.destinataire}" /></td>
						</tr>
						<tr>
							<td>Objet :</td>
							<td><input type="text" name="titre"
								value="${messageForm.titreMessage}" /></td>
						</tr>
						<tr>
							<td>Votre message :</td>
							<td><input type="text" name="message"
								value="${messageForm.contenuMessage}" /></td>
						</tr>
						
						<tr>
							<td><input type="submit" value="Envoyer" /></td>
							<td></td>
						</tr>
					</table>