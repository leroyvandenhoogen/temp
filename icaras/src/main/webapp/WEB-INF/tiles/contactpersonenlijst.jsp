<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
	<h2>Contactpersonenlijst</h2>
	<table class="list">
		<tr class="tabelheader">
			<td>Voornaam</td>
			<td>Achternaam</td>
			<td>Tussenvoegsel</td>
			<td>Organisatie</td>
			<td>Details</td>
		</tr>
		<c:forEach items="${contactpersonen}" var="contactpersoon">
			<tr class="element">
				<td>${contactpersoon.voornaam}</td>
				<td>${contactpersoon.achternaam}</td>
				<td>${contactpersoon.tussenvoegsel}</td>
				
				<td><a href="<c:url value='/contactpersonen/update-${contactpersoon.id}-persoon' />">Details</a></td>
			</tr>
		</c:forEach>
	</table>
</body>