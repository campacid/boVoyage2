<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<title>BoVoyage-Projet2</title>
<link rel="stylesheet" href="CSS/BoVoyage2.css" type="text/css">
<script type="text/javascript" src="scripts/detail.js"></script>
</head>
<body>
	
	<div class="row">
		<%@ include file="fragments/Header.html"%>
	</div>
		
		<%@ include file="fragments/Navigateur.html"%>
	
	<div class="container container-fluid" id="main">
		<div class="row">
			<c:forEach items="${destinations}" var="destination">
				<div class="col-sm-3">
					<a href="BoVoyageServlet?target=detail&id=${destination.id}" class="thumbnail">
							<img class="img-responsive" src="images/${destination.images[0]}"/>
						<div><h3>${destination.region}</h3></div>
						<p> Des journées merveilleures à petit prix à ${destination.region}</p>
					</a>
				</div> 
			</c:forEach>
		</div>
	</div>		
	<div class="row">
		<%@ include file="fragments/Footer.html" %>
	</div>
		
	
</body>
</html>