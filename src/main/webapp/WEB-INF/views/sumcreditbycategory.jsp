<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
<title>Home</title>
<title>Credit By Semester</title>
</head>
<body>
	<table class="main2">
		<tr class="head2">
			<td>교필</td>
			<td>토대</td>
			<td>인재</td>
			<td>자율</td>
			<td>전기</td>
			<td>전지</td>
			<td>전선</td>
		</tr>
		<tr>
			<c:forEach var="i" items="${sumcreditbycategory}">
				<td>${i}</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>