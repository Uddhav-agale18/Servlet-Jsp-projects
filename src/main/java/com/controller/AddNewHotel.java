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

@WebServlet("/addnewhotel")
public class AddNewHotel extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");

        out.println("</head>");
        out.println("<body>");
        RequestDispatcher r = request.getRequestDispatcher("navbar.html");
        r.include(request, response);

        out.println("<form name='frm' action='' method='POST'>");
        out.println("<center>");
        out.println("<input type='text' name='hotelname' value='' placeholder='Hotel Name' style='width:400px;height:40px;'><br><br>");
        out.println("<input type='submit' name='s' value='Add New Hotel' style='width:400px;height:40px;color:black;'><br><br>");
        out.println("</center>");
        out.println("</form>");

        String btn = request.getParameter("s");

        if (btn != null) {
            String hotelName = request.getParameter("hotelname");

            HotelModel model = new HotelModel();
            model.setName(hotelName);

            HotelService hServ = new HotelService();
            boolean b = hServ.isAddHotel(model);

            out.println("<center>");
            if (b) {
                out.println("<h1>New Hotel added successfully</h1>");
            } else {
                out.println("<h1>Some problem is there........ </h1>");
            }
            out.println("</center>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
