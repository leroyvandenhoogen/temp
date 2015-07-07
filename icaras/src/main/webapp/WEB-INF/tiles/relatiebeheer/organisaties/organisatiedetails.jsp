<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<body>
	<input type="button" value="Ga terug" onclick="history.back();" />
	<input type="submit"
		onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/organisaties/zoeken'"
		value="zoekscherm" />
	<div class="center">
		<br>
		<table class="organisiate-details">
			<tr>
				<td><c:out
						value="${fn:toUpperCase(bedrijfDTO.bedrijf.bedrijfType.type)}" /></td>
			</tr>
			<tr>
				<td>Naam:</td>
				<td><c:out value="${fn:toUpperCase(bedrijfDTO.bedrijf.naam)}" /></td>
			</tr>

			<c:forEach items="${bedrijfDTO.bedrijf.adressen}" var="adres"
				varStatus="loop">
				<tr>
					<c:set var="string2" value="${adres.adresType.type}" />
					<td><c:out value="${fn:toUpperCase(adres.adresType.type)}" /></td>
				</tr>
				<tr>
					<td><label>Straat: </label></td>
					<td>${adres.straat}</td>
				</tr>
				<tr>
					<td><label>Nummer: </label></td>
					<td>${adres.nummer}</td>
				</tr>
				<tr>
					<td><label>Toevoegsel: </label></td>
					<td>${adres.toevoegsel}</td>
				</tr>
				<tr>
					<td><label>Postcode: </label></td>
					<td>${adres.postcode}</td>
				</tr>
				<tr>
					<td><label>Plaats: </label></td>
					<td>${adres.plaats}</td>
				</tr>
				<tr>
					<td><label>Land: </label></td>
					<td>${adres.land}</td>
				</tr>
				<tr>
					<td><label>Opmerking: </label></td>
					<td>${bedrijf.opmerking}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="#modal-one" class="btn btn-big">Wijzig</a></td>
				<td><a href="#modal-two" class="btn btn-big">Bewerk</a></td>
			</tr>
		</table>

		<table class="organisiate-details">

			<c:forEach items="${bedrijfDTO.bedrijf.persoonsrollen}"
				var="persoonsrol" varStatus="loop">
				<tr>
					<th>Contact:</th>
				</tr>
				<tr>
					<td><label>Voornaam: </label></td>
					<td>${persoonsrol.persoon.voornaam}</td>
				</tr>
				<tr>
					<td><label>Tussenvoegsel: </label></td>
					<td>${persoonsrol.persoon.tussenvoegsel}</td>
				</tr>
				<tr>
					<td><label>Achternaam: </label></td>
					<td>${persoonsrol.persoon.achternaam}</td>
				</tr>
				<tr>
					<td><label>Geslacht: </label></td>
					<td>${persoonsrol.persoon.geslacht}</td>
				</tr>
				<tr>
					<td><label>Functie: </label></td>
					<td>${persoonsrol.functie}</td>
				</tr>
				<tr>
					<td><label>Afdeling: </label></td>
					<td>${persoonsrol.afdeling}</td>
				</tr>
				<tr>
					<c:forEach items="${persoonsrol.persoon.digitaleAdressen}"
						var="digitaalAdres" varStatus="innerloop">
						<tr>
							<td>${digitaalAdres.digitaalAdresType.type}</td>
							<td>${digitaalAdres.omschrijving}</td>
						</tr>
					</c:forEach>
				<tr>
					<td><label>Bijzonderheden: </label></td>
					<td>${persoonsrol.persoon.opmerking}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="#modal-three" class="btn btn-big">Nieuw</a></td>
				<td><a href="#modal-two" class="btn btn-big">Bewerk</a></td>
			</tr>
		</table>
	</div>
	<div class="modal" id="modal-one" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<h2>Bewerk organisatie</h2>

				<a href="#close" class="btn-close" aria-hidden="true">×</a>
				<!--CHANGED TO "#close"-->
			</div>
			<div class="modal-body">
				<form:form method="POST" modelAttribute="bedrijfDTO">
					<table>
						<tr>
							<form:input type="hidden" path="bedrijf.id" />
						</tr>
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
						<tr>
							<td><form:input type="hidden" path="bedrijf.kvkNummer" /></td>
						</tr>

						<tr></tr>

						<tr>
							<th>Adresgegevens</th>
						</tr>
						<c:forEach items="${bedrijfDTO.bedrijf.adressen}" var="adres"
							varStatus="loop">
							<tr>
								<td><form:input type="hidden"
										path="bedrijf.adressen[${loop.index}].id" value="${adres.id}" /></td>
							<tr>
								<td><label>Adres type: </label></td>
								<td><form:select
										path="bedrijf.adressen[${loop.index}].adresType.id">
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
								<td><form:input
										path="bedrijf.adressen[${loop.index}].straat"
										value="${adres.straat}" /></td>
							</tr>
							<tr>
								<td><label for="nummer">Nummer: </label></td>
								<td><form:input
										path="bedrijf.adressen[${loop.index}].nummer"
										value="${adres.nummer}" /></td>
							</tr>
							<tr>
								<td><label for="toevoegsel">Toevoegsel: </label></td>
								<td><form:input
										path="bedrijf.adressen[${loop.index}].toevoegsel"
										value="${adres.toevoegsel}" /></td>
							</tr>
							<tr>
								<td><label for="postcode">Postcode: </label></td>
								<td><form:input
										path="bedrijf.adressen[${loop.index}].postcode"
										value="${adres.postcode}" /></td>
							</tr>
							<tr>
								<td><label for="plaats">Plaats: </label></td>
								<td><form:input
										path="bedrijf.adressen[${loop.index}].plaats"
										value="${adres.plaats}" /></td>
							</tr>
							<tr>
								<td><label for="land">Land: </label></td>
								<td><form:input path="bedrijf.adressen[${loop.index}].land"
										value="${adres.land}" /></td>
							</tr>
							<tr>
								<td><label for="opmerking">Opmerking: </label></td>
								<td><form:textarea rows="5" cols="20"
										path="bedrijf.opmerking" /></td>
								<td><form:errors path="bedrijf.opmerking" cssClass="error" /></td>
							</tr>
							<tr></tr>
						</c:forEach>
						<tr>
							<td colspan="3"><input type="submit" name="wijzigadres"
								value="Opslaan" /></td>
						</tr>
					</table>
				</form:form>
			</div>
			<div class="modal-footer">
				<a href="#close" class="btn">Sluiten</a>
				<!--CHANGED TO "#close"-->
			</div>
		</div>
	</div>
	<div class="modal" id="modal-three" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<h2>Nieuw Contactpersoon</h2>

				<a href="#close" class="btn-close" aria-hidden="true">×</a>
				<!--CHANGED TO "#close"-->
			</div>
			<div class="modal-body">
				<form:form method="POST" modelAttribute="bedrijfDTO">
					<table>
						<th>Persoonsgegevens</th>
						<tr>
							<td><label>Voornaam: </label></td>
							<td><form:input path="persoon.voornaam" /></td>
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
							<td><form:errors path="persoon.tussenvoegsel"
									cssClass="error" /></td>
						</tr>

						<tr>
							<td><label for="geslacht">Geslacht: </label></td>
							<td><form:input path="persoon.geslacht" value="m" /></td>
							<td><form:errors path="persoon.geslacht" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>Functie: </label></td>
							<td><form:input path="persoonsrol.functie" /></td>
						</tr>
						<tr>
							<td><label>Afdeling: </label></td>
							<td><form:input path="persoonsrol.afdeling" /></td>
						</tr>
						<tr>
							<td><form:select path="dAdres1.digitaalAdresType.id">
									<option value="1" selected>Telefoon</option>
									<c:forEach items="${bedrijfDTO.digitaalAdresTypes}"
										var="lookupType">
										<option value="${lookupType.id}">${lookupType.type}</option>
									</c:forEach>
								</form:select></td>
							<td><form:input path="dAdres1.omschrijving" value="06" /></td>
							<td><form:errors path="dAdres1.omschrijving"
									cssClass="error" /></td>
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
							<td><form:errors path="dAdres2.omschrijving"
									cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>Bijzonderheden: </label></td>
							<td><form:textarea rows="5" cols="20"
									path="persoon.opmerking" /></td>
							<td><form:errors path="persoon.opmerking" cssClass="error" /></td>
						</tr>

					</table>
					<tr>
						<td colspan="3"><input type="submit" name="nieuwpersoon"
							value="Opslaan" /></td>
					</tr>
				</form:form>
			</div>
			<div class="modal-footer">
				<a href="#close" class="btn">Sluiten</a>
				<!--CHANGED TO "#close"-->
			</div>
		</div>
	</div>
</body>
