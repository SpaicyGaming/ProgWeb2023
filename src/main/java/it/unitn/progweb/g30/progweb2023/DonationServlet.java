package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

@WebServlet(name = "DonationServlet", value = "/DonationServlet")
public class DonationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int importo = Integer.parseInt(request.getParameter("importo"));
        Date today = new Date(System.currentTimeMillis());
        Donation d = new Donation();
        d.setImporto(importo);
        d.setData(today.toString());
        DonationDAO dd = new DonationDAO((Connection)request.getSession().getAttribute("connection"));
        try {
            dd.saveDonation(d);
        }catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("PrivateAreaServlet");
    }
}
