<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<html:html>
    <head>
        <title><bean:message key="addContact.failure.title" /></title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="pages/other.css">
    </head>

    <body>
    
<div class="background">
	<div class="container">
    	<bean:define id="exception" name="except" />
    	<p><bean:message key="failure.except"/><%=exception %></p>
    
    	<img  src="https://dogemuchwow.com/wp-content/uploads/2017/11/web-developer-doge-1280x960.jpg" alt="https://cdn.discordapp.com/attachments/273511917081853952/380375597311852544/2Q.png">
		
		<html:link styleClass="btn btn-lg btn-outline-primary" page="/ContactAffichage.do"><bean:message key="main.contact.affichage" /></html:link>
	</div>
</div>
</body>
</html:html>