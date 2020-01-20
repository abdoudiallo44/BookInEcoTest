<%@include file="header.jsp"%>

<br />
<div align="center" class="container">

	<form:form action="inscription/validation" method="post"
		modelAttribute="registerForm">
		<div>
			<h2 class="c-text--heading c-text--left c-text">S'inscrire</h2>
		</div>
		</br>
		<div class="form-group">
			<table>
				<tr>
					<td><form:input type="text" path="prenom" class="form-control"
							placeholder="Prénom" value="${RegisterForm.prenom}" /></td>

					<td>
						<p style="color: red">
							<form:errors path="prenom" />
						</p>
					</td>
				</tr>
				<tr>
					<td><form:input type="text" path="nom" class="form-control"
							placeholder="Nom" value="${RegisterForm.nom}" /></td>

					<td>
						<p style="color: red">
							<form:errors path="nom" />
						</p>
					</td>
				</tr>
				<tr>
					<td><form:input type="date" path="dateDenaissance" class="form-control"
							value="${RegisterForm.dateDenaissance}" /></td>
					<td>
						<p style="color: red">
							<form:errors path="dateDenaissance" />
						</p>
					</td>
				</tr>
				
				
				
				
				<tr>
					<td><form:input type="email" path="email" class="form-control"
							placeholder="exemple@domaine.fr" value="${RegisterForm.email}" /></td>

					<td>
						<p style="color: red">
							<form:errors path="email" />
						</p>
					</td>
				</tr>
				<tr>
					<td><form:input type="text" path="pseudo"
							aria-describedby="pseudoHelp" class="form-control"
							placeholder="Pseudo" value="${RegisterForm.pseudo}" /></td>
					<td>
						<p style="color: red">
							<form:errors path="pseudo" />
						</p>
					</td>
				</tr>
				<tr>
					<td><form:input type="password" path="mdp"
							aria-describedby="passHelp" class="form-control"
							placeholder="Mot de passe" value="${RegisterForm.mdp}" /></td>
					<td>
						<p style="color: red">
							<form:errors path="mdp" />
						</p>
					</td>
				</tr>
				<tr>
					<td><form:input type="password" path="mdp2"
							aria-describedby="passHelp" class="form-control"
							placeholder="Confirmer le Mot de passe"
							value="${RegisterForm.mdp2}" /></td>
					<td>
						<p style="color: red">
							<form:errors path="mdp2" />
						</p>
					</td>
				</tr>
				<tr align="center">
					<td><form:button type="submit" value="Inscription"
							class="btn btn-primary">S'inscrire</form:button></td>
				</tr>
				<span id="msg"></span>
			</table>
		</div>
	</form:form>

	<%-- <div>
			<p style="color: red;">${msg}</p>
		</div> --%>
</div>
</body>
</html>