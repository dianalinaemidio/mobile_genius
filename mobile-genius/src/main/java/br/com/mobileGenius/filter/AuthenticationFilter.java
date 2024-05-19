package br.com.mobileGenius.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
<<<<<<< HEAD
=======
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a
import java.io.IOException;

@WebFilter("/admin/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
<<<<<<< HEAD
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if (isUserLoggedOn(httpServletRequest)) {
            chain.doFilter(servletRequest, response);
        } else {
            servletRequest.setAttribute("message", "Usuário não autorizado");
            servletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, response);
        }

=======
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Obtém a sessão atual, se existir
        HttpSession session = request.getSession(false);

        // Verifica se há um usuário logado na sessão
        boolean isLoggedIn = (session != null && session.getAttribute("LoggedUser") != null);

        // Verifica se a requisição é para uma área protegida
        boolean isTryingToAccessAdminArea = request.getRequestURI().startsWith(request.getContextPath() + "/admin/");

        if (isLoggedIn || !isTryingToAccessAdminArea) {
            // Se o usuário estiver logado ou não estiver tentando acessar a área de administração, continua a cadeia de filtros
            filterChain.doFilter(request, response);
        } else {
            // Se o usuário não estiver logado e estiver tentando acessar a área de administração, redireciona para a página de login
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a
    }

    @Override
    public void destroy() {

    }

    private boolean isUserLoggedOn(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getSession().getAttribute("LoggedUser") != null;
    }
}
