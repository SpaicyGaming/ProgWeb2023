package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

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
                Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/Tum4WorldDB");
                session.setAttribute("connection", c);
            }catch(Exception e){
                System.err.println(e);
            }
        }
        ((HttpServletResponse)response).encodeURL(((HttpServletRequest) request).getRequestURI());
        chain.doFilter(request, response);
    }
}
