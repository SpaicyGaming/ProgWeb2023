package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@WebFilter(filterName = "CreateConnectionFilter")
public class CreateConnectionFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)request).getSession();
        if(session.isNew()){
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/Tum4WorldDB");
                //Connection c = DriverManager.getConnection("jdbc:derby:Tum4WorldDB;create=true");
                session.setAttribute("connection", c);
            }catch(Exception e){
                e.printStackTrace();
            }
            session.setMaxInactiveInterval(3600);
            session.setAttribute("isSessionNew", TRUE);
            /*
            session.setAttribute("cookiesEnabled", FALSE);
            session.setAttribute("madeChoiceAboutCookies", FALSE);
            */

        }else{
            if(((Boolean)(session.getAttribute("isSessionNew"))).booleanValue()){
                session.setAttribute("isSessionNew", FALSE);
            }
        }

        /*
        if(session.getAttribute("cookiesEnabled") == FALSE){
            Cookie cookies[] = ((HttpServletRequest)request).getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    c.setValue("");
                    //c.setPath("/");
                    c.setMaxAge(0);
                    ((HttpServletResponse)response).addCookie(c);
                }
            }
        }
        */

        //((HttpServletResponse)response).encodeURL(((HttpServletRequest) request).getRequestURI());
        chain.doFilter(request, response);
    }
}
