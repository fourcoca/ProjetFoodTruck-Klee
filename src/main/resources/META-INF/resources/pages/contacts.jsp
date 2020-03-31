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
<h1>CONTACTS</h1>
<div class="container">
  <h2>FoodTruck Contact</h2>
  <form  action="" method="post" modelAttribute="personneModel">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
      </div>
    </div>
   
	
	 <div class="form-group">
   <label class="control-label col-sm-2" for="pwd">Votre message:</label>
         <div class="col-sm-10">    
  <textarea class="form-control" rows="5" id="comment" name="message"></textarea>
  </div>
</div>
   
    <div class="form-group">        
       <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Envoyer</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>