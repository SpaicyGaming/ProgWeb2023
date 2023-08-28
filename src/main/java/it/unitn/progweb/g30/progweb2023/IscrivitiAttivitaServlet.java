package it.unitn.progweb.g30.progweb2023;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "IscrivitiAttivitaServlet", value = "/IscrivitiAttivitaServlet")
public class IscrivitiAttivitaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("attivita");
        User loggedUser = (User) request.getSession().getAttribute("loggedUser");
        UserDAO ud = new UserDAO((Connection) request.getSession().getAttribute("connection"));
        Connection connection = (Connection) request.getSession().getAttribute("connection");

        try (PreparedStatement selectAttivitaStmt = connection.prepareStatement("SELECT * FROM ATTIVITA WHERE NOME_ATTIVITA = ?")) {
            selectAttivitaStmt.setString(1, act);
            ResultSet rs = selectAttivitaStmt.executeQuery();
            boolean activityExist = rs.next();

            if (!activityExist) {
                try (PreparedStatement insertAttivitaStmt = connection.prepareStatement("INSERT INTO ATTIVITA VALUES(DEFAULT, ?)")) {
                    insertAttivitaStmt.setString(1, act);
                    insertAttivitaStmt.executeUpdate();
                }

                rs = selectAttivitaStmt.executeQuery();
                rs.next();
            }

            if (!ud.isUserSubscribedToActivity(loggedUser, act)) {
                try (PreparedStatement insertUserXAttivitaStmt = connection.prepareStatement("INSERT INTO USERSXATTIVITA VALUES(DEFAULT, ?, ?)")) {
                    insertUserXAttivitaStmt.setInt(1, loggedUser.getId());
                    insertUserXAttivitaStmt.setInt(2, rs.getInt(1));
                    insertUserXAttivitaStmt.executeUpdate();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect(response.encodeURL("PrivateAreaServlet"));
    }

}
