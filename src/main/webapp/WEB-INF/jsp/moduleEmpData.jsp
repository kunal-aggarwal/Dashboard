<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 class="title"><c:out value="${moduleDataWrapper.moduleName}"/></h1>
<spring:form modelAttribute="moduleDataWrapper" action="processModuleData">
<spring:hidden path="moduleCode"></spring:hidden>
<table><tr><td>
		<table class="table1 tx">
<tr>
<c:forEach var="moduleField" items="${moduleFields}">
<th><c:out value="${moduleField.name}"/></th>
</c:forEach>
</tr>

<c:forEach var="moduleDataRow" items="${moduleDataWrapper.moduleDataRowList}" varStatus="i">
<tr class="strippedTr">
<spring:hidden path="moduleDataRowList[${i.index}].rowId"></spring:hidden>
<c:forEach var="moduleField" items="${moduleFields}">
<td>
<c:if test="${moduleField.fieldType != 'TEXT' }">
<spring:select items="${refDataValuesMap[moduleField.fieldType]}" path="moduleDataRowList[${i.index}].fieldCodeValuesMap[${moduleField.code}]" />
</c:if>
<c:if test="${moduleField.fieldType == 'TEXT' }">
<spring:input path="moduleDataRowList[${i.index}].fieldCodeValuesMap[${moduleField.code}]" />
</c:if>
</c:forEach>
</tr>
 </c:forEach>
 </table>
</td>
</tr>
<tr><td>
<table><tr>
	<td align="right"><input type="submit"
	value="Update" name="update" class="button button1"></td>
</tr>
</table>
</td></tr>
</table>
</spring:form>
</body>
</html>