<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/BoVoyage2.css" type="text/css">
</head>
<body>
<div>
	<%@ include file="fragments/Header.html" %>
</div>
<div>
	<%@ include file="fragments/Navigateur.html" %>
</div>
Veuillez saisir l'information des participants:
<form action="TestServlet">
	<label for="civilite">Civilité:</label><input autocomplete="off"  name="civilite" required="required" size="3"/><br/>
	<label for="nom">Nom : </label><input type="text" id="nom" name="nom" required="required"/> *<br/> 
	<label for="prenom">Prénom : </label><input type="text" id="prenom" name="prenom"/> *<br/>	
	<button>Envoyer</button><button type="reset">Annuler</button>
</form>

</body>
</html>