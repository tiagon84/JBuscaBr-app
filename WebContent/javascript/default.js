var procurarNome = function() {
	var data = {};
	data['cliente.nome']= $('#nome').val();
	$.ajax({
		  type: "get",
		  url: "procura-normal",
		  data: data, 
	}).done(function(data) {
		$('.table').before('<p  class="text-info">Resultado: </p>');
		$("#result").html();
		$("#result").loadTemplate($("#template"), data);
		
		});
};

$(function() {
    console.log( "o pulo do gato!" );
    
    $('#procurar').click(procurarNome);
    
});