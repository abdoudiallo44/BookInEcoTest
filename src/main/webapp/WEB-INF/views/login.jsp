<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<meta charset="UTF-8">
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
						
						<td>
							<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email ou pseudo" required>
						</td>
						
					</tr>
				
				</table>
			</div>
			
			<div class="form-group">
				<table>
					<tr>
						<!-- <th><label for="exampleInputPassword1">Mot de passe</label></th> -->
						
						<td>
							<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Mot de passe" required>
						</td>
						
					</tr>
					<tr>
						<th>  </th>
					</tr>
					<tr>
						<th>  </th>
					</tr>
					<tr>
						<th>  </th>
					</tr>
					<tr>
						<th>  </th>
					</tr>
					
					<tr>
						<th>  </th>
					</tr>
					
					
					<tr align="center">
						<!-- <th>  </th> -->
						<td><button type="submit" value="Recherche" class="btn btn-primary">Se connecter</button></td>
					</tr>
				
				</table>
			</div>
			
			
			
			
			
			
		</form>
	</div>
	
	
	
	

</body>
</html>