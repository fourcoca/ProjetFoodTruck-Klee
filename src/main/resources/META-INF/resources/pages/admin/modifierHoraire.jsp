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
<%@ include file="nav.jsp"%>




	<h1>MODIFIER HORAIRE</h1>
<form class="navbar-form navbar-left" method="post" action="/admin/modifierHoraire">
	<label class="custom-control-label" for="heurePD">Petit Dejeuner </label>
	<input type="number" id="heurePD" value="${heurePD}" name="heurePD" min="8" max="22" required>
	
	
	<label class="custom-control-label" for="heureD">Dejeuner</label>
	<input type="number" id="heureD" value="${heureD}" name="heureD" min="8" max="22" required>
	
	<label class="custom-control-label" for="heureG">Gouter</label>
	<input type="number" id="heureG" value="${heureG}" name="heureG" min="8" max="22" required>
	
	
	<label class="custom-control-label" for="heureDiner">Diner</label>
	<input type="number" id="heureDiner" value="${heureDiner}" name="heureDiner" min="8" max="22" required>
</form>

	<a href="/admin/modifierHoraire">Valider</a>

</body>
</html>