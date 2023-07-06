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
  
   text-color:white;
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
<div align="center"> 
     <a href="/addCourseForm"><h5><font><button>Add new Course</button></h5></a><br><br>
     
</div>
<table border="1" align="center" padding="6">

  <thead bgColor="aqua">
      <tr>
      <th>ID</th>
      <th>Name</th>
       <th>Description</th>
    
        </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${courseList}">
        <tr>
        <td>
         <c:out value="${course.getId()}"></c:out>
        </td>
         <td>
         <c:out value="${course.getCname()}"></c:out>
        </td>
        <td>
           <c:out value="${course.getDescription()}"></c:out>
        </td>
        
        </tr>
        </c:forEach>
        </tbody>
  </table>
</body>
</html>