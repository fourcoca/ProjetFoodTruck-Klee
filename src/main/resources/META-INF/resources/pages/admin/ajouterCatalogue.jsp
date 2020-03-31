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
  	
 <a href="/type" >
       <h1> ajout type </h1>
        </a>
  
  <div class="container" style="background-color: green;">
  
  <h1>AJOUT Catalogue:</h1>
  <form  action="" method="post" modelAttribute="catalogues"  style="background-color: green;">
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
      <label class="control-label col-sm-2" >Famille:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="aill" placeholder="Enter la famille du produit  " name="famille">
      </div>
    </div>
   	
   	 
  
   
   <h1> Jours de Disponibilité:</h1>
   	
    <div class="row"> 
    
      <div class="col-sm-4">
        <input type="checkbox"  id="e587" value="1" name="lundi">lundi
      </div>
      
       <div class="col-sm-4">
        <input type="checkbox"  id="e58" value="2"name="mardi">mardi
      </div>
      
      <div class="col-sm-4">
        <input type="checkbox"  id="e58" value="3"name="mercredi">mercredi
      </div>
     </div>
     
      <div class="row"> 
    
      <div class="col-sm-4">
        <input type="checkbox"  id="e587" value="4" name="jeudi">jeudi
      </div>
      
       <div class="col-sm-4">
        <input type="checkbox"  id="e58" value="5"name="vendredi">vendredi
      </div>
      
      <div class="col-sm-4">
        <input type="checkbox"  id="e58" value="6"name="samedi">samedi
      </div>
      
       <div class="col-sm-4">
        <input type="checkbox"  id="e58" value="7"name="dimanche">dimanche
      </div>
     </div>
    
     
     
     
      
    <h1> TYPE DE REPAS :</h1>
   	   <div class="row"> 
       <div class="col-sm-4">
        <input type="checkbox"  id="e587" value="petit-dejeuner" name="ptdej">petit-dejeuner
      </div>
      <div class="col-sm-4">
        <input type="checkbox"  id="e587" value="dejeuner" name="dej">dejeuner
      </div>
      <div class="col-sm-4">
        <input type="checkbox"  id="e587" value="repas"  name="r">repas
      </div>
      <div class="col-sm-4">
        <input type="checkbox"  id="e587" value="gouter" name="g">gouter
      </div>
     </div>
        
        
        <h1>Famille de repas </h1>
          <select class="custom-select" id="inputGroupSelect01">
    <option selected>Choose...</option>
    <option value="1">One</option>
    <option value="2">Two</option>
    <option value="3">Three</option>
  </select>
    
   
  
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Ajout Catalogue </button>
      </div>
    </div>
  </form>
</div>


</body>
</html>