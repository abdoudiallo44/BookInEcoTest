<%@include file="header.jsp"%>
<h2>Ma messagerie</h2>
<table class="table">
	<tbody>
		<c:forEach var="m" items="${listeMessage}">
			<tr>
				<td><strong>Expéditeur : </strong>${m.expediteur.pseudo} </br> 
					<strong>Objet :</strong> ${m.titreMessage} </br> 
					<strong>Date de réception : </strong>${m.dateEnvoi}
				</td>
				<td>
						<a class="btn btn-warning" 
							<c:if 
								test="${not empty sessionScope.user}"> href="contenuMessage/${m.id}"
							</c:if> role="button">Consulter message
						</a>
						
						<a class="btn btn-warning" 
							<c:if 
								test="${not empty sessionScope.user}"> href="supprimerMessage/${m.id}"
							</c:if> role="button">Supprimer</a>	
						</a>
					</td></br>
				</br>
			</tr>
		</c:forEach>

	</tbody>
	</table>

	</body>
	</html>