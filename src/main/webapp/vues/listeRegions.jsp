<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><spring:message code="listeRegion.titre"></spring:message></title>
</head>
<body>
	<p><a href="<c:url value="/index.jsp" />"><spring:message code="accueil.retour"/></a></p>
	<h3><spring:message code="listeRegion.titre"/></h3>
	<c:if test="${!empty messageInfo}"><p><c:out value="${messageInfo}"/></p></c:if>
	<table border="1">
		<thead>
			<tr>
				<th><spring:message code="listeRegion.nom"></spring:message></th>
				<th><spring:message code="listeRegion.regionNumber"></spring:message></th>
				<th><spring:message code="listeRegion.monument"></spring:message></th>
				<th><spring:message code="listeRegion.pays"></spring:message></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listeRegions}" var="region">
				<tr>
     				<td><a href="<c:url value="/updateRegion/${region.id }"/>"><c:out value="${region.nom}"/></a></td>
					<td><c:out value="${region.regionNumber}"/></td>
					<td><c:out value="${region.monument}"/></td>
				    <td><a href="<c:url value="/listeRegions/${region.pays.idPays }"/>"><c:out value="${region.pays.nomPays}"/></a></td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>	
</body>
</html>