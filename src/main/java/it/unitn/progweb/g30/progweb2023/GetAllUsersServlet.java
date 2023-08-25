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
import java.util.Collections;
import java.util.List;

@WebServlet(name = "GetAllUsersServlet", value = "/GetAllUsersServlet")
public class GetAllUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO ud = new UserDAO((Connection) request.getSession().getAttribute("connection"));
        List<User> allUsers = Collections.emptyList();
        try {
            allUsers = ud.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonArray arr = new JsonArray();
        Gson gson = new Gson();
        for (User u : allUsers) {
            arr.add(gson.toJson(u));
        }
        PrintWriter pw = response.getWriter();
        pw.println(arr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
