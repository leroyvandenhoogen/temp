<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>

	<form:form method="POST" modelAttribute="bedrijfDTO">
		<form:input type="hidden" path="bedrijf.id" />
		<h2>Nieuw Persoon</h2>
		<table class="details">
			<th>Persoonsgegevens</th>
			<tr>
				<td><label>Voornaam: </label></td>
				<td><form:input path="persoon.voornaam"/></td>
				<td><form:errors path="persoon.voornaam" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Achternaam: </label></td>
				<td><form:input path="persoon.achternaam" /></td>
				<td><form:errors path="persoon.achternaam" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label>Tussenvoegsel: </label></td>
				<td><form:input path="persoon.tussenvoegsel" /></td>
				<td><form:errors path="persoon.tussenvoegsel" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="geslacht">Geslacht: </label></td>
				<td><form:input path="persoon.geslacht" value="m" /></td>
				<td><form:errors path="persoon.geslacht" cssClass="error" /></td>
			</tr>
			<tr></tr>
			<th>Contactgegevens:</th>
			<tr>
				<td><form:select path="dAdres1.digitaalAdresType.id">
						<option value="1" selected>Telefoon</option>
						<c:forEach items="${bedrijfDTO.digitaalAdresTypes}"
							var="lookupType">
							<option value="${lookupType.id}">${lookupType.type}</option>
						</c:forEach>
					</form:select></td>
				<td><form:input path="dAdres1.omschrijving" value="06" /></td>
				<td><form:errors path="dAdres1.omschrijving" cssClass="error"/></td>
				<td><label>Voorkeur: </label></td>
				<td><form:radiobutton path="dAdres1.contactvoorkeur"
						value="true" />Ja <form:radiobutton path="dAdres1.contactvoorkeur"
						value="false" />Nee</td>
			</tr>

			<tr>
				<td><form:select path="dAdres2.digitaalAdresType.id">
						<option value="2" selected>E-mail</option>
						<c:forEach items="${bedrijfDTO.digitaalAdresTypes}"
							var="lookupType" varStatus="current" begin="0">
							<option value="${lookupType.id}">${lookupType.type}</option>
						</c:forEach>
					</form:select></td>
				<td><form:input path="dAdres2.omschrijving" /></td>
				<td><form:errors path="dAdres2.omschrijving" cssClass="error"/></td>
				<td><label>Voorkeur: </label></td>
				<td><form:radiobutton path="dAdres2.contactvoorkeur"
						value="true" />Ja <form:radiobutton path="dAdres2.contactvoorkeur"
						value="false" />Nee</td>
			</tr>

		</table>
		<td colspan="2"><input type="submit" value="Voeg persoon toe" /></td>
	</form:form>
</body>