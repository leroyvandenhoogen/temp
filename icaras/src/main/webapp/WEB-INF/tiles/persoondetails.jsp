<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<h1 style="color:red">${gewijzigd}</h1>
	<form:form method="POST" modelAttribute="persoon">
		<table class="details">
		<th>Persoonsgegevens </th>
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
			<tr>
				<td><label for="opmerking">Bijzonderheden: </label></td>
				<td><form:textarea rows="5" cols="20" path="opmerking"
						id="opmerking" />
				<td><form:errors path="opmerking" cssClass="error" /></td>
			</tr>
			<tr></tr>
		</table>
		
		<table class="details">
			<th>Adresgegevens</th>
			 <c:forEach items="${persoon.adressen}" var="adres" varStatus="current" begin="0">
			 	<tr>
			 		<td><form:input type="hidden" path="adressen[${current.index}].id" value="${adres.id}"></form:input>
			 	</tr>
			 <c:if test="${current.index > 0}">
			 		<tr>
			 			<td><label><strong>Adres ${current.index+1}</strong></label>
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
							value="${nummer}"/></td>
				</tr>
				<tr>
					<td><label>Toevoegsel: </label></td>
					<td><form:input path="adressen[${current.index}].toevoegsel"
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
					<td><label>Land: </label></td>
					<td><form:input path="adressen[${current.index}].land" value="${land}" /></td>
				</tr>
				<tr>
					<td><label>Begin datum: </label></td>
					<td><form:input type="date" path="adressen[${current.index}].begindatum"
							value="${begindatum}" /></td>
				</tr>
				<tr>
					<td><label>Eind datum: </label></td>
					<td><form:input type="date" path="adressen[${current.index}].einddatum"
							value="${einddatum}" /></td>
				</tr>
					
					<td><label>Adres type: </label></td>
					<td><form:select path="adressen[${current.index}].adresType.id">
						<option value="${adres.adresType.id}" selected>${adres.adresType.type} (huidig)</option>
					<c:forEach items="${adresTypes}" var="lookupType" varStatus="current" begin="0">
						<option value="${lookupType.id}">${lookupType.type}</option>
					</c:forEach>
					</form:select></td>
				<tr></tr>	

				<tr>		
			</c:forEach>
		</table>
		
		<table class="details">
			<th>Digitaal Adres</th>
			<c:forEach items="${persoon.digitaleAdressen}" var="digitaleadres"
				varStatus="current">
					<tr class="element">
						<form:input type="hidden"
							path="digitaleAdressen[${current.index}].id"
							value="${digitaleadres.id}" />
						<td><label>${digitaleadres.digitaalAdresType.type} </label></td>
						<td><form:input
								path="digitaleAdressen[${current.index}].omschrijving"
								id="omschrijving" value="${digitaleadres.omschrijving}"
								size="30" /></td>
						<td><label>voorkeur </label></td>
						<td><form:radiobutton
								path="digitaleAdressen[${current.index}].contactvoorkeur"
								value="true" />Yes <form:radiobutton
								path="digitaleAdressen[${current.index}].contactvoorkeur"
								value="false" />No</td>
						<form:input type="hidden"
							path="digitaleAdressen[${current.index}].digitaalAdresType.id"
							value="${digitaleadres.digitaalAdresType.id}" />
					</tr>
			</c:forEach>
			<tr></tr>
		</table>

		<table class="details">
		<th>Persoonsrollen</th>
			<c:forEach items="${persoon.persoonsrollen}" var="persoonsrol" varStatus="current">
				<tr class="element">
					<form:input type="hidden" path="persoonsrollen[${current.index}].id" value="${persoonsrol.id}" />
					<form:input type="hidden" path="persoonsrollen[${current.index}].rol.id" value="${persoonsrol.rol.id}" />
					<form:input type="hidden" path="persoonsrollen[${current.index}].rol.type" id="type" value="${persoonsrol.rol.type}"/>
					<td><label>${persoonsrol.rol.type}</label>
					<td><label>begindatum</label></td>
					<td><form:input type="date" path="persoonsrollen[${current.index}].begindatum" id="begindatum" value="${persoonsrol.begindatum}" size="10"/></td>
					<td><label>einddatum </label></td>
					<td><form:input type="date" path="persoonsrollen[${current.index}].einddatum" id="einddatum" value="${persoonsrol.einddatum}" size="10"/></td>
				</tr>
			</c:forEach>
			<tr></tr>
			<td colspan="3"><input type="submit" value="Wijzig Persoon" name="wijzig" /></td>
			<tr></tr>
			<td colspan="3"><input type="submit" value="Verwijder Persoon" name="verwijder"/></td>	
		</table>
		<!--
			<table class="details">
			<c:forEach items="${persoon.identiteitsbewijzen}"
				var="identiteitsbewijs">
				<tr class="element">
					<td>${identiteitsbewijs.nummer}</td>
					<td>${identiteitsbewijs.vervaldatum}</td>
					<td>${identiteitsbewijs.identiteitsbewijsType}</td>
				</tr>
			</c:forEach>
			<tr></tr>
						<tr>
				<td colspan="3"><input type="submit" value="Wijzig Persoon" /></td>
			</tr>
		</table>
		-->
	</form:form>
</body>
