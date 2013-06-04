var procurarNome = function() {
	var nome = $('#nome').val();
	$.ajax({
		  type: "get",
		  url: "procura-normal",
		  data: nome, 
		}).done(function(data) {
		  console.info( data );
		});
};

$(function() {
    console.log( "o pulo do gato!" );
    
    $('#procurar').click(procurarNome);
});