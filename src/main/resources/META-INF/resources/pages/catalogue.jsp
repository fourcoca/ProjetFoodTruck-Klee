<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="nav.jsp"%>


	<div class="col-sm-12 ">
		<c:if test="${not empty date and not empty livraison}">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<p>Commande pour le ${date} et pour le mode de livraison :
							${livraison } � ${heure }</p>
					</div>
				</div>
			</nav>
		</c:if>
		<c:if test="${not empty utilisateur}">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">Saisir une date </a>
					</div>

					<form class="navbar-form navbar-left" method="post"
						action="/date-livraison">
						<div class="form-group">
							<input type="date" name="date" value="${date}"
								class="form-control"> <input type="time" id="heure"
								value="${heure}" name="heure" min="06:00" max="22:00" required>


							<input type="radio" class="custom-control-input" id="Domicile"
								value="Domicile" name="livraison"
								<c:if test="${empty utilisateur.adresse}">
				disabled
			</c:if>
			<c:if test="${not empty livraison && livraison.equals('Domicile')}">checked</c:if>
			>
							<label class="custom-control-label" for="Domicile">Livraison
								� Domicile</label> <input type="radio" class="custom-control-input"
								id="Societe" value="Societe" name="livraison"
								<c:if test="${empty utilisateur.societe}">
				disabled
			</c:if><c:if test="${not empty livraison && livraison.equals('Societe')}">checked</c:if>>
							<label class="custom-control-label" for="Societe">Livraison
								� la soci�t�</label> <input type="radio" class="custom-control-input"
								id="SurPlace" value="Sur Place" name="livraison" <c:if test="${empty livraison || livraison.equals('Sur Place')}">checked</c:if>>
							<label class="custom-control-label" for="SurPlace">Sur
								place</label> 
								
								
								<label for="Famille">Famille de repas</label> <select
								class="form-control" id="Famille" name="Famille">
								
								
								
								<c:forEach items="${catalogue.getFamille()}" var="fam">
									<option value="${fam}" <c:if test="${not empty famille && fam.equals(famille)}">selected</c:if> >${fam}</option>
								</c:forEach>
								
									
								
							</select> <label for="Type">Type de repas</label> <select
								class="form-control" id="Type" name="Type">
								
								
								
								<c:forEach items="${catalogue.getType()}" var="typeO">
									<option value="${typeO.nom}"  <c:if test="${not empty type && typeO.nom.equals(type)}">selected</c:if> >${typeO.nom}</option>
								</c:forEach>
								
								
								
							</select>


						</div>
						<button type="submit" class="btn btn-default">Appliquer</button>
					</form>
				</div>
			</nav>
		</c:if>
		<c:if test="${(not empty date)|| empty utilisateur}">

			<div class="">
			<c:if test="${empty utilisateur}">
				<nav class="navbar navbar-default">
					<div class="container-fluid">

						<div class="navbar-header">
							<a class="navbar-brand" href="#">Rechercher : </a>
						</div>

						<form class="navbar-form navbar-left" action="/recherche">
							<div class="form-group">
								<input type="text" name="mot" class="form-control"
									placeholder="Cocca" required>
							</div>
							<!-- 						<div class="form-group"> -->
							<!-- 						    <label for="Famille">Famille de repas</label> -->
							<!-- 						    <select class="form-control" id="Famille" name="Famille"> -->
							<%-- 						      <c:forEach items="${catalogue.getFamille()}" var="fam"> --%>
							<%-- 						      	<option value="${fam}">${fam}</option> --%>
							<%-- 						      </c:forEach> --%>
							<!-- 						    </select> -->
							<!-- 						</div> -->
							<!-- 						<div class="form-group"> -->
							<!-- 						    <label for="Type">Type de repas</label> -->
							<!-- 						    <select class="form-control" id="Type" name="Type"> -->
							<%-- 						      <c:forEach items="${catalogue.getType()}" var="type"> --%>
							<%-- 						      	<option value="${type.nom}">${type.nom}</option> --%>
							<%-- 						      </c:forEach> --%>
							<!-- 						    </select> -->
							<!-- 						</div> -->


							<button type="submit" class="btn btn-default">Rechercher</button>

						</form>



						<form class="navbar-form navbar-left" action="/TypeMode">
							<button type="submit" name="ModeType" value=2
								class="btn btn-primary">Famille de repas</button>
						</form>
						<form class="navbar-form navbar-left" action="/TypeMode">
							<button type="submit" name="ModeType" value=1
								class="btn btn-primary">Type de repas</button>
						</form>
					</div>
				</nav>
				</c:if>
				<c:if test="${not empty detail}">
					<div class="col-sm-7 ">
				</c:if>
				<c:if test="${empty detail}">
					<div class="col-sm-12" > 
				</c:if>



				<c:if test="${(empty mode) || (mode==1) }">



					<c:if test="${ empty type ||  type.equals('Petit_Dejeuner')}">
						<h3 href="#"> <span class="glyphicon glyphicon-record"></span>Petit
							Dejeuner
						</h3>
						<div class="table-responsive" style="border:2px solid #cecece; margin-bottom:5px;">
							<table>
								<tr>
									<c:forEach items="${catalogue.getPetitDejeuner()}"
										var="produit">


										<%-- 						<c:if test="${not empty motRecherche && not empty type && not empty famille}"> --%>
										<%-- 						<p>${produit.nom.contains(motRecherche)}</p> --%>
										<%-- 						<p>${produit.foudType(type)}</p> --%>
										<%-- 						<p>${produit.famille.equals(famille))}</p> --%>
										<%-- 						</c:if> --%>
										<c:if
											test="${empty motRecherche|| produit.nom.toLowerCase().contains(motRecherche.toLowerCase())}">


											<%-- 							<c:if test="${not produit.famille.equals(famille)}"> --%>
											<!-- 										<p>Famille correspond pas</p> -->
											<%-- 										<p>${produit.famille}</p> --%>
											<%-- 										<p>${famille}</p> --%>
											<%-- 							</c:if> --%>
											<c:if
												test="${empty type || produit.foudType(type) && produit.famille.equals(famille)}">
												<td><p>
														<a href="/catalogue-${produit.id}">${produit.nom}</a>
													</p>
													<a href="/catalogue-${produit.id}"><img
														src="${produit.image}" alt="Image"></a>
													<p>${produit.prix}<span
															class="glyphicon glyphicon-euro" aria-hidden="true"></span>
													</p> <c:if test="${not empty date}">
														<c:if test="${produit.isDispWeek(date)}">
															<p>Disponible pour cette date :) !</p>
														</c:if>
														<c:if test="${not produit.isDispWeek(date)}">
															<p>Pas disponible pour cette date :( !</p>
														</c:if>

													</c:if> <c:if test="${produit.stock==0}">
														<p>Stock vide !</p>
													</c:if> <c:if test="${produit.stock>0}">
														<p>En Stock !</p>
													</c:if></td>
											</c:if>
										</c:if>
									</c:forEach>
								</tr>
							</table>
						</div>

					</c:if>


					<c:if test="${ empty type || type.equals('Dejeuner') }">
						<h3 href="#"> <span class="glyphicon glyphicon-record"></span>Dejeuner
						</h3>
						<div class="table-responsive" style="border:2px solid #cecece; margin-bottom:5px;">
							<table>
								<tr>
									<c:forEach items="${catalogue.getDejeuner()}" var="produit">
										<c:if
											test="${empty motRecherche|| produit.nom.toLowerCase().contains(motRecherche.toLowerCase())}">
											<c:if
												test="${empty type || produit.foudType(type) && produit.famille.equals(famille)}">
												<td ><p>
														<a href="/catalogue-${produit.id}">${produit.nom}</a>
													</p>
													<a href="/catalogue-${produit.id}"><img
														src="${produit.image}" alt="Image"></a>
													<p>${produit.prix}<span
															class="glyphicon glyphicon-euro" aria-hidden="true"></span>
													</p> <c:if test="${not empty date}">
														<c:if test="${produit.isDispWeek(date)}">
															<p>Disponible pour cette date :) !</p>
														</c:if>
														<c:if test="${not produit.isDispWeek(date)}">
															<p>Pas disponible pour cette date :( !</p>
														</c:if>

													</c:if> <c:if test="${produit.stock==0}">
														<p>Stock vide !</p>
													</c:if> <c:if test="${produit.stock>0}">
														<p>En Stock !</p>
													</c:if></td>
											</c:if>
										</c:if>
									</c:forEach>
								</tr>
							</table>
						</div>
					</c:if>


					<c:if test="${ empty type ||  type.equals('Gouter') }">
						<h3 href="#"> <span class="glyphicon glyphicon-record"></span>Gouter
						</h3>
						<div class="table-responsive" style="border:2px solid #cecece; margin-bottom:5px;">
							<table>
								<tr>
									<c:forEach items="${catalogue.getGouter()}" var="produit">
										<c:if
											test="${empty motRecherche|| produit.nom.toLowerCase().contains(motRecherche.toLowerCase())}">
											<c:if
												test="${empty type || produit.foudType(type) && produit.famille.equals(famille)}">
												<td><p>
														<a href="/catalogue-${produit.id}">${produit.nom}</a>
													</p>
													<a href="/catalogue-${produit.id}"><img
														src="${produit.image}" alt="Image"></a>
													<p>${produit.prix}<span
															class="glyphicon glyphicon-euro" aria-hidden="true"></span>
													</p> <c:if test="${not empty date}">
														<c:if test="${produit.isDispWeek(date)}">
															<p>Disponible pour cette date :) !</p>
														</c:if>
														<c:if test="${not produit.isDispWeek(date)}">
															<p>Pas disponible pour cette date :( !</p>
														</c:if>

													</c:if> <c:if test="${produit.stock==0}">
														<p>Stock vide !</p>
													</c:if> <c:if test="${produit.stock>0}">
														<p>En Stock !</p>
													</c:if></td>
											</c:if>
										</c:if>
									</c:forEach>
								</tr>
							</table>
						</div>
					</c:if>


					<c:if test="${ empty type || type.equals('Diner') }">
						<h3 href="#"> <span class="glyphicon glyphicon-record"></span>Diner
						</h3>
						<div class="table-responsive" style="border:2px solid #cecece; margin-bottom:5px;">
							<table>
								<tr>
									<c:forEach items="${catalogue.getDiner()}" var="produit">
										<c:if
											test="${empty motRecherche || produit.nom.toLowerCase().contains(motRecherche.toLowerCase())}">
											<c:if
												test="${empty type || produit.foudType(type) && produit.famille.equals(famille)}">
												<td><p>
														<a href="/catalogue-${produit.id}">${produit.nom}</a>
													</p>
													<a href="/catalogue-${produit.id}"><img
														src="${produit.image}" alt="Image"></a>
													<p>${produit.prix}<span
															class="glyphicon glyphicon-euro" aria-hidden="true"></span>
													</p> <c:if test="${not empty date}">
														<c:if test="${produit.isDispWeek(date)}">
															<p>Disponible pour cette date :) !</p>
														</c:if>
														<c:if test="${not produit.isDispWeek(date)}">
															<p>Pas disponible pour cette date :( !</p>
														</c:if>

													</c:if> <c:if test="${produit.stock==0}">
														<p>Stock vide !</p>
													</c:if> <c:if test="${produit.stock>0}">
														<p>En Stock !</p>
													</c:if></td>
											</c:if>
										</c:if>
									</c:forEach>
								</tr>
							</table>
						</div>
					</c:if>
			</div>
		</c:if>





		<c:if test="${(not empty mode) && (mode==2)}">


			<a href="#"> <span class="glyphicon glyphicon-record"></span>Entree
			</a>
			<div class="table-responsive" style="border:2px solid #cecece; margin-bottom:5px;">
				<table>
					<tr>
						<c:forEach items="${catalogue.getEntr()}" var="produit">
							<c:if
								test="${( empty motRecherche) || produit.nom.toLowerCase().contains(motRecherche.toLowerCase())}">
								<td><p>
										<a href="/catalogue-${produit.id}">${produit.nom}</a>
									</p>
									<a href="/catalogue-${produit.id}"><img
										src="${produit.image}" alt="Image"></a>
									<p>${produit.prix}<span class="glyphicon glyphicon-euro"
											aria-hidden="true"></span>
									</p> <c:if test="${not empty date}">
										<c:if test="${produit.isDispWeek(date)}">
											<p>Disponible pour cette date :) !</p>
										</c:if>
										<c:if test="${not produit.isDispWeek(date)}">
											<p>Pas disponible pour cette date :( !</p>
										</c:if>

									</c:if> <c:if test="${produit.stock==0}">
										<p>Stock vide !</p>
									</c:if> <c:if test="${produit.stock>0}">
										<p>En Stock !</p>
									</c:if></td>
							</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>

			<a href="#"> <span class="glyphicon glyphicon-record"></span>Plat
			</a>
			<div class="table-responsive" style="border:2px solid #cecece; margin-bottom:5px;">
				<table>
					<tr>
						<c:forEach items="${catalogue.getPlat()}" var="produit">
							<c:if
								test="${( empty motRecherche) || produit.nom.toLowerCase().contains(motRecherche.toLowerCase())}">
								<td><p>
										<a href="/catalogue-${produit.id}">${produit.nom}</a>
									</p>
									<a href="/catalogue-${produit.id}"><img
										src="${produit.image}" alt="Image"></a>
									<p>${produit.prix}<span class="glyphicon glyphicon-euro"
											aria-hidden="true"></span>
									</p> <c:if test="${not empty date}">
										<c:if test="${produit.isDispWeek(date)}">
											<p>Disponible pour cette date :) !</p>
										</c:if>
										<c:if test="${not produit.isDispWeek(date)}">
											<p>Pas disponible pour cette date :( !</p>
										</c:if>

									</c:if> <c:if test="${produit.stock==0}">
										<p>Stock vide !</p>
									</c:if> <c:if test="${produit.stock>0}">
										<p>En Stock !</p>
									</c:if></td>
							</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>


			<h3> <span class="glyphicon glyphicon-record"></span>Dessert
			</h3>
			
			<div class="table-responsive" style="border:2px solid #cecece; margin-bottom:5px;">
				<table>
					<tr>
						<c:forEach items="${catalogue.getDessert()}" var="produit">
							<c:if
								test="${( empty motRecherche) || produit.nom.toLowerCase().contains(motRecherche.toLowerCase())}">
								<td><p>
										<a href="/catalogue-${produit.id}">${produit.nom}</a>
									</p>
									<a href="/catalogue-${produit.id}"><img
										src="${produit.image}" alt="Image"></a>
									<p>${produit.prix}<span class="glyphicon glyphicon-euro"
											aria-hidden="true"></span>
									</p> <c:if test="${not empty date}">
										<c:if test="${produit.isDispWeek(date)}">
											<p>Disponible pour cette date :) !</p>
										</c:if>
										<c:if test="${not produit.isDispWeek(date)}">
											<p>Pas disponible pour cette date :( !</p>
										</c:if>

									</c:if> <c:if test="${produit.stock==0}">
										<p>Stock vide !</p>
									</c:if> <c:if test="${produit.stock>0}">
										<p>En Stock !</p>
									</c:if></td>
							</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>



			<h3> <span class="glyphicon glyphicon-record"></span>Boisson
				Froide
			</h3>
			<div class="table-responsive" style="border:2px solid #cecece; margin-bottom:5px;">
				<table>
					<tr>
						<c:forEach items="${catalogue.getBfroide()}" var="produit">
							<c:if
								test="${( empty motRecherche) || produit.nom.toLowerCase().contains(motRecherche.toLowerCase())}">
								<td><p>
										<a href="/catalogue-${produit.id}">${produit.nom}</a>
									</p>
									<a href="/catalogue-${produit.id}"><img
										src="${produit.image}" alt="Image"></a>
									<p>${produit.prix}<span class="glyphicon glyphicon-euro"
											aria-hidden="true"></span>
									</p> <c:if test="${not empty date}">
										<c:if test="${produit.isDispWeek(date)}">
											<p>Disponible pour cette date :) !</p>
										</c:if>
										<c:if test="${not produit.isDispWeek(date)}">
											<p>Pas disponible pour cette date :( !</p>
										</c:if>

									</c:if> <c:if test="${produit.stock==0}">
										<p>Stock vide !</p>
									</c:if> <c:if test="${produit.stock>0}">
										<p>En Stock !</p>
									</c:if></td>
							</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>

			<h3> <span class="glyphicon glyphicon-record"></span>Boisson
				Chaude
			</h3>
			<div class="table-responsive" style="border:2px solid #cecece; margin-bottom:5px;">
				<table>
					<tr>
						<c:forEach items="${catalogue.getBchaude()}" var="produit">
							<c:if
								test="${( empty motRecherche) || produit.nom.toLowerCase().contains(motRecherche.toLowerCase())}">
								<td><p>
										<a href="/catalogue-${produit.id}">${produit.nom}</a>
									</p>
									<a href="/catalogue-${produit.id}"><img
										src="${produit.image}" alt="Image"></a>
									<p>${produit.prix}<span class="glyphicon glyphicon-euro"
											aria-hidden="true"></span>
									</p> <c:if test="${not empty date}">
										<c:if test="${produit.isDispWeek(date)}">
											<p>Disponible pour cette date :) !</p>
										</c:if>
										<c:if test="${not produit.isDispWeek(date)}">
											<p>Pas disponible pour cette date :( !</p>
										</c:if>

									</c:if> <c:if test="${produit.stock==0}">
										<p>Stock vide !</p>
									</c:if> <c:if test="${produit.stock>0}">
										<p>En Stock !</p>
									</c:if></td>
							</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>
	</div>
	</c:if>



















	<c:if test="${not empty detail}">
		<div class="table-responsive col-sm-4"  style="border:2px solid #cecece; margin-left:5px;">
			${detail.nom } <a href="/catalogue"><span
				class="glyphicon glyphicon-remove"></span></a>
			<c:if test="${empty date}">
				<img src="${detail.image}" alt="Image">
			</c:if>


			<c:if test="${not empty date}">
				<c:if test="${not detail.isDispWeek(date) && detail.stock>0}">
					<style>
					#detail {
						filter: grayscale(100%);
					}
					</style>
					<img src="${detail.image}" alt="Image" id=detail>
				</c:if>

				<c:if test="${detail.stock<=0}">
					<img src="${detail.getImageIn()}" alt="Image" id=detail>
				</c:if>
				<c:if test="${detail.stock>0 && detail.isDispWeek(date)}">
					<img src="${detail.image}" alt="Image" id=detail>
				</c:if>

			</c:if>



			<p>Famille :${detail.famille}</p>
			<p>Description :${detail.description}</p>
			<p>
				Prix :${detail.prix}<span class="glyphicon glyphicon-euro"
					aria-hidden="true"></span>
			</p>







			<c:if
				test="${not empty date && detail.isDispWeek(date) && detail.stock>0 && detail.isDispHour(date,heure,type)}">

				<form class="navbar-form navbar-left" method="post"
					action="/ajouter-panier-${detail.id}">
					<p>Quantite pour le ${date} et pour le mode de livraison :
						${livraison } a ${heure }h</p>
					Quantite : <input type="number" class="form-control" id="quantite"
						min=1 placeholder="1" value=1 name="quantite">
					<button type="submit" class="btn btn-success">Ajouter au
						Panier</button>
				</form>
			</c:if>
			<c:if test="${not empty date && not detail.isDispWeek(date)}">
				<p>Pas disponible pour cette date :( !</p>
			</c:if>

			<c:if
				test="${not empty date && not detail.isDispHour(date,heure,type)}">
				<p>Pas disponible pour cette heure l� :( !</p>
			</c:if>
			<c:if test="${detail.stock<=0}">
				<p>Stock vide !</p>
			</c:if>

			<c:if test="${empty utilisateur}">
				<p>Connectez vous pour pouvoir ajouter au panier</p>
			</c:if>
			<c:if test="${empty date && not empty utilisateur}">
				<p>Appliquez une date de livraison pour pouvoir ajouter au
					panier</p>
			</c:if>
		</div>
	</c:if>
	</c:if>
	</div>
	</div>

		<%@ include file="footer.jsp"%>	

</body>
</html>