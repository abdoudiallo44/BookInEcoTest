<%@include file="header.jsp" %>
	<h2>Mes livres</h2>
	<hr />
	<br />
	<br />
	<div class="container">
		<form action="/projettest/livres/ajouterLivre" method="post" enctype="multipart/form-data"
			modelAttribute="LivreForm" >
			<table>
				<tr>
					<td>Auteur :</td>
					<td><input type="text" name="auteur"
						value="${livreForm.auteur}" /></td>
				</tr>
				<tr>
					<td>Titre :</td>
					<td><input type="text" name="titre" value="${livreForm.titre}" /></td>
				</tr>
				<tr>
					<td>Description :</td>
					<td><input type="text" name="description"
						value="${livreForm.description}" /></td>
				</tr>
				<tr>
					<td>Poids :</td>
					<td><input type="number" name="poids"
						value="${livreForm.poids}" /></td>
				</tr>
				<tr>
					<td>Format :</td>
					<td><input type="text" name="format"
						value="${livreForm.format}" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Ajouter" /></td>
					<td></td>
				</tr>
			</table>

		</form>
		<form action="/projettest/livres/ajouterLivre" method="post" enctype="multipart/form-data">
			<table>
			<tr>
					<td>Photo:</td>
					<td><input type="file" name="photo" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Ajouter" /></td>
					<td></td>
				</tr>
				</table>
			</form>
	</div>
	<!-- 
	<div class="container">
	<form action="/projettest/livres/findByKey" method="post">
		<table>
			<tr>
				<td>Mot clé: </td>
				<td><input type="text" name="motCle" required/></td>
			</tr>
		</table><br />
		<input type="submit" value="Recherche" />
	
	</form>
	</div><br /><br />-->
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
					<td><img style="max-width: 350px; max-height: 200px" src="<c:url value="/resources/img/${l.photo}"/>"></td>
					<td>${l.auteur}</td>
					<td>${l.titre}</td>
					<td>${l.description}</td>
					<td>${l.proprietaire.nom} ${l.proprietaire.prenom}</td>
					<td><a href="/projettest/livres/supprimer/${l.id}">Supprimer</a></td>
				</tr>
			</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>