<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dendi Legend</title>
<style>
body {
	background-color: rgb(0, 128, 248);
	color: white;
	text-align: center;
}
a{
	color:white;
}
canvas, img {
	display: block;
	margin: 1em auto;
	border-radius: 8px;
	background: rgb(248, 0, 248);
}
</style>
<script src="//ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js"></script>
<script>
	dojoConfig = {
		async : true,
		parseOnLoad : false
	}
</script>
</head>
<body onload="pintadoInicial();">
	<a href="index">ABRIR AJAX TEST CON DOJO</a>
	<canvas id="mundo" width="506" height="439"></canvas>
	<script src="resources/js/pintaImagenes.js"></script>
</body>
</html>