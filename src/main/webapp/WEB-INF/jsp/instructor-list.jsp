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
<title>Instructors</title>
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
     <a href="/addInstructorForm"><h5><font><button>Add new Instructor</button></h5></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="/assignCourseForm1"><button>Assign Course To Instructor</button></a>
</div>
<br><br>
<table border="1" align="center" padding="6px">
  <thead bgColor="aqua">
      <tr>
      <th>ID</th>
      <th>Name</th>
       <th>Course</th>
    
        </tr>
        </thead>
        <tbody>
        <c:forEach var="instructor" items="${instructorList}">
        <tr>
        <td>
         <c:out value="${instructor.getId()}"></c:out>
        </td>
         <td>
         <c:out value="${instructor.getIname()}"></c:out>
        </td>
        <td>
           <c:out value="${instructor.getCourse().getCname()}"></c:out>
        </td>
        
        </tr>
        </c:forEach>
        </tbody>
  </table>
</body>
</html>