package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dxc.MongoBookRoom;
import com.dxc.MongoCancel;
import com.dxc.MongoCustomer;
import com.dxc.Mongohotel;
import com.dxc.pojos.BookRoom;
import com.dxc.pojos.CancelBooking;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Hotel;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

@Repository
@Service
public class CustomerDao 
{
	@Autowired
	MongoCustomer moncustomer;
	
	@Autowired
	Mongohotel hotel;
	
	@Autowired
	MongoBookRoom bookroom;
	
	@Autowired
	MongoCancel cancel;
	
	Random random = new Random();
	
	
	public boolean createCustomer(Customer c)
	{
		try
		{
			moncustomer.save(c);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean customerlogin(Customer c)
	{
		try
		{
			List<Customer> clist = moncustomer.findAll();
		
			  for(int i=0;i<clist.size();i++) 
			  {
				  if(clist.get(i).getMobile()==c.getMobile() && clist.get(i).getPassword().equals(c.getPassword()))
				  {
					  return true;
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
		List<Hotel> hlist = new ArrayList<>();
			
		hlist = hotel.findAll();
		
		return hlist;
	}
	
	public List<Hotel> getHotel(int id)
	{	
		List<Hotel> hlist =  new ArrayList<Hotel>();
		 hlist = hotel.findHotelById(id);
		 return hlist;
	}
	public boolean bookroom(BookRoom b,int i,Long m)
	{
	   List<Customer> clist = moncustomer.findCustomerByMobile(m);
		
	   		System.out.println(m);
		
	   		Customer c = clist.get(0);
			
	   		b.setCustomername(c.getName());
	   		b.setCustomermobile(c.getMobile());
	
		
		
	   		List<Hotel> hlist =  new ArrayList<Hotel>();
	   		hlist = hotel.findHotelById(i);
		
			Hotel h = hlist.get(0);
			
			
			b.setHotelid(i);
			b.setHotelname(h.getName());
			b.setHoteladdress(h.getAddress());
			
			int originalrooms = h.getAvaliablerooms();
			
			int bookedrooms = b.getNoofrooms();
			
			System.out.println("form rooms-"+bookedrooms);
			
			if(bookedrooms<=originalrooms)
			{
				originalrooms = originalrooms - bookedrooms;
				
				System.out.println("finalrooms-"+originalrooms);
				
				h.setAvaliablerooms(originalrooms);
				
				hotel.save(h);
				
				double cost = b.getNoofrooms() * h.getCostofroom() * b.getDays();
				
				b.setTotalamount(cost);
				
				int bid = random.nextInt(50);
				
				b.setBookingid(bid);
				
				System.out.println("bid from random--"+bid);
				
				b.setStatus("Booked");
				
				bookroom.save(b);
				
				return true;
			}
			else
			{
				return false;
			}

	}
	
	public List<BookRoom> showBookings(Long m)
	{
		List<BookRoom> blist = bookroom.findBookRoomBycustomermobile(m);
		return blist;
	}
	
	public boolean cancelBooking(CancelBooking cb,int id)
	{	
		List<BookRoom> blist = bookroom.findBookRoomBybookingid(id);
		
		if(blist.isEmpty())
		{
			return false;
		}
		else
		{
			BookRoom b = blist.get(0);
			
			if(b.getBookingid()==id)
			{
				for(BookRoom br:blist)
				{
					cb.setHotelname(br.getHotelname());
					cb.setBookingid(br.getBookingid());
					
					b.setStatus("Requesting for cancel");
					
					bookroom.save(b);
					cancel.save(cb);
				}
				return true;
			}
			
			
		}
	return false;	
	}
}
