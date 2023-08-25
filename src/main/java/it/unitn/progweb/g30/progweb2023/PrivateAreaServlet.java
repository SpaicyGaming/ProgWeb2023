package it.unitn.progweb.g30.progweb2023;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PrivateAreaServlet", value = "/PrivateAreaServlet")
public class PrivateAreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fulfillRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fulfillRequest(request, response);
    }

    protected void fulfillRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("loggedUser");
        switch (u.getStringifiedType()) {
            case "aderente":
                getServletContext().getRequestDispatcher("/aderentePrivate.jsp").forward(request, response);
                break;
            case "simpatizzante":
                getServletContext().getRequestDispatcher("/simpatizzantePrivate.jsp").forward(request, response);
                break;
            case "admin":
                getServletContext().getRequestDispatcher("/adminPrivate.jsp").forward(request, response);
                break;
        }
    }

}
