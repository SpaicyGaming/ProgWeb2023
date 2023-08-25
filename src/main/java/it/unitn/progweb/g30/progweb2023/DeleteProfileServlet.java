package it.unitn.progweb.g30.progweb2023;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "DeleteProfileServlet", value = "/DeleteProfileServlet")
public class DeleteProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fulfillRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fulfillRequest(request, response);
    }

    protected void fulfillRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        UserDAO ud = new UserDAO((Connection) session.getAttribute("connection"));
        try {
            ud.deleteUser((User) session.getAttribute("loggedUser"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("loggedUser", null);
        response.sendRedirect(response.encodeURL("HomeServlet"));
    }
}
