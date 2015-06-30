<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<input type="button" value="Ga terug" onclick="history.back();" />
	<tr></tr>
	<form:form method="POST" modelAttribute="persoonDTO">
		<form:input type="hidden" path="persoon.id"></form:input>
		<table class="details">
			<tr>
				<td><label>Persoonsrol </label></td>
				<td><form:select path="persoonsrol.rol.id">
						<option value="1" selected>cursist</option>
						<c:forEach items="${persoonDTO.rollen}" var="lookupType"
							varStatus="current" begin="0">
							<option value="${lookupType.id}">${lookupType.type}</option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><label for="begindatum">Begindatum: </label></td>
				<td><form:input type="date" path="persoonsrol.begindatum"
						value="" /></td>
				<td><form:errors path="persoonsrol.begindatum"
						cssClass="geboortedatum" /></td>
			</tr>
		</table>
		<td colspan="3"><input type="submit" value="submit" /></td>
	</form:form>

</body>