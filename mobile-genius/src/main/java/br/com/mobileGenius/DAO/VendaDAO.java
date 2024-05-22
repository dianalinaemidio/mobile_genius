package br.com.mobileGenius.DAO;

import br.com.mobileGenius.model.Venda;


import java.sql.*;

public class VendaDAO {

    public void salvar(Venda venda) {
        String sqlVenda = "INSERT INTO vendas (cliente_id, data_venda, total) VALUES (?, ?, ?)";

        try (
                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
                PreparedStatement statementVenda = connection.prepareStatement(sqlVenda, Statement.RETURN_GENERATED_KEYS)
        ) {
            // Salvar a venda
            statementVenda.setString(1, venda.getCliente().getId());
            statementVenda.setDate(2, new java.sql.Date(venda.getDataVenda().getTime()));
            statementVenda.setDouble(3, venda.getTotal());
            statementVenda.executeUpdate();

            // Obtendo o ID gerado automaticamente
            ResultSet generatedKeys = statementVenda.getGeneratedKeys();
            if (generatedKeys.next()) {
                int vendaId = generatedKeys.getInt(1);
                venda.setId(Integer.toString(vendaId)); // Definindo o ID gerado na venda
            } else {
                throw new SQLException("Falha ao obter o ID da venda criada.");
            }
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao banco de dados ou salvar a venda.");
            e.printStackTrace();
        }
    }
}