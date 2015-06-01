<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>

	<form:form method="POST" modelAttribute="organisatie">
		<table class="details">
		<th>Organisatiegegevens </th>
			<tr>
				<td><label for="naam">Naam: </label></td>
				<td><form:input path="naam" id="naam" /></td>
				<td><form:errors path="naam" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="kvkNummer">kvkNummer: </label></td>
				<td><form:input path="kvkNummer" id="kvkNummer" /></td>
				<td><form:errors path="kvkNummer" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="opmerking">Opmerking: </label></td>
				<td><form:input path="opmerking" id="opmerking" /></td>
				<td><form:errors path="opmerking" cssClass="error" /></td>
			</tr>

			<tr></tr>
		</table>

		<table class="details">
		<th>Adresgegevens </th>
			<c:forEach items="${organisatie.adressen}" var="adres">
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
				<tr></tr>
			</c:forEach>
		</table>
		
		<table class="details">
		<th>Digitaal Adres</th>
			<c:forEach items="${organisatie.digitaleAdressen}" var="digitaleadres">
				<c:if test="${digitaleadres.digitaalAdresType.type == 'email' || digitaleadres.digitaalAdresType.type == 'telefoonnummer' }">
					<tr class="element">
						<td><label>${digitaleadres.digitaalAdresType.type} </label></td>
						<td><form:input path="${omschrijving}" id="omschrijving" value="${digitaleadres.omschrijving}" size="30"/></td>
						<td><label>voorkeur </label></td>
						<td><form:input path="${contactvoorkeur}" id="contactvoorkeur" value="${digitaleadres.contactvoorkeur}" size="2"/></td>
					</tr>
				</c:if>
					
			</c:forEach>
					<tr></tr>
		</table>
		<table class="details">
		<th>Persoonsrollen</th>
			<c:forEach items="${organisatie.persoonsrollen}" var="persoonsrol">
				<tr class="element">
					<td><label>${persoonsrol.rol.type} </label></td>
					<td><label>${persoonsrol.peroon.voornaam} </label></td>
					<td><label>${persoonsrol.peroon.achternaam} </label></td>
					<td><label>begindatum</label></td>
					<td><form:input path="${begindatum}" id="begindatum" value="${persoonsrol.id.begindatum}" size="10"/></td>
					<td><label>einddatum </label></td>
					<td><form:input path="${einddatum}" id="einddatum" value="${persoonsrol.einddatum}" size="10"/></td>
				</tr>
			</c:forEach>
			<tr></tr>

			<tr>
				<td colspan="3"><input type="submit" value="Register" /></td>
			</tr>
		</table>
		
		
	</form:form>
	<br />
	<br /> Go back to
	<a href="<c:url value='/list' />">List of All Employees</a>
</body>