<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<body>
	<div class="center">
		<form:form method="POST" modelAttribute="dto">
			<table>
				<tr>
					<th>Adres types:</th>
				</tr>
				<td> test</td>
				<c:forEach items="${adresTypes}" var="atype" varStatus="status" begin="0">
					<tr>
						<td><label>id: </label></td>
						<td><form:input path="${atype.id}"/></td>
					</tr>
					<tr>
						<td><label>type: </label></td>
						<td><form:input path="${atype.type}"/></td>
					</tr>
				</c:forEach>
			</table>
		</form:form>

	</div>

</body>