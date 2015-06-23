<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<body>
	<form:form method="POST" modelAttribute="zoekinput">
		Zoek een organisatie:<br>
		<form:input type="text" path="input" name="zoekinputarea" value="" />
		<input type="submit" value="zoek" />
	</form:form>

	<c:choose>
		<c:when test="${fn:length(organisaties) > 0}">
			<h2>Zoekcriteria: ${zoekinput.input}</h2>
			<h2>Resultatenlijst</h2>
			<table class="list">
				<tr class="tabelheader">
					<td>Naam</td>
					<td>Plaats</td>
					<td>Opmerking</td>
					<td></td>
				</tr>
				<c:forEach items="${organisaties}" var="organisatie">
					<tr class="element">
						<td>${organisatie.naam}</td>

						<c:forEach items="${organisatie.adressen}" var="adres">
							<c:if test="${adres.adresType.type == 'bezoek' }">
								<td>${adres.plaats}</td>
							</c:if>
						</c:forEach>

						<td>${organisatie.opmerking}</td>
						<td><a
							href="<c:url value='/relatiebeheer/organisaties/toon-${organisatie.id}-organisatie' />">Details</a></td>
							
					</tr>
				</c:forEach>

			</table>
		</c:when>
		<c:otherwise>
			<h2>Er zijn geen resultaten gevonden</h2>
		</c:otherwise>
	</c:choose>
</body>