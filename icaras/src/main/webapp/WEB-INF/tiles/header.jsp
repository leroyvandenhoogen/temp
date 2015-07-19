<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
<img
	src="${pageContext.request.contextPath}/resources/rs4/images/rsv25.png">

<a class="title" href="<c:url value='/'/>">RSVIER Icaras</a>
</div>

<div class="right">
	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" method="post">
		<input type="submit" value="Log out" /> 
		<input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</div>


<ul>
	<li><a href="#">Intakemodule</a></li>
	<li><a href="#">Cursistbeheer</a></li>
	<li><a href="#">Arbeidsmarkt</a></li>
	<li><a href="/Icaras/relatiebeheer">Relatiebeheer</a></li>
	<li><a href="#">Agendabeheer</a></li>
	<li><a href="#">Systeem</a></li>
</ul>

