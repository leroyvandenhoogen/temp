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
				<td>${contactpersoon.persoon.voornaam}</td>
				<td>${contactpersoon.persoon.achternaam}</td>
				<td>${contactpersoon.persoon.tussenvoegsel}</td>
				<td>${contactpersoon.bedrijf.naam}</td>
				
				<td><a href="<c:url value='/contactpersonen/update-${contactpersoon.persoon.id}-persoon' />">Details</a></td>
			</tr>
		</c:forEach>
	</table>
</body>