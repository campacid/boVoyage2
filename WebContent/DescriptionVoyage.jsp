<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		<div class="row" id="description">
			<img src="images/${destination.images[0]}" class="img-responsive"
				style="width: 100%; height: 250px"><br />
			<h3>Description du voyage à ${destination.region}</h3>
			<p>${destination.description}
		</div>

		<div id="affichePrix">
			Veuillez choisir la date de voyage pour visualiser le prix du voyage:
			<select id="listeDate">
				<c:forEach items="${datesVoyages}" var="dates">
					<option data-prix="${dates.prixHT}"><f:formatDate
							pattern="dd/MM/yyyy" value="${dates.dateDepart}"></f:formatDate>
						-
						<f:formatDate pattern="dd/MM/yyyy" value="${dates.dateRetour}"></f:formatDate>
					</option>
				</c:forEach>
			</select>

			<h3>
				Prix (en euros) : <span id="prix"></span>
			</h3>

			<a href="Formulaire.jsp" id="btCommande" type="button"
				class="btn btn-primary btn-md lien" style="float:left">Choisir ce voyage</a>
		</div>
	</div>

	<div class="row">
		<%@ include file="fragments/Footer.html"%>
	</div>
</body>
</html>