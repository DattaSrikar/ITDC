package com.dxc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.CustomerDao;
import com.dxc.pojos.BookRoom;
import com.dxc.pojos.CancelBooking;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Hotel;

@Service
public class CustomerService 
{
	@Autowired
	CustomerDao dao = new CustomerDao();
	
	public boolean createCustomer(Customer c)
	{
		return dao.createCustomer(c);
	}
	
	public boolean customerlogin(Customer c)
	{
		return dao.customerlogin(c);
	}
	
	public List<Hotel> getAllHotels()
	{
		return dao.getAllHotels();
	}
	
	public List<Hotel> getHotel(int id)
	{
		return dao.getHotel(id);
	}
	public boolean bookroom(BookRoom b,int i,Long m)
	{
		return dao.bookroom(b,i,m);
	}
	public List<BookRoom> showBookings(Long m)
	{
		return dao.showBookings(m);
	}
	public boolean cancelBooking(CancelBooking cb,int id)
	{
		return dao.cancelBooking(cb,id);
	}
}
