<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
	<h2>Personenlijst</h2>
	<table class="list">
		<tr class="tabelheader">
			<td>Voornaam</td>
			<td>Achternaam</td>
			<td>Tussenvoegsel</td>
			<td>Rollen</td>
			<td></td>
		</tr>
		<c:forEach items="${personen}" var="persoon">
			<tr class="element">
				<td>${persoon.voornaam}</td>
				<td>${persoon.achternaam}</td>
				<td>${persoon.tussenvoegsel}</td>
				<td>${persoon.persoonsrollen}</td>
				<td><a href="<c:url value='/personen/update-${persoon.id}-persoon' />">Details</a></td>
			</tr>
		</c:forEach>
		
	</table>
	<br></br>
	<a href="<c:url value='/personen/nieuw' />">Voeg nieuw persoon toe</a>
	
</body>