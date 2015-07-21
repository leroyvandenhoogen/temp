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
<c:if test="${not authenticated}">
	<div class="inlogwrapper">
		<div class="inlognaam">
			<h2>Je bent niet ingelogd</h2>
		</div>
		<div class="inlogbutton">
			<a class ="login" href="/Icaras/login"> <input type="button"
				value="Log in" />
			</a>
		</div>
	</div>
</c:if>

<div class="title">
	<img
		src="${pageContext.request.contextPath}/resources/rs4/images/rsv25.png">

	<a class="title" href="<c:url value='/'/>">RSVIER Icaras</a>


	<ul>
		<li><a href="#">Intakemodule</a></li>
		<li><a href="#">Cursistbeheer</a></li>
		<li><a href="#">Arbeidsmarkt</a></li>
		<li><a href="/Icaras/relatiebeheer">Relatiebeheer</a></li>
		<li><a href="#">Agendabeheer</a></li>
		<li><a href="#">Systeem</a></li>
	</ul>


</div>


