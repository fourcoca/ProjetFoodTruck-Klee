



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="">FoodTruck</a>
      </div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="">Accueil</a></li>
        <li><a href="">Catalogue</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<c:if test="${empty sessionScope.user}">
        <li><a href="/inscription"><span class="glyphicon glyphicon-user"></span> Inscription</a></li>
        <li><a href="/connexion"><span class="glyphicon glyphicon-log-in"></span> Connexion</a></li>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
        <li style="background-color: gray;">Bonjour ${user.nom}</li>
        <li><a href="/admin/listCatalogue"><span class="glyphicon glyphicon-cutlery"></span> Gestion Produits</a></li>
		
		
		
		 <li><a href="/admin/listCatalogue"><span class="glyphicon glyphicon-book"></span> Gestion Catalogue</a></li>
		
			
		<li><a href="/admin/modifierHoraire"><span class="glyphicon glyphicon-time"></span>Gestion Horaire</a></li>
		
		<li><a href="/admin/listUtilisateur"><span class="glyphicon glyphicon-user"></span> Gestion Utilisateur</a></li>
		
		<li><a href="/admin/listMessagerie"><span class="glyphicon glyphicon-envelope"></span> Messagerie</a></li>
		
		
        <li><a href="../deconnexion"><span class="glyphicon glyphicon-off"></span> deconnexion</a></li>
		
		
		</c:if>
      </ul>
    </div>
  </nav>