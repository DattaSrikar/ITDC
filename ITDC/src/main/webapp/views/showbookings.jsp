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
<title>Your Bookings!!</title>
</head>
<body>

	<body style="background-color: hsla(89, 43%, 51%, 0.3);">
	
	<center><i><h1><u>Bookings</u></h1></i></center>
	
	         <table class="center">
								
								<tr>
									<td>Booking Id</td>
									<td>Hotel Id</td>
									<td>Hotel Name</td>
									<td>Hotel Address</td>
									<td>Customer Name</td>
									<td>Mobile No</td>
									<td>Rooms Booked</td>
									<td>Total Days</td>
									<td>From Date</td>
									<td>To Date</td>
									<td>Total Amount</td>
									<td>Status</td>
								</tr>
	
	<c:forEach var="s" items="${list}">
								
							<tr> 
							        <td><c:out value="${s.getBookingid()}"></c:out></td>
									<td><c:out value="${s.getHotelid()}"></c:out></td>
									<td><c:out value="${s.getHotelname()}"></c:out></td>
									<td><c:out value="${s.getHoteladdress()}"></c:out></td>
									<td><c:out value="${s.getCustomername()}"></c:out></td>
									<td><c:out value="${s.getCustomermobile()}"></c:out></td>
									<td><c:out value="${s.getNoofrooms()}"></c:out></td>
									<td><c:out value="${s.getDays()}"></c:out></td>
									<td><c:out value="${s.getFromdate()}"></c:out></td>
									<td><c:out value="${s.getTodate()}"></c:out></td>
									<td><c:out value="${s.getTotalamount()}"></c:out></td>
									<td><c:out value="${s.getStatus()}"></c:out></td>

							</tr>
							
					</c:forEach>		
					</table>
			
</body>
</html>