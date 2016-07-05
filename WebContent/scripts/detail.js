$(function() {	
	$("#listeDate").change(function(){
		var prix = $("#listeDate").find(":selected").attr("data-prix");
		$("#prix").html(prix);
	});
	$("#submit").click(function(event){
		var val = $("#listeDate").find(":selected").val();
		var nb = $("#nbParticipants").val();
		if(val == -1 ||  nb < 1){
			event.preventDefault();
		}
	})
});