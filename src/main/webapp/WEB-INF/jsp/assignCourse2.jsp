<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp"/>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
%>
<meta charset="ISO-8859-1">
<title>Assign Course to Student</title>
</head>
<body>
<h1>Assign Course to Student</h1>
<form action="/assign" method="post">

<table align="center" bgColor="white" height="200" width="100">

<tr>
 <td><h5> Student Id:</h5></td>
 <td>
 <select name="student_id">
  <c:forEach var="student" items="${stuList}">
        <option value=" ${student.id}"> ${student.id}</option>
      </c:forEach> 
      </select>
 </td>
</tr>
<tr>
 <td><h5> Course Id:</h5></td>

<td>
      <select name="course_id">
        <option value=" ${courseList.getId()}"> ${courseList.getId()}</option>
       
      </select>
    </td>
 <tr>
<td> </td>
 <td><input type="submit" name="Submit"/>
 </td>
 </tr>
 </table>
</body>
</html>