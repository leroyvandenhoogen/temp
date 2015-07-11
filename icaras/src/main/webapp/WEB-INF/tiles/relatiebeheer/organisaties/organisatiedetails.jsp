<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<body>
	<input type="button" value="Ga terug" onclick="history.back();" class="btn btn-small"/>
	<input type="submit"
		onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/organisaties/zoeken'"
		value="zoekscherm" class="btn btn-small"/>
	<div class="center">
		<br>
		<table class="organisiate-details">
			<tr class="bold">
				<td><c:out value="${fn:toUpperCase(bedrijfDTO.bedrijf.naam)}" />
					(${bedrijfDTO.bedrijf.bedrijfType.type})</td>
			</tr>
			<c:forEach items="${bedrijfDTO.bedrijf.adressen}" var="adres"
				varStatus="loop">

				<tr class="bold">
					<td>${adres.adresType.type} adres:</td>
				</tr>
				<tr>
					<td>${adres.straat} ${adres.nummer} 
					<c:if test="${adres.toevoegsel != ''}">${adres.toevoegsel} </c:if>
					</td>
				</tr>
				<tr>
					<td>${adres.postcode} <c:out
							value="${fn:toUpperCase(adres.plaats)}" /></td>
				</tr>

				<c:if test="${adres.land != 'Nederland'}">
					<tr>
						<td><c:out value="${fn:toUpperCase(adres.land)}" /></td>
					</tr>
				</c:if>

			</c:forEach>
			<c:if test="${bedrijfDTO.bedrijf.opmerking != ''}">
					<tr>
						<td>${bedrijfDTO.bedrijf.opmerking}</td>
					</tr>
			</c:if>
			<tr>
				<td><a href="#modal-one" class="btn btn-big">Wijzig</a> <a
					href="#modal-two" class="btn btn-big">Extra</a></td>
			</tr>
		</table>

		<table class="organisiate-details">

			<c:forEach items="${bedrijfDTO.bedrijf.persoonsrollen}"
				var="persoonsrol" varStatus="loop">
				<c:choose>
				<c:when test="${persoonsrol.einddatum == null}">
				<tr class="bold">
					<td><c:choose>
							<c:when test="${persoonsrol.persoon.geslacht eq 'M'}">
							dhr 
						</c:when>
							<c:when test="${persoonsrol.persoon.geslacht eq 'V'}">
							mvr 
						</c:when>
							<c:otherwise>

							</c:otherwise>
						</c:choose> ${persoonsrol.persoon.voornaam}<c:if
							test="${persoonsrol.persoon.tussenvoegsel != ''}">
					${persoonsrol.persoon.tussenvoegsel} 
					</c:if> ${persoonsrol.persoon.achternaam}</td>
				</tr>
				<tr>
					<td>${persoonsrol.functie}</td>
				</tr>
				<tr>
					<td>${persoonsrol.afdeling}</td>
				</tr>
				
					<c:forEach items="${persoonsrol.persoon.digitaleAdressen}"
						var="digitaalAdres" varStatus="innerloop">
						<tr>
							<td>${digitaalAdres.omschrijving} 
							<c:if
									test="${digitaalAdres.digitaalAdresType.type eq 'email'}">
									<a href="mailto:${digitaalAdres.omschrijving}">
									<img
										src="${pageContext.request.contextPath}/resources/rs4/images/icons/simpleicons/mail.png"
										height="18" width="20"></a>
								</c:if>
							</td>	
						
					</c:forEach>
				<tr>
					<td>${persoonsrol.persoon.opmerking}</td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				</c:when>
				</c:choose>
				
			</c:forEach>
			<tr>
				<td><a href="#modal-three" class="btn btn-big">Wijzig</a> 
				<a href="#modal-four" class="btn btn-big">Nieuw</a>
				<a href="<c:url value='/relatiebeheer/organisaties/zoekContactpersoon-${bedrijfDTO.bedrijf.id}' />" class="btn btn-big" >Zoek</a></td>
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
									<option value="${bedrijfDTO.bedrijf.bedrijfType.id}" selected>${bedrijfDTO.bedrijf.bedrijfType.type}</option>
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

						<c:forEach items="${bedrijfDTO.bedrijf.adressen}" var="adres"
							varStatus="loop">
							<tr>
								<td><form:input type="hidden"
										path="bedrijf.adressen[${loop.index}].id" value="${adres.id}" /></td>
							<tr class="bold">
								<td><label>Adres type: </label></td>
								<td><form:select
										path="bedrijf.adressen[${loop.index}].adresType.id">
										<option value="${adres.adresType.id}" selected>${adres.adresType.type}
											(huidig)</option>
										<c:forEach items="${bedrijfDTO.adresTypes}" var="lookupType"
											varStatus="current" begin="0">
											<option value="${lookupType.id}">${lookupType.type}</option>
										</c:forEach>
									</form:select>
								</td>
								<td><a href="<c:url value='/relatiebeheer/organisaties/verwijderadres-${adres.id}'/>">
								<img src="${pageContext.request.contextPath}/resources/rs4/images/icons/simpleicons/notification_error.png"
								width="20" height="20" alt="Verwijder"></a>
								</td>
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

							<tr></tr>
						</c:forEach>
							<tr>
								<td><label for="opmerking">Opmerking: </label></td>
								<td><form:textarea rows="2" cols="28"
										path="bedrijf.opmerking" /></td>
								<td><form:errors path="bedrijf.opmerking" cssClass="error" /></td>
							</tr>
						<tr>
							<td colspan="3"><input type="submit" name="wijzigadres"
								value="Opslaan" class="btn btn-small"/></td>
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
	<div class="modal" id="modal-two" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<h2>Extra adres</h2>

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
							<th>Adresgegevens</th>
						</tr>
							<tr>
								<td><label>Adres type: </label></td>
								<td>

								<form:select
										path="adres.adresType.id">
								<c:choose>
									<c:when test="${fn:length(bedrijfDTO.bedrijf.adressen) > 0}">
										<option value="1" selected>Post</option>
									</c:when>
									<c:otherwise>
										<option value="5" selected>Bezoek</option>
									</c:otherwise>
								</c:choose>
										<c:forEach items="${bedrijfDTO.adresTypes}" var="lookupType"
											varStatus="current" begin="0">
											<option value="${lookupType.id}">${lookupType.type}</option>
										</c:forEach>
									</form:select></td>
							</tr>
							<tr>
								<td><label for="straat">Straat: </label></td>
								<td><form:input
										path="adres.straat"/></td>
							</tr>
							<tr>
								<td><label for="nummer">Nummer: </label></td>
								<td><form:input
										path="adres.nummer"/></td>
							</tr>
							<tr>
								<td><label for="toevoegsel">Toevoegsel: </label></td>
								<td><form:input
										path="adres.toevoegsel"/></td>
							</tr>
							<tr>
								<td><label for="postcode">Postcode: </label></td>
								<td><form:input
										path="adres.postcode"/></td>
							</tr>
							<tr>
								<td><label for="plaats">Plaats: </label></td>
								<td><form:input
										path="adres.plaats"/></td>
							</tr>
							<tr>
								<td><label for="land">Land: </label></td>
								<td><form:input path="adres.land"  value="Nederland"/></td>
							</tr>
						<tr>
							<td colspan="3"><input type="submit" name="nieuwadres"
								value="Opslaan" class="btn btn-small"/></td>
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
	<div class="modal" id="modal-four" aria-hidden="true">
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
							<td><form:radiobutton path="persoon.geslacht" value="M"
						checked="checked" />Man <form:radiobutton path="persoon.geslacht"
						value="V" />Vrouw</td>
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
							value="Opslaan" class="btn btn-small"/></td>
					</tr>
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
				<h2>Wijzig Contactpersonen</h2>

				<a href="#close" class="btn-close" aria-hidden="true">×</a>
				<!--CHANGED TO "#close"-->
			</div>
			<div class="modal-body">
				<form:form method="POST" modelAttribute="bedrijfDTO">
					<table class="wijzig">
						<tr>
							<form:input type="hidden" path="bedrijf.id" />
						</tr>
				<c:forEach items="${bedrijfDTO.bedrijf.persoonsrollen}"
					var="persoonsrol" varStatus="loop">
				<c:choose>
				<c:when test="${persoonsrol.einddatum == null}">
					<form:input type="hidden"
						path="bedrijf.persoonsrollen[${loop.index}].id" />
					<form:input type="hidden"
						path="bedrijf.persoonsrollen[${loop.index}].rol.id" />
						<form:input type="hidden"
						path="bedrijf.persoonsrollen[${loop.index}].rol" />
					<form:input type="hidden"
						path="bedrijf.persoonsrollen[${loop.index}].begindatum" />
					<form:input type="hidden"
						path="bedrijf.persoonsrollen[${loop.index}].einddatum" />
					<form:input type="hidden"
						path="bedrijf.persoonsrollen[${loop.index}].persoon.id" />
						<tr class="bold">
						<td><label>Voornaam: </label></td>
						<td><form:input
								path="bedrijf.persoonsrollen[${loop.index}].persoon.voornaam" /></td>
						<td><a href="<c:url value='/relatiebeheer/organisaties/verwijderpersoon-${persoonsrol.id}'/>">
								<img src="${pageContext.request.contextPath}/resources/rs4/images/icons/simpleicons/notification_error.png"
								width="20" height="20" alt="Verwijder"></a>
								</td>
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
						<td><label for="geslacht">Geslacht: </label></td>
						<td><form:radiobutton path="bedrijf.persoonsrollen[${loop.index}].persoon.geslacht" value="M"
						checked="checked" />Man <form:radiobutton path="bedrijf.persoonsrollen[${loop.index}].persoon.geslacht"
						value="V" />Vrouw</td>
					</tr>
					<tr>
						<td><label>Functie: </label></td>
						<td><form:input
								path="bedrijf.persoonsrollen[${loop.index}].functie" /></td>
					</tr>
					<tr>
						<td><label>Afdeling: </label></td>
						<td><form:input
								path="bedrijf.persoonsrollen[${loop.index}].afdeling" /></td>
					</tr>
					
					<tr>
						<td><label>Bijzonderheden: </label></td>
						<td><form:textarea rows="2" cols="28"
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

								<form:input type="hidden"
									path="bedrijf.persoonsrollen[${loop.index}].persoon.digitaleAdressen[${innerloop.index}].digitaalAdresType.id" />
							</tr>
						</c:forEach>
				</c:when>
				<c:otherwise>
					<form:input type="hidden" path="bedrijf.persoonsrollen[${loop.index}].id" />
					<form:input type="hidden" path="bedrijf.persoonsrollen[${loop.index}].einddatum" />				
				</c:otherwise>
				</c:choose>
				</c:forEach>
						<tr>
							<td colspan="3"><input type="submit" name="wijzigcontact"
								value="Opslaan" class="btn btn-small"/></td>
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
</body>
