$(document).ready(function () {
    $('#example').DataTable();
    $('#comentarios').DataTable({
        searching :false
        
        
    });
    
    
});



$('#example tbody tr').click(function (event) {
    var id = $(this).attr('id');

    $("#initiativeByKeywords_form input").val(id);
    $("#initiativeByKeywords_form botonComentario").trigger("click");


});






