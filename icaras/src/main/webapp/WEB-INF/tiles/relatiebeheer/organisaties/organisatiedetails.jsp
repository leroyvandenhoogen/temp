<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<div class="center">
		<form:form method="POST" modelAttribute="organisatie">
			<input type="button" value="Ga terug" onclick="history.back();" />
			<br>
			<td colspan="3"><input type="submit" value="Bewerk" /></td>

			<br>
			<table class="organisiate-details">
				<tr>
					<th>Organisatiegegevens</th>
				</tr>
				<tr>
					<td><label for="naam">Naam: </label></td>
					<td><form:input path="naam" /></td>
					<td><form:errors path="naam" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:input type="hidden" path="kvkNummer" /></td>
				</tr>
				<tr>
					<td><label for="opmerking">Opmerking: </label></td>
					<td><form:textarea rows="5" cols="20" path="opmerking" /></td>
					<td><form:errors path="opmerking" cssClass="error" /></td>
				</tr>

				<tr></tr>

				<tr>
					<th>Adresgegevens</th>
				</tr>
				<c:forEach items="${organisatie.adressen}" var="adres"
					varStatus="loop">
					<tr>
						<td><form:input type="hidden"
								path="adressen[${loop.index}].id" value="${adres.id}" /></td>
					<tr>
						<td><label>Adres type: </label></td>
						<td><form:select path="adressen[${loop.index}].adresType.id">
								<option value="${adres.adresType.id}" selected>${adres.adresType.type}
									(huidig)</option>
								<c:forEach items="${adresTypes}" var="lookupType"
									varStatus="current" begin="0">
									<option value="${lookupType.id}">${lookupType.type}</option>
								</c:forEach>
							</form:select></td>
					</tr>
					<tr>
						<td><label for="straat">Straat: </label></td>
						<td><form:input path="adressen[${loop.index}].straat"
								value="${adres.straat}" /></td>
					</tr>
					<tr>
						<td><label for="nummer">Nummer: </label></td>
						<td><form:input path="adressen[${loop.index}].nummer"
								value="${adres.nummer}" /></td>
					</tr>
					<tr>
						<td><label for="toevoegsel">Toevoegsel: </label></td>
						<td><form:input path="adressen[${loop.index}].toevoegsel"
								value="${adres.toevoegsel}" /></td>
					</tr>
					<tr>
						<td><label for="postcode">Postcode: </label></td>
						<td><form:input path="adressen[${loop.index}].postcode"
								value="${adres.postcode}" /></td>
					</tr>
					<tr>
						<td><label for="plaats">Plaats: </label></td>
						<td><form:input path="adressen[${loop.index}].plaats"
								value="${adres.plaats}" /></td>
					</tr>
					<tr>
						<td><label for="land">Land: </label></td>
						<td><form:input path="adressen[${loop.index}].land"
								value="${adres.land}" /></td>
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="adressen[${loop.index}].begindatum"
								value="${adres.begindatum}" /></td>
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="adressen[${loop.index}].einddatum"
								value="${adres.einddatum}" /></td>
					</tr>
					<tr></tr>
				</c:forEach>
			</table>

			<table class="organisiate-details">
				<tr>
					<th>Contactpersonen</th>
				</tr>
				<c:forEach items="${organisatie.persoonsrollen}" var="persoonsrol"
					varStatus="loop">

					<form:input type="hidden" path="persoonsrollen[${loop.index}].id" />
					<form:input type="hidden"
						path="persoonsrollen[${loop.index}].rol.id" />
					<form:input type="hidden"
						path="persoonsrollen[${loop.index}].begindatum"
						value="${persoonsrol.begindatum}" />
					<form:input type="hidden"
						path="persoonsrollen[${loop.index}].einddatum" />
					<form:input type="hidden"
						path="persoonsrollen[${loop.index}].persoon.id" />
					<tr>
						<td><label>Voornaam: </label></td>
						<td><form:input
								path="persoonsrollen[${loop.index}].persoon.voornaam" /></td>
					</tr>
					<tr>
						<td><label>Tussenvoegsel: </label></td>
						<td><form:input
								path="persoonsrollen[${loop.index}].persoon.tussenvoegsel" /></td>
					</tr>
					<tr>
						<td><label>Achternaam: </label></td>
						<td><form:input
								path="persoonsrollen[${loop.index}].persoon.achternaam" /></td>
					</tr>
					<tr>
						<td><label>Geslacht: </label></td>
						<td><form:input
								path="persoonsrollen[${loop.index}].persoon.geslacht" /></td>
					</tr>
					<tr>
						<td><label>Bijzonderheden: </label></td>
						<td><form:textarea rows="5" cols="20"
								path="persoonsrollen[${loop.index}].persoon.opmerking"
								id="opmerking" />
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="persoonsrollen[${loop.index}].persoon.geboortedatum" /></td>
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="persoonsrollen[${loop.index}].persoon.geboorteplaats" /></td>
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="persoonsrollen[${loop.index}].persoon.rijbewijs" /></td>
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="persoonsrollen[${loop.index}].persoon.nationaliteit" /></td>
					</tr>

					<tr>
						<td></td>
						<td></td>
						<td>Voorkeur:</td>
					<tr>
						<c:forEach items="${persoonsrol.persoon.digitaleAdressen}"
							var="digitaalAdres" varStatus="innerloop">
							<tr class="element">
								<form:input type="hidden"
									path="persoonsrollen[${loop.index}].persoon.digitaleAdressen[${innerloop.index}].id" />
								<td><label>${digitaalAdres.digitaalAdresType.type}:
								</label></td>
								<td><form:input
										path="persoonsrollen[${loop.index}].persoon.digitaleAdressen[${innerloop.index}].omschrijving"
										size="30" /></td>

								<td><form:checkbox
										path="persoonsrollen[${loop.index}].persoon.digitaleAdressen[${innerloop.index}].contactvoorkeur"
										value="true" /></td>
								<form:input type="hidden"
									path="persoonsrollen[${loop.index}].persoon.digitaleAdressen[${innerloop.index}].digitaalAdresType.id" />
							</tr>

						</c:forEach>
				</c:forEach>
			</table>
		</form:form>

	</div>
	<div class="wrap">
		<a href="#modal-one" class="btn btn-big">Popup!</a>
	</div>
	<!-- Modal -->
	<div class="modal" id="modal-one" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<h2>Modal in CSS</h2>
				<a href="#close" class="btn-close" aria-hidden="true">�</a>
				<!--CHANGED TO "#close"-->
			</div>
			<div class="modal-body">
				<p>One modal example here! :D</p>
			</div>
			<div class="modal-footer">
				<a href="#close" class="btn">Nice!</a>
				<!--CHANGED TO "#close"-->
			</div>
		</div>
	</div>
	<!-- /Modal -->
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</body>