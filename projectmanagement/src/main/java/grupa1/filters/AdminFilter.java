package grupa1.filters;

import grupa1.Entity.User;
import grupa1.persistence.DataProvider;
import grupa1.persistence.HibernateDataProvider;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;

@WebFilter(
        urlPatterns = "/admin/*",
        filterName = "AdminFilter",
        description = "Filter all admin URLs"
)
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String username = (String) request.getSession().getAttribute("username");
        if (username == null) {
            response.sendRedirect("/index.jsp");
            return;
        }
        DataProvider dataProvider = new HibernateDataProvider();
        User user = dataProvider.getUserByUsername(username);
        if (user == null) {
            response.sendRedirect("/index.jsp");
            return;
        }
        if (!user.isAdmin()) {
            response.sendRedirect("/user/index.jsp");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
    // implements Filter's methods here...
}
