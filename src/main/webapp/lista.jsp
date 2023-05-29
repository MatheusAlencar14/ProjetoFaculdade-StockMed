<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("materiais");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista de Materiais</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="corUniceplac.css">

<link rel="shortcut icon" href="">

</head>
<body>
	<h1>Lista de Materiais</h1>
	<h2><a href="novo.html" class="botao-novo" style="color: #076C4C;">Novo
		Material</a></h2>
		<table id="tabela">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Código Material</th>
					<th>Quantidade</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
			<% for (int i = 0; i < lista.size(); i++) {	%>
				<tr>
					<td><%=lista.get(i).getIdmaterial()%></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getCodMaterial() %></td>
					<td><%=lista.get(i).getQuantidade()%></td>
					<td><a href="select?idmaterial=<%=lista.get(i).getIdmaterial()%>" class="botao-novo" style="color: #076C4C;">Editar</a></td>
				</tr>
			<% } %>
			</tbody>
		</table>
</body>
</html>