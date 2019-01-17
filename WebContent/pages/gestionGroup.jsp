<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<html:html>
<%
	if(session.getAttribute("login") == null){
%>
	<jsp:forward page = "main.jsp" />
<%		
	}
%>
<head>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="pages/other.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><bean:message key="gestionGroup.title"/></title>
	<html:base/>
</head>
<body>
<div class="background">
	<div class="container">
		<table class="table table-striped">
			<tr>
				<th><bean:message key="gestionGroup.affiche.idGroup" /></th>
				<th><bean:message key="gestionGroup.affiche.nomGroup" /></th>
				<th><bean:message key="gestionGroup.affiche.getContactGroup" /></th>
			</tr>
	
			<logic:iterate id="grp" name="group">
	
				<tr>
					<td><bean:write name="grp" property="idGroup" /></td>
					<td><bean:write name="grp" property="groupName" /></td>
					<bean:define id="textVal" name="grp" property="idGroup"/>
					<td><html:link page="/AfficherContactGroup.do" paramId="groupId" paramName="textVal" ><bean:message key="entreprise.table.affichercontact" /></html:link><td>
				</tr>
			</logic:iterate>
		</table>
	
		<h1><bean:message key="gestionGroup.h1.add"/></h1>
		<html:form action="/AddContactGroup.do" styleClass="form-group">
		<html:errors/>
	
		<label class="col-sm-2 col-form-label"><bean:message key="gestionGroup.form.nom" /></label>
		<html:text property="nom" size="30" maxlength="30"/> <br>
	
		<label class="col-sm-2 col-form-label"></label>
		<html:submit styleClass="btn btn-lg btn-outline-primary"><bean:message key="global.form.submit" /></html:submit>
		</html:form>
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/ContactAffichage.do"><bean:message key="main.contact.affichage" /></html:link>

	</div>
</div>
</body>
</html:html>