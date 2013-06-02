<%@ include file="/header.jsp"%>


	<h2>Escolha uma opção!</h2>
	<a class="btn btn-large btn-primary" href="welcome.jsf">Cadastrar Cliente</a>
	 <a class="btn btn-large btn-primary" href="#">Buscar Cliente</a>
<form action="cliente" method="post" />
<fieldset>
	<ul>
		<li class="inline">
			<i  class="	" >nome</i> <input type="text" id="nome" name="cliente.nome"	value="${cliente.nome}" /> 
		</li>
		<li class="inline">
			<i >email</i> <input type="text" id="email"	name="cliente.email" value="${cliente.email}" />
		</li>
			<button type="submit" id="send">vai!</button>
	
	</ul>

</fieldset>

</form>

<%@ include file="/footer.jsp"%>
