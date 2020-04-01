<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
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

<style>
.box {
	display: grid;
	grid-template-columns: 1fr 1fr 1fr;
	grid-gap: 10px 2em;
}

.box :first-child {
	align-self: center;
}

.bigorange {
	color: orange;
}
.carousel-caption h2 {
    text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
}
.carousel-caption h3 {
    text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
}
</style>

</head>

<body>



	<%@ include file="nav.jsp"%>












	<div class="container-fluid text-center">
		<div class="row content">

			<div class="col-sm-4 sidenav ">
			<c:forEach items="${top3}" var="produit">
				<div style="border:2px solid #cecece; margin-bottom:5px;">
					
				<h3>${produit.nom}</h3>
				<p>
					<a
						href="/catalogue-${produit.id}"><img src="${produit.image}" alt="Image" height="50%" width="50%" > </a>
				</p>
				<p>${produit.getDisponibiliteString()}</p>
				<h4 class=bigorange>${produit.prix}<span class="glyphicon glyphicon-euro" aria-hidden="true"></span></h4>
 				</div> 
			</c:forEach>
			</div>





			<div class="col-sm-8 text-left">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img
								src="http://127.0.0.1:8887/carrousel/promotion.png"
								alt="Image">

							<div class="carousel-caption">
								<h2 >Promotion</h2>
								<h3 >Tiramisu à seulement 8<span class="glyphicon glyphicon-euro" aria-hidden="true"></span> au lieu de 9<span class="glyphicon glyphicon-euro" aria-hidden="true"></span></h3>
							</div>
						</div>

						<div class="item ">
							<img
								src="http://127.0.0.1:8887/carrousel/NouveauProduit.png"
								alt="Image">
							<div class="carousel-caption">
							</div>
						</div>
						
						<div class="item ">
							<img
								src="http://127.0.0.1:8887/carrousel/Annonce.png"
								alt="Image">
							<div class="carousel-caption">
								<h2 >Annonce</h2>
								<h3>Désormais ouvert même le dimanche !</h3>
							</div>
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>


				<h1>Description:</h1>
				<p>En gratin de saison aux pâtes, blettes et béchamel</p>
				<p>Cuisson simultanément des tomates, des aubergines, des
					courgettes et des onions</p>
				<p>Vert de blettes crus, ricotta, Parmigiano Reggiano, noix de
					muscade râpée</p>
				<img
					src="https://th.bing.com/th?id=OIP.joYBopkGghqRYQA5QoUJHQHaFj&pid=Api&rs=1">
			</div>

		</div>
	</div>
	<%@ include file="space.jsp"%>

	<%@ include file="footer.jsp"%>
</body>
</html>