<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<<<<<<< HEAD
<%@ page session="false"%>
=======
>>>>>>> refs/heads/yohan
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
		<form action="/projettest/login/authentification" method="post">
			<div>
				<h2 class="c-text--heading c-text--left c-text">Se connecter</h2>
			</div>
			</br>
			<div class="form-group">
				<table>
					<tr>
						<!-- <th><label for="exampleInputEmail1">Adresse mail</label></th> -->
<<<<<<< HEAD
						<td>
							<input type="text" class="form-control" id="exampleInputEmail1" name="login" aria-describedby="emailHelp" placeholder="Email ou pseudo" required>
						</td>
						
=======
						<td><input type="text" class="form-control"
							id="exampleInputEmail1" name="login" aria-describedby="emailHelp"
							placeholder="Email ou pseudo" required></td>

>>>>>>> refs/heads/yohan
					</tr>

				</table>
			</div>

			<div class="form-group">
				<table>
					<tr>
						<!-- <th><label for="exampleInputPassword1">Mot de passe</label></th> -->
<<<<<<< HEAD
						
						<td>
							<input type="password" class="form-control" name="pass" id="exampleInputPassword1" placeholder="Mot de passe" required>
=======

						<td><input type="password" class="form-control" name="pass"
							id="exampleInputPassword1" placeholder="Mot de passe" required>
>>>>>>> refs/heads/yohan
						</td>

					<tr align="center">
						<!-- <th>  </th> -->
<<<<<<< HEAD
						<td><button type="submit" value="Connexion" class="btn btn-primary">Se connecter</button></td>
=======
						<td><button type="submit" value="Connexion"
								class="btn btn-primary">Se connecter</button></td>
>>>>>>> refs/heads/yohan
					</tr>

				</table>
			</div>
			<div>
<<<<<<< HEAD
				<p style="color:red;">${msg}</p>
			</div>
			
			
			
			
			
=======
				<p style="color: red;">${msg}</p>
			</div>

>>>>>>> refs/heads/yohan
		</form>
	</div>
</body>
</html>