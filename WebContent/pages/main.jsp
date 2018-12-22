<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="pages/other.css">
	<title><bean:message key="main.page.title"/></title>
</head>
<body>

	<div class="background">
		<div class="container">
			<html:form action="/Connexion" styleClass="form-signin" style="width: 300px; display: block; margin: auto">
				<h1 class="form-signin-header"><bean:message key="main.page.connection" /></h1>
				<html:errors />
				<html:text property="username" styleClass="form-control" size="30" maxlength="30"/>
				<html:password property="password" styleClass="form-control" size="30" maxlength="30"/>
				<html:submit styleClass="btn btn-lg btn-outline-primary btn-block"><bean:message key="main.connection.do" /></html:submit>
			</html:form>
		</div>
	</div>
</body>
</html>