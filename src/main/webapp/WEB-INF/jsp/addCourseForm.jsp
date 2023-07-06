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
<title>Add Course Form</title>
</head>
<body bgcolor="#ffcccc">
<form action="/addCourse" method="post">

<table align="center" bgColor="white" height="200" width="100">
<caption><h1>Add Course</h1></caption>
<tr>
<td> 
 <h5> Course Name:</h5></td>
 <td><input type="text" name="cname" placeholder="Enter name"/>
 </td>
 </tr>
 <tr>
<td> 
 <h5> Description:</h5></td>
 <td><input type="text" name="description" placeholder="Enter name"/>
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