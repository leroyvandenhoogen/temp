<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<body>
	<h1>Zoek een persoon</h1>
	<br>
	<form:form method="POST" modelAttribute="zoekinput">
		<form:input type="text" path="input" name="zoekinputarea" value="" />
		<input type="submit" value="zoek" />
	</form:form>
	<h2>Zoekcriteria: ${zoekinput.input}</h2>
	<c:choose>
		<c:when test="${fn:length(personen) > 0}">
			<c:if test="${fn:length(personen) > 1}">
				<h2>Er zijn ${fn:length(personen)} personen gevonden
					(${zoekinput.total} s)</h2>
			</c:if>
			<c:if test="${fn:length(personen) == 1}">
				<h2>Er is ${fn:length(personen)} persoon gevonden
					(${zoekinput.total} s)</h2>
			</c:if>
			<h3>Personenlijst</h3>
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
						<td><a
							href="<c:url value='/relatiebeheer/personen/zoekresultaat-${persoon.id}' />">Details</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h2>Er zijn geen resultaten gevonden</h2>
		</c:otherwise>
	</c:choose>
</body>