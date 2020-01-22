<%@include file="header.jsp"%>

<h2>Modifier mon profil</h2>
<hr />
<div class="container" align="center">
	<a class="btn btn-primary"
		<c:if 
				test="${not empty sessionScope.user}"> href="displayProfil"
			</c:if>
		<c:if 
				test="${empty sessionScope.user}"> href="login"
			</c:if>
		role="button">Retourner sur mon profil </a>
</div>
<div class="container">
	<form action="displayProfil" method="post" modelAttribute="ProfilForm">
		<%-- <input type="hidden" value="${profilForm.id}", name="id" /> --%>
		<table>
			<tr>
				<td>Nom :</td>
				<td><input type="text" name="nom" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" "
					value="${profilForm.nom}" /></td>
			</tr>
			<tr>
				<td>Prénom :</td>
				<td><input type="text" name="prenom" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" 
					value="${profilForm.prenom}" /></td>
			</tr>
			<tr>
				<td>Pseudo :</td>
				<td><input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="pseudo"
					value="${profilForm.pseudo}" /></td>
			</tr>
			<tr>
				<td>Mot de passe :</td>
				<td><input type="password" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="mdp"
					value="${profilForm.mdp}" /></td>
			</tr>
			
			<%-- <tr>
				<td>Date de naissannce :</td>
				<td><input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="dateDenaissance"
					readOnly="true" value="${profilForm.dateDenaissance}" /></td>
			</tr> --%>
			<%-- <tr>
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
			</tr> --%>
			<tr>
				<td><input class="btn btn-warning" type="submit"
					value="Modifier" /></td>
				<td></td>
			</tr>
		</table>

	</form>
</div>
</br>
<%-- <div class="container" align=justify>
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
</div> --%>

</body>
</html>