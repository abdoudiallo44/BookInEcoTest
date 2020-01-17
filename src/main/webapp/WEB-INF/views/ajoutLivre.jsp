<%@include file="header.jsp"%>
<h2>Ajout d'un livre</h2>
<hr />
<br />
<br />
<div class="container col-9">
	<div class="container col-12 border border-success"
		style="margin: 5px; border-radius: 20px">
		<div class="row">
			<form action="/projettest/livres/ajouterLivre" method="post"
				modelAttribute="LivreForm">
				<table>
					<tr>
						<td>Auteur:</td>
						<td><input type="text" name="auteur"
							value="${livreForm.auteur}" /></td>
					</tr>
					<tr>
						<td>Titre:</td>
						<td><input type="text" name="titre"
							value="${livreForm.titre}" /></td>
					</tr>
					<tr>
						<td>Description:</td>
						<td><input type="text" name="description"
							value="${livreForm.description}" /></td>
					</tr>
					<tr>
						<td>Poids (en gramme):</td>
						<td><input type="number" name="poids"
							value="${livreForm.poids}" /></td>
					</tr>
					<tr>
						<td>Format:</td>
						<td><select name="format" value="${livreForm.format}">
								<option selected="selected">-- Choisissez un format --</option>
								<option value="grand">Grand</option>
								<option value="poche">Poche</option>
						</select></td>
					</tr>
					<tr>
						<td>État:</td>
						<td><select name="etat" value="${livreForm.etat}">
								<option selected="selected">-- Choisissez un état --</option>
								<option value="commeNeuf">Comme neuf</option>
								<option value="bonEtat">Bon état</option>
								<option value="correct">Correct</option>
						</select></td>
					</tr>
					<tr>
						<td><input type="submit" value="Ajouter" /></td>
						<td></td>
					</tr>
				</table>

			</form>
		</div>

	</div>
	<div class="container col-12 border border-success" style="margin: 5px">
		<form action="/projettest/livres/ajouterLivrePhoto" method="post"
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
</div>
</body>
</html>