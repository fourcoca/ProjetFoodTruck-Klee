<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="fr">
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
<body
	style="background-image: url(https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Lula_kebab_2.jpg/1200px-Lula_kebab_2.jpg)";
>
	<%@ include file="nav.jsp"%>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>
			<div class="col-sm-8 ">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<h1>Modification PRODUIT</h1>
						<a href="/admin/listCatalogue">Modifier</a> <a
							href="/admin/ajouterCatalogue">Ajouter</a> <a
							href="/admin/listCatalogue">supprimer</a>
					</div>
				</nav>
				<div class="container" style="background-color: green;">
					
					<form action="" method="post" modelAttribute="catalogues"
						style="background-color: green;">
						<div class="form-group">
							<label class="control-label col-sm-2">image:</label>
							<div class="col-sm-10">
								<input type="text" value="${produitAmodifier.image}" class="form-control" id="ei"
								
									placeholder="Entrer l'image du produit " name="image">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">nom:</label>
							<div class="col-sm-10">
								<input type="text" value="${produitAmodifier.nom}" class="form-control" id="em"
									placeholder="Entrer le nom du produit" name="nom">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Prix:</label>
							<div class="col-sm-10">
								<input type="number"  value="${produitAmodifier.prix}" class="form-control" id="ema"
									placeholder="Entrer le prix du produit" name="prix" value="25">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Stock:</label>
							<div class="col-sm-10">
								<input type="number" value="${produitAmodifier.stock }" class="form-control" id="l"
									placeholder="Entrer le stock du produit" name="stock"
									value="25">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Description:</label>
							<div class="col-sm-10">
								<input type="text" value="${produitAmodifier.description}" class="form-control" id="il"
									placeholder="Entrer la description du produit"
									name="description">
							</div>
						</div>
						<div class="form-group">
							
							<div class="col-sm-10">
								<div class="form-group">
									<label for="aill">Famille</label> <select class="form-control"
										id="aill" name="famille">
										<option value="boisson froide" <c:if test="${produitAmodifier.famille.equals('boisson froide')}">selected</c:if>>boisson froide</option>
										<option value="boisson chaude" <c:if test="${produitAmodifier.famille.equals('boisson chaude')}">selected</c:if>>boisson chaude</option>
										<option value="entree" <c:if test="${produitAmodifier.famille.equals('entree')}">selected</c:if>>entree</option>
										<option value="plat" <c:if test="${produitAmodifier.famille.equals('plat')}">selected</c:if>>plat</option>
										<option value="dessert" <c:if test="${produitAmodifier.famille.equals('dessert')}">selected</c:if>>dessert</option>
									</select>
								</div>
							</div>
						</div>
						
						<h1>Jours de Disponibilité:</h1>
						<div class="row">
							<div class="col-sm-4">
								<input type="checkbox" id="e587" value="1" name="lundi" <c:if test="${produitAmodifier.disponibilite.contains('1')}">checked</c:if>>lundi
							</div>
							<div class="col-sm-4">
								<input type="checkbox" id="e58" value="2" name="mardi" <c:if test="${produitAmodifier.disponibilite.contains('2')}">checked</c:if>>mardi
							</div>
							<div class="col-sm-4">
								<input type="checkbox" id="e58" value="3" name="mercredi" <c:if test="${produitAmodifier.disponibilite.contains('3')}">checked</c:if>>mercredi
							</div>
						</div>
						<div class="row">
							<div class="col-sm-4">
								<input type="checkbox" id="e587" value="4" name="jeudi"  <c:if test="${produitAmodifier.disponibilite.contains('4')}">checked</c:if>>jeudi
							</div>
							<div class="col-sm-4">
								<input type="checkbox" id="e58" value="5" name="vendredi" <c:if test="${produitAmodifier.disponibilite.contains('5')}">checked</c:if>>vendredi
							</div>
							<div class="col-sm-4">
								<input type="checkbox" id="e58" value="6" name="samedi" <c:if test="${produitAmodifier.disponibilite.contains('6')}">checked</c:if>>samedi
							</div>
							<div class="col-sm-4">
								<input type="checkbox" id="e58" value="7" name="dimanche" <c:if test="${produitAmodifier.disponibilite.contains('7')}">checked</c:if>>dimanche
							</div>
						</div>
						<h1>TYPE DE REPAS :</h1>
						<div class="row">
							<div class="col-sm-4">
								<input type="checkbox" id="e587" value="Petit_Dejeuner"
									name="ptdej" <c:if test="${produitAmodifier.estPD()}">checked</c:if>>petit-dejeuner
							</div>
							<div class="col-sm-4">
								<input type="checkbox" id="e587" value="Dejeuner" name="dej" <c:if test="${produitAmodifier.estD()}">checked</c:if>>dejeuner
							</div>
							<div class="col-sm-4">
								<input type="checkbox" id="e587" value="Diner" name="r" <c:if test="${produitAmodifier.estDiner()}">checked</c:if>>Diner
							</div>
							<div class="col-sm-4">
								<input type="checkbox" id="e587" value="Gouter" name="g" <c:if test="${produitAmodifier.estG()}">checked</c:if>>>gouter
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">Modifier
									Produit</button>
							</div>
						</div>
					</form>
				</div>
</body>
</html>