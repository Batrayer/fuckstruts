<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="nanterre.miage.baptiste.model.Contact"%>
<%@ page import="java.util.List"%>

<%
	if(session.getAttribute("login") == null){
%>
	<jsp:forward page = "main.jsp" />
<%		
	}
%>

<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="pages/other.css">
	<title><bean:message key="afficheContact.title" /></title>
	<html:base/>
</head>

<body>
<div class="background">
	<div class="container">

		<table class="table table-striped">
			<tr>
				<th><bean:message key="afficheContact.table.id" /></th>
				<th><bean:message key="afficheContact.table.nom" /></th>
				<th><bean:message key="afficheContact.table.prenom" /></th>
				<th><bean:message key="afficheContact.table.email" /></th>
				<!-- 
				<th><bean:message key="afficheContact.table.adresse" /></th>
				<th><bean:message key="afficheContact.table.ville" /></th>
				<th><bean:message key="afficheContact.table.pays" /></th>
				<th><bean:message key="afficheContact.table.codepostal" /></th>
				<th><bean:message key="afficheContact.table.supprime" /></th>
				<th><bean:message key="afficheContact.table.modifier" /></th>
 				-->
			</tr>
	
			<logic:iterate id="c" name="contact">
		
			<tr>
				<td><bean:write name="c" property="id" /></td>
				<td><bean:write name="c" property="nom" /></td>
				<td><bean:write name="c" property="prenom" /></td>
				<td><bean:write name="c" property="email" /></td>
				<!-- 
				<td><bean:write name="c" property="adresse" /></td>
				<td><bean:write name="c" property="ville" /></td>
				<td><bean:write name="c" property="pays" /></td>
				<td><bean:write name="c" property="codepostal" /></td>
				<bean:define id="textVal" name="c" property="id"/>
			  	<td><html:checkbox property="id" value="<%=textVal.toString() %>" /></td>
			  	<td><html:link page="/ModifierContact.do" paramId="id" paramName="textVal" ><bean:message key="afficheContact.table.modifier" /></html:link><td>
				 -->
			</tr>
			</logic:iterate>

		</table>
		<!-- 
		<html:submit styleClass="btn btn-lg btn-outline-danger"><bean:message key="afficheContact.table.supprime" /></html:submit>
		-->
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/ContactCreation.do"><bean:message key="main.addContact.link" /></html:link>
		<!-- 
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/EntrepriseCreation.do"><bean:message key="main.addEntreprise.link" /></html:link>
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/GestionGroupe.do"><bean:message key="main.gestionGroup.link" /></html:link>
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/RechercheContact.do"><bean:message key="main.rechercheContact.link" /></html:link>
		
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/ContactAffichage.do"><bean:message key="main.contact.affichage" /></html:link>
		 -->
	</div>
</div>
</body>
</html:html>