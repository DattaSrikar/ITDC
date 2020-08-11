<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Hotel Details!</title>
</head>
<body style="background-color: hsla(89, 43%, 51%, 0.3);">
		
	<center><i><h1><u>Hotel Details</u></h1></i> 
	        
   <table>
	        
	        <tr>
	        
	               <td><h3>Hotel id :- ${id}</h3></td>
	         </tr>
	         
	         <tr>
	               <td><h3>Hotel Name :- ${name}</h3></td>
	          </tr>
	          
	          <tr>
	               <td><h3>Hotel Address :- ${address}</h3></td>
	           </tr>
	           
	           <tr>
	               <td><h3>Total Rooms :- ${totalrooms}</h3></td>
	               
	             </tr>
	             
	             
	              <tr>
	               <td><h3>Avaliable Rooms :- ${avaliablerooms}</h3></td>
	               
	             </tr>
	             
	             
	             <tr>
	               <td><h3>Cost Of Room/Day :- ${costperroom}</h3></td>
	              </tr>
	      
   	</table>	
				
				<form action="bookroom.jsp">
	               	<input type="submit" value="Book Now">
	             </form>
		
				
	</center>

	
</body>
</html>