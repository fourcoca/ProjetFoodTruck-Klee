

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="/accueil">FoodTruck</a>
      </div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="/accueil">Accueil</a></li>
        <li><a href="/catalogue">Catalogue</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<c:if test="${empty sessionScope.utilisateur}">
        <li><a href="/inscription"><span class="glyphicon glyphicon-user"></span> Inscription</a></li>
        <li><a href="/connexion"><span class="glyphicon glyphicon-log-in"></span> Connexion</a></li>
        </c:if>
        <c:if test="${not empty sessionScope.utilisateur}">
        <li style="background-color: gray;">Bonjour ${utilisateur.nom}</li>
        <li><a href="/panier"><span class="glyphicon glyphicon-cutlery"></span> panier</a></li>
		<li><a href="/profil"><span class="glyphicon glyphicon-user"></span> profil</a></li>
        <li><a href="/deconnexion"><span class="glyphicon glyphicon-off"></span> deconnexion</a></li>
		</c:if>
      </ul>
    </div>
  </nav>