<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book a room!</title>
</head>
<body style="background-color: hsla(89, 43%, 51%, 0.3);">

<center>

		<form action="bookaroom">
		
	      <h3> How many rooms you want : </h3>
	      	
	      	<input type="number" name="noofrooms">
	      	
	      <h3>Number of days : </h3>
	      
	        <input type="number" name="days">
	        
	       <h3>From :</h3>
	       
	       <input type="date" name="fromdate">

		
			<h3>To :</h3>
	       
	       <input type="date" name="todate"> <br><br>
					
	       <input type="submit" value="Book Here">
		
		</form>
 </center>
		
</body>
</html>