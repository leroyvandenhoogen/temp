<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<input type="button" value="Ga terug" onclick="history.back();" />
	<br>
	<form:form method="POST" modelAttribute="user">
		<table class="details">
			<tr>
				<td><label>Gebruikersnaam: </label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><label>Email: </label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><label>Wachtwoord: </label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><label>Wachtwoord nogmaals: </label></td>
				<td><input name="confirmpass"/></td>
			</tr>
		</table>
		<td colspan="3"><input type="submit" value="submit" /></td>
	</form:form>

</body>