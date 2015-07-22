<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
Het aanmaken van de account is gelukt
<c:url var="onderhoud" value="/onderhoud" />
<a href="${onderhoud}">Terug naar beginscherm</a>
</body>