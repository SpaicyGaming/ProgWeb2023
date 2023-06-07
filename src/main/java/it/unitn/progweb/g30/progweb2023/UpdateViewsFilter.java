package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebFilter(filterName = "UpdateViewsFilter")
public class UpdateViewsFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String page = ((HttpServletRequest) request).getServletPath();
        String method = ((HttpServletRequest) request).getMethod();
        if(!(page.equals("/LoginServlet") && method.equals("POST") || page.equals("/SignUpServlet") && method.equals("POST"))) {
            Connection c = (Connection) ((HttpServletRequest) request).getSession().getAttribute("connection");
            try {
                Statement stmt = c.createStatement();
                String query = String.format("SELECT * FROM VIEWSXPAGE WHERE PAGE = '%s'", page);
                ResultSet rs = stmt.executeQuery(query);
                stmt = c.createStatement();
                if (rs.next()) {
                    query = String.format("UPDATE VIEWSXPAGE SET VIEWS = VIEWS + 1 WHERE PAGE = '%s'", page);
                    stmt.execute(query);
                } else {
                    query = String.format("INSERT INTO VIEWSXPAGE VALUES(DEFAULT, '%s', 1)", page);
                    stmt.execute(query);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        chain.doFilter(request, response);
    }
}
