
package br.com.mobileGenius.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.mobileGenius.model.Celular;
import br.com.mobileGenius.DAO.CelularDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;

@WebServlet("/create-celular")

public class CreateCelularServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> parameters = uploadImage(request);

        // Pegando as informações da requisicao do metodo post
        String id = parameters.get("id");
        String marca = parameters.get("marca");
        String modelo = parameters.get("modelo");
        double preco = Double.parseDouble(parameters.get("preco"));
        int quantidade = Integer.parseInt(parameters.get("quantidade"));
        String descricao = parameters.get("descricao");
        String image = parameters.get("image");



        // Inicializando a Classe Celular e setando os valores

        Celular celular = new Celular(id, marca, modelo, preco, quantidade, descricao, image);

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

    private Map<String, String> uploadImage(HttpServletRequest httpServletRequest) {

        Map<String, String> requestParameters = new HashMap<>();

        if (isMultipartContent(httpServletRequest)) {

            try {

                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

                List<FileItem> fileItems = new ServletFileUpload(diskFileItemFactory).parseRequest(httpServletRequest);

                for (FileItem fileItem : fileItems) {

                    checkFieldType(fileItem, requestParameters);

                }

            } catch (Exception ex) {

                requestParameters.put("image", "img/iphone1.jpeg");

            }

        }

        return requestParameters;

    }

    private void checkFieldType(FileItem item, Map requestParameters) throws Exception {

        if (item.isFormField()) {

            requestParameters.put(item.getFieldName(), item.getString());

        } else {

            String fileName = processUploadedFile(item);
            requestParameters.put("image", "img/".concat(fileName));

        }

    }


    private String processUploadedFile(FileItem fileItem) throws Exception {
        Long currentTime = new Date().getTime();
        String fileName = currentTime.toString().concat("-").concat(fileItem.getName().replace(" ", ""));
        String filePath = this.getServletContext().getRealPath("img").concat(File.separator).concat(fileName);
        fileItem.write(new File(filePath));
        return fileName;
    }
}
