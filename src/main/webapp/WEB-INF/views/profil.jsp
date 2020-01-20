<%@include file="header.jsp" %>
	
	<h2>Gestion de mon profil</h2>
	<hr />
	
	<div class="container">
		<a class="btn btn-primary" 
			<c:if 
				test="${not empty sessionScope.user}"> href="profil/modifierProfil/${user.id}"
			</c:if>
			<c:if 
				test="${empty sessionScope.user}"> href="login"
			</c:if>
			role="button">Modifier mon profil
		</a>
	</div>
	</br>
	<div class="container" align=justify>
		<p> Nom : ${user.nom}</p>
		<p> Prénom : ${user.prenom}</p>
		<p> Date de naissance : ${user.dateDenaissance}</p>
		<p>
			Adresse
			<c:forEach var="adr" items="${listeAdresse}">
				<p>${adr.numEtRueAdresse}</p> 
				<p>${adr.codePostal} - ${adr.ville} - (${adr.pays})</p>
				</br>
			</c:forEach>
		
		</p>
		<p> Nombre de points : ${user.nombreDePoint}</p>
	</div>
	
	</body>
</html>