<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
</head>
<body>
	<br />
	<div align="center" class="container" class="form-group row">
	
		<form:form action="/projettest/inscription/validation" method="post" modelAttribute="registerForm">
			<div>
				<h2 class="c-text--heading c-text--left c-text">S'inscrire</h2>
			</div>
			</br>
			<div class="form-group">
				<table>
					<tr>
						<td>
							<form:input type="text" path="email" aria-describedby="emailHelp" placeholder="Email" value="${RegisterForm.email}"/>
						</td>
						
						<td>
							<p style="color: red"><form:errors path="email" /></p>
						</td>
					</tr>
					<tr>
						<td>
							<form:input type="text" path="pseudo" aria-describedby="pseudoHelp" placeholder="Pseudo" value="${RegisterForm.pseudo}"/>
						</td>
						<td>
							<p style="color: red"><form:errors path="pseudo" /></p>
						</td>
					</tr>
					<tr>
						<td>
							<form:input type="password" path="mdp" aria-describedby="passHelp" placeholder="Password" value="${RegisterForm.mdp}"/>
						</td>
						<td>
							<p style="color: red"><form:errors path="mdp" /></p>
						</td>
					</tr>
					<tr align="center">
						<td><form:button type="submit" value="Inscription" class="btn btn-primary">S'inscrire</form:button></td>
					</tr>			
				</table>
			</div>		
		</form:form>
		
	
		<!-- <form action="/projettest/inscription/validation" method="post">
			<div>
				<h2 class="c-text--heading c-text--left c-text">S'inscrire</h2>
			</div>
			</br>
			
			<div class="form-group">
				<table>
					<tr>
						<td>
							<input type="text" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Email" required>
						</td>
						
					</tr>
				
				</table>
			</div>			
			<div class="form-group">
				<table>
					<tr>
						<td>
							<input type="text" class="form-control" id="pseudo" aria-describedby="pseudolHelp" placeholder="Pseudo" required>
						</td>						
					</tr>	
				</table>
			</div>
			
			<div class="form-group">
				<table>
					<tr>
						<td>
							<input type="password" class="form-control" id="pass" placeholder="Mot de passe">
						</td>
					
					<tr align="center">
						<td><button type="submit" value="Inscription" class="btn btn-primary">S'inscrire</button></td>
					</tr>
				</table>
			</div>
		</form> -->
		
		<div>
			<p style="color: red;">${msg}</p>
		</div>
	</div>
</body>
</html>