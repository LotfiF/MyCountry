<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><spring:message code="formulaireSupprimerRegion.titre"/></title>
</head>
<body>
	<p><a href="<c:url value="/index.jsp" />"><spring:message code="accueil.retour"/></a></p>
	<h3><spring:message code="formulaireSupprimerRegion.titre"/></h3>
	<form method="post" action="supprimerRegion">
		<label for="nom">Nom : </label>
		<input type="text" name="nom" id="nom"/>
		
		<input type="submit"/>
	</form>
	<p></p>
	<table border="1">
		<thead>
			<tr>				
				<th><spring:message code="listeRegion.nom"/></th>
				<th><spring:message code="listeRegion.regionNumber"/></th>
				<th><spring:message code="listeRegion.monument"/></th>
				<th><spring:message code="listeRegion.pays"/></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listeRegions}" var="region">
				<tr>
					<td><c:out value="${region.nom}"/></td>
					<td><c:out value="${region.regionNumber}"/></td>
					<td><c:out value="${region.monument}"/></td>
					<td><c:out value="${region.pays.nomPays}"/></td>
				</tr>
			</c:forEach>	
		</tbody>	
	</table>
</body>
</html>