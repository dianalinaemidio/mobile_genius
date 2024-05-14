package br.com.mobileGenius.DAO;

import br.com.mobileGenius.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuarioDAO {

    public Usuario getUsuariosPorNome(String nome, String senha) {
        String SQL = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();


            if (resultSet.next()) {
                String ID = resultSet.getString("ID");
                String nomeUsuario = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                String cpf = resultSet.getString("cpf");
                String senhaUsuario = resultSet.getString("senha");
                Date dataNascimento = resultSet.getDate("datanascimento");
                String endereco = resultSet.getString("endereco");
                String email = resultSet.getString("email");
                String numeroCelular = resultSet.getString("numeroCelular");
                boolean administrador = resultSet.getBoolean("administrador");

                return new Usuario(ID, nomeUsuario, sobrenome, cpf, senhaUsuario, dataNascimento, endereco, email, numeroCelular, true,administrador);


            }

            connection.close();
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao verificar credenciais: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Cria um novo usuário no banco de dados
    public void criarUsuario(Usuario usuario) {
        String SQL = "INSERT INTO usuarios (nome, sobrenome, cpf, senha, datanascimento, endereco, email, numeroCelular, administrador, loggedUser) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getSobrenome());
            preparedStatement.setString(3, usuario.getCpf());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.setDate(5, usuario.getDataNascimento());
            preparedStatement.setString(6, usuario.getEndereco());
            preparedStatement.setString(7, usuario.getEmail());
            preparedStatement.setString(8, usuario.getNumeroCelular());
            preparedStatement.setBoolean(9, usuario.isAdministrador());
            preparedStatement.setBoolean(10,usuario.isLoggedUser());

            preparedStatement.executeUpdate();

            connection.close();

        } catch (Exception e) {
            System.out.println("Erro ao criar usuário no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Lista todos os usuários
    public List<Usuario> listarUsuarios() {
        String SQL = "SELECT * FROM usuarios";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Usuario> usuarios = new ArrayList<>();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                String cpf = resultSet.getString("cpf");
                String senha = resultSet.getString("senha");
                Date dataNascimento = resultSet.getDate("dataNascimento");
                String endereco = resultSet.getString("endereco");
                String email = resultSet.getString("email");
                String numeroCelular = resultSet.getString("numeroCelular");
                boolean administrador = resultSet.getBoolean("administrador");

                Usuario usuario = new Usuario(id, nome, sobrenome, cpf, senha, dataNascimento, endereco, email, numeroCelular, administrador);
                usuarios.add(usuario);
            }

            connection.close();

            return usuarios;

        } catch (Exception e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    // Deleta um usuário do banco de dados
    public void deletarUsuario(String idUsuario) {
        String SQL = "DELETE FROM usuarios WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, idUsuario);
            preparedStatement.executeUpdate();

            connection.close();

        } catch (Exception e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
            e.printStackTrace();
        }
    }
    // Atualiza as informações de um usuário no banco de dados
    public void atualizarUsuario(Usuario usuario) {
        String SQL = "UPDATE usuarios SET nome = ?, sobrenome = ?, cpf = ?, senha = ?, data_nascimento = ?, endereco = ?, email = ?, numeroCelular = ?, administrador = ? WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getSobrenome());
            preparedStatement.setString(3, usuario.getCpf());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.setDate(5, usuario.getDataNascimento());
            preparedStatement.setString(6, usuario.getEndereco());
            preparedStatement.setString(7, usuario.getEmail());
            preparedStatement.setString(8, usuario.getNumeroCelular());
            preparedStatement.setBoolean(9, usuario.isAdministrador());
            preparedStatement.setString(10, usuario.getID());

            preparedStatement.executeUpdate();

            connection.close();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            e.printStackTrace();
        }
    }
}