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


 <nav class="navbar navbar-inverse">
    <div class="container-fluid">
     
	 <%@ include file="navProfil.jsp" %>
     
      
    </div>
  </nav>

<div class="container" style="background-color: green;">
  <h2>FoodTruck</h2>
  <h3>MODIFIER PROFIL</h3>
  <form  action="" method="post" style="background-color: green;">
    <div class="form-group">
      <label class="control-label col-sm-2" >Nom:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="e" placeholder="Entrer votre Nom" value="${utilisateur.nom}"name="nom">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Prenom:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="em" placeholder="Entrer votre pr�nom" value="${utilisateur.prenom}" name="prenom">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Date de naissance:</label>
      <div class="col-sm-10">
        <input type="date" class="form-control" id="ema" value="${utilisateur.dateDeNaissance}" placeholder="Entrer votre Date de naissance" name="dateDeNaissance">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Adresse:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="l" value="${utilisateur.adresse}" placeholder="Entrer votre adresse" name="adresse">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Societ�:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="il" value="${utilisateur.societe}" placeholder="Entrer l'adresse de votre societe " name="societe">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Genre:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="ail" value="${utilisateur.genre}" placeholder="Enter le genre " name="genre">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Email:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="aill" value="${utilisateur.email}" placeholder="Enter le mail " name="email">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="pwd" value="${utilisateur.motDePasse}" placeholder="Entrer le mot de passe " name="motDePasse">
      </div>
    </div>
   
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Modifier</button>
      </div>
    </div>
  </form>
</div>

<%@ include file="../footer.jsp" %>
</body>
</html>