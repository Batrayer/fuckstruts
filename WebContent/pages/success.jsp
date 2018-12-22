<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<html:html>
    <head>
    <title><bean:message key="addContact.success.title" /></title>

    </head>

    <body>
    
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/ContactAffichage.do"><bean:message key="main.contact.affichage" /></html:link>
        <bean:message key="addContact.success"/>
        <bean:message key="addContact.title"/>
    </body>
</html:html>