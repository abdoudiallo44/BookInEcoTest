<%@include file="header.jsp" %>
<div class="container-fluid">
	<img src="<c:url value="/resources/img/banniere.gif"/>" width=100% style=" margin:0%">
</div>
<div class="container">
	<table class="table">
		<tbody>
			<c:forEach var="l" items="${listeLivre}">
				<tr>
					<td><img style="max-width: 350px; max-height: 200px" src="<c:url value="/resources/img/${l.photo}"/>"></td>
					<td>Auteur : ${l.auteur} </br> 
					Titre : ${l.titre} </br>
					Format : ${l.format}</br>
					Etat : ${l.etat} </br>
					Propriétaire : ${l.proprietaire.nom} ${l.proprietaire.prenom}
					<td>Description : ${l.description}</td>
					<td>
						<a class="btn btn-warning" 
							<c:if 
								test="${not empty sessionScope.user}"> href="ajoutPanier/${l.id}"
							</c:if>
							<c:if 
								test="${empty sessionScope.user}"> href="login"
							</c:if>
							role="button">Ajouter au panier
						</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>

</body>
</html>
