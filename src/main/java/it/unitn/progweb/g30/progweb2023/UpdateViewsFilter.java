package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@WebFilter(filterName = "UpdateViewsFilter")
public class UpdateViewsFilter implements Filter {

    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String page = ((HttpServletRequest) request).getServletPath();
        String method = ((HttpServletRequest) request).getMethod();
        if (!(page.equals("/LoginServlet") && method.equals("POST") || page.equals("/SignUpServlet") && method.equals("POST"))) {
            Connection connection = (Connection) ((HttpServletRequest) request).getSession().getAttribute("connection");
            try {
                try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM VIEWSXPAGE WHERE PAGE = ?")) {
                    stmt.setString(1, page);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        try (PreparedStatement stmt2 = connection.prepareStatement("UPDATE VIEWSXPAGE SET VIEWS = VIEWS + 1 WHERE PAGE = ?")) {
                            stmt2.setString(1, page);
                            stmt2.executeUpdate();
                        }
                    } else {
                        try (PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO VIEWSXPAGE VALUES(DEFAULT, ?, 1)")) {
                            stmt2.setString(1, page);
                            stmt2.executeUpdate();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        chain.doFilter(request, response);
    }

}
