<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>

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
			<!--
				<tr>
					<td><label>Adres type: </label>
					<td><form:input type="hidden" path="adressen[${current.index}].adresType.type" value="${type}"></form:input>
					<td><form:input type="hidden" path="adressen[${current.index}].adresType.id" value="${adresType.id}"></form:input>
				</tr>
				  -->
					
					<td><label>Adres type: </label></td>
					<td><form:select path="adressen[${current.index}].adresType.id">
						<option value="${adres.adresType.id}" selected>${adres.adresType.type} (huidig)</option>
					<c:forEach items="${adresTypes}" var="lookupType" varStatus="current" begin="0">
						<option value="${lookupType.id}">${lookupType.id}${lookupType.type}</option>
					</c:forEach>
					</form:select></td>
						
				
				
				<tr></tr>	
				<td colspan="3"><input type="submit" value="Wijzig Persoon" /></td>	
				<tr>		
			</c:forEach>
		</table>
		
		<!--  
		<table class="details">
			<th>Digitaal Adres</th>
			<c:forEach items="${persoon.digitaleAdressen}" var="digitaleadres" varStatus="loop">
					<tr class="element"> 
						<form:input type="hidden" path="digitaleAdressen[${loop.index}].id" value="${digitaleadres.id}"/>
						<td><label>${digitaleadres.digitaalAdresType.type} </label></td>
						<td><form:input path="digitaleAdressen[${loop.index}].omschrijving" id="omschrijving"
								value="${digitaleadres.omschrijving}" size="30" /></td>
						<td><label>voorkeur </label></td>
						<td><form:radiobutton path="digitaleAdressen[${loop.index}].contactvoorkeur" value="true"/>Yes
							<form:radiobutton path="digitaleAdressen[${loop.index}].contactvoorkeur" value="false"/>No
						</td>
						<form:input type="hidden" path="digitaleAdressen[${loop.index}].digitaalAdresType.id" value="${digitaleadres.digitaalAdresType.id}"/>
					</tr>
			</c:forEach>
			<tr></tr>
		</table>
		-->
		
		<!--  
		<table class="details">
		<th>Digitaal Adres</th>
			<c:forEach items="${persoon.digitaleAdressen}" var="digitaleadres">
				<c:if test="${digitaleadres.digitaalAdresType.type == 'email' || digitaleadres.digitaalAdresType.type == 'telefoonnummer' || digitaleadres.digitaalAdresType.type == 'website'}">
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
			<c:forEach items="${persoon.persoonsrollen}" var="persoonsrol">
				<tr class="element">
					<td><label>${persoonsrol.rol.type} </label></td>
					<td><label>begindatum</label></td>
					<td><form:input path="${begindatum}" id="begindatum" value="${persoonsrol.begindatum}" size="10"/></td>
					<td><label>einddatum </label></td>
					<td><form:input path="${einddatum}" id="einddatum" value="${persoonsrol.einddatum}" size="10"/></td>
				</tr>
			</c:forEach>
			<tr></tr>
		</table>
		
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
	
	<br />
	<br /> Ga terug naar
	<a href="<c:url value='/personen' />">Lijst van alle Personen</a>
</body>
