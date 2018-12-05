$(document).on("click", ".modify-esp", function () {
     var nameIniEspera = $(this).data('id');
   
     $(".modal-body #nameIniEspera").val( nameIniEspera );
});

$("#modalEspera").on('shown.bs.modal', function(){

	$("#espera_form\\:nameIniEspera").val($("#nameIniEspera").val())
});

$(document).on("click", "#modificar", function () {
     location.reload();
});