<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>
	<li><a href="#">Gebruiker &#9662;</a>
		<ul>
			<li><a href="<c:url value='/onderhoud/gebruiker/nieuw'/>">Nieuw</a></li>
		</ul>
	<li><a href="#">Lookup table &#9662;</a>
		<ul>
			<li><a href="<c:url value='/onderhoud/lookuptable/adrestypes'/>">Adrestypes</a></li>
			<li><a href="#">Digitaal adrestypes</a></li>
			<li><a href="#">Bedrijftypes</a></li>
			<li><a href="#">Bedrijfexpertises</a></li>
			<li><a href="#">Rol</a></li>
		</ul>
</ul>