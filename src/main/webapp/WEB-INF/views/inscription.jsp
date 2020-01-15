<%@include file="header.jsp" %>
<%@ page session="true"%>
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
		
		<%-- <div>
			<p style="color: red;">${msg}</p>
		</div> --%>
	</div>
</body>
</html>