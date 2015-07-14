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
						<td>${persoonDTO.persoon.voornaam}</td>
					</tr>
					<tr>
						<td><label for="achternaam">Achternaam: </label></td>
						<td>${persoonDTO.persoon.achternaam}</td>
					</tr>

					<tr>
						<td><label for="tussenvoegsel">Tussenvoegsel: </label></td>
						<td>${persoonDTO.persoon.tussenvoegsel}</td>
					</tr>

					<tr>
						<td><label for="geboortedatum">Geboortedatum: </label></td>
						<td>${persoonDTO.persoon.geboortedatum}</td>
					</tr>

					<tr>
						<td><label for="geslacht">Geslacht: </label></td>
						<td><form:radiobutton path="persoonDTO.persoon.geslacht"
								value="M" />Man <form:radiobutton
								path="persoonDTO.persoon.geslacht" value="V" />Vrouw</td>
					</tr>

					<tr class="element">
						<td><label>Telefoonnummer: </label></td>
						<c:forEach items="${persoonDTO.persoon.digitaleAdressen}"
							var="digitaleadres" varStatus="current">
							<c:if
								test="${digitaleadres.digitaalAdresType.type == 'telefoonnummer'}">
								<td>${digitaleadres.omschrijving}</td>
							</c:if>
						</c:forEach>
					</tr>

					<tr class="element">
						<td><label>Email: </label></td>
						<c:forEach items="${persoonDTO.persoon.digitaleAdressen}"
							var="digitaleadres" varStatus="current">
							<c:if test="${digitaleadres.digitaalAdresType.type == 'email'}">
								<td>${digitaleadres.omschrijving}</td>
							</c:if>
						</c:forEach>
					</tr>

					<tr>
						<td><label>Bijzonderheden: </label></td>
						<td><textarea rows="5" cols="15"
								${persoonDTO.persoon.opmerking} /></textarea></td>
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
				<table class="gegevens-table">
					<th>Adres</th>
					<c:if test="${not empty persoonDTO.persoon.adressen}">
						<c:forEach items="${persoonDTO.persoon.adressen}" var="adres"
							varStatus="current" begin="0">
							<c:if test="${current.index > 0}">
								<tr>
									<td><label><strong>Adres
												${current.index+1}</strong></label>
								</tr>
							</c:if>
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
								<td><label>Provincie: </label></td>
								<td>${adres.provincie}</td>
							</tr>
							<tr>
								<td><label>Land: </label></td>
								<td>${adres.land}</td>
							</tr>

							<td><label>Adres type: </label></td>
							<td>${adres.adresType.type}</td>
						</c:forEach>
					</c:if>
					<table class="modal-table">
						<tr>
							<td><a href="#modal-wijzigadres" class="btn btn-small">Wijzig</a></td>
							<td><a href="#modal-deleteadres" class="btn btn-small">Delete</a></td>
							<td><a href="#modal-nieuwadres" class="btn btn-small">Voeg
									toe</a></td>
						</tr>
					</table>
				</table>
			</div>

			<div class="eenderde">
				<table class="gegevens-table">
					<th>Rol</th>
					<c:if test="${not empty persoonDTO.persoon.persoonsrollen}">
						<c:forEach items="${persoonDTO.persoon.persoonsrollen}"
							var="persoonsrol" varStatus="current">
							<tr class="element">
								<td><label>${persoonsrol.rol.type} </label>
								<td><label>Begin:</label></td>
								<td>${persoonsrol.begindatum}</td>
								<td><label>Eind:</label></td>
								<td>${persoonsrol.einddatum}</td>
							</tr>

							<c:if test="${persoonsrol.rol.type eq 'contactpersoon'}">
								<tr>
									<td></td>
									<td><label>Functie:</label></td>
									<td>${persoonsrol.functie}</td>
									<td><label>Afdeling:</label></td>
									<td>${persoonsrol.afdeling}</td>
								</tr>
							</c:if>
						</c:forEach>
					</c:if>
					<table class="modal-table">
						<tr>
							<td><a href="#modal-wijzigrol" class="btn btn-small">Wijzig</a></td>
							<td><a href="#modal-deleterol" class="btn btn-small">Delete</a></td>
							<td><a href="#modal-nieuwrol" class="btn btn-small">Voeg
									toe</a></td>
						</tr>
					</table>
				</table>

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
							<form:input type="hidden" path="persoon.id" />
						</tr>
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
							<c:forEach items="${persoonDTO.persoon.digitaleAdressen}"
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
							<c:forEach items="${persoonDTO.persoon.digitaleAdressen}"
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
					<tr>
						<form:input type="hidden" path="persoon.id" />
					</tr>
					<c:if test="${not empty persoonDTO.persoon.adressen}">
						<table class="gegevens-table">
							<th>Adres</th>
							<c:forEach items="${persoonDTO.persoon.adressen}" var="adres"
								varStatus="current" begin="0">
								<tr>
									<td><form:input type="hidden"
											path="persoon.adressen[${current.index}].id"
											value="${adres.id}"></form:input>
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
									<td><form:input
											path="persoon.adressen[${current.index}].straat"
											value="${adres.straat}" /></td>
								</tr>
								<tr>
									<td><label>Nummer: </label></td>
									<td><form:input
											path="persoon.adressen[${current.index}].nummer"
											value="${adres.nummer}" /></td>
								</tr>
								<tr>
									<td><label>Toevoegsel: </label></td>
									<td><form:input
											path="persoon.adressen[${current.index}].toevoegsel"
											value="${adres.toevoegsel}" /></td>
								</tr>
								<tr>
									<td><label>Postcode: </label></td>
									<td><form:input
											path="persoon.adressen[${current.index}].postcode"
											value="${adres.postcode}" /></td>
								</tr>
								<tr>
									<td><label>Plaats: </label></td>
									<td><form:input
											path="persoon.adressen[${current.index}].plaats"
											value="${adres.plaats}" /></td>
								</tr>
								<tr>
									<td><label>Provincie: </label></td>
									<td><form:input
											path="persoon.adressen[${current.index}].provincie"
											value="${adres.provincie}" /></td>
								</tr>
								<tr>
									<td><label>Land: </label></td>
									<td><form:input
											path="persoon.adressen[${current.index}].land"
											value="${adres.land}" /></td>
								</tr>

								<td><label>Adres type: </label></td>
								<td><form:select
										path="persoon.adressen[${current.index}].adresType.id">
										<option value="${adres.adresType.id}" selected>${adres.adresType.type}
											(huidig)</option>

										<c:forEach items="${adresTypes}" var="lookupType"
											varStatus="current" begin="0">
											<option value="${lookupType.id}">${lookupType.type}</option>
										</c:forEach>
									</form:select></td>
							</c:forEach>
							<tr>
								<td colspan="3"><input type="submit" name="wijzigadres"
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

	<!-- Modal -->
	<div class="modal" id="modal-nieuwadres" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<h2>Nieuw adres</h2>

				<a href="#close" class="btn-close" aria-hidden="true">×</a>
				<!--CHANGED TO "#close"-->
			</div>
			<div class="modal-body">
				<form:form method="POST" modelAttribute="persoonDTO">
					<tr>
						<form:input type="hidden" path="persoon.id" />
					</tr>
					<table class="gegevens-table">
						<th>Adres</th>
						<tr>
							<td><label>Straat: </label></td>
							<td><form:input path="adres.straat" value="${adres.straat}" /></td>
						</tr>
						<tr>
							<td><label>Nummer: </label></td>
							<td><form:input path="adres.nummer" value="${adres.nummer}" /></td>
						</tr>
						<tr>
							<td><label>Toevoegsel: </label></td>
							<td><form:input path="adres.toevoegsel"
									value="${adres.toevoegsel}" /></td>
						</tr>
						<tr>
							<td><label>Postcode: </label></td>
							<td><form:input path="adres.postcode"
									value="${adres.postcode}" /></td>
						</tr>
						<tr>
							<td><label>Plaats: </label></td>
							<td><form:input path="adres.plaats" value="${adres.plaats}" /></td>
						</tr>
						<tr>
							<td><label>Provincie: </label></td>
							<td><form:input path="adres.provincie"
									value="${adres.provincie}" /></td>
						</tr>
						<tr>
							<td><label>Land: </label></td>
							<td><form:input path="adres.land" value="${adres.land}" /></td>
						</tr>

						<td><label>Adres type: </label></td>
						<td><form:select path="adres.adresType.id">
								<option value="1" selected>post</option>

								<c:forEach items="${adresTypes}" var="lookupType"
									varStatus="current" begin="0">
									<option value="${lookupType.id}">${lookupType.type}</option>
								</c:forEach>
							</form:select></td>
						<tr>
							<td colspan="3"><input type="submit" name="nieuwadres"
								value="Voeg toe" /></td>
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



	<div class="modal" id="modal-wijzigrol" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<h2>Wijzig gegevens</h2>

				<a href="#close" class="btn-close" aria-hidden="true">×</a>
			</div>
			<div class="modal-body">
				<form:form method="POST" modelAttribute="persoonDTO">
					<c:if test="${not empty persoonDTO.persoon.persoonsrollen}">
						<table class="gegevens-table">
							<th>Rol</th>
							<c:forEach items="${persoonDTO.persoon.persoonsrollen}"
								var="persoonsrol" varStatus="current" begin="0">
								<tr class="element">

									<form:input type="hidden"
										path="persoon.persoonsrollen[${current.index}].persoon.id" />
									<form:input type="hidden"
										path="persoon.persoonsrollen[${current.index}].id" />
									<td><form:select
											path="persoon.persoonsrollen[${current.index}].rol.id">
											<option value="${persoonsrol.rol.id}" selected>${persoonsrol.rol.type}
											</option>

											<c:forEach items="${rollen}" var="lookupType"
												varStatus="loop" begin="0">
												<option value="${lookupType.id}">${lookupType.type}</option>
											</c:forEach>
										</form:select></td>


									<td><label>begindatum</label></td>
									<td><form:input
											path="persoon.persoonsrollen[${current.index}].begindatum"
											size="10" /></td>
									<td><label>einddatum </label></td>
									<td><form:input
											path="persoon.persoonsrollen[${current.index}].einddatum"
											size="10" /></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="3"><input type="submit" name="wijzigrol"
									value="Wijzig" /></td>
							</tr>
						</table>
					</c:if>
				</form:form>
			</div>
			<div class="modal-footer">
				<a href="#close" class="btn">Sluiten</a>
			</div>
		</div>
	</div>




	<div class="modal" id="modal-nieuwrol" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<h2>Wijzig gegevens</h2>

				<a href="#close" class="btn-close" aria-hidden="true">×</a>
			</div>
			<div class="modal-body">
				<form:form method="POST" modelAttribute="persoonDTO">
					<table class="gegevens-table">
						<th>Rol</th>
						<tr class="element">


							<td><label>begindatum</label></td>
							<td><form:input path="persoonsrol.begindatum" size="10" /></td>
							<td><label>einddatum </label></td>
							<td><form:input path="persoonsrol.einddatum" size="10" /></td>
						</tr>
						<tr>
							<td colspan="3"><input type="submit" name="nieuwrol"
								value="Voeg toe" /></td>
						</tr>
					</table>
				</form:form>
			</div>
			<div class="modal-footer">
				<a href="#close" class="btn">Sluiten</a>

			</div>
		</div>
	</div>


	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</body>