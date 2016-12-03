<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
<title>Add Course</title>
</head>
<body>
	<form:form method="post" action="add" modelAttribute="course">
		<table class="main2">
			<tr>
				<td>Year :</td>
				<td><form:input type="number" path="year" value="" /> <br />
					<form:errors path="year"></form:errors></td>
			</tr>
			<tr>
				<td>Semester :</td>
				<td><form:input type="number" path="semester" value="" /> <br />
					<form:errors path="semester"></form:errors></td>
			</tr>
			<tr>
				<td>Subject Name :</td>
				<td><form:input type="text" path="subjectname" value="" /> <br />
					<form:errors path="subjectname"></form:errors></td>
			</tr>
			<tr>
				<td>Subject Code :</td>
				<td><form:input type="text" path="subjectcode" value="" /> <br />
					<form:errors path="subjectcode"></form:errors></td>
			</tr>
			<tr>
				<td>Category :</td>
				<td><form:input type="text" path="category" value="" /> <br />
					<form:errors path="category"></form:errors></td>
			</tr>
			<tr>
				<td>Credit :</td>
				<td><form:input type="number" path="credit" value="" /> <br />
					<form:errors path="credit"></form:errors></td>
			</tr>
			<td></td>
			<td><input type="submit" value="신청" /></td>
		</table>
	</form:form>
</body>
</html>