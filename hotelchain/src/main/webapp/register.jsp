<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div align="center">
  <h1>User Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
    <tr>
     <td>Identification Type</td>
     <td><input type="text" name="ident_type" /></td>
    </tr>
    <tr>
    <tr>
     <td>Identification Number</td>
     <td><input type="text" name="ident_number" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="address" /></td>
    </tr>
    <tr>
     <td>Home Number</td>
     <td><input type="text" name="home_phone" /></td>
    </tr>
    <tr>
     <td>Mobile Number</td>
     <td><input type="text" name="mobile_phone" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>