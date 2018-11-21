$('#select').on('change', function() {
	$(".rol").val($('#select').val());
       
});

$(document).on("click", ".modify-ini", function () {
     var nameIni = $(this).data('id');
   
     $(".modal-body #nameIni").val( nameIni );
});

$("#myModal").on('shown.bs.modal', function(){

	$("#est_form\\:nameIni").val($("#nameIni").val())
});

