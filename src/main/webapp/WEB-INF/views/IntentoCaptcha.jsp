<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src='https://www.google.com/recaptcha/api.js?hl=es'></script>
</head>
<body>
<h1>${info}</h1>
<form action="busqueda" method="post">
	<input type="text" name="nombre" />
	<div class="g-recaptcha" data-sitekey="6Lfdbw0TAAAAADO2STVAK9jQz_V_YLW_Hj9EGeix"></div>
	<input type="submit" value="Guardar" />
</form>
</body>
</html>