<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<h1>${succes}</h1>

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
			<c:forEach items="${persoon.digitaleAdressen}" var="digitaleadres"
				varStatus="loop">

				<c:if
					test="${digitaleadres.digitaalAdresType.type == 'email' || digitaleadres.digitaalAdresType.type == 'telefoonnummer' }">
					<tr class="element">
						<form:input type="hidden"
							path="digitaleAdressen[${loop.index}].id"
							value="${digitaleadres.id}" />
						<td><label>${digitaleadres.digitaalAdresType.type} </label></td>
						<td><form:input
								path="digitaleAdressen[${loop.index}].omschrijving"
								id="omschrijving" value="${digitaleadres.omschrijving}"
								size="30" /></td>
						<td><label>voorkeur </label></td>
						<!-- 					<td><form:input path="digitaleAdressen[${loop.index}].contactvoorkeur"
								id="contactvoorkeur" value="${digitaleadres.contactvoorkeur}"
								size="2" /></td>
 -->
						<td><form:radiobutton
								path="digitaleAdressen[${loop.index}].contactvoorkeur"
								value="true" />Yes <form:radiobutton
								path="digitaleAdressen[${loop.index}].contactvoorkeur"
								value="false" />No</td>
						<form:input type="hidden"
							path="digitaleAdressen[${loop.index}].digitaalAdresType.id"
							value="${digitaleadres.digitaalAdresType.id}" />
					</tr>
				</c:if>

			</c:forEach>
			<tr></tr>
		</table>
		</br>
		<table class="details">
			<th>Adresgegevens</th>

			<c:forEach items="${persoon.persoonsrollen}" var="persoonsrol"
				varStatus="loop">
				<tr>
					<td><form:input type="hidden"
							path="persoonsrollen[${loop.index}].id" value="${persoonsrol.id}" /></td>
				</tr>
				<tr class="element">
					<td><label>Bedrijfsnaam:</label></td>

					<td><form:input
							path="persoonsrollen[${loop.index}].bedrijf.naam"
							value="${persoonsrol.bedrijf.naam}" /></td>
				</tr>
				<tr>
					<td><form:input type="hidden"
							path="persoonsrollen[${loop.index}].bedrijf.id"
							value="${persoonsrol.bedrijf.id}" /></td>
				</tr>

				<c:forEach items="${persoonsrol.bedrijf.adressen}" var="adres"
					varStatus="innerloop">
					<tr>
						<td><form:input type="hidden"
								path="persoonsrollen[${loop.index}].bedrijf.adressen[${innerloop.index}].id" /></td>
					</tr>
					<tr>
						<td><label>Adres type: </label></td>
						<td><form:select
								path="persoonsrollen[${loop.index}].bedrijf.adressen[${innerloop.index}].adresType.id">
								<option value="${adres.adresType.id}" selected>${adres.adresType.type}
									(huidig)</option>
								<c:forEach items="${adresTypes}" var="lookupType"
									varStatus="current" begin="0">
									<option value="${lookupType.id}">${lookupType.type}</option>
								</c:forEach>
							</form:select></td>
<!--  					<td><form:input type="hidden"
								path="persoonsrollen[${loop.index}].bedrijf.adressen[${innerloop.index}].adresType.id" /></td> -->	
					</tr>
					<tr>
						<td><label for="straat">Straat: </label></td>
						<td><form:input
								path="persoonsrollen[${loop.index}].bedrijf.adressen[${innerloop.index}].straat"
								value="${adres.straat}" /></td>
					</tr>
					<tr>
						<td><label for="nummer">Nummer: </label></td>
						<td><form:input
								path="persoonsrollen[${loop.index}].bedrijf.adressen[${innerloop.index}].nummer"
								id="nummer" value="${adres.nummer}" /></td>
					</tr>
					<tr>
						<td><label for="toevoegsel">Toevoegsel: </label></td>
						<td><form:input
								path="persoonsrollen[${loop.index}].bedrijf.adressen[${innerloop.index}].toevoegsel"
								id="toevoegsel" value="${adres.toevoegsel}" /></td>
					</tr>
					<tr>
						<td><label for="postcode">Postcode: </label></td>
						<td><form:input
								path="persoonsrollen[${loop.index}].bedrijf.adressen[${innerloop.index}].postcode"
								id="postcode" value="${adres.postcode}" /></td>
					</tr>
					<tr>
						<td><label for="plaats">Plaats: </label></td>
						<td><form:input
								path="persoonsrollen[${loop.index}].bedrijf.adressen[${innerloop.index}].plaats"
								id="plaats" value="${adres.plaats}" /></td>
					</tr>
					<tr>
						<td><label for="land">Land: </label></td>
						<td><form:input
								path="persoonsrollen[${loop.index}].bedrijf.adressen[${innerloop.index}].land"
								id="land" value="${adres.land}" /></td>
					</tr>
					<tr>
						<td><label for="begindatum">Begin datum: </label></td>
						<td><form:input
								path="persoonsrollen[${loop.index}].bedrijf.adressen[${innerloop.index}].begindatum"
								id="begindatum" value="${adres.begindatum}" /></td>
					</tr>
					<tr>
						<td><label for="einddatum">Eind datum: </label></td>
						<td><form:input
								path="persoonsrollen[${loop.index}].bedrijf.adressen[${innerloop.index}].einddatum"
								id="einddatum" value="${adres.einddatum}" /></td>
					</tr>
					<tr></tr>

				</c:forEach>
			</c:forEach>
		</table>
		<tr>
			<td colspan="3"><input type="submit" value="Update" /></td>
		</tr>
	</form:form>
</body>
