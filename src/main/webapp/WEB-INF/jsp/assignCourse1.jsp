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
<title>Assign Course to Instructor</title>
</head>
<body bgcolor="#99ccff">
<form action="/assign1" method="post">

<table align="center" bgColor="white" height="200" width="100">
<caption><h1>Assign Course to Instructor</h1></caption>
<tr>
 <td><h5> Instructor Id:</h5></td>
 <!--  <td><input type="number" name="Iid" placeholder="Enter id ">
 </td>-->
 <td>
 <select name="Iid">
  <c:forEach var="instructor" items="${instructorList}">
 
      
        <option value=" ${instructor}"> ${instructor}</option>
        </c:forEach>
</select>
  </td>
   
</tr>
<tr>
 <td><h5> Course Id:</h5></td>
 <td>
 <select name="Cid">
  <c:forEach var="course" items="${courseList}">
 
      
        <option value=" ${course.id}"> ${course.id}</option>
        </c:forEach>
</select>
  </td>
 <!--<td><input type="number" name="Cid" placeholder="Enter Course id ">-->

</tr>
<tr>

 </tr>
 <tr>
<td> </td>
 <td><input type="submit" name="Submit"/>
 </td>
 </tr>
</body>
</html>