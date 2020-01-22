<%@include file="header.jsp" %>
	<h2>Gestion des Livres</h2>
	<hr />
	<br />
	<br /> 
	<div class="container">
		<div class="row">
			<div class="col-2">
				<form action="livres/ajouterLivre" method="post"
					enctype="multipart/form-data">
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
			<div class="col-8">
				<form action="livres/ajouterLivrePhoto" method="post" modelAttribute="LivreForm">
					<table>
						<tr>
							<td>Auteur :</td>
							<td><input type="text" name="auteur"
								value="${livreForm.auteur}" /></td>
						</tr>
						<tr>
							<td>Titre :</td>
							<td><input type="text" name="titre"
								value="${livreForm.titre}" /></td>
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
			</div>
		</div>
	</div>
	<div class="container">
	<a class="btn btn-primary" href="" >Retour page d'accueil</a>
	</div>
</body>
</html>