<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	${succes}

	<form:form method="POST" modelAttribute="persoon">

		<table class="details">
			<th>Persoonsgegevens</th>
			<tr>
				<td><label for="voornaam">Voornaam: </label></td>
				<td><form:input path="voornaam" id="voornaam" /></td>
				<td><form:errors path="voornaam" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="tussenvoegsel">Tussenvoegsel: </label></td>
				<td><form:input path="tussenvoegsel" id="tussenvoegsel" /></td>
				<td><form:errors path="tussenvoegsel" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="achternaam">Achternaam: </label></td>
				<td><form:input path="achternaam" id="achternaam" /></td>
				<td><form:errors path="achternaam" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:input type="hidden" path="geboortedatum"
						id="geboortedatum" /></td>
			</tr>
			<tr>
				<td><form:input type="hidden" path="geboorteplaats"
						id="geboorteplaats" /></td>
			</tr>
			<tr>
				<td><label for="geslacht">Geslacht: </label></td>
				<td><form:input path="geslacht" id="geslacht" /></td>
				<td><form:errors path="geslacht" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:input type="hidden" path="rijbewijs" id="rijbewijs" /></td>
			</tr>
			<tr>
				<td><form:input type="hidden" path="nationaliteit"
						id="nationaliteit" /></td>
			</tr>
			<tr>
				<td><label for="opmerking">Bijzonderheden: </label></td>
				<td><form:textarea rows="5" cols="20" path="opmerking"
						id="opmerking" />
				<td><form:errors path="opmerking" cssClass="error" /></td>
			</tr>
		</table>
		<table class="details">
			<th>Digitaal Adres</th>
			<c:forEach items="${persoon.digitaleAdressen}" var="digitaleadres">
				<c:if
					test="${digitaleadres.digitaalAdresType.type == 'email' || digitaleadres.digitaalAdresType.type == 'telefoonnummer' }">
					<tr class="element">
						<td><label>${digitaleadres.digitaalAdresType.type} </label></td>
						<td><form:input path="${omschrijving}" id="omschrijving"
								value="${digitaleadres.omschrijving}" size="30" /></td>
						<td><label>voorkeur </label></td>
						<td><form:input path="${contactvoorkeur}"
								id="contactvoorkeur" value="${digitaleadres.contactvoorkeur}"
								size="2" /></td>
					</tr>
				</c:if>

			</c:forEach>
			<tr></tr>
		</table>
		<table class="details">
			<th>Adresgegevens</th>
			<c:forEach items="${persoon.persoonsrollen}" var="persoonsrol">
				<c:if test="${persoonsrol.rol.type == 'contactpersoon'}">
					<tr>
						<td><label for="${persoonsrol.bedrijf.naam}">Bedrijfsnaam:</label></td>
						<td><form:input path="${bedrijf.naam}" id="${bedrijf.naam}"
								value="${persoonsrol.bedrijf.naam }" /></td>
						<td><form:errors path="${bedrijf.naam}" cssClass="error" /></td>
					</tr>
					<c:forEach items="${persoonsrol.bedrijf.adressen}" var="adres">
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
							<td><form:input path="${straat}" id="straat"
									value="${adres.straat}" /></td>
						</tr>
						<tr>
							<td><label for="nummer">Nummer: </label></td>
							<td><form:input path="${nummer}" id="nummer"
									value="${adres.nummer}" /></td>
						</tr>
						<tr>
							<td><label for="toevoegsel">Toevoegsel: </label></td>
							<td><form:input path="${toevoegsel}" id="toevoegsel"
									value="${adres.toevoegsel}" /></td>
						</tr>
						<tr>
							<td><label for="postcode">Postcode: </label></td>
							<td><form:input path="${postcode}" id="postcode"
									value="${adres.postcode}" /></td>
						</tr>
						<tr>
							<td><label for="plaats">Plaats: </label></td>
							<td><form:input path="${plaats}" id="plaats"
									value="${adres.plaats}" /></td>
						</tr>
						<tr>
							<td><label for="land">Land: </label></td>
							<td><form:input path="${land}" id="land"
									value="${adres.land}" /></td>
						</tr>
						<tr>
							<td><label for="begindatum">Begin datum: </label></td>
							<td><form:input path="${begindatum}" id="begindatum"
									value="${adres.begindatum}" /></td>
						</tr>
						<tr>
							<td><label for="einddatum">Eind datum: </label></td>
							<td><form:input path="${einddatum}" id="einddatum"
									value="${adres.einddatum}" /></td>
						</tr>
						<tr></tr>

					</c:forEach>
				</c:if>
			</c:forEach>
		</table>
		<tr>
			<td colspan="3"><input type="submit" value="Update" /></td>
		</tr>
	</form:form>
</body>
