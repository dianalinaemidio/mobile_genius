package br.com.mobileGenius.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponseResponse = (HttpServletResponse) response;

        if (isUserLoggedOn(httpServletRequest)) {
            chain.doFilter(servletRequest, response);
        } else {
            servletRequest.setAttribute("message", "Usuário não autorizado");
            servletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, response);
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isUserLoggedOn(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession(false);
        return session != null && session.getAttribute("LoggedUser") != null;
    }
}
