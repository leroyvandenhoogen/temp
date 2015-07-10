<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script>
	$(document).ready(function() {

		$('#lijst tr').click(function() {
			var href = $(this).find("a").attr("href");
			if (href) {
				window.location = href;
			}
		});

	});
</script>

<body>
	<input type="button" value="Ga terug" onclick="history.back();" class="btn btn-small"/>
	<tr></tr>
	<h1>Zoek een persoon</h1>
	<br>
	<form:form method="POST" modelAttribute="bedrijfDTO">
		<form:input type="text" path="input" name="zoekinputarea" value="" />
		<input type="submit" value="zoek" class="btn btn-small"/>
	</form:form>

	<c:choose>
		<c:when test="${not empty contactpersonen}">
			<c:if test="${fn:length(contactpersonen) > 1}">
				<h2>Er zijn ${fn:length(contactpersonen)} personen gevonden</h2>
			</c:if>
			<c:if test="${fn:length(contactpersonen) == 1}">
				<h2>Er is ${fn:length(contactpersonen)} persoon gevonden</h2>
			</c:if>
			<h3>Personenlijst</h3>
			<div class="divlijst">
			<table id="lijst" class="list">
				<tr class="tabelheader">
					<td>Voornaam</td>
					<td>Achternaam</td>
					<td>Tussenvoegsel</td>
					<td>Rollen</td>
					<td></td>
				</tr>
				<c:forEach items="${contactpersonen}" var="persoon">
					<tr class="element">
						<td>${persoon.voornaam}</td>
						<td>${persoon.achternaam}</td>
						<td>${persoon.tussenvoegsel}</td>
						<td>${persoon.persoonsrollen}</td>
						<td><a
							href="<c:url value='/relatiebeheer/organisaties/koppel-${bedrijfDTO.bedrijf.id}-${persoon.id}' />"></a></td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</c:when>

		<c:when
			test="${fn:length(contactpersonen) == 0 && fn:length(bedrijfDTO.input) > 0}">
			<h2>Er zijn geen resultaten gevonden</h2>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>

</body>