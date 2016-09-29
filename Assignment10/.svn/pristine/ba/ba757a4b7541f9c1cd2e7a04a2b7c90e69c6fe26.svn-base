<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Matching Flights</title>
<style>
fieldset{
	border-radius:4px ;
}
div{
	width: 400px;
    margin-left:calc(50% - 200px) ;
	margin-bottom:30px ;
}
form input{
	float:right ;
	margin-right:20px ;
	border:0.5px solid black ;
}
table{
	width:60% ;
	margin:auto ;
}
table,tr,td,th{
border: 1px solid black ;
border-collapse:collapse ;
text-align :center ;
}
p{
	/* margin:10px 20px 0px 0px; */
	font-size: small;
	float:right ;
	color:red ;
}
</style>
</head>
<body>
<a href="logout" style="float: left"><button >sign out</button> </a>
<p>${loginedUser.userId} is currently logged in .</p>
<div id= "flightSearch">
<fieldset>
<legend  >Flight Search Details</legend>
<form method="post" action="" id ="registrationForm">
<label>Departure Location  <input value="${flightdetails.depLoc}" disabled></label>
<br><br>
<label>Arrival Location <input value="${flightdetails.arrLoc}" disabled></label>
<br><br>
<label>Flight Date  <input value="<fmt:formatDate value="${flightdetails.flightDate}" type="date" dateStyle="long" />" disabled></label>

<br><br>
<label>Flight Class <input value="${flightdetails.flightClass}" disabled></label>
<br><br>
<label>Output Preference <input value="${flightdetails.outputPreference==1?'Sort By Fare':'Sort By Duration'}" disabled></label>
<br>
</form>
</fieldset>
</div>

<table>
<tr>
<th>S.no.</th>
<th>flight No. </th>
<th>Valid till</th>
<th>Departure Time</th>
<th>Duration</th>
<th>fare</th>
</tr>

<c:forEach  var="listValue" items="${list}"  varStatus="status">
<tr>
<td> ${status.index +1}   </td>
<td>  ${listValue.flightNo} </td>
<td> <fmt:formatDate value="${listValue.validTill}" type="date" dateStyle="long" /> </td>
<td>  ${listValue.flightTime} </td>
<td>  ${listValue.flightDuration} </td>
<td>  ${listValue.fare} </td>
</tr>
</c:forEach>

</table>

</body>
</html>