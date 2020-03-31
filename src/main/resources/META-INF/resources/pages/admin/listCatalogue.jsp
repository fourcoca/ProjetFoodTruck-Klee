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
<h1>LISTE UTILISATEUR</h1>



<div class="container-fluid text-center">    
    <div class="row content">
      <div class="col-sm-2 sidenav">
        
      
      </div>
      <div class="col-sm-8 "> 
       <nav class="navbar navbar-inverse">
    <div class="container-fluid">


<a href="/admin/listCatalogue">Modifier</a>
<a href="/admin/ajouterCatalogue">Ajouter</a>
<a href="/admin/listCatalogue">supprimer</a>

</div>
  </nav>

          <table class="table table-hover" style="background-color: green;">
    <thead>
      <tr>
        <th>Image </th>
        <th>nom </th>
        <th>Prix</th>
        <th>Stock</th>
        <th>Description</th>
        <th> Disponibilite:</th>
        <th>famille:</th>
        <th>type :</th>
        
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${ prodList }" var="prod">
      <tr>
        
				
        <td>
         <a href="../print?id=<c:out value="${ prod.id }"/>">
         
        <c:out value="${ prod.image}"/>
        <img src="${ prod.image}" height="50%" width="50%" alt="">
        </a>
        </td>
        
        
       	<td><c:out value="${ prod.nom}"/></td>
       	<td><c:out value="${ prod.prix}"/></td>
       	<td><c:out value="${ prod.stock}"/></td>
       	<td><c:out value="${ prod.description}"/></td>
       	<td><c:out value="${ prod.disponibilite}"/></td>
       	<td><c:out value="${ prod.famille}"/></td>
       	<td>
       		  <c:forEach items="${ prod.type }" var="types">
       	:<c:out value="${ types.nom}"/>:
       			</c:forEach>
       	</td>
       	<td>
       	 
      <a href="../suppr?id=<c:out value="${ prod.id }"/>">
													
		<h3>supprimer</h3>
      
    	</a>
    	</td>
    	
    		<td>
       	 
      <a href="">
													
		<h3>modifier</h3>
      
    	
    	</td>
      </tr>
      </c:forEach>
</tbody>
  </table>
  
 
</div>   
      </div>
	    <div class="col-sm-4 sidenav">
        
      
      </div>
     
     
      
    

</body>
</html>