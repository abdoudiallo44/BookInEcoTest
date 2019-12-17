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
		<form action="/projettest/inscription/validation" method="post">
			<div>
				<h2 class="c-text--heading c-text--left c-text">S'inscrire</h2>
			</div>
			</br>
			
			<div class="form-group">
				<table>
					<tr>
						<td>
							<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email">
						</td>
						
					</tr>
				
				</table>
			</div>
			
			
			<div class="form-group">
				<table>
					<tr>
						<td>
							<input type="text" class="form-control" id="exampleInputPseudo" aria-describedby="pseudolHelp" placeholder="Pseudo">
						</td>
						
					</tr>
				
				</table>
			</div>
			
			<div class="form-group">
				<table>
					<tr>
						<td>
							<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Mot de passe">
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
						<td><button type="submit" value="Inscription" class="btn btn-primary">S'inscrire</button></td>
					</tr>
				
				</table>
			</div>

		</form>


	</div>
</body>
</html>