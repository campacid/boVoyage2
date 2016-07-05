$(function() {	
	$("#listeDate").change(function(){
		var prix = $("#listeDate").find(":selected").attr("data-prix");
		$("#prix").html(prix);
	});
	
});