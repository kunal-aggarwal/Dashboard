<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
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
		<c:out value="${refDataType.name}"></c:out>
</h1>
<spring:form modelAttribute="refData" action="processRefData">
<spring:hidden path="category" />
<table><tr><td valign="top">
		<table class="table1 tx">
	
<tr><th>Field Code</th><th>Field Desc</th></tr>
<c:forEach var="refData" items="${refDataList}">
<tr class="strippedTr">
<td><c:out value="${refData.code}"/></td>
<td><c:out value="${refData.name}"/></td></tr>
</c:forEach>
</table>
</td>
	<td valign="top">
		<table class="editTable">
				<tr>
					<td align="right">Field Code:<spring:input path="code" /></td>
					<td align="right">Field Desc:<spring:input path="name" /></td>
					<td align="right"><input type="submit"
						value="Add Field" name="add" class="button button1"></td>
				</tr>
			</table>
			</td>
</tr></table>
</spring:form>

</body>
</html>