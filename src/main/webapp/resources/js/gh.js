
$(document).on("click", ".votos", function () {
     var lik = $(this).data('id');
   
     $(".modal-body #lik").val( lik );
});

$("#ModalVoto").on('shown.bs.modal', function(){
	$("#votos_form\\:lik").val($("#lik").val())
});
