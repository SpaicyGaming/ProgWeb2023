package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

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
        PrintWriter pw = response.getWriter();
        //System.out.println("Sono entrato nella CookieServlet");
        try {
            if (choice != null) {
                if (request.getParameter("choice").equals("allow")) {
                    session.setAttribute("cookiesEnabled", TRUE);
                }else{
                    session.setAttribute("cookiesEnabled", FALSE);
                }
                session.setAttribute("madeChoiceAboutCookies", TRUE);
                response.sendRedirect(response.encodeURL("HomeServlet"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
