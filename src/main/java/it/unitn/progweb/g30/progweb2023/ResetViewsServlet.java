package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

@WebServlet(name = "ResetViewsServlet", value = "/ResetViewsServlet")
public class ResetViewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fulfillRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fulfillRequest(request, response);
    }

    private void fulfillRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection c = (Connection)request.getSession().getAttribute("connection");
        try {
            Statement stmt = c.createStatement();
            String query = "UPDATE VIEWSXPAGE SET VIEWS = 0";
            stmt.execute(query);
        }catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("PrivateAreaServlet");

    }
}
