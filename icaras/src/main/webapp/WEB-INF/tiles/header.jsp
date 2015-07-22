<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()" var="authenticated">
	<div class="inlogwrapper">
		<div class="inlognaam">
			<c:if test="${inlognaam != null}">
				<h2>Welkom,</h2>
				<h2>${inlognaam}.</h2>
			</c:if>
		</div>
		<div class="inlogbutton">
			<c:url var="logoutUrl" value="/logout" />
			<form action="${logoutUrl}" method="post">
				<input type="submit" value="Log uit" /> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	</div>
</sec:authorize>

<div class="title">
	<img
		src="${pageContext.request.contextPath}/resources/rs4/images/rsv25.png">

	<a class="title" href="<c:url value='/'/>">RSVIER Icaras</a>

	<sec:authorize access="isAuthenticated()">
		<ul>
			<li><a href="#">Intakemodule</a></li>
			<li><a href="#">Cursistbeheer</a></li>
			<li><a href="#">Arbeidsmarkt</a></li>
			<li><a href="/Icaras/relatiebeheer" <c:if test="${pageContext.request.requestURI eq '/Icaras/relatiebeheer'}">class="current"</c:if>>Relatiebeheer</a></li>
			<li><a href="#">Agendabeheer</a></li>
			<sec:authorize access="hasRole('ROLE_ADMIN')"> 
			<li><a href="/Icaras/onderhoud">Onderhoud</a></li>
			</sec:authorize>
		</ul>
	</sec:authorize>

</div>


