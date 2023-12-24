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
import com.service.HotelService;


@WebServlet("/viewhotelinfo")
public class ViewHotelInfoController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher r = request.getRequestDispatcher("navbar.html");
        r.include(request, response);
        out.println("<br><br>");
        out.println("<table border='5' align='center' width=70%>");
        out.println("<tr><th>Name</th><th>Email</th><th>Contact</th><th>Location</th><th>Delete</th><th>Update</th></tr>");
        List<HotelInfoModel> list = new HotelService().getHotelList();
        for (HotelInfoModel m : list) {
            out.println("<tr>");
            out.println("<td>" + m.getName() + "</td>");
            out.println("<td>" + m.getEmail() + "</td>");
            out.println("<td>" + m.getContact() + "</td>");
            out.println("<td>" + m.getLocation() + "</td>");
            out.println("<td><a href=''>Delete</a></td>");
            out.println("<td><a href=''>Update</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
