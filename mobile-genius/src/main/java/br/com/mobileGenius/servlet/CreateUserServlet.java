package br.com.mobileGenius.servlet;

import br.com.mobileGenius.DAO.UsuarioDAO;
import br.com.mobileGenius.model.Usuario;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
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
            }
    }

