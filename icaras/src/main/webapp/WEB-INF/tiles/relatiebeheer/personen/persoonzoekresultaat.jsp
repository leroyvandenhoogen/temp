<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<h1 style="color: red">${gewijzigd}</h1>
	<p>
		<input type="submit"
			onclick="location.href='${pageContext.request.contextPath}/relatiebeheer/personen/zoeken'"
			value="Terug naar zoekpagina" />
	</p>
	<div class="content">
		<form:form method="POST" modelAttribute="persoonDTO">
			<div class="eenderde">

				<table class="gegevens-table">
					<th>Persoon</th>
					<tr>
						<td><label for="voornaam">Voornaam: </label></td>
						<td><form:input path="persoonDTO.persoon.voornaam"
								id="voornaam" /></td>
						<td><form:errors path="persoonDTO.persoon.voornaam"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td><label for="achternaam">Achternaam: </label></td>
						<td><form:input path="persoonDTO.persoon.achternaam"
								id="achternaam" /></td>
						<td><form:errors path="persoonDTO.persoon.achternaam"
								cssClass="error" /></td>
					</tr>

					<tr>
						<td><label for="tussenvoegsel">Tussenvoegsel: </label></td>
						<td><form:input path="persoonDTO.persoon.tussenvoegsel"
								id="tussenvoegsel" /></td>
						<td><form:errors path="persoonDTO.persoon.tussenvoegsel"
								cssClass="error" /></td>
					</tr>

					<tr>
						<td><label for="geboortedatum">Geboortedatum: </label></td>
						<td><form:input path="persoonDTO.persoon.geboortedatum"
								id="geboortedatum" /></td>
						<td><form:errors path="persoonDTO.persoon.geboortedatum"
								cssClass="geboortedatum" /></td>
					</tr>

					<tr>
						<td><label for="geslacht">Geslacht: </label></td>
						<td><form:radiobutton path="persoonDTO.persoon.geslacht"
								value="M" />Man <form:radiobutton
								path="persoonDTO.persoon.geslacht" value="V" />Vrouw</td>
					</tr>

					<tr class="element">
						<td><label>Telefoonnummer: </label></td>
						<c:forEach items="${persoonDTO.digitaleAdressen}"
							var="digitaleadres" varStatus="current">
							<c:if
								test="${digitaleadres.digitaalAdresType.type == 'telefoonnummer'}">
								<form:input type="hidden"
									path="digitaleAdressen[${current.index}].id"
									value="${digitaleadres.id}" />
								<form:input type="hidden"
									path="digitaleAdressen[${current.index}].digitaalAdresType.type"
									value="${digitaleadres.digitaalAdresType.type}" />
								<td><form:input
										path="digitaleAdressen[${current.index}].omschrijving"
										id="omschrijving" value="${digitaleadres.omschrijving}"
										size="25" /></td>
								<form:input type="hidden"
									path="digitaleAdressen[${current.index}].digitaalAdresType.id"
									value="${digitaleadres.digitaalAdresType.id}" />

							</c:if>
						</c:forEach>
					</tr>

					<tr class="element">
						<td><label>Email: </label></td>
						<c:forEach items="${persoonDTO.digitaleAdressen}"
							var="digitaleadres" varStatus="current">
							<c:if test="${digitaleadres.digitaalAdresType.type == 'email'}">

								<form:input type="hidden"
									path="digitaleAdressen[${current.index}].id"
									value="${digitaleadres.id}" />
								<form:input type="hidden"
									path="digitaleAdressen[${current.index}].digitaalAdresType.type"
									value="${digitaleadres.digitaalAdresType.type}" />
								<td><form:input
										path="digitaleAdressen[${current.index}].omschrijving"
										id="omschrijving" value="${digitaleadres.omschrijving}"
										size="25" /></td>
								<form:input type="hidden"
									path="digitaleAdressen[${current.index}].digitaalAdresType.id"
									value="${digitaleadres.digitaalAdresType.id}" />
							</c:if>
						</c:forEach>
					</tr>

					<tr>
						<td><label for="opmerking">Bijzonderheden: </label></td>
						<td><form:textarea rows="5" cols="20"
								path="persoonDTO.persoon.opmerking" id="opmerking" />
						<td><form:errors path="persoonDTO.persoon.opmerking"
								cssClass="error" /></td>
					</tr>
					<table class="modal-table">
						<tr>
							<td><a href="#modal-wijzigpersoon" class="btn btn-small">Wijzig</a></td>
							<td><a href="#modal-deletepersoon" class="btn btn-small">Delete</a></td>
						</tr>
					</table>
				</table>
			</div>

			<div class="eenderde">
				<c:if test="${not empty persoonDTO.persoon.adressen}">
					<table class="gegevens-table">
						<th>Adres</th>
						<c:forEach items="${persoonDTO.persoon.adressen}" var="adres"
							varStatus="current" begin="0">
							<tr>
								<td><form:input type="hidden"
										path="adressen[${current.index}].id" value="${adres.id}"></form:input>
							</tr>
							<c:if test="${current.index > 0}">
								<tr>
									<td><label><strong>Adres
												${current.index+1}</strong></label>
								</tr>
							</c:if>
							<tr>
								<td><label></label>
							</tr>
							<tr>
								<td><label>Straat: </label></td>
								<td><form:input path="adressen[${current.index}].straat"
										value="${straat}" /></td>
							</tr>
							<tr>
								<td><label>Nummer: </label></td>
								<td><form:input path="adressen[${current.index}].nummer"
										value="${nummer}" /></td>
							</tr>
							<tr>
								<td><label>Toevoegsel: </label></td>
								<td><form:input
										path="adressen[${current.index}].toevoegsel"
										value="${toevoegsel}" /></td>
							</tr>
							<tr>
								<td><label>Postcode: </label></td>
								<td><form:input path="adressen[${current.index}].postcode"
										value="${postcode}" /></td>
							</tr>
							<tr>
								<td><label>Plaats: </label></td>
								<td><form:input path="adressen[${current.index}].plaats"
										value="${plaats}" /></td>
							</tr>
							<tr>
								<td><label>Provincie: </label></td>
								<td><form:input path="adressen[${current.index}].provincie"
										value="${provincie}" /></td>
							</tr>
							<tr>
								<td><label>Land: </label></td>
								<td><form:input path="adressen[${current.index}].land"
										value="${land}" /></td>
							</tr>

							<td><label>Adres type: </label></td>
							<td><form:select
									path="adressen[${current.index}].adresType.id">
									<option value="${adres.adresType.id}" selected>${adres.adresType.type}
										(huidig)</option>
									<c:forEach items="${adresTypes}" var="lookupType"
										varStatus="current" begin="0">
										<option value="${lookupType.id}">${lookupType.type}</option>
									</c:forEach>
								</form:select></td>
							<table class="modal-table">
								<tr>
									<td><a href="#modal-wijzigadres" class="btn btn-small">Wijzig</a></td>
									<td><a href="#modal-deleteadres" class="btn btn-small">Delete</a></td>
									<td><a href="#modal-nieuwadres" class="btn btn-small">Voeg
											toe</a></td>
								</tr>
							</table>
						</c:forEach>
					</table>
				</c:if>
			</div>

			<div class="eenderde">
				<c:if test="${not empty persoonDTO.persoon.persoonsrollen}">
					<table class="gegevens-table">
						<th>Rol</th>
						<c:forEach items="${persoonDTO.persoon.persoonsrollen}"
							var="persoonsrol" varStatus="current">
							<tr class="element">
								<form:input type="hidden"
									path="persoonsrollen[${current.index}].id"
									value="${persoonsrol.id}" />
								<form:input type="hidden"
									path="persoonsrollen[${current.index}].rol.id"
									value="${persoonsrol.rol.id}" />
								<form:input type="hidden"
									path="persoonsrollen[${current.index}].rol.type" id="type"
									value="${persoonsrol.rol.type}" />
								<td><label>${persoonsrol.rol.type}: </label>
								<td><label>Begin:</label></td>
								<td><form:input type="date"
										path="persoonsrollen[${current.index}].begindatum"
										id="begindatum" value="${persoonsrol.begindatum}" size="10" /></td>
								<td><label>Eind:</label></td>
								<td><form:input type="date"
										path="persoonsrollen[${current.index}].einddatum"
										id="einddatum" value="${persoonsrol.einddatum}" size="10" /></td>
							</tr>
						</c:forEach>
						<table class="modal-table">
							<tr>
								<td><a href="#modal-wijzigrol" class="btn btn-small">Wijzig</a></td>
								<td><a href="#modal-deleterol" class="btn btn-small">Delete</a></td>
								<td><a href="#modal-nieuwrol" class="btn btn-small">Voeg
										toe</a></td>
							</tr>
						</table>
					</table>
				</c:if>
			</div>
		</form:form>
	</div>
	<div class="wrap"></div>

	<!-- Modal -->
	<div class="modal" id="modal-wijzigpersoon" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<h2>Wijzig gegevens</h2>

				<a href="#close" class="btn-close" aria-hidden="true">×</a>
				<!--CHANGED TO "#close"-->
			</div>
			<div class="modal-body">
				<form:form method="POST" modelAttribute="persoonDTO">
					<table class="gegevens-table">
						<th>Persoon</th>
						<tr>
							<td><label for="voornaam">Voornaam: </label></td>
							<td><form:input path="persoonDTO.persoon.voornaam"
									id="voornaam" /></td>
							<td><form:errors path="persoonDTO.persoon.voornaam"
									cssClass="error" /></td>
						</tr>
						<tr>
							<td><label for="achternaam">Achternaam: </label></td>
							<td><form:input path="persoonDTO.persoon.achternaam"
									id="achternaam" /></td>
							<td><form:errors path="persoonDTO.persoon.achternaam"
									cssClass="error" /></td>
						</tr>

						<tr>
							<td><label for="tussenvoegsel">Tussenvoegsel: </label></td>
							<td><form:input path="persoonDTO.persoon.tussenvoegsel"
									id="tussenvoegsel" /></td>
							<td><form:errors path="persoonDTO.persoon.tussenvoegsel"
									cssClass="error" /></td>
						</tr>

						<tr>
							<td><label for="geboortedatum">Geboortedatum: </label></td>
							<td><form:input path="persoonDTO.persoon.geboortedatum"
									id="geboortedatum" /></td>
							<td><form:errors path="persoonDTO.persoon.geboortedatum"
									cssClass="geboortedatum" /></td>
						</tr>

						<tr>
							<td><label for="geslacht">Geslacht: </label></td>
							<td><form:radiobutton path="persoonDTO.persoon.geslacht"
									value="M" />Man <form:radiobutton
									path="persoonDTO.persoon.geslacht" value="V" />Vrouw</td>
						</tr>

						<tr class="element">
							<td><label>Telefoonnummer: </label></td>
							<c:forEach items="${persoonDTO.digitaleAdressen}"
								var="digitaleadres" varStatus="current">
								<c:if
									test="${digitaleadres.digitaalAdresType.type == 'telefoonnummer'}">
									<form:input type="hidden"
										path="digitaleAdressen[${current.index}].id"
										value="${digitaleadres.id}" />
									<form:input type="hidden"
										path="digitaleAdressen[${current.index}].digitaalAdresType.type"
										value="${digitaleadres.digitaalAdresType.type}" />
									<td><form:input
											path="digitaleAdressen[${current.index}].omschrijving"
											id="omschrijving" value="${digitaleadres.omschrijving}"
											size="25" /></td>
									<form:input type="hidden"
										path="digitaleAdressen[${current.index}].digitaalAdresType.id"
										value="${digitaleadres.digitaalAdresType.id}" />

								</c:if>
							</c:forEach>
						</tr>

						<tr class="element">
							<td><label>Email: </label></td>
							<c:forEach items="${persoonDTO.digitaleAdressen}"
								var="digitaleadres" varStatus="current">
								<c:if test="${digitaleadres.digitaalAdresType.type == 'email'}">

									<form:input type="hidden"
										path="digitaleAdressen[${current.index}].id"
										value="${digitaleadres.id}" />
									<form:input type="hidden"
										path="digitaleAdressen[${current.index}].digitaalAdresType.type"
										value="${digitaleadres.digitaalAdresType.type}" />

									<td><form:input
											path="digitaleAdressen[${current.index}].omschrijving"
											id="omschrijving" value="${digitaleadres.omschrijving}"
											size="25" /></td>
									<form:input type="hidden"
										path="digitaleAdressen[${current.index}].digitaalAdresType.id"
										value="${digitaleadres.digitaalAdresType.id}" />
								</c:if>
							</c:forEach>
						</tr>

						<tr>
							<td><label for="opmerking">Bijzonderheden: </label></td>
							<td><form:textarea rows="5" cols="20"
									path="persoonDTO.persoon.opmerking" id="opmerking" />
							<td><form:errors path="persoonDTO.persoon.opmerking"
									cssClass="error" /></td>
						</tr>
						<tr>
							<td colspan="3"><input type="submit" name="wijzigpersoon"
								value="Wijzig" /></td>
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
	<!-- /Modal -->

	<!-- Modal -->
	<div class="modal" id="modal-wijzigadres" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<h2>Wijzig gegevens</h2>

				<a href="#close" class="btn-close" aria-hidden="true">×</a>
				<!--CHANGED TO "#close"-->
			</div>
			<div class="modal-body">
				<form:form method="POST" modelAttribute="persoonDTO">
					<c:if test="${not empty persoonDTO.persoon.adressen}">
						<table class="gegevens-table">
							<th>Adres</th>
							<c:forEach items="${persoonDTO.persoon.adressen}" var="adres"
								varStatus="current" begin="0">
								<tr>
									<td><form:input type="hidden"
											path="adressen[${current.index}].id" value="${adres.id}"></form:input>
								</tr>
								<c:if test="${current.index > 0}">
									<tr>
										<td><label><strong>Adres
													${current.index+1}</strong></label>
									</tr>
								</c:if>
								<tr>
									<td><label></label>
								</tr>
								<tr>
									<td><label>Straat: </label></td>
									<td><form:input path="adressen[${current.index}].straat"
											value="${straat}" /></td>
								</tr>
								<tr>
									<td><label>Nummer: </label></td>
									<td><form:input path="adressen[${current.index}].nummer"
											value="${nummer}" /></td>
								</tr>
								<tr>
									<td><label>Toevoegsel: </label></td>
									<td><form:input
											path="adressen[${current.index}].toevoegsel"
											value="${toevoegsel}" /></td>
								</tr>
								<tr>
									<td><label>Postcode: </label></td>
									<td><form:input path="adressen[${current.index}].postcode"
											value="${postcode}" /></td>
								</tr>
								<tr>
									<td><label>Plaats: </label></td>
									<td><form:input path="adressen[${current.index}].plaats"
											value="${plaats}" /></td>
								</tr>
								<tr>
									<td><label>Provincie: </label></td>
									<td><form:input
											path="adressen[${current.index}].provincie"
											value="${provincie}" /></td>
								</tr>
								<tr>
									<td><label>Land: </label></td>
									<td><form:input path="adressen[${current.index}].land"
											value="${land}" /></td>
								</tr>

								<td><label>Adres type: </label></td>
								<td><form:select
										path="adressen[${current.index}].adresType.id">
										<option value="${adres.adresType.id}" selected>${adres.adresType.type}
											(huidig)</option>
										<c:forEach items="${adresTypes}" var="lookupType"
											varStatus="current" begin="0">
											<option value="${lookupType.id}">${lookupType.type}</option>
										</c:forEach>
									</form:select></td>
								<tr>
									<td colspan="3"><input type="submit" name="wijzig"
										value="Wijzig" /></td>
								</tr>
								<tr></tr>

								<tr>
							</c:forEach>
						</table>
					</c:if>

				</form:form>
			</div>
			<div class="modal-footer">
				<a href="#close" class="btn">Sluiten</a>
				<!--CHANGED TO "#close"-->
			</div>
		</div>
	</div>
	<!-- /Modal -->

	<!-- Modal -->
	<div class="modal" id="modal-wijzigrol" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<h2>Wijzig gegevens</h2>

				<a href="#close" class="btn-close" aria-hidden="true">×</a>
				<!--CHANGED TO "#close"-->
			</div>
			<div class="modal-body">
				<form:form method="POST" modelAttribute="persoonDTO">
					<c:if test="${not empty persoonDTO.persoon.persoonsrollen}">
						<table class="gegevens-table">
							<th>Rol</th>
							<c:forEach items="${persoonDTO.persoon.persoonsrollen}"
								var="persoonsrol" varStatus="current">
								<tr class="element">
									<form:input type="hidden"
										path="persoonsrollen[${current.index}].id"
										value="${persoonsrol.id}" />
									<form:input type="hidden"
										path="persoonsrollen[${current.index}].rol.id"
										value="${persoonsrol.rol.id}" />
									<form:input type="hidden"
										path="persoonsrollen[${current.index}].rol.type" id="type"
										value="${persoonsrol.rol.type}" />
									<td><label>${persoonsrol.rol.type}</label>
									<td><label>begindatum</label></td>
									<td><form:input type="date"
											path="persoonsrollen[${current.index}].begindatum"
											id="begindatum" value="${persoonsrol.begindatum}" size="10" /></td>
									<td><label>einddatum </label></td>
									<td><form:input type="date"
											path="persoonsrollen[${current.index}].einddatum"
											id="einddatum" value="${persoonsrol.einddatum}" size="10" /></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="3"><input type="submit" name="wijzig"
									value="Wijzig" /></td>
							</tr>
						</table>
					</c:if>
				</form:form>
			</div>
			<div class="modal-footer">
				<a href="#close" class="btn">Sluiten</a>
				<!--CHANGED TO "#close"-->
			</div>
		</div>
	</div>
	<!-- /Modal -->

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</body>
