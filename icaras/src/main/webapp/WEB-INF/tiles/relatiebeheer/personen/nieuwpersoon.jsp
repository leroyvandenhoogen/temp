<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<form:form method="POST" modelAttribute="persoon">
		<table class="details">
			<th>Persoonsgegevens</th>
			<tr>
				<td><label for="voornaam">Voornaam: </label></td>
				<td><form:input path="voornaam" id="voornaam" value="" /></td>
				<td><form:errors path="voornaam" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="achternaam">Achternaam: </label></td>
				<td><form:input path="achternaam" id="achternaam" value="" /></td>
				<td><form:errors path="achternaam" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="tussenvoegsel">Tussenvoegsel: </label></td>
				<td><form:input path="tussenvoegsel" id="tussenvoegsel"
						value="" /></td>
				<td><form:errors path="tussenvoegsel" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="geboortedatum">Geboortedatum: </label></td>
				<td><form:input type="date" path="geboortedatum"
						id="geboortedatum" value="" /></td>
				<td><form:errors path="geboortedatum" cssClass="geboortedatum" /></td>
			</tr>

			<tr>
				<td><label for="geboorteplaats">Geboorteplaats: </label></td>
				<td><form:input path="geboorteplaats" id="geboorteplaats"
						value="" /></td>
				<td><form:errors path="geboorteplaats" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="geslacht">Geslacht: </label></td>
				<td><form:radiobutton path="geslacht" value="M"
						checked="checked" />Man <form:radiobutton path="geslacht"
						value="F" />Vrouw</td>
			</tr>

			<tr>
				<td><label for="nationaliteit">Nationaliteit: </label></td>
				<td><form:input path="nationaliteit" id="nationaliteit"
						value="Nederland" /></td>
				<td><form:errors path="nationaliteit" cssClass="nationaliteit" /></td>
			</tr>
			<tr>
				<td><label for="opmerking">Bijzonderheden: </label></td>
				<td><form:textarea rows="5" cols="20" path="opmerking"
						id="opmerking" />
				<td><form:errors path="opmerking" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="rijbewijs">Rijbewijs: </label></td>
				<td><form:radiobutton path="rijbewijs" value="true" />In bezit
					<form:radiobutton path="rijbewijs" value="false" checked="checked" />Geen</td>
			</tr>

			<tr></tr>
		</table>

		<table class="details">
			<th>Adresgegevens</th>
			<c:forEach items="${persoon.adressen}" var="adres"
				varStatus="current" begin="0">
				<tr>
					<td><label>Straat: </label></td>
					<td><form:input path="adressen[${current.index}].straat"
							value="" /></td>
				</tr>
				<tr>
					<td><label>Nummer: </label></td>
					<td><form:input path="adressen[${current.index}].nummer"
							value="" /></td>
				</tr>
				<tr>
					<td><label>Toevoegsel: </label></td>
					<td><form:input path="adressen[${current.index}].toevoegsel"
							value="" /></td>
				</tr>
				<tr>
					<td><label>Postcode: </label></td>
					<td><form:input path="adressen[${current.index}].postcode"
							value="" /></td>
				</tr>
				<tr>
					<td><label>Plaats: </label></td>
					<td><form:input path="adressen[${current.index}].plaats"
							value="" /></td>
				</tr>
				<tr>
					<td><label>Land: </label></td>
					<td><form:input path="adressen[${current.index}].land"
							value="Nederland" /></td>
				</tr>

				<!--  
				<tr>
					<td><label>Begin datum: </label></td>
					<td><form:input type="date"
							path="adressen[${current.index}].begindatum" value="" /></td>
				</tr>
				<tr>
					<td><label>Eind datum: </label></td>
					<td><form:input type="date"
							path="adressen[${current.index}].einddatum" value="" /></td>
				</tr>
				-->

				<td><label>Adres type: </label></td>
				<td><form:select path="adressen[${current.index}].adresType.id">
						<option value="${adres.adresType.id}" selected>${adres.adresType.type}</option>
						<c:forEach items="${adresTypes}" var="lookupType"
							varStatus="current" begin="0">
							<option value="${lookupType.id}">${lookupType.type}</option>
						</c:forEach>
					</form:select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Voeg persoon toe" /></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
