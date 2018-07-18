package grupa1;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import grupa1.Entity.User;
import grupa1.persistence.DataProvider;
import grupa1.persistence.HibernateDataProvider;

import java.net.URLEncoder;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws java.io.IOException, ServletException {

        System.out.println("login filter massage");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/login";
        String errorURI = request.getContextPath() + "/error.jsp";
        String registerURI = request.getContextPath() + "/register";

        //UserModel userModel = session == null ? null : (UserModel) session.getAttribute(UserModel.KEY);
        DataProvider dataProvider = new HibernateDataProvider();
        User user = dataProvider.getUserByUsername((String)session.getAttribute("username"));
        dataProvider.commitChanges();
        boolean loggedIn = user != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean registerRequest = request.getRequestURI().equals(registerURI);
        boolean adminPageRequest = request.getRequestURI().contains("admin");

        if (!loggedIn) {
            if (loginRequest || registerRequest) {
                chain.doFilter(request, response);
            } else {
                response.sendRedirect(loginURI);
            }
        } else if (loggedIn) {
            if(loginRequest || registerRequest) {
                response.sendRedirect(request.getContextPath() + "/home");
            } else if(!user.isAdmin() && adminPageRequest) {
                response.sendRedirect(errorURI);
                String errorMessage = "you are not authorized to access this page";
                response.sendRedirect(errorURI + "?error_message=" + URLEncoder.encode(errorMessage, "UTF-8"));
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}