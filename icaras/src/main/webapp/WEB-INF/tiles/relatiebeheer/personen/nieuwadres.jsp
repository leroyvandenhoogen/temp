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
				<td><label>Adres type: </label></td>
				<td><form:select path="adres.adresType.id">
						<option value="1" selected>post</option>
						<c:forEach items="${persoonDTO.adresTypes}" var="lookupType"
							varStatus="current" begin="0">
							<option value="${lookupType.id}">${lookupType.type}</option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><label>Straat: </label></td>
				<td><form:input path="adres.straat" /></td>
			</tr>
			<tr>
				<td><label>Nummer: </label></td>
				<td><form:input path="adres.nummer" /></td>
			</tr>
			<tr>
				<td><label>Toevoegsel: </label></td>
				<td><form:input path="adres.toevoegsel" /></td>
			</tr>
			<tr>
				<td><label>Postcode: </label></td>
				<td><form:input path="adres.postcode" /></td>
			</tr>
			<tr>
				<td><label>Plaats: </label></td>
				<td><form:input path="adres.plaats" /></td>
			</tr>
			<tr>
				<td><label>Provincie: </label></td>
				<td><form:input path="adres.provincie" /></td>
			</tr>
			<tr>
				<td><label>Land: </label></td>
				<td><form:input path="adres.land" value="Nederland" /></td>
			</tr>
		</table>
		<td colspan="3"><input type="submit" value="submit" /></td>
	</form:form>

</body>