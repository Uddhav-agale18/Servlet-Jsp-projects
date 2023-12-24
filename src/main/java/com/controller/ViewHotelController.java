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

import com.model.HotelModel;
import com.service.HotelService;


@WebServlet("/viewhotelcontroller")
public class ViewHotelController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("navbar.html");
		r.include(request, response);
		HotelService hotelService =new HotelService();
		List<HotelModel>list=hotelService.getAllHotels();
		out.println("<table border='5' align='center' width='400px;'>");
		out.println("<tr><th>Hotel Name</th><th>Delete</th><th>Update</th></tr>");
		for(HotelModel h:list)
		{
			out.println("<tr>");
			out.println("<td>"+h.getName()+"</td>");
			out.println("<td><a href='deletecontroller?hotelId="+h.getId()+"'>Delete</a></td>");
			out.println("<td><a href='updateservlet?hotelId="+h.getId()+"&hotelName="+h.getName()+"'>Update</a></td>");
			out.println("</tr>");

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
