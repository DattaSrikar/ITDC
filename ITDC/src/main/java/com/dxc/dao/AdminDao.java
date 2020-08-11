package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dxc.MongoBookRoom;
import com.dxc.MongoCancel;
import com.dxc.Mongodb;
import com.dxc.Mongohotel;
import com.dxc.pojos.Admin;
import com.dxc.pojos.BookRoom;
import com.dxc.pojos.CancelBooking;
import com.dxc.pojos.Hotel;

@Service
@Repository
public class AdminDao 
{
	@Autowired
	Mongodb mon;
	
	@Autowired
	Mongohotel hotel;
	
	@Autowired
	MongoBookRoom bookRoom;
	
	@Autowired
	MongoCancel cancel;
	
	public boolean login(String u,String p,Admin a)
	{          
          System.out.println("form user-"+u);
          System.out.println("form pass-"+p);
          
          List<Admin> alist = new ArrayList<>();
          
           alist =  mon.findAll();
           System.out.println(alist.size());
           System.out.println(alist);
           
           Admin a1 = alist.get(1);
           
           if(a1.getUsername().equals(u) && a1.getPassword().equals(p))
           {
        	   return true;
           }
			/*
			 * for(int i=0;i<alist.size();i++) { if(alist.get(i).getUsername().equals(u) &&
			 * alist.get(i).getPassword().equals(p)) { return true; } }
			 */
		return false;
	}
	
	public boolean addHotel(Hotel h)
	{
		List<Hotel> hlist = new ArrayList<>();
		try
		{
			hlist = hotel.findAll();
			
			if(hlist.isEmpty())
			{
				System.out.println("no hotels..");
				hotel.save(h);
				return true;
			}
			else
			{
				for(Hotel h1:hlist)
				{
					if(h1.getId()==h.getId())
					{
						return false;
					}
					else
					{
						hotel.save(h);
						return true;
					}
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
	return false;
	}
	
	public List<Hotel> getAllHotels()
	{
		List<Hotel> hotelList = new ArrayList<>();
		try
		{
			hotelList = hotel.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return hotelList;
	}
	
	public List<BookRoom> getAllBookings()
	{
		return bookRoom.findAll();
	}
	
	public List<CancelBooking> cancelBookings()
	{
		List<CancelBooking> clist = cancel.findAll();
		
		if(clist.isEmpty())
		{
			return clist;
		}
		else
		{ 
			return clist;
		}
	}
	
	public boolean cancel(BookRoom b)
	{	
		
		List<CancelBooking> clist  = cancel.findAll();
		
		for(CancelBooking cb:clist)
		{
			int bid = cb.getBookingid();
			
			List<BookRoom> blist = bookRoom.findBookRoomBybookingid(bid);
			
			BookRoom br = blist.get(0);
			
			int brooms = br.getNoofrooms();
			
			System.out.println("bookedrooms--"+brooms);
			
			int hotelid = br.getHotelid();
			
			List<Hotel> hlist = hotel.findHotelById(hotelid);
			
			Hotel h = hlist.get(0);
			
			int hrooms = h.getAvaliablerooms();
			
			System.out.println("availrooms--"+hrooms);
			
			hrooms = hrooms + brooms;
			
			System.out.println("finalrooms--"+hrooms);
			
			h.setAvaliablerooms(hrooms);
			
			br.setStatus("Cancelled");
			
			bookRoom.save(br);
			hotel.save(h); 
			cancel.deleteAll();
			
		}
		return true;
	}
    
    
     
     
     
}
