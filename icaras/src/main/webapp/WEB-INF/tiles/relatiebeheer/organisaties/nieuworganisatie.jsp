<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<input type="button" value="Ga terug" onclick="history.back();" class="btn btn-small"/>
	<br>
	<form:form method="POST" modelAttribute="bedrijfDTO">
		<h2>Nieuwe organisatie</h2>
		<table class="details">
			<tr>
			<td></td>
			<td><form:select path="bedrijf.bedrijfType.id">
						<option value="2" selected>detacheerder</option>
						<c:forEach items="${bedrijfDTO.bedrijfTypes}" var="lookupType">
							<option value="${lookupType.id}">${lookupType.type}</option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><label for="naam">Naam: </label></td>
				<td><form:input path="bedrijf.naam" /></td>
				<td><form:errors path="bedrijf.naam" cssClass="error" /></td>
			</tr>

			<tr></tr>

			<tr>
				<td><label>Adres: </label></t11d>
				<td><form:select path="adres.adresType.id">
						<option value="5" selected>bezoek</option>
						<c:forEach items="${bedrijfDTO.adresTypes}" var="lookupType">
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
				<td><label>Land: </label></td>
				<td><form:input path="adres.land" value="Nederland" /></td>
			</tr>
			
			<tr>
				<td><label for="opmerking">Opmerking: </label></td>
				<td><form:textarea rows="2" cols="28" path="bedrijf.opmerking" /></td>
				<td><form:errors path="bedrijf.opmerking" cssClass="error" /></td>
			</tr>
		</table>
		
		<td colspan="3"><input type="submit" value="submit" class="btn btn-small"/></td>
	</form:form>

</body>