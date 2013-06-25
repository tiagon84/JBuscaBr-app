var procurarNome = function() {
	var data = {};
	data['cliente.nome']= $('#nome').val();
	$.ajax({
		  type: "get",
		  url: "procura-normal",
		  contentType: "charset=utf-8",
		  dataType : "json",
		  data: data, 
		  success: function(data) {
			if(data == undefined || data.length == 0){
				$('tbody').empty();
				$('tbody').append('<p>Nenhum resultado encontrado</p>');
			}else{
				$('tr th').prepend('nome');
				$("#result").loadTemplate($("#template"), data);
			}
		}
	});
};
var procurarNomeBuscaBr = function() {
	var data = {};
	data['cliente.nome']= $('#nome-buscabr').val();
	$.ajax({
		type: "get",
		url: "procura-buscabr",
		contentType: "charset=utf-8",
		dataType : "json",
		data: data,
		success: function(data) {
			if(data == undefined || data.length == 0){
				$('tbody').empty();
				$('tbody').append('<p>Nenhum resultado encontrado</p>');
			}else{
				$('tr th').prepend('nome');
				$("#result-buscabr").loadTemplate($("#template"), data);
			}
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