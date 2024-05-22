package br.com.mobileGenius.DAO;

import br.com.mobileGenius.model.Carrinho;
import br.com.mobileGenius.model.Celular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO {

    public void createCarrinho(Carrinho carrinho) {
        String SQL = "INSERT INTO CARRINHO (CLIENTE_ID, TOTAL) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, carrinho.getIdCliente());
            preparedStatement.setString(2, String.valueOf(carrinho.getTotal()));
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            String carrinhoId = null;
            if (generatedKeys.next()) {
                carrinhoId = String.valueOf(generatedKeys.getInt(1));
                carrinho.setId(carrinhoId);
            }

            if (carrinhoId != null) {
                for (Celular celular : carrinho.getCelulares()) {
                    String celularClienteSQL = "INSERT INTO CARRINHO_CELULAR (CARRINHO_ID, CELULAR_ID) VALUES (?, ?)";
                    PreparedStatement celularClienteStatement = connection.prepareStatement(celularClienteSQL);
                    celularClienteStatement.setString(1, carrinhoId);
                    celularClienteStatement.setString(2, celular.getId());
                    celularClienteStatement.executeUpdate();
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao criar carrinho no banco de dados");
            e.printStackTrace();
        }
    }


    public Carrinho getCarrinhoById(String carrinhoId) {
        String SQL = "SELECT * FROM carrinho WHERE id = ?";
        Carrinho carrinho = null;

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, carrinhoId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String clienteId = resultSet.getString("cliente_id");
                double total = resultSet.getDouble("total");

                carrinho = new Carrinho(clienteId);
                carrinho.setId(carrinhoId);
                carrinho.setTotal(total);

                // Buscar os celulares no carrinho e adicioná-los
                List<Celular> celulares = getCelularesNoCarrinho(carrinho);
                carrinho.setCelulares((ArrayList<Celular>) celulares);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar carrinho pelo ID no banco de dados");
            e.printStackTrace();
        }

        return carrinho;
    }


    public Carrinho findCarrinhoByUserId(String userId) {
        String SQL = "SELECT * FROM carrinho WHERE cliente_id = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String carrinhoId = resultSet.getString("id");
                double total = resultSet.getDouble("total");
                Carrinho carrinho = new Carrinho(userId);
                carrinho.setId(carrinhoId);
                carrinho.setTotal(total);

                // Buscar os celulares no carrinho e adicioná-los
                List<Celular> celulares = getCelularesNoCarrinho(carrinho);
                carrinho.setCelulares((ArrayList<Celular>) celulares);

                return carrinho;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar carrinho do cliente no banco de dados");
            e.printStackTrace();
        }

        return null;
    }


    public void updateCarrinho(Carrinho carrinho) {
        String updateCarrinhoSQL = "UPDATE carrinho SET total = ? WHERE id = ?";
        String deleteCarrinhoCelularSQL = "DELETE FROM carrinho_celular WHERE carrinho_id = ?";
        String insertCarrinhoCelularSQL = "INSERT INTO carrinho_celular (carrinho_id, celular_id) VALUES (?, ?)";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            connection.setAutoCommit(false);

            PreparedStatement updateCarrinhoStatement = connection.prepareStatement(updateCarrinhoSQL);
            updateCarrinhoStatement.setDouble(1, carrinho.getTotal());
            updateCarrinhoStatement.setString(2, carrinho.getId());
            updateCarrinhoStatement.executeUpdate();
            updateCarrinhoStatement.close();


            PreparedStatement deleteCarrinhoCelularStatement = connection.prepareStatement(deleteCarrinhoCelularSQL);
            deleteCarrinhoCelularStatement.setString(1, carrinho.getId());
            deleteCarrinhoCelularStatement.executeUpdate();
            deleteCarrinhoCelularStatement.close();



            PreparedStatement insertCarrinhoCelularStatement = connection.prepareStatement(insertCarrinhoCelularSQL);
            for (Celular celular : carrinho.getCelulares()) {
                insertCarrinhoCelularStatement.setString(1, carrinho.getId());
                insertCarrinhoCelularStatement.setString(2, celular.getId());
                insertCarrinhoCelularStatement.executeUpdate();
            }
            insertCarrinhoCelularStatement.close();

            connection.commit();
            System.out.println("Carrinho atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar carrinho no banco de dados: " + e.getMessage());

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public void deleteCelular(String carrinhoId, String celularId) {
        String deleteCelularSQL = "DELETE FROM carrinho_celular WHERE carrinho_id = ? AND celular_id = ? LIMIT 1"; // Adicione "LIMIT 1" para garantir que apenas uma entrada seja excluída
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement deleteCelularStatement = connection.prepareStatement(deleteCelularSQL);
            deleteCelularStatement.setString(1, carrinhoId);
            deleteCelularStatement.setString(2, celularId);
            deleteCelularStatement.executeUpdate();
            System.out.println("Celular removido do carrinho com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao remover celular do carrinho: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public void deleteCarrinho(Carrinho carrinho) {
        String SQL = "DELETE FROM carrinho WHERE id = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, carrinho.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao deletar carrinho do banco de dados");
            e.printStackTrace();
        }
    }

    public List<Celular> getCelularesNoCarrinho(Carrinho carrinho) {
        String SQL = "SELECT c.id, c.marca, c.modelo, c.preco, c.quantidade, c.descricao, c.image " +
                "FROM carrinho_celular cc " +
                "JOIN celular c ON cc.celular_id = c.id " +
                "WHERE cc.carrinho_id = ?";
        List<Celular> celulares = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, carrinho.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Celular celular = new Celular(
                        resultSet.getString("id"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getDouble("preco"),
                        resultSet.getInt("quantidade"),
                        resultSet.getString("descricao"),
                        resultSet.getString("image")
                );
                celulares.add(celular);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar celulares do carrinho no banco de dados");
            e.printStackTrace();
        }

        return celulares;
    }

}

