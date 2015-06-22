<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table class="details">
			
			<th>Adresgegevens</th>
			<c:forEach items="${organisatie.adressen}" var="adres"
				varStatus="loop">
				<tr>
					<td><form:input path="adressen[${loop.index}].id"
							value="${adres.id}" /></td>
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
					<td><label for="begindatum">Begin datum: </label></td>
					<td><form:input path="adressen[${loop.index}].begindatum"
							value="${adres.begindatum}" /></td>
				</tr>
				<tr>
					<td><label for="einddatum">Eind datum: </label></td>
					<td><form:input path="adressen[${loop.index}].einddatum"
							value="${adres.einddatum}" /></td>
				</tr>
				<tr></tr>
			</c:forEach>
		</table>