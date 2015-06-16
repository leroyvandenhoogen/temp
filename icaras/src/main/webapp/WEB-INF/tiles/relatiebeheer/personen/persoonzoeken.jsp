<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<h1>Zoekscherm</h1>
	<br>
	<form:form method="POST" modelAttribute="zoekinput">
		Zoek een persoon:<br>
		<form:input type="text" path="input" name="zoekinputarea" value=""/>
		<input type="submit" value="zoek"/>
	</form:form>
	
	<h2>Personenlijst</h2>
	<table class="list">
		<tr class="tabelheader">
			<td>Voornaam</td>
			<td>Achternaam</td>
			<td>Tussenvoegsel</td>
			<td>Rollen</td>
			<td></td>
		</tr>
		<c:forEach items="${personen}" var="persoon">
			<tr class="element">
				<td>${persoon.voornaam}</td>
				<td>${persoon.achternaam}</td>
				<td>${persoon.tussenvoegsel}</td>
				<td>${persoon.persoonsrollen}</td>
				<td><a href="<c:url value='/personen/update-${persoon.id}-persoon' />">Details</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>