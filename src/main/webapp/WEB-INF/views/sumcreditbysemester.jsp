<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<style>
A:visited {
	COLOR: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
<title>Credit By Semester</title>
</head>
<body>
	<table class="main2">
		<tr class="head2">
			<td>년도</td>
			<td>학기</td>
			<td>이수 학점</td>
			<td>상세 보기</td>
		</tr>
		<c:forEach var="course" items="${sumcreditbysemester}">
			<tr>
				<td><c:out value="${course.year}">
					</c:out></td>
				<td><c:out value="${course.semester}">
					</c:out></td>
				<td><c:out value="${course.credit}">
					</c:out></td>
				<td><a
					href="${pageContext.request.contextPath}/moreinfo?year=${course.year}&semester=${course.semester}">
						링크</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>