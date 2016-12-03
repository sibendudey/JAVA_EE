
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spittr</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" /> 
</head>
<body>
<h1> Register </h1>
<sf:form method="POST" commandName="spitter">
<sf:errors path="*" element="div" cssClass="errors" />
First Name: <sf:input path="firstName" />
<!--<sf:errors path="firstName" /> <br/> -->
Last Name: <sf:input path="lastName" />
<!--<sf:errors path="lastName" /> <br/> -->
UserName: <sf:input path="userName" />
<!--<sf:errors path="userName" /> <br/> -->
Password: <sf:input path="password" />
<!--<sf:errors path="password" />	<br/> -->
<input type="submit" value="Register" />
</sf:form>
</body>
</html>