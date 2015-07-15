<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<input type="button" value="Ga terug" onclick="history.back();" />
	<form:form method="POST" modelAttribute="persoonDTO">
		<table class="details">
			<th>Persoonsgegevens</th>
			<tr>
				<td><label for="voornaam">Voornaam: </label></td>
				<td><form:input path="persoon.voornaam" value="" /></td>
				<td><form:errors path="persoon.voornaam" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="achternaam">Achternaam: </label></td>
				<td><form:input path="persoon.achternaam" value="" /></td>
				<td><form:errors path="persoon.achternaam" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="tussenvoegsel">Tussenvoegsel: </label></td>
				<td><form:input path="persoon.tussenvoegsel" value="" /></td>
				<td><form:errors path="persoon.tussenvoegsel" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="geboortedatum">Geboortedatum: </label></td>
				<td><form:input type="date" path="persoon.geboortedatum"
						value="" /></td>
				<td><form:errors path="persoon.geboortedatum"
						cssClass="geboortedatum" /></td>
			</tr>

			<tr>
				<td><label for="geboorteplaats">Geboorteplaats: </label></td>
				<td><form:input path="persoon.geboorteplaats" value="" /></td>
				<td><form:errors path="persoon.geboorteplaats" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="geslacht">Geslacht: </label></td>
				<td><form:radiobutton path="persoon.geslacht" value="M"
						checked="checked" />Man <form:radiobutton path="persoon.geslacht"
						value="V" />Vrouw</td>
			</tr>

			<tr>
				<td><label for="nationaliteit">Nationaliteit: </label></td>
				<td><form:input path="persoon.nationaliteit" value="Nederland" /></td>
				<td><form:errors path="persoon.nationaliteit"
						cssClass="nationaliteit" /></td>
			</tr>

			<tr class="element">
				<td><label>Telefoonnummer: </label></td>
				<form:input type="hidden" path="digitaalAdres1.digitaalAdresType.id"
					value="1" />
				<td><form:input path="digitaalAdres1.omschrijving" value="" size="30" /></td>
			</tr>

			<tr class="element">
				<td><label>Email: </label></td>
				<form:input type="hidden" path="digitaalAdres2.digitaalAdresType.id"
					value="2" />
				<td><form:input path="digitaalAdres2.omschrijving" value="" size="30" /></td>
			</tr>

			<tr>
				<td><label for="opmerking">Bijzonderheden: </label></td>
				<td><form:textarea rows="5" cols="20" path="persoon.opmerking" />
				<td><form:errors path="persoon.opmerking" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="rijbewijs">Rijbewijs: </label></td>
				<td><form:radiobutton path="persoon.rijbewijs" value="true" />In
					bezit <form:radiobutton path="persoon.rijbewijs" value="false"
						checked="checked" />Geen</td>
			</tr>

			<tr></tr>
		</table>

		<table class="details">
			<th>Adresgegevens</th>
			<tr>
				<td><label>Adres type: </label></td>
				<td><form:select path="adres.adresType.id">
						<option value="1" selected>post</option>
						<c:forEach items="${persoonDTO.adresTypes}" var="lookupType">
							<option value="${lookupType.id}">${lookupType.type}</option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><label>Straat: </label></td>
				<td><form:input path="adres.straat" value="" /></td>
			</tr>
			<tr>
				<td><label>Nummer: </label></td>
				<td><form:input path="adres.nummer" value="" /></td>
			</tr>
			<tr>
				<td><label>Toevoegsel: </label></td>
				<td><form:input path="adres.toevoegsel" value="" /></td>
			</tr>
			<tr>
				<td><label>Postcode: </label></td>
				<td><form:input path="adres.postcode" value="" /></td>
			</tr>
			<tr>
				<td><label>Plaats: </label></td>
				<td><form:input path="adres.plaats" value="" /></td>
			</tr>
			<tr>
				<td><label>Provincie: </label></td>
				<td><form:input path="adres.provincie" /></td>
			</tr>
			<tr>
				<td><label>Land: </label></td>
				<td><form:input path="adres.land" value="Nederland" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Voeg persoon toe" /></td>
			</tr>
		</table>
	</form:form>
</body>
