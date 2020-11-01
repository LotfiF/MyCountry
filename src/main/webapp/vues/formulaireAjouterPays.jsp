<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><spring:message code="formulaireAjouterPays.titre"/></title>
</head>
<body>
	<p><a href="<c:url value="/index.jsp" />"><spring:message code="accueil.retour"/></a><p/>
	<h3><spring:message code="formulaireAjouterPays.titre"/></h3>
	<form method="post" action="ajouterPays">
		<label for="codeIso">Code ISO : </label>
		<input type="text" name="codeIso" id="codeIso"/>
		
		<label for="nomPays">Nom pays : </label>
		<input type="text" name="nomPays" id="nomPays"/>
		
		<label for="capitale">Capitale : </label>
		<input type="text" name="capitale" id="capitale"/>
		
		<label for="langue">Langue : </label>
		<input type="text" name="langue" id="langue"/>
		
		<label for="surface">Surface : </label>
		<input type="text" name="surface" id="surface" value="0.0"/>
		
		<label for="population">Population : </label>
		<input type="text" name="population" id="population" value="0.0">
		
		<input type="submit" value="Valider" />
	</form>
</body>
</html>