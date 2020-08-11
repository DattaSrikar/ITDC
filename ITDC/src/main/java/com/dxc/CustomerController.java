package com.dxc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.BookRoom;
import com.dxc.pojos.CancelBooking;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Hotel;
import com.dxc.services.CustomerService;

@Controller
public class CustomerController 
{
	@Autowired
	CustomerService customerService = new CustomerService();
	
	String message="";
	
	@RequestMapping("/newcustomer")
	public String createCustomer(@ModelAttribute Customer c, Model m)
	{
		if(c.getPassword().equals(c.getCpassword()))
		{
			boolean b  = customerService.createCustomer(c);
			
			if(b)
			{
				message="Registration Successfull!!";
				m.addAttribute("message",message);
				return "message";
			}
			else
			{
				message="An Error occured try again!!";
				m.addAttribute("message",message);
				return "message";
			}
		}
		else
		{
			message="Password must match";
			m.addAttribute("message",message);
			return "message";
		}
	}
	
	@RequestMapping("/customerlogin")
	public String customerLogin(@ModelAttribute Customer c,Model m,HttpSession session)
	{
		boolean b = customerService.customerlogin(c);
		
		session.setAttribute("mobile",c.getMobile());
		
		if(b)
		{
			m.addAttribute("message","Customer Login successfull!!");
			return "customermenu";
		}
		else
		{
			message="Incorrect Login Credentials..";
			m.addAttribute("message",message);
			return "message";
		}
	}
	
	@RequestMapping("/gethotels")
	public String getAll(Model m)
	{
		List<Hotel> hlist = customerService.getAllHotels();
		
		m.addAttribute("list",hlist);
		return "getallhotels";		
	}
	
	@RequestMapping("/gethotel")
	public String getHotel(@RequestParam int id, Model m,HttpSession session)
	{
		List<Hotel> hlist = customerService.getHotel(id);
		
		session.setAttribute("id",id);
		
		System.out.println(hlist);
		
		if(hlist.isEmpty())
		{
			m.addAttribute("message","Hotel not found!");
			return "message";
		}
		else
		{
			for(Hotel h:hlist)
			{
				int hid = h.getId();
				String name = h.getName();
				String Address = h.getAddress();
				int totalrooms  = h.getTotalrooms();
				int avaliablerooms = h.getAvaliablerooms();
				double costperroom = h.getCostofroom();
				
				m.addAttribute("id",hid);
				m.addAttribute("name",name);
				m.addAttribute("address",Address);
				m.addAttribute("totalrooms",totalrooms);
				m.addAttribute("avaliablerooms",avaliablerooms);
				m.addAttribute("costperroom",costperroom);
			}
			return "showhotel";	
			
		}
	}
	@RequestMapping("/bookaroom")
	public String bookRoom(@ModelAttribute BookRoom bookroom,Model m,HttpSession session)
	{
		int id = (int) session.getAttribute("id");
		
		Long mobile = (Long) session.getAttribute("mobile");
		
		boolean b = customerService.bookroom(bookroom,id,mobile);
		
		
		if(b)
		{
			message="Room Booked Successfully!!";
			m.addAttribute("message",message);
			return "message";	
		}
		else
		{
			message="Unable to Bookrooms-(insufficent rooms)!!";
			m.addAttribute("message",message);	
			return "message";
		}
	}
	@RequestMapping("/showbookings")
	public String showBookings(Model m,HttpSession session)
	{
		Long mobile = (Long) session.getAttribute("mobile");
		
		 List<BookRoom>  blist = customerService.showBookings(mobile);
		 
		 System.out.println("controller list...");
		 System.out.println(blist);
		
		if(blist.isEmpty())
		{
			message="No Active Bookings!!";
			m.addAttribute("message",message);
			return "message";	
		}
		else
		{
			m.addAttribute("list",blist);
			return "showbookings";	
		}
	}
	
	@RequestMapping("/cancelbooking")
	public String cancelBooking(@ModelAttribute CancelBooking cb,@RequestParam int bookingid,Model m,HttpSession session)
	{
		boolean b = customerService.cancelBooking(cb,bookingid);
		
		if(b)
		{
			message="Request for cancellation has sent to admin !! ";
			m.addAttribute("message",message);
			return "message";
		}
		else
		{
			message="No Booking found!! ";
			m.addAttribute("message",message);
			return "message";
		}
	}
}
