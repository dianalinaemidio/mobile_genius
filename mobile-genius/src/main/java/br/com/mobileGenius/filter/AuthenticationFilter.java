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
    }

    @Override
    public void destroy() {

    }

    private boolean isUserLoggedOn(HttpServletRequest request) {
        return request.getSession().getAttribute("LoggedUser") != null;
    }
}
