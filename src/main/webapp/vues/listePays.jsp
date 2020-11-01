<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><spring:message code="listePays.titre"/></title>
</head>
<body>
	<p><a href="<c:url value="/index.jsp" />"><spring:message code="accueil.retour"/></a></p>
	<h3><spring:message code="listePays.titre"/></h3>
	<c:if test="${!empty responce}"><p><c:out value="${responce}"/></p></c:if>
	<c:if test="${!empty messageInfo}"><p><c:out value="${messageInfo}"/></p></c:if>
	<table border="1">
		<thead>
			<tr>
				<th><spring:message code="listePays.codeIso"/></th>
				<th><spring:message code="listePays.nomPays"/></th>
				<th><spring:message code="listePays.capitale"/></th>
				<th><spring:message code="listePays.langue"/></th>
				<th><spring:message code="listePays.surface"/></th>
				<th><spring:message code="listePays.population"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listePays}" var="pays">
			 <tr>
                <td><a href="<c:url value="/updatePays/${pays.idPays }"/>"><c:out value="${pays.codeIso}"/></a></td>
                <td><a href="<c:url value="/listeRegions/${pays.idPays }"/>"><c:out value="${pays.nomPays}"/></a></td>
				<td><c:out value="${pays.capitale}"/></td>
				<td><c:out value="${pays.langue}"/></td>
				<td><c:out value="${pays.surface}"/></td>
				<td><c:out value="${pays.population}"/></td>
			 </tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>