<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Description des Voyages</title>
<link rel="stylesheet" href="CSS/BoVoyage2.css" type="text/css">

</head>
<body>
<div>
		<%@ include file="fragments/Header.html" %>
</div>
<div>
		<%@ include file="fragments/Navigateur.html" %>
</div>
Images et
description ici
${destinations.description} <br/>
Choisir date de voyage: 
<select>
	<c:forEach items="${datesVoyages}" var="dates">
		<option>${datesVoyages.dateDepart}-${datesVoyages.dateRetour}</option>		
	</c:forEach>
</select>
<div>Le prix de voyage : ${datesVoyages.prixHT}</div>
<a href="Formulaire.jsp">Commander votre voyages</a>
</body>
</html>