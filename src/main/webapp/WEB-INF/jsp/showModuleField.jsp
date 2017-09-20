<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<h1 class="title">
		<a href="moduleEmpData?code=<c:out value='${moduleName.code}'/>"><c:out value="${moduleName.name}" /></a>
	</h1>
	
	<table><tr><td valign="top">
		<table class="table1 tx">
			<tr>
				<!-- >th>Field Code</th -->
				<th>Column</th>
				<th>Data Type</th>
			</tr>
			<c:forEach var="moduleField" items="${moduleFields}">
				<tr class="strippedTr">
					<!-- >td><c:out value="${moduleField.code}" /></td -->
					<td><c:out value="${moduleField.name}" /></td>
					<td><c:out value="${moduleField.fieldType}" /></td>
				</tr>
			</c:forEach>
		</table>
	</td>
	<td valign="top">
		<spring:form modelAttribute="moduleField" action="addModuleField">
			<spring:hidden path="moduleCode" />
			<table class="editTable">
				<tr>
					<td align="right">Column: <spring:input path="name" /></td>
					<td align="right">Data Type: <spring:select items="${fieldTypes}" path="fieldType" /></td>
					<td align="right"><input type="submit"
						value="Add Field" class="button button1"></td>
				</tr>
			</table>
		</spring:form>
		</td></tr></table>
		
</body>
</html>