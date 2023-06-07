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

@WebServlet(name = "GetAllSimpatizzantiServlet", value = "/GetAllSimpatizzantiServlet")
public class GetAllSimpatizzantiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO ud = new UserDAO((Connection)request.getSession().getAttribute("connection"));
        ArrayList<User> al = null;
        try {
            al = ud.getAllSimpatizzanti();
        }catch(Exception e){
            e.printStackTrace();
        }

        JsonArray arr = new JsonArray();
        Gson gson = new Gson();
        for(User u : al){
            arr.add(gson.toJson(u));
        }
        PrintWriter pw = response.getWriter();
        pw.println(arr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
