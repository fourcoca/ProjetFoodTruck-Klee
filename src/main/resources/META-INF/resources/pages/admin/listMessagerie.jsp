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
<h1>LISTES DES MESSAGES </h1>



<div class="container-fluid text-center">    
    <div class="row content">
      <div class="col-sm-2 sidenav">
        
      
      </div>
      <div class="col-sm-8 "> 
       <nav class="navbar navbar-inverse">
    <div class="container-fluid">
     
	<h1>LISTES DE DIFFERENTS  MESSAGES </h1>
     
      
    </div>
  </nav>

	
        
          <table class="table table-hover" style="background-color: green;">
    <thead>
      <tr>
        
        <th>Email</th>
        
        <th>Message :</th>
        
         <th>Suppréssion: :</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${ List }" var="c">
      <tr>
      
       	<td><c:out value="${ c.email}"/></td>
       	<td><c:out value="${ c.message}"/></td>
       
       	<td>
       	 
   <a href="../supr?id=<c:out value="${ c.id }"/>">
													
		<h3>supprimer</h3>
      
    	</a>
    	
    	</td>
    	
    		
      </tr>
      </c:forEach>
				
      
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