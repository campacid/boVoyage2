<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript" src="scripts/formulaire.js"></script>

</head>
<body>
	<div class="row">
		<%@ include file="fragments/Header.html"%>
	</div>
	<%@ include file="fragments/Navigateur.html"%>

	<div class="container container-fluid" id="main">
		<div class="row">
			<div class="col-md-8">
				<div class="col-md-10">
					<form role="form" id="formParticipants" action="BoVoyageServlet">
					<input type="hidden" value="formulaire" name="target"/>
					<input type="hidden" value="${nbParticipants}" name="nbParticipants"/>
						<fieldset>
							<legend>${nbParticipants+1} voyageur(s) � enregistrer </legend>
			
							<div>
								<label for="Gender">Civility:</label> <input type="radio"
									name="civilite" value="M" />M <input type="radio"
									name="civilite" value="Mme" />Mme
							</div>
			
							<div class="form-group has-feedback">
								<label for="nom">Nom:</label> <input type="text"
									class="form-control" id="nom" name="nom"><span
									class="glyphicon form-control-feedback"></span>
							</div>
			
							<div class="form-group has-feedback">
								<label for="prenom">Prenom:</label> <input type="text"
									class="form-control" id="prenom" name="prenom"> <span
									class="glyphicon form-control-feedback"></span>
							</div>
			
			
							<div class="form-group has-feedback">
								<label for="dateDeNaissance">Date de naissance:</label> <input
									type="date" class="form-control" id="dateDeNaissance" name="dateDeNaissance"> <span
									class="glyphicon form-control-feedback"></span>
							</div>
			
							<div class="form-group has-feedback">
								<label for="email">Email address:</label> <input type="email"
									class="form-control" name="emailParticipant" id="emailParticipant" disabled> <span
									class="glyphicon form-control-feedback"></span>
									<span class="help-block">Le champ email n'est accessible qu'aux personnes majeures.</span>
							</div>
			
			
							<button id="validerListe" class="btn btn-primary btn-block lien"
								type="submit">Valider le voyageur</button>
			
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<%@ include file="fragments/Footer.html"%>
	</div>
</body>
</html>