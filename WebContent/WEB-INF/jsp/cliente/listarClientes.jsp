<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<td>nome</td>
			<td>email</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="cliente" items="${clientes}" varStatus="s">
			<tr class="${s.count % 2 == 0? 'even': 'odd' }">
				<td>${cliente.nome}</td>
				<td>${cliente.email}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>