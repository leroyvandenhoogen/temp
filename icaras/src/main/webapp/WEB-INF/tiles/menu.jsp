<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>
	<li>
		<a href="<c:url value='/personen'/>">Personen &#9662;</a>
		<ul>
			<li><a href="#">Zoek</a></li>
			<li><a href="#">Nieuw</a></li>
		</ul>

	<li>
		<a href="<c:url value='/organisaties'/>">Organisaties &#9662;</a>
		<ul>
			<li><a href="#">Zoek</a></li>
			<li><a href="#">Nieuw</a></li>
		</ul>

	<li>
		<a href="<c:url value='/maillijst'/>">Maillijst &#9662;</a>
		<ul>
			<li><a href="#">Placeholder</a></li>
			<li><a href="#">Placeholder</a></li>
		</ul>

	<li><a href="<c:url value='/rapporten'/>">Rapporten &#9662;</a>
	<ul>
		<li><a href="#">Cursisten</a></li>
		<li><a href="#">Kandidaten</a></li>
		<li><a href="#">Stagiaires</a></li>
		<li><a href="#">Werknemers</a></li>
		<li><a href="#">Contactpersonen</a></li>
		<li><a href="#">Prive</a></li>
	</ul>

	<li><a href="<c:url value='/onderhoud'/>">Onderhoud &#9662;</a>
	<ul>
		<li><a href="#">Gebruikers-rollen</a></li>
		<li><a href="#">Gebruikers</a></li>
		<li><a href="#">RBS-rollen</a></li>
		<li><a href="#">Bedrijftypes</a></li>
		<li><a href="#">Adrestypes</a></li>
		<li><a href="#">Digitaal Adrestypes</a></li>
		<li><a href="#">Kandidaten</a></li>
	</ul>
</ul>