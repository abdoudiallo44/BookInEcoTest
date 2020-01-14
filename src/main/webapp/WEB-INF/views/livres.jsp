<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bouttonConnexionInscription.css"/>">
<title>Livres</title>
<meta charset="UTF-8">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">BookInEco</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<!-- <a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a>  -->

					<form action="/projettest/livres/findByKey" method="post"
						class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="text" name="motCle"
							placeholder="Rechercher un livre" aria-label="Rechercher">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
					</form>
				</li>

			</ul>
			<div class="float-right">

				<ul class="navbar-nav mr-auto">
					<li>${utilisateurName}</li>
					<li class="nav-item active">
						<!-- <a class="nav-link" href="#">Home<span class="sr-only">(current)</span></a>  -->

						(<a href="/projettest/login/deconnexion">Déconnexion</a>)
					</li>
			</div>

		</div>

	</nav>

	</br>
	<hr />
<body>
	<h2>Gestion des Livres</h2>
	<hr />
	<div class="container">
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
					<td><input type="text" name="titre" value="${livreForm.titre}" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input type="text" name="description"
						value="${livreForm.description}" /></td>
				</tr>
				<tr>
					<td>Poids:</td>
					<td><input type="number" name="poids"
						value="${livreForm.poids}" /></td>
				</tr>
				<tr>
					<td>Format:</td>
					<td><input type="text" name="format"
						value="${livreForm.format}" /></td>
				</tr>
				<tr>
					<td>Photo:</td>
					<td><input type="text" name="photo" value="${livreForm.photo}" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Ajouter" /></td>
					<td></td>
				</tr>
			</table>

		</form>
	</div>
	<!-- 
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
	</div><br /><br />-->
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
						<td><img src="<c:url value="/resources/img/${l.photo}.jpg"/>"></td>
						<td>${l.auteur}</td>
						<td>${l.titre}</td>
						<td>${l.description}</td>
						<td>${l.proprietaire.nom}${l.proprietaire.prenom}</td>
						<td><a href="/projettest/panier/supprimer/${l.id}">Supprimer</a></td>
					</tr>
				</c:forEach>
</body>
</html>