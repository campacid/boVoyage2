

//vérifier si les champs sont saisis
function isFieldEmpty() {

	if ($(this).val().trim() == 0) {
		$(this).closest("div").removeClass("has-success").addClass("has-error");
		$(this).next().removeClass("glyphicon-ok").addClass("glyphicon-remove");
		return true;
	} else {
		$(this).closest("div").removeClass("has-error").addClass("has-success");
		$(this).next().removeClass("glyphicon-remove").addClass("glyphicon-ok");
		return false;
	}
}
//vérifier si le participant est majeur
function isAdulte() {
	var dateDeNaissance = $(this).val();
	var eltDateDeNaissance = dateDeNaissance.split("-");
	var anneeDeMajeur = parseInt(eltDateDeNaissance[0], 10) + 18;
	var dateDuJour = new Date;
	var anneeEnCour = dateDuJour.getFullYear();
	var moisEnCour = dateDuJour.getMonth() + 1;
	var jourEnCour = dateDuJour.getDay();
	if (anneeEnCour > anneeDeMajeur) {
		return true;
	} else {
		if (anneeEnCour == anneeDeMajeur) {
			if (moisEnCour > eltDateDeNaissance[1]) {
				return true;
			} else {
				if (moisEnCour == eltDateDeNaissance[1]) {
					if (dateDuJour.getDate() >= eltDateDeNaissance[2]) {
						return true;
					}
					return false;
				}
				return false;
			}
		}
		return false;
	}
	return false;
}

// verifie le format des champs emails
function isEmailWellFormed() {
	var email = $(this).val();
	var i = email.indexOf("@");
	var j = email.indexOf(".", i);
	var k = email.length - 1;
	if (i < 1 || j == -1 || (j - i) == 1 || j == k) {
		$(this).closest("div").removeClass("has-success").addClass("has-error");
		$(this).next().removeClass("glyphicon-ok").addClass("glyphicon-remove");
		return false;
	}
	$(this).closest("div").removeClass("has-error").addClass("has-success");
	$(this).next().removeClass("glyphicon-remove").addClass("glyphicon-ok");
	return true;
}

// ajoute un participant a la liste des participants (formParticipants.html)
function ajouterParticipant() {
	if (formValide()) {
		listeParticipantHTML = $("#listeParticipants").html();
		listeParticipantHTML += "<option value='"
				+ $('#listeParticipants option').length + "' " + "data-nom='"
				+ $("#nom").val().trim() + "' " + "data-prenom='"
				+ $("#prenom").val().trim() + "' " + "data-email='"
				+ $("#emailParticipant").val().trim() + "' " + "data-dateDeNaissance='"
				+ $("#dateDeNaissance").val().trim() + "' " + "data-telephone='"
				+ $("#telephone").val().trim() + "' " + ">"
				+ $("#nom").val().trim() + " " + $("#prenom").val().trim()
				+ "</option>";
		$("#listeParticipants").html(listeParticipantHTML);
		resetForm.apply($("#formParticipants"));
	}
}

function formValide() {
	var state = true;
	$("input").trigger("blur");
	$(".has-error").each(function() {
		state = false;
		return false;
	});
	return state;
}
//verifier si le numero de telephone est bien forme
function isPhoneWellFormed() {
	var rg = new RegExp("^([0-9]{2}[ -]?){4}[0-9]{2}$");
	if (!rg.test($(this).val())) {
		$(this).closest("div").removeClass("has-success").addClass("has-error");
		$(this).next().removeClass("glyphicon-ok").addClass("glyphicon-remove");
		return false;
	}
	$(this).closest("div").removeClass("has-error").addClass("has-success");
	$(this).next().removeClass("glyphicon-remove").addClass("glyphicon-ok");
	return true;
}

function resetForm() {
	$(this).trigger("reset");
	$("#emailParticipant").attr("disabled", "disabled");
	$(".has-success,.has-error,.glyphicon-remove,.glyphicon-ok").removeClass(
			"has-success has-error glyphicon-remove glyphicon-ok");
}

function supprimerElement() {
	$("#listeParticipants option:selected").remove();
}

function connexion() {
	if (formValide()) {
		$("#butInscription").hide();
		$("#butConnexion").html($("#username").val().trim());
		$("#main").load("listeVoyages.html");
	}
}

function connexionInscription() {
	if (formValide()) {
		$("#butInscription").hide();
		$("#butConnexion").html($("#nom").val().trim() + " " + $("#prenom").val().trim());
		$("#main").load("listeVoyages.html");
	}
}


function formValide() {
	var state = true;
	$("input").trigger("blur");
	$(".has-error").each(function() {
		state = false;
		return false;
	});
	return state;
}
//vérifier si le téléphone est bon
function isPhoneWellFormed() {
	var rg = new RegExp("^([0-9]{2}[ -]?){4}[0-9]{2}$");
	if (!rg.test($(this).val())) {
		$(this).closest("div").removeClass("has-success").addClass("has-error");
		$(this).next().removeClass("glyphicon-ok").addClass("glyphicon-remove");
		return false;
	}
	$(this).closest("div").removeClass("has-error").addClass("has-success");
	$(this).next().removeClass("glyphicon-remove").addClass("glyphicon-ok");
	return true;
}

function resetForm() {
	$(this).trigger("reset");
	$("#emailParticipant").attr("disabled", "disabled");
	$(".has-success,.has-error,.glyphicon-remove,.glyphicon-ok").removeClass(
			"has-success has-error glyphicon-remove glyphicon-ok");
}

function supprimerElement() {
	$("#listeParticipants option:selected").remove();
}



$(function() {	
	$(document).on("blur", ":text", isFieldEmpty);
	$(document).on("blur", "#pass", isFieldEmpty);
	$(document).on("blur", "#emailParticipant", function() {
		if ($(this).attr("disabled") == undefined) {
			if (!isFieldEmpty.apply(this)) {
				isEmailWellFormed.apply(this);
			}
		}
	});
	$(document).on("blur", "#emailInscription", function() {
		if (!isFieldEmpty.apply(this)) {
			isEmailWellFormed.apply(this);
		}
	});
	$(document).on(
			"blur",
			"#dateDeNaissance",
			function() {
				console.log(this);
				if (!isFieldEmpty.apply(this)) {
					if (isAdulte.apply(this)) {
						$("#emailParticipant").removeAttr("disabled");
					} else {
						$("#emailParticipant").val("");
						$("#emailParticipant").next().removeClass("glyphicon-ok")
								.removeClass("glyphicon-remove");
						$("#emailParticipant").closest("div").removeClass("has-error")
								.removeClass("has-success");
						$("#emailParticipant").attr("disabled", "disabled");

					}

				}
			});

	$(document).on("click", "#ajouterParticipant", ajouterParticipant);
	$(document).on("click", "#viderListe", function() {
		$("#listeParticipants").html("");
	});
	$(document).on("click", "#supprimerElement", supprimerElement);
	$(document).on("click", "#resetInscription", function() {
		resetForm.apply($("#formInscription"));
	});
	$(document).on("click", "#connexion", connexion);
	$(document).on("click", "#validerInscription", connexionInscription);
	$(document).on("blur", "#telephone", function() {
		console.log(this);
		if (!isFieldEmpty.apply(this)) {
			isPhoneWellFormed.apply(this);
		}

	});
	$(document).on("blur","#isMajeur",function(){
		if($("#isMajeur").is(":checked")){
			return true;
		}
		return false;
	});
});