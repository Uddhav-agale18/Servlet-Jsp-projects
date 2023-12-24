package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.HotelInfoModel;
import com.model.HotelModel;
import com.service.HotelService;

@WebServlet("/hotelInfo")
public class HotelInfoController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 RequestDispatcher r=request.getRequestDispatcher("navbar.html");
		 r.include(request, response);
		 out.println("<br>");
		 out.println("<form name='frm' action='' method='POST'>");
		 out.println("<input type='text' name='email' value='' placeholder='Email' style='width:400px; height:40px;'><br><br>");
		 out.println("<input type='text' name='contact' value='' placeholder='Contact' style='width:400px; height:40px;'><br><br>");
		 out.println("<input type='text' name='address' value='' placeholder='Adress' style='width:400px; height:40px;'><br><br>");
		 out.println("<input type='text' name='location' value='' placeholder='Location' style='width:400px; height:40px;'><br><br>");
		HotelService hotelServ=new HotelService();
		List<HotelModel> list =hotelServ.getAllHotels();
		out.println("<select  name='hotelname'style='width:400px; height:40px;'>");
		out.println("<option>Select Hotel</option>");
		for(HotelModel model:list)
		{
			out.println("<option>"+model.getName()+"</option>");
		}
		out.println("</select >");
		 out.println("<br><br><input type='submit' name='s' value='Add Hotel Info'style='width:400px; height:40px;'>");
		 out.println("</form>");
	String btn=request.getParameter("s");
	if(btn!=null)
	{
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		String location=request.getParameter("location");
		String hotelName=request.getParameter("hotelname");
		
		HotelInfoModel model=new HotelInfoModel();
		model.setEmail(email);
		model.setContact(contact);
		model.setAddress(address);
		model.setLocation(location);
		model.setName(hotelName);
		HotelService hServ=new HotelService();
		boolean b=hServ.isAddHotelInfo(model);
		if(b)
		{
			out.println("<h1>Hotel Information added succesfully</h1>");
		}
		else
		{
			out.println("<h1>Some problem is there........ </h1>");

		}
	}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
