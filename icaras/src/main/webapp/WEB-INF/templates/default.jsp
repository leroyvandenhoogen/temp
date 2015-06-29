<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>


<!--  	<link href="${pageContext.request.contextPath}/static/rs4/css/icaras.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script>-->

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/rs4/css/icaras.css" />
</head>
<body>
	<div class="wrapper">

		<div class="header">
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>

		<div class="menu">
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
		</div>

		<div class="content">
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
		</div>

		<div class="details">
			<tiles:insertAttribute name="details"></tiles:insertAttribute>
		</div>

	</div>

	<div class="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>

</body>
</html>