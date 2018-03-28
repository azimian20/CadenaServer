<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security 5</title>
</head>
<body>
<h1>Cadena Server</h1>
<h2>${message}</h2>

<form:form action="loginAction" method="POST">
	<input value="Logout" type="submit">
</form:form>
</body>
</html>