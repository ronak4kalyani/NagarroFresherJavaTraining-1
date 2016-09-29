<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ='s' uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<s:if test='#session.logined =="true" '>
<%response.sendRedirect("emplist");%>
</s:if>
<s:form action="register" method ="post">
	<s:textfield label = "Choose User ID  " key="userId" requiredLabel="true" />
	<s:password label = "Password " key="pass" requiredLabel="true" />
	<s:password label = " ReEnter Password " key="rePass" requiredLabel="true" />
	<s:submit  />
</s:form>
</body>
</html>