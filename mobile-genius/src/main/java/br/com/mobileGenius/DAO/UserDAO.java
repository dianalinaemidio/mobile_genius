package br.com.mobileGenius.DAO;

import br.com.mobileGenius.model.Celular;
import br.com.mobileGenius.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAO {

    // Verificando as credenciais do usuario
    public User verifyCredentials(User user) {
        String SQL = "SELECT * FROM USERS WHERE USERNAME = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso ao entrar no banco de dados");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Sucesso ao selecionar o username");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                boolean type = resultSet.getBoolean("type");

                if (password.equals(user.getPassword()) && username.equals(user.getUsername())) {

                    return new User(type, true);

                }
            }

            connection.close();
            return new User(false, false);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return new User(false, false);
        }

    }

    // Salvando o usuario no banco de dados
    public void createUser(User user) {
        String SQL = "INSERT INTO USERS (username, password, type) VALUES (?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso ao entrar no banco de dados");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            // Não inserir o campo "id" aqui, pois é autoincrementado

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, user.getType());

            preparedStatement.executeUpdate();
            System.out.println("Sucesso ao criar no banco");

            connection.close();

        } catch (Exception e) {
            System.out.println("Erro ao entrar no banco de dados (Create)");
            e.printStackTrace();
        }
    }

    // Listar usuarios
    public List<User> findUser() {
        String SQL = "SELECT * FROM USERS";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("SUCESSO AO ACESSAR O BANCO DE DADOS (select)");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                boolean type = resultSet.getBoolean("type");

                User user = new User(id, username, password, type);
                users.add(user);
            }

            System.out.println("SUCESSO AO SELECIONAR OS CELULARES");
            connection.close();

            return users;

        } catch (Exception e) {
            System.out.println("FALHA AO CONECTAR AO BANCO (Select)");
            e.printStackTrace();

            System.out.println("Error: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    // Deletando os usuarios do banco de dados
    public void deleteUserId(String userId) {
        String SQL = "DELETE FROM USERS WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, userId);
            preparedStatement.executeUpdate();

            System.out.println("success on delete celular with id: " + userId);
            connection.close();

        } catch (Exception e) {
            System.out.println("fail in database connection");
            e.printStackTrace();
        }
    }

    // Atualizando as informações do usuario no banco de dados
    public void updateUser(User user) {
        String SQL = "UPDATE USERS SET username = ?, password = ?, type = ? WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso ao conectar no banco de dados e fazer o update");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, user.getType());
            preparedStatement.setString(4, user.getId());

            preparedStatement.executeUpdate();
            System.out.println("Sucesso em atualizar o usuario");

            connection.close();

        } catch (Exception e) {
            System.out.println("Falha na conexão do banco de dados");
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }
}
