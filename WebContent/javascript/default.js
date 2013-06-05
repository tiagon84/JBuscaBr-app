var procurarNome = function() {
	var data = {};
	data['cliente.nome']= $('#nome').val();
	$.ajax({
		  type: "get",
		  url: "procura-normal",
		  data: data, 
	}).done(function(data) {
		  console.info( data );
		});
};

$(function() {
    console.log( "o pulo do gato!" );
    
    $('#procurar').click(procurarNome);
});