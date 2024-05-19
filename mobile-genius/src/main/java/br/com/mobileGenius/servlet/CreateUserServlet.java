package br.com.mobileGenius.servlet;

<<<<<<< HEAD
import br.com.mobileGenius.DAO.UserDAO;
import br.com.mobileGenius.model.User;
=======
import br.com.mobileGenius.DAO.UsuarioDAO;
import br.com.mobileGenius.model.Usuario;

>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
<<<<<<< HEAD
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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


        if (usuarioDao.usernameExiste(username)) {
            request.setAttribute("error", "Nome de usuário já existe. Escolha outro.");
            request.getRequestDispatcher("/cadastrarUser.jsp").forward(request, response);
            return;
        }

        if (!dataValida(dataNascimentoString)) {
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

        if (dataValida(dataNascimentoString) && cpfValido(cpf) && emailValido(email) && numeroValido(numeroCelular)) {

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date dataUtil = null;

            try {
                dataUtil = sdf.parse(dataNascimentoString);

                User usuario = new User(id, username, senha, false, nome, sobrenome, cpf, new java.sql.Date(dataUtil.getTime()), endereco, email, numeroCelular);

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
        } else{
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

=======
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Para onde o formulario html faz a requisicao

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

                // Convertendo a String diretamente para java.sql.Date
                java.sql.Date dataNascimentoDate = java.sql.Date.valueOf(dataNascimentoString);

                Usuario usuario = new Usuario(id, nome, sobrenome, cpf, senha, dataNascimentoDate, endereco, email, numeroCelular, false);
                UsuarioDAO usuarioDao = new UsuarioDAO();

                if (id.isBlank()) {
                    usuarioDao.criarUsuario(usuario);
                    response.sendRedirect("/index.jsp");
                } else {
                    usuarioDao.atualizarUsuario(usuario);
                    response.sendRedirect("/find-all-user");
                }

                // Validação de formato para CPF
                if (!cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")) {
                    throw new IllegalArgumentException("Formato inválido para o CPF.");
                }

                // Validação de formato para o email (se necessário)
                // Aqui você pode usar uma expressão regular para verificar o formato do email
                if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                    throw new IllegalArgumentException("Formato inválido para o email.");
                }

                // Validação de formato para o número de celular (se necessário)
                if (!numeroCelular.matches("\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}")) {
                    throw new IllegalArgumentException("Formato inválido para o número de celular.");
                }

            }
    }
>>>>>>> 018eaef7f96b23aae0b486a02260a10e83b0b17a
