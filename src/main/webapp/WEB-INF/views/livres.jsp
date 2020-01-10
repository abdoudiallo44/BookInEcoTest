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
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<<<<<<< HEAD
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">BookInEco</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<hr />
		<br /> <br />
=======
<h2>Gestion des Livres </h2>
	<hr />
	<br />
	<br />
	<div class="container">
		<form action="/projettest/livres/ajouterLivre" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id" readOnly="true" value="${livreForm.id}"/></td>
			</tr>
			<tr>
				<td>Auteur:</td>
				<td><input type="text" name="auteur" value="${livreForm.auteur}"/></td>
			</tr>
			<tr>
				<td>Titre:</td>
				<td><input type="text" name="titre" value="${livreForm.titre}"/></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description" value="${livreForm.description}"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Valider" /></td>
				<td></td>
			</tr>
		</table>
		
		</form>
	</div>
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
					<td><img src="/ressources/img/${l.photoLivre}.jpg"></td>
					<td>${l.auteur}</td>
					<td>${l.titre}</td>
					<td>${l.description}</td>
					<td>${l.proprietaire.nom} ${l.proprietaire.prenom}</td>
					<td><a href="/projettest/livres/supprimer/${l.id}">Supprimer</a> |<a href="/projettest/livres/modifier/${l.id}"> Modifier</a></td>
				</tr>
			</c:forEach>
>>>>>>> refs/heads/yohan

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

	<div class="container">
		<form:form action="/projettest/livres/ajouterLivre" method="post"
			modelAttribute="livreForm">


			<table>
				<tr>
					<td><span class="input-group-text" id="addon-wrapping">ID</span></td>
					<td><form:input class="form-control" type="text"
							path="idLivre" value="${livreForm.idLivre}" /></td>
				</tr>
				<tr>
					<td><span class="input-group-text" id="addon-wrapping">Auteur</span></td>
					<td><form:input class="form-control" type="text" path="auteur"
							value="${LivreForm.auteur}" /></td>
					<td><p>
							<form:errors path="auteur" />
						</p></td>
				</tr>
				<tr>
					<td><span class="input-group-text" id="addon-wrapping">Tritre</span></td>
					<td><form:input class="form-control" type="text" path="titre"
							value="${LivreForm.titre}" /></td>
					<td><p>
							<form:errors path="titre" />
						</p></td>
				</tr>
				<tr>
					<td><span class="input-group-text" id="addon-wrapping">Description</span></td>
					<td><form:input class="form-control" type="text"
							path="description" value="${LivreForm.description}" /></td>
					<td><p>
							<form:errors path="description" />
						</p></td>
				</tr>
				<tr>
					<td><span class="input-group-text" id="addon-wrapping">Photo
							livre</span></td>
					<td><form:input class="form-control" type="text"
							path="photoLivre" value="${LivreForm.photoLivre}" /></td>
					<td><p>
							<form:errors path="photoLivre" />
						</p></td>
				</tr>
				<tr>
					<td><span class="input-group-text" id="addon-wrapping">Poids
							du livre</span></td>
					<td><form:input class="form-control" type="text"
							path="poidsLivre" value="${LivreForm.poidsLivre}" /></td>
					<td><p>
							<form:errors path="poidsLivre" />
						</p></td>
				</tr>
				<tr>
					<td><span class="input-group-text" id="addon-wrapping">Format
							du livre</span></td>
					<td><form:input class="form-control" type="text"
							path="formatLivre" value="${LivreForm.formatLivre}" /></td>
					<td><p>
							<form:errors path="formatLivre" />
						</p></td>
				</tr>
				<tr>
					<td><span class="input-group-text" id="addon-wrapping">Date
							d'ajout</span></td>
					<td><form:input class="form-control" type="text"
							path="dateAjoutLivre" value="${LivreForm.dateAjoutLivre}" /></td>
					<td><p>
							<form:errors path="dateAjoutLivre" />
						</p></td>
				</tr>
				<tr>
					<td><span class="input-group-text" id="addon-wrapping">Disponibilté</span></td>
					<td><form:input class="form-control" type="text"
							path="disponibilite" value="${LivreForm.disponibilite}" /></td>
					<td><p>
							<form:errors path="disponibilite" />
						</p></td>
				</tr>
				<tr>
					<td><input class="form-control" type="submit" value="Valider" /></td>
					<td></td>
				</tr>
			</table>

		</form:form>
	</div>

	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Auteur</th>
					<th scope="col">Titre</th>
					<th scope="col">Description</th>
					<th scope="col">Photo</th>
					<th scope="col">Poids</th>
					<th scope="col">Format</th>
					<th scope="col">Date d'ajout</th>
					<th scope="col">Disponibilité</th>
					<th scope="col">Option</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${listeLivre }">
					<tr>
						<td>${p.id}</td>
						<td>${p.auteur}</td>
						<td>${p.titre}</td>
						<td>${p.description}</td>
						<td>${p.photoLivre}</td>
						<td>${p.poidsLivre}</td>
						<td>${p.formatLivre}</td>
						<td>${p.dateAjoutLivre}</td>
						<td>${p.disponibilite}</td>
						<td><a href="/projettest/livres/supprimer/${p.id}">Supprimer</a>
							|<a href="/projettest/livres/modifier/${p.id}"> Modifier</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>