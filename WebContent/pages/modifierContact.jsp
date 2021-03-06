
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@page import="nanterre.miage.baptiste.model.Entreprise"%>
<%@page import="nanterre.miage.baptiste.model.Contact"%>
<script
              src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
              integrity="sha256-k2WSCIexGzOj3Euiig+TlR8gA0EmPjuc79OEeY5L45g="
              crossorigin="anonymous">
</script>
<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<html:html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="pages/other.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><bean:message key="modifContact.title"/></title>
	<html:base/>
</head>
<body>
<%
	if(session.getAttribute("login") == null){
%>
	<jsp:forward page = "main.jsp" />
<%		
	}
	Contact contact = (Contact) request.getAttribute("contact");
%>
<div class="background">
	<div class="container">
		<h1><bean:message key="modifContact.h1"/></h1>
		<html:form action="/ModifierBDDContact" styleClass="form-group">
			<html:errors/>
			
			<html:hidden property="idContact" name="contact" />
			<html:hidden property="version" name="contact" />
			<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.nom" /></label>
			<html:text property="nom" size="30" maxlength="30" name="contact"/> <br>
			
			<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.prenom" /></label>
			<html:text property="prenom" size="30" maxlength="30" name="contact"/> <br>
			
			<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.email" /></label>
			<html:text property="email" size="30" maxlength="30" name="contact"/> <br>
			
			<% if(Entreprise.class.isInstance(contact)) {%>
				<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.siret" /></label>
				<html:text property="siret" size="30" maxlength="30" name="contact"/> <br>
			<% } %>
			
			<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.adresse" /></label>
			<% if(contact.getAdresse() != null) {%>
				<bean:define id="adr" name="contact" property="adresse"/>
				<html:text property="adresse" size="30" maxlength="100" name="adr"/> <br>
			<%}else{ %>
				<html:text property="adresse" size="30" maxlength="100"/> <br>
			<%}%>
			<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.group" /></label>
			<html:select multiple="true" property="idGroup">
				<html:option value="<%=null %>"><bean:message key="addContact.form.noGroup" /></html:option>
				<html:optionsCollection name="cgrp" value="idGroup" label="groupName"/>
			</html:select> <br>
			<bean:define id="group" name="contact" property="groups"></bean:define>
			<bean:message key="modifContact.contactdansgroupe" />
			<logic:iterate id="groups" name="group">
				<bean:write property="groupName" name="groups" />,
			</logic:iterate>
			<br/>
			<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.phoneNumber" /></label>
			<html:select multiple="true" property="idTel">
				<html:option value="<%=null %>"><bean:message key="addContact.form.noTel" /></html:option>
				<html:optionsCollection name="tel" value="idTelephone" label="telephone"/>
			</html:select> <br>
			<bean:message key="modifContact.contactavectel" />
			<logic:iterate id="tel" name="tctc">
				<bean:write property="telephone" name="tel" />,
			</logic:iterate>
			<label class="col-sm-2 col-form-label"></label>
			<html:submit styleClass="btn btn-lg btn-outline-primary"><bean:message key="global.form.submit" /></html:submit>
		</html:form>
	
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/ContactAffichage.do"><bean:message key="main.contact.affichage" /></html:link>
</div>
</div>
</body>
	<script>
	var idGroupes = <%=request.getAttribute("idGroupes")%>;
    for(var i=0; i<idGroupes.length; i++) {
        $("option[value=" + idGroupes[i] + "]").attr("selected", true);
    }
	</script>
</html:html>
