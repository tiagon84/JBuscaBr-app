
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp"%>
<table class="table table-hover table-striped">
<h3 class="text-success">Lista de Clientes</h3>
	<thead>
		<tr>
			<th >Nome</th>
			<th>Código Fonético</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="cliente" items="${clienteList}" varStatus="s">
			<tr >
				<td>${cliente.nome}</td>
				<td>${cliente.nomeCodFonetico}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/footer.jsp"%>