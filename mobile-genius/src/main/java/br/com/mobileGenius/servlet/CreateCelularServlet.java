
package br.com.mobileGenius.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.mobileGenius.model.Celular;
import br.com.mobileGenius.DAO.CelularDAO;

@WebServlet("/create-celular")

public class CreateCelularServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Pegando as informações da requisicao do metodo post

        String id = request.getParameter("id");
        String marca = request.getParameter("marca");
        String descricao = request.getParameter("descricao");
        String modelo = request.getParameter("modelo");
        double preco = Double.parseDouble(request.getParameter("preco"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));



        // Inicializando a Classe Celular e setando os valores

        Celular celular = new Celular(marca, id, preco,quantidade, descricao, modelo);

        // Inicializando a Classe DAO para gravar no banco

        CelularDAO celularDao = new CelularDAO();

        /* Validando se o valor da variavel Id e vazio
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
