<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp"/>
<meta charset="ISO-8859-1">
<title>Courses</title>
</head>
<style>
body {
  
  background-repeat: no-repeat;
  background-size:cover;
}
table {
  border-collapse: collapse;
  width: 80%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

tr:hover {background-color: gray;}

td:hover {background-color: gray;}
h1{
  
   text-color:black;
}
td{
    background-color:white;
    text-color:red;'
    }
button:hover
{
 background-color:green;
}
</style>
<body>
<h1>Your Courses are here...</h1>
<br><br>
 <table border="1" align="center" padding="6px">

  <thead bgColor="aqua">
      <tr>
      <th>Course ID</th>
      <th>Course Name</th>
      <th>Course Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${studentCourseList}">
        <tr>
        <td>
         <c:out value="${list.getd()}"></c:out>
        </td>
         <td>
         <c:out value="${list.getCname()}"></c:out>
        </td>
         <td>
         <c:out value="${list.getDescription()}"></c:out>
        </td>
        </tr>
        </c:forEach>
        </tbody>
  </table>
</body>
</html>