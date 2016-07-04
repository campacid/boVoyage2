<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Description des Voyages</title>
<link rel="stylesheet" href="CSS/BoVoyage2.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="scripts/detail.js"></script>

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
${destination.description} <br/>
Choisir date de voyage: 
<select id="listeDate">
	<c:forEach items="${datesVoyages}" var="dates">
		<option data-prix="${dates.prixHT}"><f:formatDate pattern="DD-MM-YYYY" value="${dates.dateDepart}"></f:formatDate> - 
				<f:formatDate pattern="yyyy-MM-dd" value="${dates.dateRetour}"></f:formatDate>
		</option>		
	</c:forEach>
</select>
<div id="prix"></div>
<a href="Formulaire.jsp">Commander votre voyages</a>
</body>
</html>