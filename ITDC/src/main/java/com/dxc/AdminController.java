package com.dxc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Admin;
import com.dxc.pojos.BookRoom;
import com.dxc.pojos.CancelBooking;
import com.dxc.pojos.Hotel;
import com.dxc.services.AdminService;

@Controller
public class AdminController 
{
	@Autowired
	AdminService adminService = new AdminService();
	
	
	String message="";
	
	@RequestMapping("/welcome")
	public String home()
	{
		return "welcome";
	}
	
	@RequestMapping("/login")
	public String adminlogin(@ModelAttribute Admin a, Model m)
	{
		boolean b = adminService.login(a.getUsername(),a.getPassword(),a);
		
		if(b)
		{
			m.addAttribute("message","Admin Login successfull!!");
			return "adminmenu";
		}
		else
		{
			message="Incorrect Login Credentials..";
			m.addAttribute("message",message);
			return "message";
		}
	}
	@RequestMapping("/add")
	public String addHotel(@ModelAttribute Hotel h,Model m)
	{
		boolean b = adminService.addHotel(h);
		
		if(b)
		{
			message="Hotel Added!!";
			m.addAttribute("message",message);
			return "adminmenu";
		}
		else
		{
			message="Hotel already exists..!!";
			m.addAttribute("message",message);
			return "message";
		}
	}
	@RequestMapping("/getallhotels")
	public String getAll(Model m)
	{
		List<Hotel> hlist = adminService.getAllHotels();
		
		if(hlist.isEmpty())
		{
			message="Hotels not found!!";
			m.addAttribute("message",message);
			return "message";
		}
		else
		{
			m.addAttribute("list",hlist);
			return "showhotels";
		}
	}
	
	@RequestMapping("/displaybookings")
	public String getAllBookings(Model m)
	{
		List<BookRoom> blist = adminService.getAllBookings();
		
		if(blist.isEmpty())
		{
			message="No Active Bookings !!";
			m.addAttribute("message",message);
			return "message";
		}
		else
		{
			m.addAttribute("list",blist);
			return "showallbookings";
		}
	}
	
	@RequestMapping("/cancelbookings")
	public String cancelBookings(Model m)
	{
		List<CancelBooking> cblist = adminService.cancelBookings();
		
		if(cblist.isEmpty())
		{
			message="No Active Cancellation Requests!!";
			m.addAttribute("message",message);
			return "message";
		}
		else
		{
			m.addAttribute("list",cblist);
			return "cancel";
		}
	}
	
	@RequestMapping("/cancel")
	public String cancel(@ModelAttribute BookRoom bookroom,Model m)
	{
		boolean b = adminService.cancel(bookroom);
		
		if(b)
		{
			message="Bookings Cancelled!!";
			m.addAttribute("message",message);
			return "message";
		}
		else
		{
			message="Unable to cancel!!";
			m.addAttribute("message",message);
			return "message";
		}
	}
	
	
}

