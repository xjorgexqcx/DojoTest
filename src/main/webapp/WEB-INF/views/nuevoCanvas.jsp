<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
img {
    display: none;
}
canvas {
    background-color: #eee;

    background-image: -webkit-linear-gradient(45deg, black 25%, 
transparent 25%, transparent 75%, black 75%, black), 
-webkit-linear-gradient(45deg, black 25%, transparent 25%, 
transparent 75%, black 75%, black);

    background-image: -moz-linear-gradient(45deg, black 25%, 
transparent 25%, transparent 75%, black 75%, black), 
-moz-linear-gradient(45deg, black 25%, transparent 25%, 
transparent 75%, black 75%, black);
    background-image: linear-gradient(45deg, black 25%, transparent 25%, 
transparent 75%, black 75%, black), linear-gradient(45deg, black 25%, 
transparent 25%, transparent 75%, black 75%, black);

    background-size:60px 60px;
    background-position:0 0, 30px 30px
}
</style>
<script src="//ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js"></script>
</head>
<body>
<a href="listarInfo">ABRIR PAGINA DE CRUD'S</a>
	<a href="nuevoCanvas">ABRIR PAGINA DEL NUEVO CANVAS</a>
	<br/>
	<canvas id="canvas" width="300" height="100"></canvas>
	<img id="img" src="resources/sprites/sprite.png">
	<script src="resources/js/nuevoCanvas.js"></script>	
</body>
</html>