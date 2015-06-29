<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Icaras</title>
<link href="<c:url value="/resources/rs4/css/icaras.css"/>"
	rel="stylesheet">
</head>


<body>

	<div id="menu">
		<ul id="menubar">
			<li class="menubar_item"><a href="/Icaras/">welkom</a></li>
			<li class="menubar_item"><a href="/Icaras/getAllRelaties">relaties</a></li>
			<li class="menubar_item"><a href="/Icaras/getAllPersonen">personen</a></li>
			<li class="menubar_item"><a href="/Icaras/getAllOrganisaties">organisaties</a></li>
		</ul>
	</div>

	<c:if test="${not empty organisatieForm}">
		<form:form action="voegOrganisatieToe" method="post"
			modelAttribute="organisatieForm">
			<div class="fieldset">
				<fieldset>
					<legend>Organisatie</legend>

					<p>
						<label for="naam">Naam</label>
						<form:input name="naam" path="naam" />
						<form:errors path="naam" cssClass="validationError" />
					</p>

					<p>
						<input type="submit" value="Voeg organisatie toe" />
					</p>

				</fieldset>
			</div>
		</form:form>
	</c:if>

</body>
</html>