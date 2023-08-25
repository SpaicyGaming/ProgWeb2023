package it.unitn.progweb.g30.progweb2023;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO ud = new UserDAO((Connection) request.getSession().getAttribute("connection"));
        User u = ud.getUserByUsername(username);
        if (u == null || !u.getPassword().equals(password)) {
            ErrorMessageBean em = new ErrorMessageBean();
            em.setMessage("Username o password errati");
            request.setAttribute("errorMessage", em);
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", u);
            //System.out.println(((User)session.getAttribute("loggedUser")).getUsername());
            response.sendRedirect(response.encodeURL("PrivateAreaServlet"));
        }
    }
}
