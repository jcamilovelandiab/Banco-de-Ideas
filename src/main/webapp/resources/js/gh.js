//Votos
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
    	var voto = $("#TablaIni tr:eq("+(rowIndex+1)+") td:last .g").data('id');
    	if(voto==true){
    		$(".ntb").attr('style','background-color: #900; color:white;');
    	}else{
    		$(".ntb").attr('style','background-color: white; color:black;');
    	}
    }
});

$(".ntb").click(function(){
	var estilo = $(".ntb").attr('style');
	var estiloSplit = estilo.split(" ");
	//["background-color:", "#900;", "color:white"]
	if(estiloSplit[1]=='#900;'){
		$(".ntb").attr('style','background-color: white; color:black;');
	}else{
		$(".ntb").attr('style','background-color: #900; color:white;');
	}
	$(".oculto").click();
});

//Mias

$(document).on("click", ".mias", function () {
     var lik = $(this).data('id');
     
     $(".modal-body #mia").val( lik );

});

$("#ModalMias").on('shown.bs.modal', function(){
	$("#mias_form\\:mia").val($("#mia").val());

});



$('td').click(function(){

    var colIndex = $(this).parent().children().index($(this));
    var rowIndex = $(this).parent().parent().children().index($(this).parent());
    if(colIndex == 6){
    	var voto = $("#TablaIniP tr:eq("+(rowIndex+1)+") td:last .p").data('id');
    	if(voto==true){
    		$(".mia").attr('style','background-color: #900; color:white;');
    	}else{
    		$(".mia").attr('style','background-color: white; color:black;');
    	}
    }
});



$(".mia").click(function(){
	var estilo = $(".mia").attr('style');
	var estiloSplit = estilo.split(" ");
	//["background-color:", "#900;", "color:white"]
	if(estiloSplit[1]=='#900;'){
		$(".mia").attr('style','background-color: white; color:black;');
	}else{
		$(".mia").attr('style','background-color: #900; color:white;');
	}
	$(".escondido").click();
});