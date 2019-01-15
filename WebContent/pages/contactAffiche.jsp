<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page import="nanterre.miage.baptiste.model.Contact"%>
<%@page import="nanterre.miage.baptiste.model.Entreprise"%>
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
		<% if(session.getAttribute("error") != null) {%>
			<bean:define id="error" name="e" property="err"/>
			<h2><bean:write name="e" property="err" /></h2>
		<% } %>
		<html:form action="/DeleteSelected">
		<html:errors/>
		<table class="table table-striped">
			<tr>
				<th><bean:message key="afficheContact.table.id" /></th>
				<th><bean:message key="afficheContact.table.nom" /></th>
				<th><bean:message key="afficheContact.table.prenom" /></th>
				<th><bean:message key="afficheContact.table.email" /></th>
				<th><bean:message key="afficheContact.table.siret" /></th>
				<th><bean:message key="afficheContact.table.adresse" /></th>
				<th><bean:message key="afficheContact.table.modifier" /></th>
				<th><bean:message key="afficheContact.table.supprime" /></th>
				
				<!-- 
				
				<th><bean:message key="afficheContact.table.ville" /></th>
				<th><bean:message key="afficheContact.table.pays" /></th>
				<th><bean:message key="afficheContact.table.codepostal" /></th>
				
 				-->
			</tr>
	
			<logic:iterate id="c" name="contact">
		
			<tr>
				<td><bean:write name="c" property="idContact" /></td>
				<td><bean:write name="c" property="nom" /></td>
				<td><bean:write name="c" property="prenom" /></td>
				<td><bean:write name="c" property="email" /></td>
				<% if(Entreprise.class.isInstance(c)) {%>
					<td><bean:write name="c" property="siret" /></td>
				<% } else {%>
					<td></td>
				<% } %>
				<% if(((Contact) c).getAdresse() != null) {%>
					<td><bean:write name="c" property="adresse.adresse" /></td>
				<% } else {%>
					<td></td>
				<% } %>
				<bean:define id="textVal" name="c" property="idContact"/>
				<td><html:link page="/ModifierContact.do" paramId="id" paramName="textVal" ><bean:message key="afficheContact.table.modifier" /></html:link></td>
			  	<td><html:checkbox property="id" value="<%=textVal.toString() %>" /></td>
			  	
			</tr>
			</logic:iterate>

		</table>
		<html:submit styleClass="btn btn-lg btn-outline-danger"><bean:message key="afficheContact.table.supprime" /></html:submit>
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/ContactCreation.do"><bean:message key="main.addContact.link" /></html:link>
		<!-- 
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/EntrepriseCreation.do"><bean:message key="main.addEntreprise.link" /></html:link>
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/GestionGroupe.do"><bean:message key="main.gestionGroup.link" /></html:link>
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/RechercheContact.do"><bean:message key="main.rechercheContact.link" /></html:link>
		
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/ContactAffichage.do"><bean:message key="main.contact.affichage" /></html:link>
		 -->
		 </html:form>
	</div>
</div>
</body>
</html:html>