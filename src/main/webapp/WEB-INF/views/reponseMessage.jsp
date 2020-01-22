<%@include file="header.jsp"%>
<h2>Ecrire un message :</h2>

<form action="reponseMessage" method="post" modelAttribute="MessageForm">
	<table>
		<%-- <tr>
			<td><input type="hidden" name="id_exp"
				value="${MessageForm.destinataire}" /></td>
		</tr> --%>
		<tr>
			<td>Destinataire :</td>
			<td><input type="text" name="destinataire"
				value="${MessageForm.destinataire}" /></td>
		</tr>
		<tr>
			<td>Objet :</td>
			<td><input type="text" name="titreMessage"
				value="${MessageForm.titreMessage}" /></td>
		</tr>
		<tr>
			<td>Votre message :</td>
			<td><input type="text" name="contenuMessage"
				value="${MessageForm.contenuMessage}" /></td>
		</tr>

		<tr>
			<td><input type="submit" value="Envoyer" /></td>
			<td></td>
		</tr>
	</table>