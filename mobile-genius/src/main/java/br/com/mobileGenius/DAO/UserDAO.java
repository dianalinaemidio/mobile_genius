package br.com.mobileGenius.DAO;

import br.com.mobileGenius.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UserDAO {

    // Verificando as credenciais do usuario
    public User verifyCredentials(User user) {
        String SQL = "SELECT * FROM USER WHERE USERNAME = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso ao entrar no banco de dados (login)");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Sucesso ao selecionar o username");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                boolean admin = resultSet.getBoolean("admin");

                if (password.equals(user.getPassword()) && username.equals(user.getUsername())) {
                    return new User(username, password);
                }
            }

            connection.close();
            return null; // Retorna null se não encontrar o usuário
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    // Salvando o usuario no banco de dados
    public void createUser(User user) {
        String SQL = "INSERT INTO USER (username, sobrenome, cpf, dataNascimento, endereco, email, numeroCelular, password, admin, loggedUser) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("SUCESSO AO ACESSAR O BANCO DE DADOS (Create)");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getSobrenome());
            preparedStatement.setString(3, user.getCpf());
            preparedStatement.setString(4, user.getDataNascimento());
            preparedStatement.setString(5, user.getEndereco());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getNumeroCelular());
            preparedStatement.setString(8, user.getPassword());
            preparedStatement.setBoolean(9, user.isAdmin());
            preparedStatement.setBoolean(10,user.isLoggedUser());

            preparedStatement.executeUpdate();
            System.out.println("SUCESSO AO CRIAR NO BANCO DE DADOS");

            connection.close();

        } catch (Exception e) {
            System.out.println("Erro ao criar no banco de dados (Create)" + e.getMessage());
            e.printStackTrace();
        }
    }

    // Listar usuarios
    public List<User> findUser() {
        String SQL = "SELECT * FROM USER";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("SUCESSO AO ACESSAR O BANCO DE DADOS (ListUser)");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<User> user = new ArrayList<>();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String username = resultSet.getString("username");
                String sobrenome = resultSet.getString("sobrenome");
                String cpf = resultSet.getString("cpf");
                String dataNascimento = resultSet.getString("dataNascimento");
                String endereco = resultSet.getString("endereco");
                String email = resultSet.getString("email");
                String numeroCelular = resultSet.getString("numeroCelular");
                String password = resultSet.getString("password");
                boolean admin = resultSet.getBoolean("admin");
                boolean loggedUser = resultSet.getBoolean("loggedUser");

                User users = new User(id, username, sobrenome, cpf, dataNascimento, endereco, email, numeroCelular, password, admin, loggedUser);
                user.add(users);
            }

            System.out.println("SUCESSO AO SELECIONAR OS USUÁRIOS");
            connection.close();

            return user;

        } catch (Exception e) {
            System.out.println("FALHA AO CONECTAR AO BANCO (List)" + e.getMessage());
            e.printStackTrace();

            return Collections.emptyList();
        }
    }

    // Deletando os usuarios do banco de dados
    public void deleteUserId(String userId) {
        String SQL = "DELETE FROM USER WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("SUCESSO AO ACESSAR O BANCO DE DADOS (deleteUserId)");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, userId);
            preparedStatement.executeUpdate();

            System.out.println("Succeso ao deletar o usuário com o id: " + userId);
            connection.close();

        } catch (Exception e) {
            System.out.println("FALHA AO CONECTAR AO BANCO (DeleteUserId)" + e.getMessage());
            e.printStackTrace();
        }
    }

    // Atualizando as informações do usuario no banco de dados
    public void updateUser(User user) {
        String SQL = "UPDATE USER SET username = ?, sobrenome = ?, cpf = ?, dataNascimento = ?, endereco = ?, email = ?, numeroCelular = ?, password = ?, admin = ?, loggedUser = ? WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("SUCESSO AO ACESSAR O BANCO DE DADOS (updateUser)");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getSobrenome());
            preparedStatement.setString(3, user.getCpf());
            preparedStatement.setString(4, user.getDataNascimento());
            preparedStatement.setString(5, user.getEndereco());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getNumeroCelular());
            preparedStatement.setString(8, user.getPassword());
            preparedStatement.setBoolean(9, user.isAdmin());
            preparedStatement.setBoolean(10,user.isLoggedUser());
            preparedStatement.setString(11, user.getId());

            preparedStatement.executeUpdate();
            System.out.println("Sucesso em atualizar o usuario");

            connection.close();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public User encontrarUsuarioPorUsername(String username) {
        String SQL = "SELECT * FROM USER WHERE username = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String username1 = resultSet.getString("username");
                String sobrenome = resultSet.getString("sobrenome");
                String cpf = resultSet.getString("cpf");
                String dataNascimento = resultSet.getString("dataNascimento");
                String endereco = resultSet.getString("endereco");
                String email = resultSet.getString("email");
                String numeroCelular = resultSet.getString("numeroCelular");
                String password = resultSet.getString("password");
                boolean admin = resultSet.getBoolean("admin");
                boolean loggedUser = resultSet.getBoolean("loggedUser");

                User user = new User(id, username1, sobrenome, cpf, dataNascimento, endereco, email, numeroCelular, password, admin, loggedUser);
                System.out.println("SUCESSO AO SELECIONAR USUARIO");
                return user;
            } else {
                System.out.println("USUARIO NAO ENCONTRADO");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao encontrar usuário por username: " + e.getMessage());
            return null;
        }
    }


    public boolean usernameExiste(String username) {
        String SQL = "SELECT COUNT(*) FROM USER WHERE username = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                connection.close();
                return count > 0;
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao verificar a existência do username: " + e.getMessage());
        }

        return false;
    }

    public boolean cpfExiste(String cpf) {
        String SQL = "SELECT COUNT(*) FROM USER WHERE cpf = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                connection.close();
                return count > 0;
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao verificar a existência do CPF: " + e.getMessage());
        }

        return false;
    }
}

