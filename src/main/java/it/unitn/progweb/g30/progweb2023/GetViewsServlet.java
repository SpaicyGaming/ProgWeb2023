package it.unitn.progweb.g30.progweb2023;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "GetViewsServlet", value = "/GetViewsServlet")
public class GetViewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection c = (Connection)request.getSession().getAttribute("connection");
        ArrayList<Views> al = new ArrayList<>();
        try {
            Statement stmt = c.createStatement();
            String query = "SELECT * FROM VIEWSXPAGE";
            ResultSet rs = stmt.executeQuery(query);
            JsonArray arr = new JsonArray();
            Gson gson = new Gson();
            while(rs.next()){
                Views v = new Views();
                v.setId(rs.getInt(1));
                v.setPage(rs.getString(2));
                v.setViews(rs.getInt(3));
                arr.add(gson.toJson(v));
            }
            PrintWriter pw = response.getWriter();
            pw.println(arr);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
