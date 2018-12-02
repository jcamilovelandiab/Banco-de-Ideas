
$(document).on("click", ".votos", function () {
     var lik = $(this).data('id');
     
     $(".modal-body #lik").val( lik );

});

$("#ModalVoto").on('shown.bs.modal', function(){
	$("#votos_form\\:lik").val($("#lik").val());

});

$('td').click(function(){
    var colIndex = $(this).parent().children().index($(this));
    var rowIndex = $(this).parent().parent().children().index($(this).parent());
    if(colIndex == 6){
    	var voto = $("#TablaIni tr:eq("+rowIndex+") td:last .g").data('id');
    	if(voto==true){
    		$("#ts4").prop('checked','true');
    	}
    }
});