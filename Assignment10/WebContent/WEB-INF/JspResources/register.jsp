<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
fieldset{
	border-radius:4px ;
}
div{
	width: 350px;
    margin:auto;
    position:fixed ;
	top: 30%;
	left:calc(50% - 175px) ;
	
}
form input{
	float:right ;
	margin-right:20px ;
	border:0.5px solid black ;
}
p{
	margin:10px 20px 0px 0px;
	font-size: small;
	float:right ;
	color:red ;
}
span{
	font-size: small;
	color:red ;
}
</style>
</head>
<body>

<div id= "register">
<fieldset>
<legend>Register</legend>
<form method="post" action="register" >
<label>Full Name  <input name="name" required></label><form:errors path="registerDetails.name"/>
<br><br>
<label>UserName <input name="userId"  required></label><form:errors path="registerDetails.userId"/>
<br><br>
<label>Email  <input name="email" type="email" required></label><form:errors path="registerDetails.email"/>
<br><br>
<label>Password  <input name="pass" type="password" required></label><form:errors path="registerDetails.pass"/>
<br><br>
<!-- <label>Retype Password <input name="rePass" type="password" required></label>
<br><br> -->
<a href="login">Existing User</a>
<input type="submit" value= "Register"><br>
</form>
<p >${InvalidationMsg}</p>
</fieldset>
</div>

</body>
</html>