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
						<td><select name="format">
								<option <c:if test="${empty livreForm.format}">selected</c:if>>--
									Choisissez un format --</option>
								<option
									<c:if test="${livreForm.format == 'grand'}">selected</c:if>
									value="grand">Grand</option>
								<option
									<c:if test="${livreForm.format == 'poche'}">selected</c:if>
									value="poche">Poche</option>
						</select></td>
					</tr>
					<tr>
						<td>État:</td>
						<td><select name="etat">
								<option <c:if test="${empty livreForm.etat}">selected</c:if>>--
									Choisissez un état --</option>
								<option
									<c:if test="${livreForm.etat == 'commeNeuf'}">selected</c:if>
									value="commeNeuf">Comme neuf</option>
								<option <c:if test="${livreForm.etat == 'bon'}">selected</c:if>
									value="bon">Bon</option>
								<option
									<c:if test="${livreForm.etat == 'correct'}">selected</c:if>
									value="correct">Correct</option>
						</select></td>
					</tr>
					<tr>
						<td><input type="submit" value="Enregistrer" /></td>
						<td></td>
					</tr>
				</table>
				<c:if test="${ajoutLivre}">
					<div class="container col-6">Les informations ont été
						enregistrer, veuillez maintenant ajouter une photo</div>
				</c:if>

			</form>
		</div>

	</div>
	<div class="container col-12 border border-success" style="margin: 5px">
		<c:if test="${not empty livreAjout.photo}">
			<div class="container">
				<p>Photo actuelle :</p>
				<img style="max-width: 350px; max-height: 200px"
					src="<c:url value="/resources/img/${livreAjout.photo}"/>">
			</div>
		</c:if>
		<form action="/projettest/livres/ajouterLivrePhoto" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>Photo:</td>
					<td><input type="file" name="photo" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Enregistrer"
						<c:if test="${empty livreAjout}">disabled</c:if> /></td>
				</tr>
				<c:if test="${not empty livreAjout.photo}">
					<tr>
						<td>Photo ajoutée : ${photoAjoutee}</td>
					</tr>
				</c:if>
			</table>
		</form>
	</div>
	<div class="container col-12 border border-success" style="margin: 5px">
		<form action="/projettest/livres/ajouterLivre" method="get">
			<button type="submit" class="btn btn-success"
				<c:if test="${empty livreAjout.photo}">disabled</c:if>>Ajouter
				le livre</button>
		</form>
	</div>
	<c:if test="${ajoutFinal}">
		<div class="container col-1 border border-success">Livre ajouté
			avec succès</div>
	</c:if>
	<div class="container col-12" style="margin: 5px">
		<a class="btn btn-primary" href="/projettest/gestionLivre/">Retour à la liste
			des livres</a>
	</div>
</div>
</body>
</html>