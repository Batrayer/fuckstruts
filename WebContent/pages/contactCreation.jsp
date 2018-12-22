<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

<!DOCTYPE html>
<html:html>
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="pages/other.css">
	<title><bean:message key="addContact.title"/></title>
	<html:base/>
</head>
<body>
<%
	if(session.getAttribute("login") == null){
%>
	<jsp:forward page = "main.jsp" />
<%		
	}
%>
<div class="background">
	<div class="container">
	<h1><bean:message key="addContact.h1"/></h1>	
			<html:form styleClass="form-group" action="/AddContact">
				<html:errors/>
				<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.nom" /></label>
				<html:text property="nom" size="30" maxlength="30"/> <br>
				<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.prenom" /></label>
				<html:text property="prenom" size="30" maxlength="30"/> <br>
				<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.email" /></label>
				<html:text property="email" size="30" maxlength="30"/> <br>
				<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.adresse" /></label>
				<html:text property="adresse" size="30" maxlength="100"/> <br>
				<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.ville" /></label>
				<html:text property="ville" size="30" maxlength="30"/> <br>
				<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.pays" /></label>
				<html:text property="pays" size="30" maxlength="30"/> <br>
				<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.codepostal" /></label>
				<html:text property="codepostal" size="30" maxlength="30"/> <br>
				
				<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.phoneKind" /></label>
				<html:text property="phoneKind" size="30" maxlength="30"/> <br>
				<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.phoneNumber" /></label>
				<html:text property="phoneNumber" size="30" maxlength="30"/> <br>
				
				<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.group" /></label>
				<html:select property="idGroup">
					<html:option value="<%=null %>"><bean:message key="addContact.form.noGroup" /></html:option>
					<html:optionsCollection name="cgrp" value="idGroup" label="groupName"  />
				</html:select> <br>
				
				<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.entreprise" /></label>
				<html:select  property="siret">
					<html:option value="<%=null %>"><bean:message key="addContact.form.noEntreprise" /></html:option>
					<html:optionsCollection name="ent" value="siret" label="nom"  />
				</html:select> <br>
				<html:submit styleClass="btn btn-lg btn-outline-primary"><bean:message key="global.form.submit" /></html:submit>
		</html:form>
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/ContactAffichage.do"><bean:message key="main.contact.affichage" /></html:link>
	
	</div>
</div>
</body>
</html:html>