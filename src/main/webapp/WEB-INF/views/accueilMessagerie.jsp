<%@include file="header.jsp"%>
<h2>Ma messagerie</h2><br/>

<a class="btn btn-warning" 
							<c:if 
								test="${not empty sessionScope.user}"> href="reponseMessage"
							</c:if> role="button">R�diger un message
						</a>
<table class="table"><br/>
	<tbody>
	<br/><div class="messagesrecus">Vos derniers messages re�us : </div>
		<c:forEach var="m" items="${listeMessage}">
		
			<tr>
			
				<td><strong>Exp�diteur : </strong>${m.expediteur.pseudo} </br> 
					<strong>Objet :</strong> ${m.titreMessage} </br> 
					<strong>Date de r�ception : </strong>${m.dateEnvoi}
				</td>
				<td>
						<a class="btn btn-warning" 
							<c:if 
								test="${not empty sessionScope.user}"> href="contenuMessage/${m.id}"
							</c:if> role="button">Voir
						</a>
						
						<a class="btn btn-warning" 
							<c:if 
								test="${not empty sessionScope.user}"> href="supprimerMessage/${m.id}"
							</c:if> role="button">Supprimer</a>	
						</a>
					</td></br>
				</br>
			</tr>
		</c:forEach>

	</tbody>
	</table>

	</body>
	</html>