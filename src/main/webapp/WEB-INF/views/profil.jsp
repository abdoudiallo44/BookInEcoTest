<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
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
<title>Insert title here</title>
</head>
<body>
	</br>
	<div align="center" class="container" class="form-group row">
	
		<form:form action="/projettest/inscription/validation" method="post" modelAttribute="infosForm">
			<div>
				<h2 class="c-text--heading c-text--left c-text">Modifier vos informations</h2>
			</div>
			</br>
			<div class="form-group">
				<table>
					<tr>
						<td>
							<form:input type="text" path="nom" aria-describedby="nomHelp" placeholder="Nom" value="${RegisterForm.nom}"/>
						</td>
					</tr>
					<%-- <tr>
						<td>
							<form:input type="text" path="prenom" aria-describedby="prenomHelp" placeholder="Prenom" value="${RegisterForm.prenom}"/>
						</td>
					</tr>
					<tr>
						<td>
							<form:input type="text" path="email" aria-describedby="emailHelp" placeholder="Email" value="${RegisterForm.email}"/>
						</td>
					</tr>
					<tr>
						<td>
							<form:input type="text" path="pseudo" aria-describedby="pseudoHelp" placeholder="Pseudo" value="${RegisterForm.pseudo}"/>
						</td>
					</tr>
					<tr>
						<td>
							<form:input type="password" path="mdp" aria-describedby="passHelp" placeholder="Password" value="${RegisterForm.mdp}"/>
						</td>
					</tr> --%>
					<tr align="center">
						<td><form:button type="submit" value="ModificationCoordonnees" class="btn btn-primary">Enregistrer</form:button></td>
					</tr>			
				</table>
			</div>		
		</form:form>
</body>
</html>