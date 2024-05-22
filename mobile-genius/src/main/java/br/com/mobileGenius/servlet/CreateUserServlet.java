package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.CarrinhoDAO;
import br.com.mobileGenius.DAO.UserDAO;
import br.com.mobileGenius.model.Carrinho;
import br.com.mobileGenius.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String dataNascimentoString = request.getParameter("datanascimento");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String numeroCelular = request.getParameter("numerocelular");
        String username = request.getParameter("username");

        UserDAO usuarioDao = new UserDAO();
        CarrinhoDAO carrinhoDao = new CarrinhoDAO();
        boolean atualizar = !id.isBlank();

        if (usuarioDao.cpfExiste(cpf) && (!atualizar || !usuarioDao.encontrarUsuarioPorId(id).getCpf().equals(cpf))) {
            request.setAttribute("message", "CPF já cadastrado. Tente outro.");
            request.getRequestDispatcher("/cadastrarUser.jsp").forward(request, response);
            return;
        }

        if (usuarioDao.usernameExiste(username) && (!atualizar || !usuarioDao.encontrarUsuarioPorId(id).getUsername().equals(username))) {
            request.setAttribute("message", "Nome de usuário já existe. Escolha outro.");
            request.getRequestDispatcher("/cadastrarUser.jsp").forward(request, response);
            return;
        }


        // Validação do CPF
        if (!cpfValido(cpf)) {
            request.setAttribute("message", "CPF inválido. O formato correto é 123.456.789-01.");
            request.getRequestDispatcher("/cadastrarUser.jsp").forward(request, response);
            return;
        }

        if (!dataValida(dataNascimentoString)) {
            request.setAttribute("message", "Data inválida, o formato correto é 20-12-2004");
        }

        if (!emailValido(email)) {
            request.setAttribute("message", "E-mail inválido. O formato correto é exemplo@dominio.com.");
        }

        if (!numeroValido(numeroCelular)) {
            request.setAttribute("message", "Número de celular inválido. O formato correto é 1234567890");
        }

        if (dataValida(dataNascimentoString) && emailValido(email) && numeroValido(numeroCelular)) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date dataUtil = null;

            try {
                dataUtil = sdf.parse(dataNascimentoString);

                User usuario = new User(id, username, senha, false, nome, sobrenome, cpf, new java.sql.Date(dataUtil.getTime()), endereco, email, numeroCelular);

                if (id.isBlank()) {
                     usuarioDao.createUser(usuario);
                     User u = usuarioDao.encontrarUsuarioPorUsername(username);
                     Carrinho carrinho = new Carrinho(u.getId());
                     carrinhoDao.createCarrinho(carrinho);


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
            return;
        }
    }

    private boolean cpfValido(String cpf) {
        return cpf != null && Pattern.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", cpf);
    }

    private boolean emailValido(String email) {
        return email != null && Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", email);
    }

    private boolean numeroValido(String numeroCelular) {

        if (numeroCelular != null && numeroCelular.matches("\\d+")) {

            String numeroLimpo = numeroCelular.replaceAll("\\D", "");

            return numeroLimpo.length() >= 10 && numeroLimpo.length() <= 15;
        }
        return false;
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
