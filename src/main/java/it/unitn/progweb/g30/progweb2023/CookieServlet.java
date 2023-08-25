package it.unitn.progweb.g30.progweb2023;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@WebServlet(name = "CookieServlet", value = "/CookieServlet")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String choice = request.getParameter("choice");
        //System.out.println("Sono entrato nella CookieServlet");
        try {
            if (choice != null) {
                if (request.getParameter("choice").equals("allow")) {
                    session.setAttribute("cookiesEnabled", TRUE);
                } else {
                    session.setAttribute("cookiesEnabled", FALSE);
                }
                session.setAttribute("madeChoiceAboutCookies", TRUE);
                response.sendRedirect(response.encodeURL("HomeServlet"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
