$('#select').on('change', function() {
	$(".rol").val($('#select').val());
        alert($('#select').val());
});

$(document).on("click", ".modify-ini", function () {
     var emailUser = $(this).data('id');
   
     $(".modal-body #emailUser").val( emailUser );
});

$("#myModal").on('shown.bs.modal', function(){

	$("#rol_form\\:emailUser").val($("#emailUser").val())
});
