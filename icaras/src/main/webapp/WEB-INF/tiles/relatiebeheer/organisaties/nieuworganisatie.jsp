<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<form:form method="POST" modelAttribute="bedrijf">
		<table class="details">
			<th>Nieuwe organisatie</th>
			<tr>
				<td><label for="naam">Naam: </label></td>
				<td><form:input path="naam" /></td>
				<td><form:errors path="naam" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="kvknummer">KvkNummer: </label></td>
				<td><form:input path="kvkNummer" /></td>
				<td><form:errors path="kvkNummer" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="opmerking">Opmerking: </label></td>
				<td><form:textarea rows="5" cols="20" path="opmerking" /></td>
				<td><form:errors path="opmerking" cssClass="error" /></td>
			</tr>
			
			<tr>
			<td colspan="2"><input type="submit" value="Voeg adres toe"/></td>
			</tr>
		</table>

		</form:form>
</body>