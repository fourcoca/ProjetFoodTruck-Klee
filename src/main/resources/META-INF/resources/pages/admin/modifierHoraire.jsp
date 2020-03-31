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
     
	 <h1>Modification  PRODUIT</h1>

<a href="/admin/modifierHoraire">Modifier</a>
<a href="/admin/addHoraire">Ajouter</a>
<a href="/admin/listHoraire">supprimer</a>

     
     
      
    </div>
  </nav>
  
  <div class="container" style="background-color: green;">
  <h2>FoodTruck</h2>
  <h1>GESTION TYPES ET HORAIRE</h1>
  <form  action="" method="post" modelAttribute="TYPE" style="background-color: green;">
   
	
   	 
    <div class="form-group">
      <label class="control-label col-sm-2" >Nom:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="e5878" placeholder="Entrer le type " name="nom">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" >heure:</label>
      <div class="col-sm-10">          
        <input type="number" class="form-control" id="pwd122" placeholder="Entrer l'heure " name="heure">
      </div>
    </div>
   
  
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Modifier TYPE </button>
      </div>
    </div>
  </form>
</div>

</body>
</html>