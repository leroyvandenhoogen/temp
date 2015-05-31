<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
	<h2>Personenlijst</h2>
	<table class="list">
		<tr class="tabelheader">
			<td>Voornaam</td>
			<td>Achternaam</td>
			<td>Tussenvoegsel</td>
			<td>Rollen</td>
		</tr>
		<c:forEach items="${personen}" var="persoon">
			<tr class="element">

				<td>${persoon.voornaam}</td>
				<td>${persoon.achternaam}</td>
				<td>${persoon.tussenvoegsel}</td>
				<td><a href="<c:url value='/personen/update-${persoon.id}-persoon' />">${persoon.id}</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="http://www.w3schools.com/html/">Visit our HTML tutorial</a>
</body>