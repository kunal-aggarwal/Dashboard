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
		Reference Data Type
</h1>
<spring:form modelAttribute="refDataType" action="processRefDataType">
<table><tr><td valign="top">
		<table class="table1 tx">
	
<tr><!-- >th>Field Code</th -->
<th colspan="2">Reference Data Types</th></tr>
<c:forEach var="refDataType" items="${refDataTypes}">
<tr class="strippedTr">
<!-- td><c:out value="${refDataType.code}"/></td -->
<td><c:out value="${refDataType.name}"/></td>
<td><a href="showRefData?category=<c:out value='${refDataType.code}'/>"><img alt="Add Ref Data" height="10px" src="resources/images/edit.png"></a></td>
</tr>
</c:forEach>
</table>
</td>
	<td valign="top">
		<table class="editTable">
				<tr>
					<!-- td>Field Code:<spring:input path="code" /></td -->
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