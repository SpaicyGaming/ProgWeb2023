package it.unitn.progweb.g30.progweb2023;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

    private void fulfillRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection connection = (Connection) request.getSession().getAttribute("connection");
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE VIEWSXPAGE SET VIEWS = 0")) {
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect(response.encodeURL("PrivateAreaServlet"));
    }

}
