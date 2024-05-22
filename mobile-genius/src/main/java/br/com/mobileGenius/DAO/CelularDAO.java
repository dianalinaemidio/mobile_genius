package br.com.mobileGenius.DAO;

import br.com.mobileGenius.model.Celular;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CelularDAO {

    // Gravar o celular no banco de dados
    public void createCelular(Celular celular) {
        String SQL = "INSERT INTO CELULAR (modelo, marca, preco, quantidade, descricao, image) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso ao entrar no banco de dados");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            // Não inserir o campo "id" aqui, pois é autoincrementado

            preparedStatement.setString(1, celular.getModelo());
            preparedStatement.setString(2, celular.getMarca());
            preparedStatement.setDouble(3, celular.getPreco());
            preparedStatement.setInt(4, celular.getQuantidade());
            preparedStatement.setString(5, celular.getDescricao());
            preparedStatement.setString(6, celular.getImage());

            preparedStatement.executeUpdate();
            System.out.println("Sucesso ao criar no banco");

            connection.close();

        } catch (Exception e) {
            System.out.println("Erro ao entrar no banco de dados (Create)");
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Listar todos os celulares do banco de dados
    public List<Celular> findCelular() {
        String SQL = "SELECT * FROM CELULAR";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("SUCESSO AO ACESSAR O BANCO DE DADOS (select)");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Celular> celulares = new ArrayList<>();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                double preco = resultSet.getDouble("preco");
                int quantidade = resultSet.getInt("quantidade");
                String descricao = resultSet.getString("descricao");
                String image = resultSet.getString("image");

                Celular celular = new Celular(id, marca, modelo, preco, quantidade, descricao, image);
                celulares.add(celular);
            }

            System.out.println("SUCESSO AO SELECIONAR OS CELULARES");
            connection.close();

            return celulares;

        } catch (Exception e) {
            System.out.println("FALHA AO CONECTAR AO BANCO (Select)");
            e.printStackTrace();

            System.out.println("Error: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    // Deletando os celulares do banco de dados
    public void deleteCelularId(String celularId) {
        String SQL = "DELETE FROM CELULAR WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, celularId);
            preparedStatement.executeUpdate();

            System.out.println("success on delete celular with id: " + celularId);
            connection.close();

        } catch (Exception e) {
            System.out.println("fail in database connection");
            e.printStackTrace();
        }
    }

    // Atualizando as informações do celular no banco de dados
    public void updateCelular(Celular celular) {
        String SQL = "UPDATE CELULAR SET marca = ?, modelo = ?, preco = ?, quantidade = ?, descricao = ?, image = ? WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso ao conectar no banco de dados e fazer o update");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, celular.getModelo());
            preparedStatement.setString(2, celular.getMarca());
            preparedStatement.setDouble(3, celular.getPreco());
            preparedStatement.setInt(4, celular.getQuantidade());
            preparedStatement.setString(5, celular.getDescricao());
            preparedStatement.setString(6, celular.getImage());
            preparedStatement.setString(7, celular.getId());

            preparedStatement.executeUpdate();
            System.out.println("Sucesso em atualizar o celular");

            connection.close();

        } catch (Exception e) {
            System.out.println("Falha na conexão do banco de dados");
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Celular findCelularById(String celularId) {
        String SQL = "SELECT * FROM CELULAR WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso ao conectar no banco de dados");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, celularId);
            ResultSet resultSet = preparedStatement.executeQuery();

            Celular celular = null;

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                double preco = resultSet.getDouble("preco");
                int quantidade = resultSet.getInt("quantidade");
                String descricao = resultSet.getString("descricao");
                String image = resultSet.getString("image");

                celular = new Celular(id, marca, modelo, preco, quantidade, descricao, image);
            }

            System.out.println("Sucesso ao encontrar o celular pelo ID");
            connection.close();

            return celular;

        } catch (Exception e) {
            System.out.println("Falha na conexão do banco de dados (findCelularById)");
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
