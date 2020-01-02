<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	</div><br /><br />
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
					<td>photo</td>
					<td>${l.auteur}</td>
					<td>${l.titre}</td>
					<td>${l.description}</td>
					<td>${l.proprietaire.nom} ${l.proprietaire.prenom}</td>
					<td><a href="/projettest/panier/supprimer/${l.id}">Supprimer</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	</div>

</body>
</html>