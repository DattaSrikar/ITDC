package com.dxc.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.AdminDao;
import com.dxc.pojos.Admin;
import com.dxc.pojos.BookRoom;
import com.dxc.pojos.CancelBooking;
import com.dxc.pojos.Hotel;

@Service
public class AdminService 
{
	@Autowired
	AdminDao dao = new AdminDao();
	
	public boolean login(String u, String p,Admin a)
	{
		 return dao.login(u,p,a);
	}
	
	public boolean addHotel(Hotel h)
	{
		return dao.addHotel(h);
	}
	
	public List<Hotel> getAllHotels()
	{
		return dao.getAllHotels();
	}
	
	public List<BookRoom> getAllBookings()
	{
		return dao.getAllBookings();
	}
	
	public List<CancelBooking> cancelBookings()
	{
		return dao.cancelBookings();
	}
	
	public boolean cancel(BookRoom b)
	{
		return dao.cancel(b);
	}
}
