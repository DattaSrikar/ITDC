<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

					<style>
					table, tr, td
					{
						 border: 2px solid black;
						 width : 40%; 
						text-align: center; 
						 border-collapse: collapse;
					}
					table.center 
					{
						margin-left: auto;
  						margin-right: auto;
  						
					}
					
					tr,td
					{
						padding :10px;
					}
  
					
				</style>


<meta charset="ISO-8859-1">

<title>Hotels List</title>
</head>
<body style="background-color: hsla(89, 43%, 51%, 0.3);">
	
	<center><i><h1>List Of Hotels</h1></i></center>
	
	         <table class="center">
								
								<tr>
									<td>Hotel Id</td>
									<td>Hotel Name</td>
									<td>Address</td>
									<td>Total Rooms</td>
									<td>Avaliable Rooms</td>
									<td>Cost Per Room</td>
									</tr>
	
	<c:forEach var="s" items="${list}">
								
							<tr>
									<td><c:out value="${s.getId()}"></c:out></td>
									<td><c:out value="${s.getName()}"></c:out></td>
									<td><c:out value="${s.getAddress()}"></c:out></td>
									<td><c:out value="${s.getTotalrooms()}"></c:out></td>
									<td><c:out value="${s.getAvaliablerooms()}"></c:out></td>
									<td><c:out value="${s.getCostofroom()}"></c:out></td>

							</tr>
							
					</c:forEach>		
					</table>
		
	
</body>
</html>