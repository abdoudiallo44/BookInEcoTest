<%@include file="header.jsp" %>
	
	<h2>Gestion de mon profil</h2>
	<hr />
	
	<div class="container">
		<a class="btn btn-primary" 
			<c:if 
				test="${not empty sessionScope.user}"> href="profil/modifierProfil"
			</c:if>
			<c:if 
				test="${empty sessionScope.user}"> href="login"
			</c:if>
			role="button">Modifier mon profil
			
		</a>
		<a class="btn btn-primary" 
			<c:if 
				test="${not empty sessionScope.user}"> href="profil/ajouteradresse"
			</c:if>
			<c:if 
				test="${empty sessionScope.user}"> href="login"
			</c:if>
			role="button">Ajouter une nouvelle adresse
			
		</a>
	</div>
	</br>
	<div class="container" align=justify>
		<p> Nom : ${user.nom}</p>
		<p> Prénom : ${user.prenom}</p>
		<p> Pseudo : ${user.pseudo}</p>
		<p> Date de naissance : ${user.dateDenaissance}</p>
		<%-- <p>
			Adresse
			<c:forEach var="adr" items="${listeAdresse}">
				<p>${adr.numEtRueAdresse}</p> 
				<p>${adr.codePostal} - ${adr.ville} - (${adr.pays})</p>
				</br>
			</c:forEach>
		
		</p> --%>
		<p> Nombre de points : ${user.nombreDePoint}</p>
	</div>
	
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Numéro et nom de la rue</th>
					<th scope="col">Code postal</th>
					<th scope="col">Ville</th>
					<th scope="col">Pays</th>
					<th scope="col">Option</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="adresse" items="${listeAdresse}">
				<tr>
					<td>${adresse.numEtRueAdresse}</td>
					<td>${adresse.codePostal}</td>
					<td>${adresse.ville}</td>
					<td>${adresse.pays}</td>
					<td><%-- <a href="profil/modifierAdresse/${adresse.id}"><i class="fa fa-edit fa-2x text-success" ></i></a> --%>
					<a href="profil/supprimerAdresse/${adresse.id}"> <i class="fa fa-trash-o fa-2x text-danger"></i></a></td>
					
				</tr>
			</c:forEach>

			</tbody>
		</table>
	</div>
	
	</body>
</html>