<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

<%@ page import="nanterre.miage.baptiste.model.Contact"%>
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
	Contact contact =(Contact) request.getAttribute("contact");
%>
<div class="background">
	<div class="container">
	
	<h1><bean:message key="recherche.h1"/></h1>
	<html:form action="/RechercheContactAction" styleClass="form-group">
	<html:errors/>
	
	<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.nom"  /></label>
	<html:text property="nom" size="30" maxlength="30"/> <br>
	
	<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.prenom" /></label>
	<html:text property="prenom" size="30" maxlength="30" /> <br>
	
	<label class="col-sm-2 col-form-label"><bean:message key="addContact.form.email" /></label>
	<html:text property="email" size="30" maxlength="30" /> <br>
	
	<label class="col-sm-2 col-form-label"></label>
	<html:submit styleClass="btn btn-lg btn-outline-primary"><bean:message key="global.form.submit" /></html:submit>
	</html:form>
	
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/ContactAffichage.do"><bean:message key="main.contact.affichage" /></html:link>
	</div>
</div>
</body>
</html:html>