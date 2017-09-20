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
		Dashboard
</h1>
<spring:form modelAttribute="module" action="processModule">
<table><tr><td valign="top">
		<table class="table1 tx">
	
<tr><th colspan="2">Dashboard Name</th></tr>
<c:forEach var="module" items="${modules}">
<tr class="strippedTr">
<td><a href="moduleEmpData?code=<c:out value='${module.code}'/>"><c:out value="${module.name}"/></a></td>
<td><a href="showModuleField?code=<c:out value='${module.code}'/>"><img alt="edit" height="10px" src="resources/images/edit.png"></a></td>
</tr>
</c:forEach>
</table>
</td>
	<td valign="top">
		<table class="editTable">
				<tr>
					<!-- >td>Module Code:<spring:input path="code" /></td -->
					<td align="right">Dashboard Name:<spring:input path="name" /></td>
					<td align="right"><input type="submit"
						value="Add Field" name="add" class="button button1"></td>
				</tr>
			</table>
			</td>
</tr></table>
</spring:form>

</body>
</html>