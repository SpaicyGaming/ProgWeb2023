package it.unitn.progweb.g30.progweb2023;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "GetDonationsServlet", value = "/GetDonationsServlet")
public class GetDonationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DonationDAO dd = new DonationDAO((Connection)request.getSession().getAttribute("connection"));
        ArrayList<Donation> al = null;
        try {
            al = dd.getYearsDonations();
        }catch(Exception e){
            e.printStackTrace();
        }

        JsonArray arr = new JsonArray();
        Gson gson = new Gson();
        for(Donation d : al){
            arr.add(gson.toJson(d));
        }
        PrintWriter pw = response.getWriter();
        pw.println(arr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
