<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp"/>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
%>
<meta charset="ISO-8859-1">
<title>Instruction Registration Form</title>
</head>

<body bgColor="#ffcccc">
<form action="/addInst" method="post">

<table align="center" bgColor="white" height="200" width="100">
<caption><h1 color="Red">Add Instructor</h1></caption>
<tr>
 <td><h5><b> Instructor Id: </b></h5></td>
 <td><input type="number" name="id" placeholder="Enter id ">
 </td>
</tr>
<tr>
<td> 
 <h5> Name:</h5></td>
 <td><input type="text" name="iname" placeholder="Enter name"/>
 </td>
 </tr>
 <tr>
<td> 
 <h5> Username:</h5></td>
 <td><input type="text" name="username" placeholder="Enter Username"/>
 </td>
 </tr>
 
 <tr>
<td> 
 <h5> Password:</h5></td>
 <td><input type="text" name="password" placeholder="Enter password"/>
 </td>
 </tr>
 <tr>
<!--  <td> 
 <h5> Role:</h5></td>
 <td><input type="text" name="role" placeholder="Enter role"/>
 </td>-->
 </tr>
<tr> </tr>
<tr></tr>
<tr>
<td></td>
<td> 
<input type="submit" value="Submit" placeholder="Submit" />
</td>
</tr>
</table>
</form>
</body>
</html>