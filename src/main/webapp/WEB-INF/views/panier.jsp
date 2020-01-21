<%@include file="header.jsp" %>
	<div class="container">
	</div><br /><br />
	<div class="container">
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Photo</th>
				<th scope="col">Auteur</th>
				<th scope="col">Titre</th>
				<th scope="col">Description</th>
				<th scope="col">Proprietaire</th>
				<th scope="col">Option</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="l" items="${listeLivre}">
				<tr>
					<td><img src="<c:url value="/resources/img/${l.photo}"/>"></td>
					<td>${l.auteur}</td>
					<td>${l.titre}</td>
					<td>${l.description}</td>
					<td>${l.proprietaire.nom} ${l.proprietaire.prenom}</td>
					<td><a href="/projettest/panier/supprimer/${l.id}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>

</body>
</html>