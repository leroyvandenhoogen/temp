<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
	<h2>Organisatieslijst</h2>
	<table class="list">
		<tr class="tabelheader">
			<td>Naam</td>
			<td>kvkNummer</td>
			<td>opmerking</td>
			<td>Details</td>
		</tr>
		<c:forEach items="${organisaties}" var="organisatie">
			<tr class="element">
				<td>${organisatie.naam}</td>
				<td>${organisatie.kvkNummer}</td>
				<td>${organisatie.opmerking}</td>
				<td><a href="<c:url value='/organisaties/update-${organisatie.id}-organisatie' />">Details</a></td>
			</tr>
		</c:forEach>
	</table>
</body>