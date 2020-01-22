<%@include file="header.jsp"%>
<h2>Ma messagerie</h2>
<br/>

<p class="deletemessage">
	<c:if test="${ suppression}">hjhgjjhgjhgjhgkkjhkg
	</c:if>
</p>

<a class="btn btn-warning"
	<c:if test="${not empty sessionScope.user}"> href="reponseMessage"
	</c:if> role="button">Rédiger un message </a>
	
<table class="table">
	<br />
	<tbody>
	<br />
		
		<c:forEach var="m" items="${listeMessage}">

			<tr>

				<td><strong>Expéditeur : </strong>${m.expediteur.pseudo} </br> <strong>Objet
						:</strong> ${m.titreMessage} </br> <strong>Date de réception : </strong>${m.dateEnvoi}
				</td>
				<td><a class="btn btn-warning"
					<c:if 
								test="${not empty sessionScope.user}"> href="contenuMessage/${m.id}"
							</c:if>
					role="button">Voir </a> <a class="btn btn-warning"
					<c:if 
								test="${not empty sessionScope.user}"> href="supprimerMessage/${m.id}"
							</c:if>
					role="button">Supprimer</a> </a></td>
			</tr>
		</c:forEach>

	</tbody>
</table>

</body>
</html>