<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><spring:message code="formulaireUpdateRegion.titre"/></title>
</head>
<body>
	<p><a href="<c:url value="/index.jsp" />"><spring:message code="accueil.retour"/></a><p/>
	<h3><spring:message code="formulaireUpdateRegion.titre"/></h3>
	<form method="post" action="${pageContext.request.contextPath}/updateRegion/${region.id }" >		
		<label for="nom">Nom région : </label>
		<input type="text" name="nom" id="nom" value="<c:out value="${region.nom}"/>"/>
		
		<label for="monument">Monument : </label>
		<input type="text" name="monument" id="monument" value="<c:out value="${region.monument}"/>"/>
		
		<label for="regionNumber">Numéro de Région : </label>
		<input type="text" name="regionNumber" id="regionNumber" value="<c:out value="${region.regionNumber}"/>"/>
		
		<label for="pays">Pays : </label>
		<select name="pays" id="pays">
		   <c:forEach items = "${listePays }" var = "pays">
                 <option value = "${pays.idPays }">${pays.nomPays}</option>                 
            </c:forEach>          				
        </select>
        		
		<input type="submit" value="Valider" />
	</form>
</body>
</html>