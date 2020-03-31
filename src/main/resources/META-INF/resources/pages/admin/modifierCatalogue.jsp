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




<div class="container-fluid text-center">    
    <div class="row content">
      <div class="col-sm-2 sidenav">
        
      
      </div>
      <div class="col-sm-8 "> 
       <nav class="navbar navbar-inverse">
    <div class="container-fluid">
     
	 <h1>AJOUT  PRODUIT</h1>

<a href="/admin/modifierCatalogue">Modifier</a>
<a href="/admin/ajouterCatalogue">Ajouter</a>
<a href="/admin/listCatalogue">supprimer</a>

     
     
      
    </div>
  </nav>
  
  <div class="container" style="background-color: green;">
  <h2>FoodTruck</h2>
  <h1>MODIFICATION  Catalogue</h1>
  <form  action="" method="post" modelAttribute="catalogue" style="background-color: green;">
    <div class="form-group">
      <label class="control-label col-sm-2" >image:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="ei" placeholder="Entrer l'image du produit " name="image">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >nom:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="em" placeholder="Entrer le nom du produit" name="nom">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Prix:</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" id="ema" placeholder="Entrer le prix du produit" name="prix">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Stock:</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" id="l" placeholder="Entrer le stock du produit" name="stock">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Description:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="il" placeholder="Entrer la description du produit" name="description">
      </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2" >Disponibilité:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="ail" placeholder="Enter la disponibilité du produit " name="disponibilite">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >Famille:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="aill" placeholder="Enter la famille du produit  " name="famille">
      </div>
    </div>
   	
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Nom:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="email" placeholder="Entrer le type " name="nom">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">heure:</label>
      <div class="col-sm-10">          
        <input type="number" class="form-control" id="pwd" placeholder="Entrer l'heure " name="heure">
      </div>
    </div>
   
  
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Modifier Catalogue </button>
      </div>
    </div>
  </form>
</div>

</body>
</html>