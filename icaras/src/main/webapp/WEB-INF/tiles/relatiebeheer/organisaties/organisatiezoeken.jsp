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

	<form:form method="POST" modelAttribute="zoekinput">
		Zoek een organisatie:<br>
		<form:input type="text" path="input" name="zoekinputarea" value="" />
		<input type="submit" value="zoek" class="btn btn-small"/>
	</form:form>

	<c:choose>
		<c:when test="${not empty organisaties}">
			<c:if test="${fn:length(organisaties) > 1}">
				<h2>Er zijn ${fn:length(organisaties)} organisaties gevonden</h2>
			</c:if>
			<c:if test="${fn:length(organisaties) == 1}">
				<h2>Er is ${fn:length(organisaties)} organisatie gevonden</h2>
			</c:if>
			<br>
			<h2>Zoekcriteria: ${zoekinput.input}</h2>
			<br>
			<h2>Resultatenlijst</h2>
			<div class="divlijst">
			<table id="lijst" class="list">
				<tr class="tabelheader">
					<td>Naam</td>
					<td>Plaats</td>
					<td></td>
					<td>Verwijder</td>
					<td></td>
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

						<td><a
							href="<c:url value='/relatiebeheer/organisaties/toon-${organisatie.id}-organisatie' />"></a></td>
						<td><a
							href="<c:url value='/relatiebeheer/organisaties/verwijder-${organisatie.id}'/>">Verwijder</a></td>

						<td><input type="checkbox" name="checkbutton"
							value="${status.count}" /></td>
					</tr>

				</c:forEach>

			</table>
			</div>
		</c:when>
		<c:when
			test="${fn:length(organisaties) == 0 && fn:length(zoekinput.input) > 0}">
			<h2>Er zijn geen resultaten gevonden</h2>
		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>
</body>