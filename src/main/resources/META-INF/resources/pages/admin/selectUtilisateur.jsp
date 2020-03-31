<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  </head>
<body

style="background-image: url(https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Lula_kebab_2.jpg/1200px-Lula_kebab_2.jpg)";

>
<%@ include file="nav.jsp" %>
<h1>Utilisateur séléctionné est :</h1>

 	<h2><c:out value="${ List.nom}"/></h2>

<div class="container-fluid text-center">    
    <div class="row content">
      <div class="col-sm-2 sidenav">
        
      
      </div>
      <div class="col-sm-8 "> 
       <nav class="navbar navbar-inverse">
    <div class="container-fluid">
     
	 <a href="/admin/listUtilisateur">supprimer</a>
	<a href="/admin/ajouterUtilisateur">Ajouter</a>
	 <a href="/admin/listUtilisateur">Modifier</a>
	<a href="/admin/listUtilisateur">Visualiser la liste des utilisateurs</a>
     
      
    </div>
  </nav>

	
        
          <table class="table table-hover" style="background-color: green;">
    <thead>
      <tr>
        <th>Adresse </th>
        <th>Date de Naissance </th>
        <th>Email</th>
        <th>genre</th>
        <th>Mot de passe</th>
        <th>Nom:</th>
        <th>Prénom :</th>
        <th>Societe :</th>
        <th>Suppression :</th>
      </tr>
    </thead>
    <tbody>
    
      <tr>
        <td><c:out value="${ List.adresse}"/></td>
       	<td><c:out value="${ List.dateDeNaissance}"/></td>
       	<td><c:out value="${ List.email}"/></td>
       	<td><c:out value="${ List.genre}"/></td>
       	<td><c:out value="${ List. motDePasse}"/></td>
       	<td><c:out value="${ List.nom}"/></td>
       	<td><c:out value="${ List.prenom}"/></td>
       	<td><c:out value="${ List.societe}"/></td>
       	<td>
       	 
     
													
		<c:out value="${ List.prenom}"/>
    
      
    	
    	</td>
      </tr>
     
				
      
    </tbody>
  </table>
  
 
</div>   
      </div>
	    <div class="col-sm-4 sidenav">
        
      
      </div>
      
      <%@ include file="../space.jsp" %>

	<%@ include file="../footer.jsp" %>
</body>
</html>