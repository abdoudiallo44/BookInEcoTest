<%@include file="header.jsp"%>
<h2>Gestion des Livres</h2>
<hr />
<br />
<div class="container">
	<a class="btn btn-primary" href="/projettest/livres/ajouterLivre"> Ajout de livre </a>
</div>
<br />
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
					<td><img style="max-width: 350px; max-height: 200px"
						src="<c:url value="/resources/img/${l.photo}"/>"></td>
					<td>${l.auteur}</td>
					<td>${l.titre}</td>
					<td>${l.description}</td>
					<td>${l.proprietaire.nom}${l.proprietaire.prenom}</td>
					<td><a href="/projettest/livres/supprimer/${l.id}">Supprimer</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
</body>
</html>