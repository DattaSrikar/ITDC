<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body style=" background-color: lightgray;">
			
	<center>
			<h2><i><b>Customer Registration Form</b></i></h2>
		<form action="newcustomer" method="post">
		
			Enter your name: <input type="text" name="name" required="required"><br>
			Enter Gender: <input type="text" name="gender" required="required"><br>
			Enter password: <input type="text" name="password" required="required"><br>
			Confirm password: <input type="text" name="cpassword"><br>
			Enter mail id: <input type="email" name="mail"><br>
			Enter address: <input type="text" name="address"><br>
			Enter Mobile no: <input type="tel" name="mobile"><br><br><br>
		
			<input type="submit" value="Create Account">
			<input type="reset" value="Reset">	
		</form>
	</center>
</body>
</html>