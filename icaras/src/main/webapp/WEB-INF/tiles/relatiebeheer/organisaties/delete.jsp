<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>

	<h2>U staat op het punt de volgende organisatie te verwijderen:</h2>


	<form:form method="POST" modelAttribute="organisatie">
		<table>
			<tr>
				<td><label>Naam: </label></td>
				<td>${organisatie.naam}</td>
			</tr>

			<tr>
				<td><label>Plaats: </label></td>
				<c:forEach items="${organisatie.adressen}" var="adres">
					<c:if test="${adres.adresType.type == 'bezoek' }">
						<td>${adres.plaats}</td>
					</c:if>
				</c:forEach>
			</tr>
			<tr>
				<td><input type="button" value="Ga terug"
					onclick="history.back();" /></td>
				<td colspan="3"><input type="submit" value="Bevestig" /></td>
			</tr>
		</table>
	</form:form>
</body>