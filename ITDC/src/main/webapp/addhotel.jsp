<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Hotel</title>
</head>
<body style="background-color: hsla(89, 43%, 51%, 0.3);">

	<center>
			<form action="add" method="post"><br><br>
		
		Enter Hotel Id: <input type="text" name="id"><br><br>
		Enter Hotel Name:  <input type="text" name="name"><br><br>
		Enter Address: <input type="text" name="address"><br><br>
		Enter Totalrooms: <input type="text" name="totalrooms"><br><br>
		Enter Avaliablerooms: <input type="text" name="avaliablerooms"><br><br>
		Enter cost per room: <input type="text" name="costofroom"><br><br>

		<input type="submit" name="btn" value="AddHotel">		
		
		</form>
		
	</center>
	
</body>
</html>