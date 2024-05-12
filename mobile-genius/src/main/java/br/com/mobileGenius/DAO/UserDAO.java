package br.com.mobileGenius.DAO;

import br.com.mobileGenius.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
