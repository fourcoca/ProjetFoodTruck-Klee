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
<%@ include file="nav.jsp" %>
<p>Merci pour votre achat la commande ${commande.id} à bien été prise en compte avec les achats suivants :</p>
<table class="table">
		<thead>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Produit</th>
				<th scope="col">Prix unitaire</th>
				<th scope="col">Quantité</th>
				<th scope="col">Destination</th>
				<th scope="col">Etat</th>
				<th scope="col">Frais de port</th>
				<th scope="col">Prix total</th>
			</tr>
		</thead>
		<c:forEach items="${commande.getLignes()}" var="ligne">

			<tbody>
				<tr>
					<th>${ligne.dateDeLivraison }</th>
					<th>${ligne.produit.nom }</th>
					<th>${ligne.produit.prix }</th>
					<th>${ligne.quantite}</th>
					<th>${ligne.adresse }</th>
					<th>${ligne.getEtat() }</th>
					<th>${ligne.getFrais() }</th>
					<th>${ligne.getPrix() }</th>
				</tr>
			</tbody>
		</c:forEach>
		<tfoot>
			<tr>
				<th>Totals</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th>${commande.getPrixTotal() }</th>
			</tr>
		</tfoot>
	</table>
<h1>VALIDER</h1>
</body>
</html>