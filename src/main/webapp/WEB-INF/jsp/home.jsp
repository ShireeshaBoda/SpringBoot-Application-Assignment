<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<jsp:include page="Header.jsp"/>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
%>
  <title>HOME Page</title>
  <style>
  
    body {
      background-color: #f2f2f2;
      font-family: Arial, sans-serif;
    }

   
    h1 {
      text-align: center;
      color: #333;
    }

 
    .button-container {
      text-align: center;
      margin-top: 50px;
    }

   
    .button {
      padding: 10px 20px;
      font-size: 18px;
      background-color: #4CAF50;
      border: none;
      color: white;
      cursor: pointer;
      margin-right: 10px;
    }

    .button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  
 <sec:authorize access="hasRole('ADMIN')">
 <h1>HEY ADMIN...!</h1>
<h1>Click your Options below...</h1>
  <div class="button-container">
    <a href="/addInstructor"><button class="button">ACCESS INSTRUCTORS</button></a>
   <a href="/getCourse"> <button class="button">ACCESS COURSES</button></a>
  </div>
 </sec:authorize>
 <sec:authorize access="hasRole('INSTRUCTOR')">
 <h1>HEY INSTRUCTOR...!</h1>
<h1>Click your Option below...</h1>
  <div class="button-container">
    <a href="/addStudent"><button class="button">ACCESS STUDENTS</button></a>
   </div>
 </sec:authorize>
 <sec:authorize access="hasRole('STUDENT')">
 <!--  <h1>HEY STUDENT...!</h1>
  <div class="button-container">
    <a href="/accessCourses"><button class="button">ACCESS YOUR COURSES</button></a>
   </div>-->
<h1>Your Courses are here...</h1>
<br><br>
 <table border="1" align="center" padding="6px">

  <thead bgColor="aqua">
      <tr>
      <th>Course Name</th>
      <th>Course Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${studentCourseList}">
        <tr>
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
 </sec:authorize>
 
</body>
</html>
