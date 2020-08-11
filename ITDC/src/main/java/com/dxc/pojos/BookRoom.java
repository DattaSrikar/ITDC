package com.dxc.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BookRoom 
{

	@Id
	private int bookingid;
	private int noofrooms;
	private int days;
	private String fromdate;
	private String todate;
	private double totalamount;
	
	private String hotelname;
	private int  hotelid;
	private String hoteladdress;
	
	private String customername;
	private long customermobile;
	
	private String status;
	
	
	public BookRoom()  {}



	public int getNoofrooms() {
		return noofrooms;
	}



	public void setNoofrooms(int noofrooms) {
		this.noofrooms = noofrooms;
	}



	public int getDays() {
		return days;
	}



	public void setDays(int days) {
		this.days = days;
	}



	public String getFromdate() {
		return fromdate;
	}



	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}



	public String getTodate() {
		return todate;
	}



	public void setTodate(String todate) {
		this.todate = todate;
	}



	public String getHotelname() {
		return hotelname;
	}



	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}



	public int getHotelid() {
		return hotelid;
	}



	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}



	public String getHoteladdress() {
		return hoteladdress;
	}



	public void setHoteladdress(String hoteladdress) {
		this.hoteladdress = hoteladdress;
	}



	public String getCustomername() {
		return customername;
	}



	public void setCustomername(String customername) {
		this.customername = customername;
	}



	public long getCustomermobile() {
		return customermobile;
	}



	public void setCustomermobile(long customermobile) {
		this.customermobile = customermobile;
	}


	
	

	public double getTotalamount() {
		return totalamount;
	}



	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}



	public int getBookingid() {
		return bookingid;
	}



	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	


	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "BookRoom [bookingid=" + bookingid + ", noofrooms=" + noofrooms + ", days=" + days + ", fromdate="
				+ fromdate + ", todate=" + todate + ", totalamount=" + totalamount + ", hotelname=" + hotelname
				+ ", hotelid=" + hotelid + ", hoteladdress=" + hoteladdress + ", customername=" + customername
				+ ", customermobile=" + customermobile + "]";
	}

	

	
	



	



	
	
	

	
	
}
