<%@ include file="/header.jsp"%>

<div id="message">${msg}</div>
<fieldset>
	<form class="form-signin" action="<c:url value="/clientes/cliente"/>" method="post">
		<h3 class="form-signin-heading">Cadastro de Clientes</h3>
		<input type="text" class="input-block-level" placeholder="nome" id="nome" name="cliente.nome" value="${cliente.nome}" /> 
		<button class="btn btn-medium btn-primary" type="submit">vai!</button>
	</form>

</fieldset>

<%@ include file="/footer.jsp"%>
