<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>HISTORIQUE COMMANDES</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
.bigorange {
	color: orange;
}
</style>
</head>

<body
	style="background-image: url(https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Lula_kebab_2.jpg/1200px-Lula_kebab_2.jpg)">

	
	<%@ include file="../nav.jsp"%>


	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>
			<div class="col-sm-8 " style="background-color: Beige;">
				

				
				<%@ include file="navProfil.jsp"%>

				<h1>HISTORIQUE COMMANDES</h1>



				<c:forEach items="${historique}" var="commande">
				<h2>Commande numero "${commande.id}" :</h2>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Nom du produit</th>
								<th>Quantite</th>
								<th>Famille de produits</th>
								<th>Description</th>
								<th>Date De Livraison</th>
								<th>Prix unitaire</th>
								<th>Frais livraison</th>
								<th>Prix Total</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${commande.getLignes()}" var="ligne">
								<tr>
									<td>${ligne.produit.nom}</td>
									<td>${ligne.quantite}</td>
									<td>${ligne.produit.famille}</td>
									<td>${ligne.produit.description}</td>
									<td>${ligne.dateDeLivraison}</td>
									<td>${ligne.produit.prix}</td>
									<td>${ligne.getFrais()}</td>
									<td class=bigorange>${ligne.getPrix()}</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</c:forEach>


				<div class="col-sm-4 sidenav"></div>

				<footer class="container-fluid text-center">
					<p>
						<a href="">Nous contacter</a>
					</p>
				</footer>
</body>
</html>

