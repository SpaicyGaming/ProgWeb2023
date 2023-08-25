package it.unitn.progweb.g30.progweb2023;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "PrivateAreaAccessFilter")
public class PrivateAreaAccessFilter implements Filter {

    public void init(FilterConfig config) {
    }

    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (((HttpServletRequest) request).getSession().getAttribute("loggedUser") != null) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect(((HttpServletResponse) response).encodeURL("LoginServlet"));
        }
    }

}
