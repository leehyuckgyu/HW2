<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
A:visited {
	COLOR: black;
}
</style>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
<title>Home</title>
</head>
<body>
	<table class="main">
		<tr>
			<td><h1 class="head">수강 조회</h1></td>
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/sumcreditbysemester">
					1. 학년/학기별 이수 총 학점 </a>
		</tr>
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/sumcreditbycategory">
					2. 이수 구분별 학점내역 </a></td>
		</tr>

		<tr>
			<td><a href="${pageContext.request.contextPath}/newcourse">
					3. 수강 신청하기 </a></td>
		</tr>
		<tr>
			<td><a href="${pageContext.request.contextPath}/newcourseinfo">
					4. 수강 신청 조회 </a></td>
		</tr>
	</table>
</body>
</html>
