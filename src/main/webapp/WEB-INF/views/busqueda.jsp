<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<style>
body {
	background: url('resources/imagenes/fondo.jpg');
	text-align: center;
	margin: 0px;
}

.mdl-textfield__input {
	border: none;
	border-bottom: 1px solid #908989 !important;
}

.mdl-textfield__label:after {
	background-color: white !important;
}

.mdl-textfield__label {
	color: white !important;
}

#tabla {
	width: 75%;
	margin-left: 12.5%;
	box-shadow: 2px 2px 1px black;
}

#boton {
	margin-bottom: 15px;
}

#formulario {
	margin-top: 25px;
	margin-bottom: 25px;
}

#rpta{
    color: rgb(255, 0, 0);
}
</style>
<script
	src="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.min.js"></script>
<link rel="stylesheet"
	href="https://storage.googleapis.com/code.getmdl.io/1.0.4/material.indigo-pink.min.css">
</head>
<body>
	<a href="nuevoCanvas">ABRIR PAGINA DEL NUEVO CANVAS</a>
	<br/>
	<br />
	<span id="rpta">${rpta}</span>
	<form action="buscarInfo" id="formulario" method="post">
		<div
			class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
			<input class="mdl-textfield__input" type="text" id="sample3"
				name="codigo" placeholder="Código o Nombre" /> <label
				class="mdl-textfield__label" for="sample3"></label>
		</div>
		<br /> <input id="boton" type="submit"
			class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
			value="Buscar">
	</form>
	<table id="tabla"
		class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
		<thead>
			<tr>
				<th class="mdl-data-table__cell--non-numeric">Código</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Dirección</th>
				<th>Teléfono</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${info}" var="contacto">
				<tr>
					<td class="mdl-data-table__cell--non-numeric">${contacto.id}</td>
					<td>${contacto.name}</td>
					<td>${contacto.email}</td>
					<td>${contacto.address}</td>
					<td>${contacto.telephone}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>