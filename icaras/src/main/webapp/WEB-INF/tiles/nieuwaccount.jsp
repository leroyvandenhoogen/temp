<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	function onLoad() {

		$("#password").keyup(checkPasswordsMatch);
		$("#confirmpass").keyup(checkPasswordsMatch);
		$("#details").submit(canSubmit);
	}

	function canSubmit() {
		if(password != confirmpass) {
			alert("Wachtwoorden komen niet overeen!")
			return false;
		}
		else {
			return true;
		}
	}
	function checkPasswordsMatch() {
		var password = $("#password").val();
		var confirmpass = $("#confirmpass").val();

		if (password.length > 3 || confirmpass.length > 3) {

			if (password == confirmpass) {
				$("#matchpass").text("Wachtwoorden komen overeen");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");
			} else {
				$("#matchpass").text("Wachtwoorden komen niet overeen");
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
			}
		}
	}
	$(document).ready(onLoad);
	
</script>
<body>
	<input type="button" value="Ga terug" onclick="history.back();" />
	<br>
	<form:form id="details" method="POST" modelAttribute="user">
		<table>
			<tr>
				<td><label>Gebruikersnaam: </label></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><label>Email: </label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><label>Wachtwoord: </label></td>
				<td><form:input path="password" id="password" type="password" /></td>
				<td><form:errors path="password" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><label>Wachtwoord nogmaals: </label></td>
				<td><input name="confirmpass" id="confirmpass" type="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td id="matchpass"></td>
			</tr>
		</table>
		<td colspan="3"><input type="submit" value="submit" /></td>
	</form:form>

</body>