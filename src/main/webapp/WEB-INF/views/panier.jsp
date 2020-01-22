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
			<c:forEach var="c" items="${listeCommande}">
				<tr>
					<td><img style="max-width: 350px; max-height: 200px" src="<c:url value="/resources/img/${c.livre.photo}"/>"></td>
					<td>${c.livre.auteur}</td>
					<td>${c.livre.titre}</td>
					<td>${c.livre.description}</td>
					<td>${c.livre.proprietaire.nom} ${c.livre.proprietaire.prenom}</td>
					<td><a href="/projettest/panier/acheter/${c.id}">Acheter</a></td>
					<td><a href="/projettest/panier/supprimer/${c.id}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>

</body>
</html>