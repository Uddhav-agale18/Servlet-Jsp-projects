package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.HotelModel;
import com.service.HotelService;


@WebServlet("/finalUpdate")
public class FinalUpdateController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int hotelId=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		HotelModel model=new HotelModel();
		model.setId(hotelId);
		model.setName(name);
		boolean b=new HotelService().isHotelUpdate(model);
		if(b)
		{
			RequestDispatcher r=request.getRequestDispatcher("viewhotelcontroller");
			r.forward(request, response); 
		}
		else {
			out.println("some problem here...");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
