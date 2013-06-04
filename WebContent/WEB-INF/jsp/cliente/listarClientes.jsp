<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp"%>
<table class="table table-hover table-striped">
<caption>Lista de Clientes</caption>
	<thead>
		<tr>
			<th >nome</th>
			<th>email</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="cliente" items="${clienteList}" varStatus="s">
			<tr >
				<td>${cliente.nome}</td>
				<td>${cliente.email}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="/footer.jsp"%>