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
     
	 <a href="/admin/listUtilisateur">Modifier</a>
	<a href="/admin/ajouterUtilisateur">Ajouter</a>
     
      
    </div>
  </nav>

<div class="container" style="background-color: green;">
  <h2>FoodTruck</h2>
  <h3>MODIFIER PROFIL</h3>
  <form  action="" method="post" modelAttribute="usersModel" style="background-color: green;">
    <div class="form-group">
      <label class="control-label col-sm-2" >Nom:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="e" placeholder="Entrer votre Nom" name="nom">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Prenom:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="em" placeholder="Entrer votre prénom" name="prenom">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Date de naissance:</label>
      <div class="col-sm-10">
        <input type="datetime" class="form-control" id="ema" placeholder="Entrer votre Date de naissance" name="dateDeNaissance">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Adresse:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="l" placeholder="Entrer votre adresse" name="adresse">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Societé:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="il" placeholder="Entrer l'adresse de votre societe " name="societe">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Genre:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="ail" placeholder="Enter le genre " name="genre">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Email:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="aill" placeholder="Enter le mail " name="email">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="pwd" placeholder="Entrer le mot de passe " name="motDePasse">
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