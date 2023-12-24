package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateservlet")
public class UpdateServletController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("navbar.html");
		r.include(request, response); 
		int hid=Integer.parseInt(request.getParameter("hotelId"));
		String name=request.getParameter("hotelName");
		out.println("<center>");
		out.println("<form name='frm' action='finalUpdate' method='POST'>");
		out.println("<input type='hidden' name='id' value='"+hid+"' style='width:400px;height:40px;'><br><br>");
		out.println("<input type='text' name='name' value='"+name+"' style='width:400px;height:40px;'><br><br>");
		out.println("<input type='submit' name='s' value='Update Hotel' style='width:400px;height:40px;'><br><br>");
		out.println("</form>");
		out.println("</center>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
