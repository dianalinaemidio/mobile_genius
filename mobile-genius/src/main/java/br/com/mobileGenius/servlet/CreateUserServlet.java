package br.com.mobileGenius.servlet;


import br.com.mobileGenius.DAO.UserDAO;
import br.com.mobileGenius.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        String dataNascimento = request.getParameter("dataNascimento");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String numeroCelular = request.getParameter("numeroCelular");
        String password = request.getParameter("password");

        User user = new User(id, username, sobrenome, cpf, dataNascimento, endereco, email, numeroCelular, password, false, false);
        UserDAO usuarioDao = new UserDAO();

        // Convertendo a String diretamente para java.sql.Date
        java.sql.Date dataNascimentoDate = java.sql.Date.valueOf(dataNascimento);


        if (usuarioDao.usernameExiste(username)) {
            request.setAttribute("error", "Nome de usuário já existe. Escolha outro.");
            request.getRequestDispatcher("/cadastrarUser.jsp").forward(request, response);
            return;
        }

        if (!dataValida(dataNascimento)) {
            request.setAttribute("dataNascimentoError", "Data inválida , o formato correto é 20-12-2004");
        }

        if (!cpfValido(cpf)) {
            request.setAttribute("cpfError", "CPF inválido. O formato correto é 123.456.789-01.");
        }

        if (usuarioDao.cpfExiste(cpf)) {
            request.setAttribute("error", "CPF já cadastrado. Tente outro.");
            request.getRequestDispatcher("/cadastrarUser.jsp").forward(request, response);
            return;
        }


        if (!emailValido(email)) {
            request.setAttribute("emailError", "E-mail inválido. O formato correto é exemplo@dominio.com.");
        }

        if (!numeroValido(numeroCelular)) {
            request.setAttribute("celularError", "Número de celular inválido. O formato correto é 1234567890");
        }

        if (dataValida(dataNascimento) && cpfValido(cpf) && emailValido(email) && numeroValido(numeroCelular)) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date dataUtil = null;

            try {
                dataUtil = sdf.parse(dataNascimento);

                User usuario = new User(id, username, sobrenome, cpf, dataNascimento, endereco, email, numeroCelular, password,  false, false);


                if (id.isBlank()) {
                    usuarioDao.createUser(usuario);
                    response.sendRedirect("/index.jsp");
                } else {
                    usuarioDao.updateUser(usuario);
                    if (usuario.isAdmin()) {
                        response.sendRedirect("/find-all-user");
                    } else {
                        response.sendRedirect("/area-cliente?username=" + usuario.getUsername());
                    }
                }

            } catch (ParseException e) {
                return;
            }
        } else {
            request.getRequestDispatcher("/cadastrarUser.jsp").forward(request, response);
        }

    }

    private boolean cpfValido(String cpf) {
        return cpf != null && Pattern.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", cpf);
    }

    private boolean emailValido(String email) {
        return email != null && Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", email);
    }

    private boolean numeroValido(String numeroCelular) {
        return numeroCelular != null && Pattern.matches("\\d{10,11}", numeroCelular);
    }

    private boolean dataValida(String data) {
        if (data == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);

        try {
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}