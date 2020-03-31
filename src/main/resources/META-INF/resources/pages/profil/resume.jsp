<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
<%@ include file="../nav.jsp" %>



<h1>RESUMEE PROFIL</h1>

 <div class="container-fluid text-center">    
    <div class="row content">
      <div class="col-sm-2 sidenav">
        
      
      </div>
      <div class="col-sm-8 "> 
       <nav class="navbar navbar-inverse">
    <div class="container-fluid">
     
	 <%@ include file="navProfil.jsp" %>
     
      
    </div>
  </nav>

        
          <table class="table table-hover" style="background-color: green;">
    <thead>
      <tr>
        <th>Adresse <c:out value="${ utilisateur.adresse}"/></th>
        <th>Date de Naissance </th>
        <th>Email</th>
        <th>genre</th>
        <th>Mot de passe</th>
        <th>Nom:</th>
        <th>Prénom :</th>
        <th>Societe :</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><c:out value="${ utilisateur.adresse}"/></td>
       	<td><c:out value="${ utilisateur.dateDeNaissance}"/></td>
       	<td><c:out value="${ utilisateur.email}"/></td>
       	<td><c:out value="${ utilisateur.genre}"/></td>
       	<td><c:out value="${ utilisateur. motDePasse}"/></td>
       	<td><c:out value="${ utilisateur.nom}"/></td>
       	<td><c:out value="${ utilisateur.prenom}"/></td>
       	<td><c:out value="${ utilisateur.societe}"/></td>
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