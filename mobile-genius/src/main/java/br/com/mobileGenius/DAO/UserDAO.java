package br.com.mobileGenius.DAO;

import br.com.mobileGenius.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public User verifyCredentials(User user) {
        String SQL = "SELECT * FROM USERS WHERE USERNAME = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso ao entrar no banco de dados");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1,user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Sucesso ao selecionar o username");

            while (resultSet.next()) {
                String password = resultSet.getString("password");
                boolean type = resultSet.getBoolean("type");

                if (password.equals(user.getPassword())) {

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
}
