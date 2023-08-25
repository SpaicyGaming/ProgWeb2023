package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@WebFilter(filterName = "CreateConnectionFilter")
public class CreateConnectionFilter implements Filter {
    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        if (session.isNew()) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/Tum4WorldDB");
                session.setAttribute("connection", c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setMaxInactiveInterval(3600);
            session.setAttribute("isSessionNew", TRUE);
        } else {
            if ((Boolean) (session.getAttribute("isSessionNew"))) {
                session.setAttribute("isSessionNew", FALSE);
            }
        }

        chain.doFilter(request, response);
    }
}
