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
<link rel="stylesheet"
	href="<c:url value="/resources/css/bookinecoStyle.css"/>">
	

	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
	<!-- balise permettant de préfixer les liens -->
		<base href="<%=request.getScheme()+"://"
					+ request.getServerName() + ":"
					+ request.getServerPort()
					+ request.getContextPath() + "/"%>" />
					
	<script type="text/javascript" src="/BookInEcoTest/src/main/webapp/resources/css/validatePassword.jsp"></script>
<title>Home</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a style="width: 15%" class="navbar-brand" href=""><img width="100%" alt="logo" src="resources/img/bookin-titre.gif" /></a>
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

					<form action="livres/findByKey" method="post"
						class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search" name="motCle"
							placeholder="Rechercher un livre ou un auteur" aria-label="Rechercher">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Rechercher</button>
					</form>
				</li>

			</ul>
			<c:if test="${not empty sessionScope.user}">
					<a style="margin: 2px" class="btn btn-outline-primary" href="messagerie" role="button"><i class="fa fa-envelope fa-2x"></i></a>
					<a style="margin: 2px" class="btn btn-outline-primary" href="gestionLivre" role="button">Mes livres</a>
					<a style="margin: 2px" class="btn btn-outline-primary" href="panier" role="button">Mon panier</a>
					<a style="margin: 2px" class="btn btn-outline-primary" href="displayProfil" role="button">Profil</a>
				</div>
				<div class="float-right">
					Bonjour ${sessionScope.user.prenom}
					<a class="btn btn-primary" href="login/deconnexion"
						role="button">Deconnexion</a>
				</div>
			</c:if>

			<c:if test="${empty sessionScope.user}">
				<div class="float-right">
					<a class="btn btn-primary" href="login" role="button">Connexion</a>
					<a class="btn btn-primary" href="inscription" role="button">Inscription</a>
				</div>

			</c:if>
		</div>
	</nav>