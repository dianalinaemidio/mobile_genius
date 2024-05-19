package br.com.mobileGenius.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.text.SimpleDateFormat;

import br.com.mobileGenius.DAO.UserDAO;
import br.com.mobileGenius.model.User;

@WebServlet("/area-cliente")
public class AreaClienteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.encontrarUsuarioPorUsername(username);

        if (user != null) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String dataNascimentoFormatada = sdf.format(user.getDataNascimento());
            request.setAttribute("dataNascimentoFormatada", dataNascimentoFormatada);


            request.setAttribute("user", user);
            request.getRequestDispatcher("areaCliente.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Erro ao tentar encontrar usuario");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}