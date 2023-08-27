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

@WebServlet(name = "GetAllAderentiServlet", value = "/GetAllAderentiServlet")
public class GetAllAderentiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO ud = new UserDAO((Connection) request.getSession().getAttribute("connection"));
        List<User> aderenti = Collections.emptyList();
        try {
            aderenti = ud.getAllAderenti();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonArray arr = new JsonArray();
        Gson gson = new Gson();
        for (User u : aderenti) {
            arr.add(gson.toJson(u));
        }
        PrintWriter pw = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        pw.print(arr);
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
