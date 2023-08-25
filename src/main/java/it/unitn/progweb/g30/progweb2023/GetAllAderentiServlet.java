package it.unitn.progweb.g30.progweb2023;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet(name = "GetAllAderentiServlet", value = "/GetAllAderentiServlet")
public class GetAllAderentiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO ud = new UserDAO((Connection) request.getSession().getAttribute("connection"));
        ArrayList<User> al = null;
        try {
            al = ud.getAllAderenti();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonArray arr = new JsonArray();
        Gson gson = new Gson();
        for (User u : al) {
            arr.add(gson.toJson(u));
        }
        PrintWriter pw = response.getWriter();
        pw.println(arr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
