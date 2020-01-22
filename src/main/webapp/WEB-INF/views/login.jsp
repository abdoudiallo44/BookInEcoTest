<%@include file="header.jsp"%>
</br>
<div align="center" class="container" class="form-group row">
	<form action="login/authentification" method="post">
		<div>
			<h2 class="c-text--heading c-text--left c-text">Se connecter</h2>
		</div>
		</br>
		<div class="form-group">
			<table>
				<tr>
					<!-- <th><label for="exampleInputEmail1">Adresse mail</label></th> -->
					<td><input type="text" class="form-control"
						id="exampleInputEmail1" name="login" aria-describedby="emailHelp"
						placeholder="Email ou pseudo" required></td>
					<td>
						<p style="color: red">
							<c:if test="${ UnknownUser }">
								<p style="color: red">Identifiant inconnu</p>
							</c:if>
						</p>
					</td>

				</tr>

			</table>
		</div>

		<div class="form-group">
			<table>
				<tr>
					<!-- <th><label for="exampleInputPassword1">Mot de passe</label></th> -->
					<td><input type="password" class="form-control" name="pass"
						id="mdp" placeholder="Mot de passe" required>
				<tr align="center">
					<!-- <th>  </th> -->
					<td><button onclick="validatePassword()" type="submit"
							value="Connexion" class="btn btn-primary">Se connecter</button></td>

				</tr>

			</table>
		</div>
		<div></div>


	</form>
</div>
</body>
</html>