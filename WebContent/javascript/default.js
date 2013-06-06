var procurarNome = function() {
	var data = {};
	data['cliente.nome']= $('#nome').val();
	$.ajax({
		  type: "get",
		  url: "procura-normal",
		  data: data, 
	}).done(function(data) {
			if(data !== undefined && data !== []){
				$('tr th').prepend('nome');
				$("#result").loadTemplate($("#template"), data);
			}else{
				$('#message').empty();
				$('#message').prepend('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>Nenhum resultado encontrado</div>');
			}
		});
};
var procurarNomeBuscaBr = function() {
	var data = {};
	data['cliente.nome']= $('#nome-buscabr').val();
	$.ajax({
		type: "get",
		url: "procura-buscabr",
		data: data, 
	}).done(function(data) {
		if(data === undefined & data === []){
			$('#message').empty();
			$('#message').prepend('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>Nenhum resultado encontrado</div>');
		}else{
			$('tr th').prepend('nome');
			$("#result-buscabr").loadTemplate($("#template"), data);
		}
	});
};

$(function() {
    console.log( "o pulo do gato!" );
    
    $('#procurar-normal').click(function() {
    	$('thead th').empty();
    	$("#result").html();
    	
    	procurarNome();
    	
	});
    $('#procurar-buscabr').click(function() {
    	$('thead th').empty();
    	$("#result").html();
    	procurarNomeBuscaBr();
	});
    
    $('#a #b').click(function() {
    	$('thead th').empty();
		$('#result #result-buscabr').html();
	});
    
});