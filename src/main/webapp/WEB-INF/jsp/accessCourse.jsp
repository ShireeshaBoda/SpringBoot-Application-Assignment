<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="Header.jsp"/>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
%>
<title>Insert title here</title>
</head>
<body>
 <form align="center" action="/accessCourse" method="post">
<table>
<tr>
<td>Enter id</td>
<td><input type="number" name="student_id" placeholder="Enter id"/>
</td>
</tr>
<tr>
<td><input type="submit" value="Submit" placeholder="Submit" />
</td>
</tr>
</table>
</form>
   
</body>
</html>