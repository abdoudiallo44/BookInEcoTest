<%@include file="header.jsp" %>
	<div class="container">
		 Bonjour ${sessionScope.user.prenom} ${sessionScope.user.nom}</br>
		<a href="livres/display"> Affichage et gestion des livres </a><br /> <br />
	</div>
</body>
</html>