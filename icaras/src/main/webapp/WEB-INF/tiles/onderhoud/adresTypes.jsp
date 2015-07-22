<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<body>
	<div class="center">
		<table>
			<tr>
				<th>Adres types:</th>
			</tr>
			<c:forEach items="${dto.adresTypes}" var="atype" varStatus="status"
				begin="0">
				<tr>
					<td>${atype.type}</td>
				</tr>
			</c:forEach>
		</table>


	</div>
	<div class="wrap">
		<a href="#modal-one" class="btn btn-big">Nieuw</a> <a
			href="#modal-two" class="btn btn-big">Bewerk</a>
	</div>
	<!-- Modal -->
	<div class="modal" id="modal-one" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<h2>Nieuw Adrestype</h2>

				<a href="#close" class="btn-close" aria-hidden="true">×</a>
				<!--CHANGED TO "#close"-->
			</div>
			<div class="modal-body">
				<form:form method="POST" modelAttribute="dto">
					<tr>
						<form:input path="input" />
						<td colspan="3"><input type="submit" name="add" value="Voeg toe" /></td>
					</tr>
				</form:form>
			</div>
			<div class="modal-footer">
				<a href="#close" class="btn">Sluiten</a>
				<!--CHANGED TO "#close"-->
			</div>
		</div>
	</div>
	<div class="modal" id="modal-two" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-header">
				<h2>Bewerk Adrestype</h2>

				<a href="#close" class="btn-close" aria-hidden="true">×</a>
				<!--CHANGED TO "#close"-->
			</div>
			<div class="modal-body">
				<div class="center">
					<form:form method="POST" modelAttribute="dto">
						<table>
							<tr>
								<th>Adres types:</th>
							</tr>
							<c:forEach items="${dto.adresTypes}" var="atype"
								varStatus="status" begin="0">
								<tr>
									<form:input type="hidden" path="adresTypes[${status.index}].id"/>
									<td><form:input path="adresTypes[${status.index}].type"/></td>
								</tr>
							</c:forEach>
						</table>
						<td colspan="3"><input type="submit" name="update" value="Opslaan" /></td>
					</form:form>
				</div>
				<div class="modal-footer">
					<a href="#close" class="btn">Sluiten</a>
					<!--CHANGED TO "#close"-->
				</div>
			</div>
		</div>
	</div>

	<!-- /Modal -->
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</body>