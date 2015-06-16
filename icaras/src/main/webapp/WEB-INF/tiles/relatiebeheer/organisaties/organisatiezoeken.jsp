<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<h1>Zoekscherm</h1>
	<br>
	<form:form method="POST" modelAttribute="zoekinput">
		Zoek een organisatie:<br>
		<form:input type="text" path="input" name="zoekinputarea" value=""/>
		<input type="submit" value="zoek"/>
	</form:form>
	
	<h2>Resultatenlijst</h2>
	<table class="list">
		<tr class="tabelheader">
			<td>Naam</td>
			<td>Opmerking</td>
			<td></td>
		</tr>
		<c:forEach items="${organisaties}" var="organisatie">
			<tr class="element">
				<td>${organisatie.naam}</td>
				<td>${organisatie.opmerking}</td>
				<td><a href="<c:url value='/personen/update-${persoon.id}-persoon' />">Details</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>