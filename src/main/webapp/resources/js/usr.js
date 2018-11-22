$(document).ready(function () {
    $('#TablaUsr').DataTable({       
    });    
});

$('#selectUsr').on('change', function() {
	$(".rol").val($('#selectUsr').val());
    
});

$(document).on("click", ".modify-usu", function () {
     var emailUser = $(this).data('id');
   
     $(".modal-body #emailUser").val( emailUser );
});

$("#myModalUser").on('shown.bs.modal', function(){

	$("#usuario_form\\:emailUser").val($("#emailUser").val())
});