package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "IscrivitiAttivitaServlet", value = "/IscrivitiAttivitaServlet")
public class IscrivitiAttivitaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("attivita");
        User loggedUser = (User)request.getSession().getAttribute("loggedUser");
        UserDAO ud = new UserDAO((Connection)request.getSession().getAttribute("connection"));
        try{
            Connection conn = (Connection)request.getSession().getAttribute("connection");
            Statement stmt = conn.createStatement();
            String query = String.format("SELECT * FROM ATTIVITA WHERE NOME_ATTIVITA = '%s'", act);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next() && !ud.isUserSubscribedToActivity(loggedUser, act)) {
                int actId = rs.getInt(1);
                stmt = conn.createStatement();
                query = String.format("INSERT INTO USERSXATTIVITA VALUES(DEFAULT, %d, %d)", loggedUser.getId(), actId);
                stmt.execute(query);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("PrivateAreaServlet");
    }
}
