<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<s:if test='#session.logined !="true" '>
<%response.sendRedirect("index.jsp");%>
</s:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="empDetails.css">
<title>Employee Details</title>
</head>
<body>

<div id ="overlay"></div>

<div id ="header">
<a href="logout"><button id='logoutBtn'>Logout</button></a>
<h1>WELCOME <i>${sessionScope.user}</i> !</h1>
<hr>
</div>

<div id ="uploadSec">
<fieldset>
<legend>Upload CSV</legend>
<s:form action="upload" method="post" enctype="multipart/form-data">
<s:file name="csvFile" accept=".csv" />

<s:submit value ="Upload CSV" id ="submitBtn"/>
<input type="reset" id ="resetBtn"/>
</s:form>
</fieldset>
</div>
<br>

<div>
<a href="download"  id="downloadBtn">
  <button>Download CSV</button>
</a>
</div>
<br><br>

<table  style="width: 100% " id="table">
<tr>
<th>Employee Code</th>
<th>Name</th>
<th>Location</th>
<th>Email</th>
<th>Date of Birth</th>
<th>Action</th>
</tr>
	<s:iterator value="#session.empList" >
				<tr>
					<td class="td" name="employeeCode"><s:property value="employeeCode"></s:property></td>
					<td class="td" name="name"><s:property value="name"></s:property></td>
					<td class="td" name="location"><s:property value="location"></s:property></td>
					<td class="td" name="email"><s:property value="email"></s:property></td>
					<td class="td" name="dob"><s:property value="dob"></s:property></td>
					<td class="td" ><span class="editLink" >Edit</span></td>
				</tr>
	</s:iterator>
</table>

<div id ="editSec">
<fieldset>
<legend>Edit Employee Details</legend>
<s:form action="updateemp" method="post">
<s:textfield  label="Employee Code" name="employeeCode" id ="employeeCode" value ="500" disabled="true" />
<s:hidden name="eCode" id ="eCode"/>
<s:textfield label="Name" name="name" id ="name" />
<s:textfield  label="Location" name="location" id ="location"/>
<s:textfield label="Email" name="email" id ="email"/>
<s:textfield label="Date of Birth" name="dob" id ="dob"/>
<s:submit value ="Edit" id="editBtn" />
</s:form>
</fieldset>
</div>

<script src="jquery-3.1.0.js"></script>
<script src="empDetails.js"></script>
</body>
</html>