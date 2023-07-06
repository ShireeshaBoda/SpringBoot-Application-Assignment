<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Minor Project</title>
<link rel="stylesheet" type="text/css" href=styles.css">
<style>
body {
 background-image: url('https://img.freepik.com/premium-photo/keyboard-coffee-smartphone-notebook-color-background-top-view_1286-1326.jpg');
 height:100%;
  background-size:cover;
  background-position: center;
  background-repeat:no-repeat;
  font-family:Arial,sans-serif;
}
login-container{
  background-color:green;
   border-radius:5px;
   border-shadow:0 0 10px rgba(0,0,0,0.1);
   margin:100px auto;
   max-width:300px;
   padding:20px;
   text-align:center;
}
h1{
   color:#333333;
   font-size:50px;
   margin-bottom:30px;
   text-align:center;
}
input[type="text"],
input[type="password"]{
 border:1px solid #dddddd;
 border-radius:3px;
 
 margin-bottom:20px;
 padding:10px;
 
}
button{
  background-color:34CAF5O;
  border:none;
  border-radius:3px;
  color:black;
  cursor:pointer;
  font-size:16px;
  padding:10px;
}
button:hover{
 background-color:#45a049;
}
input:focus,
button:focus{
outline:none;
}
</style>
<body >
<div class="login-container">
<br><br>
<h1 >Login</h1>
<br>
      <form action="/login" method="post" align="center" bgColor="white">
     
      <label for="username">Username:</label>
      <input type="text" is="username" name="username" required><br><br>
      <label for="password">Password:</label>
      <input type="password" is="password" name="password" required><br><br>
      <button type="submit" value="Submit"> Log in</button>
      </div>
      </form>
</body>
</html> 