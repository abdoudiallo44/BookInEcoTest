<%@include file="header.jsp"%>
<h2>Message de : ${message.expediteur.pseudo}</h2>
<table class="table">
	<tbody>
		
			<tr>
				<td>
					<strong>Objet :</strong> ${message.titreMessage} </br> 
					<strong>Date de réception : </strong>${message.dateEnvoi}</br> 
					<strong>Message :</strong> ${message.contenuMessage} </br> 
					
				</td>
				<td>
						<a class="btn btn-warning" 
							<c:if 
								test="${not empty sessionScope.user}"> href="contenuMessage/${m.id}"
							</c:if> role="button">Répondre</a>
					</td></br>
					<td>
						<a class="btn btn-warning" 
							<c:if 
								test="${not empty sessionScope.user}"> href="supprimerMessage/${m.id}"
							</c:if> role="button">Supprimer</a>
					</td></br>
				</br>
			</tr>
		

	</tbody>
	</table>
	</body>
	</html>