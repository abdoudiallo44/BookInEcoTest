<%@include file="header.jsp"%>

<h2>Ajouter une adresse</h2>
<hr />
<div class="container" align="center">
	<a class="btn btn-primary"
		<c:if 
				test="${not empty sessionScope.user}"> href="displayProfil/"
			</c:if>
		<c:if 
				test="${empty sessionScope.user}"> href="login"
			</c:if>
		role="button">Retourner sur mon profil </a>
</div>

<div class="container">
	<form action="profil/ajouteradresse" method="post" modelAttribute="adresseForm">
		<table>
			<tr>
				<td>Adresse :</td>
				<td><input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="numEtRueAdresse"
					value="" placeholder="Numéro et nom de la rue" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="codePostal"
					value="" placeholder="Code Postal" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="ville"
					value="" placeholder="Ville" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" class="form-control"
					aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" name="pays"
					value="" placeholder="Pays" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-warning" type="submit"
					value="Ajouter" /></td>
				<td></td>
			</tr>
		</table>

	</form>
</div>
</br>
</body>
</html>