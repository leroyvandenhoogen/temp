<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<body>
	<input type="button" value="Ga terug" onclick="history.back();" />
	<input type="submit"
		onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/organisaties/zoeken'"
		value="zoekscherm" />
	<div class="center">
		<br>
		<table>
<!-- 		
			<tr>
				<c:set var="string1" value="${bedrijfDTO.bedrijf.bedrijfType.type}"/>
				<th><c:out value="${fn:toUpperCase(string1)}"/></th>
			</tr>
			<tr>
				<td>Naam:</td>
				<td>${bedrijfDTO.bedrijf.naam}</td>
			</tr>

			<c:forEach items="${bedrijfDTO.bedrijf.adressen}" var="adres"
					varStatus="loop">
						<tr>
						<c:set var="string2" value="${adres.adresType.type}"/>
						<th><c:out value="${fn:toUpperCase(string2)}"/></th>
						</tr>
						
					<tr>
						<td><label for="straat">Straat: </label></td>
						<td><form:input path="bedrijf.adressen[${loop.index}].straat"
								value="${adres.straat}" /></td>
					</tr>
					<tr>
						<td><label for="nummer">Nummer: </label></td>
						<td><form:input path="bedrijf.adressen[${loop.index}].nummer"
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
						<td><form:input path="bedrijf.adressen[${loop.index}].plaats"
								value="${adres.plaats}" /></td>
					</tr>
					<tr>
						<td><label for="land">Land: </label></td>
						<td><form:input path="bedrijf.adressen[${loop.index}].land"
								value="${adres.land}" /></td>
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="bedrijf.adressen[${loop.index}].begindatum"
								value="${adres.begindatum}" /></td>
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="bedrijf.adressen[${loop.index}].einddatum"
								value="${adres.einddatum}" /></td>
					</tr>
					<tr></tr>
				</c:forEach>
 -->
		</table>

	</div>
  
	<div class="center">
		<form:form method="POST" modelAttribute="bedrijfDTO">
			<br>
			<td colspan="3"><input type="submit" value="Bewerk" /></td>

			<br>
			<table class="organisiate-details">
				<tr>
					<th>Organisatiegegevens</th>
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
				<tr>
					<td><label for="opmerking">Opmerking: </label></td>
					<td><form:textarea rows="5" cols="20" path="bedrijf.opmerking" /></td>
					<td><form:errors path="bedrijf.opmerking" cssClass="error" /></td>
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
						<td><form:input path="bedrijf.adressen[${loop.index}].straat"
								value="${adres.straat}" /></td>
					</tr>
					<tr>
						<td><label for="nummer">Nummer: </label></td>
						<td><form:input path="bedrijf.adressen[${loop.index}].nummer"
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
						<td><form:input path="bedrijf.adressen[${loop.index}].plaats"
								value="${adres.plaats}" /></td>
					</tr>
					<tr>
						<td><label for="land">Land: </label></td>
						<td><form:input path="bedrijf.adressen[${loop.index}].land"
								value="${adres.land}" /></td>
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="bedrijf.adressen[${loop.index}].begindatum"
								value="${adres.begindatum}" /></td>
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="bedrijf.adressen[${loop.index}].einddatum"
								value="${adres.einddatum}" /></td>
					</tr>
					<tr></tr>
				</c:forEach>
			</table>

			<table class="organisiate-details">
				<tr>
					<th>Contactpersonen</th>
				</tr>
				<c:forEach items="${bedrijfDTO.bedrijf.persoonsrollen}"
					var="persoonsrol" varStatus="loop">

					<form:input type="hidden"
						path="bedrijf.persoonsrollen[${loop.index}].id" />
					<form:input type="hidden"
						path="bedrijf.persoonsrollen[${loop.index}].rol.id" />
					<form:input type="hidden"
						path="bedrijf.persoonsrollen[${loop.index}].begindatum"
						value="${persoonsrol.begindatum}" />
					<form:input type="hidden"
						path="bedrijf.persoonsrollen[${loop.index}].einddatum" />
					<form:input type="hidden"
						path="bedrijf.persoonsrollen[${loop.index}].persoon.id" />
					<tr>
						<td><label>Voornaam: </label></td>
						<td><form:input
								path="bedrijf.persoonsrollen[${loop.index}].persoon.voornaam" /></td>
					</tr>
					<tr>
						<td><label>Tussenvoegsel: </label></td>
						<td><form:input
								path="bedrijf.persoonsrollen[${loop.index}].persoon.tussenvoegsel" /></td>
					</tr>
					<tr>
						<td><label>Achternaam: </label></td>
						<td><form:input
								path="bedrijf.persoonsrollen[${loop.index}].persoon.achternaam" /></td>
					</tr>
					<tr>
						<td><label>Geslacht: </label></td>
						<td><form:input
								path="bedrijf.persoonsrollen[${loop.index}].persoon.geslacht" /></td>
					</tr>
					<tr>
						<td><label>Bijzonderheden: </label></td>
						<td><form:textarea rows="5" cols="20"
								path="bedrijf.persoonsrollen[${loop.index}].persoon.opmerking"
								id="opmerking" />
					
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="bedrijf.persoonsrollen[${loop.index}].persoon.geboortedatum" /></td>
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="bedrijf.persoonsrollen[${loop.index}].persoon.geboorteplaats" /></td>
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="bedrijf.persoonsrollen[${loop.index}].persoon.rijbewijs" /></td>
					</tr>
					<tr>
						<td><form:input type="hidden"
								path="bedrijf.persoonsrollen[${loop.index}].persoon.nationaliteit" /></td>
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
									path="bedrijf.persoonsrollen[${loop.index}].persoon.digitaleAdressen[${innerloop.index}].id" />
								<td><label>${digitaalAdres.digitaalAdresType.type}:
								</label></td>
								<td><form:input
										path="bedrijf.persoonsrollen[${loop.index}].persoon.digitaleAdressen[${innerloop.index}].omschrijving"
										size="30" /></td>

								<td><form:checkbox
										path="bedrijf.persoonsrollen[${loop.index}].persoon.digitaleAdressen[${innerloop.index}].contactvoorkeur"
										value="true" /></td>
								<form:input type="hidden"
									path="bedrijf.persoonsrollen[${loop.index}].persoon.digitaleAdressen[${innerloop.index}].digitaalAdresType.id" />
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
				<a href="#close" class="btn-close" aria-hidden="true">×</a>
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
	<script
							src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

					</body>

<p>
	<input type="submit"
		onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/organisaties/nieuwAdres-${organisatie.id}'"
		value="Adres toevoegen" />
</p>
<p>
	<input type="submit"
		onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/organisaties/nieuwContactpersoon-${organisatie.id}'"
		value="Nieuw persoon toevoegen" />
</p>
<p>
	<input type="submit"
		onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/organisaties/zoekContactpersoon-${organisatie.id}'"
		value="Bestaand persoon toevoegen" />
</p>