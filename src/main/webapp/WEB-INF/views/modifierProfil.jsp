<%@include file="header.jsp"%>

<h2>Gestion de mon profil</h2>
<hr />
<div class="container">
	<form action="profil" method="post" modelAttribute="ProfilForm">
		<table>
			<tr>
				<td>Nom :</td>
				<td><input type="text" name="nom" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" readOnly="true"
					value="${profilForm.nom}" /></td>
			</tr>
			<tr>
				<td>Prénom :</td>
				<td><input type="text" name="prenom" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" readOnly="true"
					value="${profilForm.prenom}" /></td>
			</tr>
			<tr>
				<td>Date de naissannce :</td>
				<td><input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="dateDenaissance"
					readOnly="true" value="${profilForm.dateDenaissance}" /></td>
			</tr>
			<tr>
				<td>Adresse :</td>
				<td><input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="dateDenaissance"
					value="" placeholder="Numéro et nom de la rue" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="dateDenaissance"
					value="" placeholder="Code Postal" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="dateDenaissance"
					value="" placeholder="Ville" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="dateDenaissance"
					value="" placeholder="Pays" /></td>
			</tr>
			<tr>
				<td>Nombre de points :</td>
				<td><input type="text" name="poids" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm"
					value="${profilForm.nombreDePoint}" /></td>
			</tr>
			<tr>
				<td><input class="btn btn-warning" type="submit"
					value="Modifier" /></td>
				<td></td>
			</tr>
		</table>

	</form>
</div>
</br>
<div class="container" align=justify>
	<p>Nom : ${user.nom}</p>
	<p>Prénom : ${user.prenom}</p>
	<p>Date de naissance : ${user.dateDenaissance}</p>
	<p>
		Adresse
		<c:forEach var="adr" items="${listeAdresse}">
			<p>${adr.numEtRueAdresse}</p>
			<p>${adr.codePostal}- ${adr.ville} - (${adr.pays})</p>
			</br>
		</c:forEach>

	</p>
	<p>Nombre de points : ${user.nombreDePoint}</p>
</div>

</body>
</html>