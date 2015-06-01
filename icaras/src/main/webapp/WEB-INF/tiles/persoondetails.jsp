<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>

	<form:form method="POST" modelAttribute="persoon">
		<table>
			<tr>
				<td><label for="voornaam">Voornaam: </label></td>
				<td><form:input path="voornaam" id="voornaam" /></td>
				<td><form:errors path="voornaam" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="achternaam">Achternaam: </label></td>
				<td><form:input path="achternaam" id="achternaam" /></td>
				<td><form:errors path="achternaam" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="tussenvoegsel">Tussenvoegsel: </label></td>
				<td><form:input path="tussenvoegsel" id="tussenvoegsel" /></td>
				<td><form:errors path="tussenvoegsel" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="geboortedatum">Geboortedatum: </label></td>
				<td><form:input path="geboortedatum" id="geboortedatum" /></td>
				<td><form:errors path="geboortedatum" cssClass="geboortedatum" /></td>
			</tr>

			<tr>
				<td><label for="geboorteplaats">Geboorteplaats: </label></td>
				<td><form:input path="geboorteplaats" id="geboorteplaats" /></td>
				<td><form:errors path="geboorteplaats" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="geslacht">Geslacht: </label></td>
				<td><form:input path="geslacht" id="geslacht" /></td>
				<td><form:errors path="geslacht" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="rijbewijs">Rijbewijs: </label></td>
				<td><form:input path="rijbewijs" id="rijbewijs" /></td>
				<td><form:errors path="rijbewijs" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="nationaliteit">Nationaliteit: </label></td>
				<td><form:input path="nationaliteit" id="nationaliteit" /></td>
				<td><form:errors path="nationaliteit" cssClass="nationaliteit" /></td>
			</tr>
		</table>

		<table>
			<c:forEach items="${persoon.adressen}" var="adres">
				<tr>
					<td><label for="adrestype">Adres type: </label></td>
					<td><select name="type">
							<option value="huis">Huis</option>
							<option value="post">Post</option>
							<option value="postbus">Postbus</option>
							<option value="woonboot">Woonboot</option>
							<option value="${adres.adresType.type}" selected>${adres.adresType.type}</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="straat">Straat: </label></td>
					<td><form:input path="${straat}" id="straat" value="${adres.straat}"/></td>
				</tr>
				<tr>
					<td><label for="nummer">Nummer: </label></td>
					<td><form:input path="${nummer}" id="nummer" value="${adres.nummer}"/></td>
				</tr>
				<tr>
					<td><label for="toevoegsel">Toevoegsel: </label></td>
					<td><form:input path="${toevoegsel}" id="toevoegsel" value="${adres.toevoegsel}"/></td>
				</tr>
				<tr>
					<td><label for="postcode">Postcode: </label></td>
					<td><form:input path="${postcode}" id="postcode" value="${adres.postcode}"/></td>
				</tr>
				<tr>
					<td><label for="plaats">Plaats: </label></td>
					<td><form:input path="${plaats}" id="plaats" value="${adres.plaats}"/></td>
				</tr>
				<tr>
					<td><label for="land">Land: </label></td>
					<td><form:input path="${land}" id="land" value="${adres.land}"/></td>
				</tr>
				<tr>
					<td><label for="begindatum">Begin datum: </label></td>
					<td><form:input path="${begindatum}" id="begindatum" value="${adres.begindatum}"/></td>
				</tr>
				<tr>
					<td><label for="einddatum">Eind datum: </label></td>
					<td><form:input path="${einddatum}" id="einddatum" value="${adres.einddatum}"/></td>
				</tr>
			</c:forEach>
		</table>
		<table>
			<c:forEach items="${persoon.identiteitsbewijzen}"
				var="identiteitsbewijs">
				<tr class="element">
					<td>${identiteitsbewijs.nummer}</td>
					<td>${identiteitsbewijs.vervaldatum}</td>
					<td>${identiteitsbewijs.identiteitsbewijsType}</td>
				</tr>
			</c:forEach>
		</table>
		<table>

			<c:forEach items="${persoon.digitaleAdressen}" var="digitaleadres">
				<tr class="element">
					<td>${digitaleadres.digitaalAdresType.type}</td>
					<td>${digitaleadres.omschrijving}</td>
					<td>${digitaleadres.contactvoorkeur}</td>
				</tr>
			</c:forEach>

			<c:forEach items="${persoon.persoonsrollen}" var="persoonsrol">
				<tr class="element">
					<td>${persoonsrol.rol}</td>
					<td>${persoonsrol.einddatum}</td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="3"><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br /> Go back to
	<a href="<c:url value='/list' />">List of All Employees</a>
</body>
