package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
    protected void fulfillRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDAO ud = new UserDAO((Connection)session.getAttribute("connection"));
        try{
            ud.deleteUser((User)session.getAttribute("loggedUser"));
        }catch(Exception e){
            e.printStackTrace();
        }
        request.getSession().setAttribute("loggedUser", null);
        response.sendRedirect("HomeServlet");
    }
}
