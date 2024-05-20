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
                boolean admin = resultSet.getBoolean("admin");

                if (password.equals(user.getPassword()) && username.equals(user.getUsername())) {
                    return new User(username, password, admin, true);
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
        String SQL = "INSERT INTO USERS (username, password, admin, nome, sobrenome, cpf, datanascimento, endereco, email, numerocelular, loggeduser) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso ao entrar no banco de dados");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, user.isAdmin());
            preparedStatement.setString(4, user.getNome());
            preparedStatement.setString(5, user.getSobrenome());
            preparedStatement.setString(6, user.getCpf());
            java.sql.Date dataNascimentoSql = new java.sql.Date(user.getDataNascimento().getTime());
            preparedStatement.setDate(7, dataNascimentoSql);
            preparedStatement.setString(8, user.getEndereco());
            preparedStatement.setString(9, user.getEmail());
            preparedStatement.setString(10, user.getNumeroCelular());
            preparedStatement.setBoolean(11, user.isLoggedUser());

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
                boolean admin = resultSet.getBoolean("admin");
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                String cpf = resultSet.getString("cpf");
                Date dataNascimento = resultSet.getDate("datanascimento");
                String endereco = resultSet.getString("endereco");
                String email = resultSet.getString("email");
                String numeroCelular = resultSet.getString("numerocelular");
                boolean loggedUser = resultSet.getBoolean("loggeduser");

                User user = new User(id, username, password, admin, nome, sobrenome, cpf, dataNascimento, endereco, email, numeroCelular, loggedUser);
                users.add(user);
            }

            System.out.println("SUCESSO AO SELECIONAR OS USUÁRIOS");
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
        String SQL = "UPDATE USERS SET username = ?, password = ?, admin = ?, nome = ?, sobrenome = ?, cpf = ?, datanascimento = ?, endereco = ?, email = ?, numerocelular = ?, loggeduser = ? WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Sucesso ao conectar no banco de dados e fazer o update");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, user.isAdmin());
            preparedStatement.setString(4, user.getNome());
            preparedStatement.setString(5, user.getSobrenome());
            preparedStatement.setString(6, user.getCpf());
            java.sql.Date dataNascimentoSql = new java.sql.Date(user.getDataNascimento().getTime());
            preparedStatement.setDate(7, dataNascimentoSql);
            preparedStatement.setString(8, user.getEndereco());
            preparedStatement.setString(9, user.getEmail());
            preparedStatement.setString(10, user.getNumeroCelular());
            preparedStatement.setBoolean(11, user.isLoggedUser());
            preparedStatement.setString(12, user.getId());

            preparedStatement.executeUpdate();
            System.out.println("Sucesso em atualizar o usuario");

            connection.close();

        } catch (Exception e) {
            System.out.println("Falha na conexão do banco de dados");
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    }

    public User encontrarUsuarioPorUsername(String username) {
        String SQL = "SELECT * FROM USERS WHERE username = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String password = resultSet.getString("password");
                boolean admin = resultSet.getBoolean("admin");
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                String cpf = resultSet.getString("cpf");
                Date dataNascimentoSql = resultSet.getDate("datanascimento");
                java.util.Date dataNascimento = new java.util.Date(dataNascimentoSql.getTime());
                String endereco = resultSet.getString("endereco");
                String email = resultSet.getString("email");
                String numeroCelular = resultSet.getString("numerocelular");
                boolean loggedUser = resultSet.getBoolean("loggeduser");

                User user = new User(id, username, password, admin, nome, sobrenome, cpf, dataNascimento, endereco, email, numeroCelular, loggedUser);
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
        String SQL = "SELECT COUNT(*) FROM USERS WHERE username = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao verificar a existência do username: " + e.getMessage());
        }

        return false;
    }

    public boolean cpfExiste(String cpf) {
        String SQL = "SELECT COUNT(*) FROM USERS WHERE cpf = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cpf);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao verificar a existência do CPF: " + e.getMessage());
        }

        return false;
    }

    public User encontrarUsuarioPorId(String id) {
        String SQL = "SELECT * FROM USERS WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                boolean admin = resultSet.getBoolean("admin");
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                String cpf = resultSet.getString("cpf");
                Date dataNascimento = resultSet.getDate("datanascimento");
                String endereco = resultSet.getString("endereco");
                String email = resultSet.getString("email");
                String numeroCelular = resultSet.getString("numerocelular");
                boolean loggedUser = resultSet.getBoolean("loggeduser");

                User user = new User(id, username, password, admin, nome, sobrenome, cpf, dataNascimento, endereco, email, numeroCelular, loggedUser);
                System.out.println("Usuário encontrado com sucesso.");
                return user;
            } else {
                System.out.println("Usuário não encontrado.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao encontrar usuário por ID: " + e.getMessage());
            return null;
        }
    }
}

