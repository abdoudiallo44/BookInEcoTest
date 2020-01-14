<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Home</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/projettest/">BookInEco</a>
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

					<form action="/projettest/livres/findByKey" method="post" class="form-inline my-2 my-lg-0" >
						<input class="form-control mr-sm-2" type="search" name="motCle"
							placeholder="Rechercher un livre" aria-label="Rechercher">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
					</form>
				</li>

			</ul>
			<c:if test="${not empty sessionScope.user}">
			<div>
				<a class="btn btn-outline-primary" href="/projettest/gestionLivre"
					role="button">Mes livres</a> <a class="btn btn-outline-primary"
					href="/projettest/panier" role="button">Mon panier</a>
			</div>
			<div class="float-right">
				<a class="btn btn-primary" href="/projettest/login/deconnexion"
					role="button">Deconnexion</a>
					</div>
			</c:if>
			<c:if test="${empty sessionScope.user}">
			<div class="float-right">
				<a class="btn btn-primary" href="/projettest/login" role="button">Connexion</a>
				<a class="btn btn-primary" href="/projettest/inscription" role="button">Inscription</a>
			</div>

			</c:if>
		</div>

	</nav>
	<br />

<div class="container">
	<table class="table">
		<tbody>
			<c:forEach var="l" items="${listeLivre}">
				<tr>
				<td><img src="<c:url value="/resources/img/${l.photo}.jpg"/>"></td>
					<td>Auteur : ${l.auteur} </br> 
					Titre : ${l.titre} </br>
					Format : ${l.format}</br>
					Etat : ${l.etat} </br>
					Propriétaire : ${l.proprietaire.nom} ${l.proprietaire.prenom}
					<td>Description : ${l.description}</td>
					<td><a class="btn btn-warning" <c:if test="${not empty sessionScope.user}"> href="/projettest/ajoutPanier/${l.id}"</c:if>
					<c:if test="${empty sessionScope.user}"> href="/projettest/login"</c:if>
					role="button">Ajouter au panier</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	</div>

</body>
</html>
