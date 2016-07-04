<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BoVoyage-Projet2</title>
<link rel="stylesheet" href="CSS/BoVoyage2.css" type="text/css">
</head>
<body>
	<div>
		<%@ include file="fragments/Header.html" %>
	</div>
	<div>
		<%@ include file="fragments/Navigateur.html" %>
	</div>
	<div>
	<c:forEach items="${destinations }" var="destination">
		<a href="DescriptionVoyage.jsp">			
<!-- 			<img src="images/canada_1.jpg" alt="DescriptionVoyage.jsp"><br/> -->
<!-- 			Click pour afficher description -->					
				<div><img src="images/${destination.images[0]}"/></div>
				<div>${destination.region}</div> 
		</a>
		</c:forEach>
	</div>
</body>
</html>