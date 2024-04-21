
package br.com.mobileGenius.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.mobileGenius.Model.Celular;
import br.com.mobileGenius.DAO.CelularDAO;

@WebServlet("/create-celular")

public class CreateCelularServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Pegando as informações da requisicao do metodo post
        String id = request.getParameter("id");
        String marca = request.getParameter("marca");


        // Inicializando a Classe Celular e setando os valores
        Celular celular = new Celular(marca, id);

        // Inicializando a Classe DAO para gravar no banco
        CelularDAO celularDao = new CelularDAO();

        /* Validando se o valor da variavel cId e vazio
         * Se o valor da variavel Id não for um valor vazio (contem um ID) significa que se trata de uma requisiçao de atualizaçao.
         */
        if (id.isBlank()) {
            celularDao.createCelular(celular);

        } else { //

            celularDao.updateCelular(celular);

        }


        System.out.println("celular gravado no banco");

        response.sendRedirect("/encontre-todos-celulares");

    }
}
