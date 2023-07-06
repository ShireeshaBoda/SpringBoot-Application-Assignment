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
<title>Add Student Form</title>
</head>
<body>
<form action="/addStu" method="post">

<table align="center" bgColor="white" height="200" width="100">
<caption><h1>Add Student</h1></caption>
<br>
<tr>
 <td><h5> Student Id: </h5></td>
 <td><input type="number" name="id" placeholder="Enter id ">
 </td>
</tr>
<tr>
<td> 
 <h5> Student Name:</h5></td>
 <td><input type="text" name="sname" placeholder="Enter name"/>
 </td>
 </tr>
 <tr>
<td> 
 <h5> Username</h5></td>
 <td><input type="text" name="username" placeholder="Enter username"/>
 </td>
 </tr>
 <tr>
<td> 
 <h5> Password</h5></td>
 <td><input type="text" name="password" placeholder="Enter password"/>
 </td>
 </tr>
 <tr>
<td> 
 <h5> Role</h5></td>
 <td><input type="text" name="role" placeholder="Enter role:"/>
 </td>
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