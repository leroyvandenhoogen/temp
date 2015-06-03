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
				<td><form:input path="voornaam" id="voornaam" value="testerino"/></td>
				<td><form:errors path="voornaam" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="achternaam">Achternaam: </label></td>
				<td><form:input path="achternaam" id="achternaam" value="testerino"/></td>
				<td><form:errors path="achternaam" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="tussenvoegsel">Tussenvoegsel: </label></td>
				<td><form:input path="tussenvoegsel" id="tussenvoegsel" value="testerino"/></td>
				<td><form:errors path="tussenvoegsel" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="geboortedatum">Geboortedatum: </label></td>
				<td><form:input type="date" path="geboortedatum"
						id="geboortedatum" value="1990-01-01" /></td>
				<td><form:errors path="geboortedatum" cssClass="geboortedatum" /></td>
			</tr>

			<tr>
				<td><label for="geboorteplaats">Geboorteplaats: </label></td>
				<td><form:input path="geboorteplaats" id="geboorteplaats" value="testerino"/></td>
				<td><form:errors path="geboorteplaats" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="geslacht">Geslacht: </label></td>
				<td><form:input path="geslacht" id="geslacht" value="m"/></td>
				<td><form:errors path="geslacht" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="rijbewijs">Rijbewijs: </label></td>
				<td><form:input path="rijbewijs" id="rijbewijs" value="true"/></td>
				<td><form:errors path="rijbewijs" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="nationaliteit">Nationaliteit: </label></td>
				<td><form:input path="nationaliteit" id="nationaliteit" value="testerino"/></td>
				<td><form:errors path="nationaliteit" cssClass="nationaliteit" /></td>
			</tr>
			<tr></tr>
		</table>
		
		<table class="details">
			<th>Adresgegevens</th>
			 <c:forEach items="${persoon.adressen}" var="adres" varStatus="current" begin="0">
				<tr>
					<td><label>Straat: </label></td>
					<td><form:input path="adressen[${current.index}].straat"
							value="testerino" /></td>
				</tr>
				<tr>
					<td><label>Nummer: </label></td>
					<td><form:input path="adressen[${current.index}].nummer"
							value="1337"/></td>
				</tr>
				<tr>
					<td><label>Toevoegsel: </label></td>
					<td><form:input path="adressen[${current.index}].toevoegsel"
							value="testerino" /></td>
				</tr>
				<tr>
					<td><label>Postcode: </label></td>
					<td><form:input path="adressen[${current.index}].postcode"
							value="testerino" /></td>
				</tr>
				<tr>
					<td><label>Plaats: </label></td>
					<td><form:input path="adressen[${current.index}].plaats"
							value="testerino" /></td>
				</tr>
				<tr>
					<td><label>Land: </label></td>
					<td><form:input path="adressen[${current.index}].land" value="testerino" /></td>
				</tr>
				<tr>
					<td><label>Begin datum: </label></td>
					<td><form:input type="date" path="adressen[${current.index}].begindatum"
							value="2000-01-01" /></td>
				</tr>
				<tr>
					<td><label>Eind datum: </label></td>
					<td><form:input type="date" path="adressen[${current.index}].einddatum"
							value="2010-02-02" /></td>
				</tr>
				<tr></tr>
					<tr>
					<td><label for="adresType">Adres type: </label></td>
					<td><select name="type">
					<c:forEach items="${adresTypes}" var="adresType">
							<option id="adresType" value="${adresType.type}">"${adresType.type}"</option>
					</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Voeg persoon toe" /></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>

	<br />
	<br /> Ga terug naar
	<a href="<c:url value='/personen' />">Lijst van alle Personen</a>
</body>
