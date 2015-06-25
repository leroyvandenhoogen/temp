<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script>
	$(document).ready(function() {

		$('#lijst tr').click(function(e) {
			if (e.target.type == "checkbox") {
				e.stopPropagation();
			} else {
				var href = $(this).find("a").attr("href");
				if (href) {
					window.location = href;
				}
			}
		});
	});
</script>
<body>
	<input type="button" value="Ga terug" onclick="history.back();" />
	</br>
	<form:form method="POST" modelAttribute="zoekinput">
		Zoek een organisatie:<br>
		<form:input type="text" path="input" name="zoekinputarea" value="" />
		<input type="submit" value="zoek" />
	</form:form>

	<c:choose>
		<c:when test="${fn:length(organisaties) > 0}">
			<h2>Zoekcriteria: ${zoekinput.input}</h2>
			<h2>Resultatenlijst</h2>
			<table id="lijst" class="list">
				<tr class="tabelheader">
					<td>Naam</td>
					<td>Plaats</td>
					<td>Opmerking</td>
					<td></td>
					<td>Verwijder</td>
				</tr>
				<c:forEach items="${organisaties}" var="organisatie"
					varStatus="status">
					<tr>
						<td>${organisatie.naam}</td>

						<c:forEach items="${organisatie.adressen}" var="adres">
							<c:if test="${adres.adresType.type == 'bezoek' }">
								<td>${adres.plaats}</td>
							</c:if>
						</c:forEach>

						<td>${organisatie.opmerking}</td>
						<td><a
							href="<c:url value='/relatiebeheer/organisaties/toon-${organisatie.id}-organisatie' />"></a></td>
						<td><a
							href="<c:url value='/relatiebeheer/organisaties/verwijder-${organisatie.id}'/>">Verwijder</a></td>

						<td><input type="checkbox" name="checkbutton"
							value="${status.count}" /></td>
					</tr>

				</c:forEach>

			</table>
		</c:when>
		<c:otherwise>
			<h2>Er zijn geen resultaten gevonden</h2>
		</c:otherwise>
	</c:choose>
</body>