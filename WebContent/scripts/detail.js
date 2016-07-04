$(function(){
	$('#listeDate').change(function() {
    var val = $("#listeDate").find(":selected").attr("data-prix");
    $('#prix').html(val);
});
})