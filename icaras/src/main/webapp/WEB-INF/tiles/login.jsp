<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<body onload='document.f.username.focus();'>
	<h3>Inloggen</h3>

	<c:if test="${param.error != null}">
		
		<p class="error">Uw login is mislukt
		
		</p>
	
	</c:if>
	
	<form:form name='f' action='${pageContext.request.contextPath}/login'
		method='POST'>
		<table>
			<tr>
				<td>Gebruikersnaam:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Wachtwoord:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form:form>
	
	<div>
	<a href="<c:url value='/nieuwaccount'/>">Account aanmaken </a>
	<br>
	<a href="<c:url value='/'/>">Wachtwoord vergeten </a>
	</div>
</body>
