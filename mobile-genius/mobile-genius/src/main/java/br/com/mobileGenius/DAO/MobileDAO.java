package br.com.mobileGenius.DAO;

import br.com.mobileGenius.Model.Mobile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MobileDAO {


    public void createMobile(Mobile mobile) {

        String SQL = "INSERT INTO CELULAR (NAME) VALUES (?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, mobile.getNomeCelular());
            preparedStatement.execute();

            System.out.println("SUCESSO!");

            connection.close();

        } catch (Exception e) {

            System.out.println("ERROR");

        }

    }

    public List<Mobile> findMobile() {

        String SQL = "SELECT * FROM CELULAR";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("SUCESSO AO ACESSAR O BANCO DE DADOS");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Mobile> mobiles = new ArrayList<>();

            while (resultSet.next()) {

                String mobileName = resultSet.getString("name");

                Mobile mobile = new Mobile(mobileName);

                mobiles.add(mobile);

            }

            System.out.println("SUCESSO AO SELECIONAR OS CELULARES");

            connection.close();

            return mobiles;

        } catch (Exception e) {

            System.out.println("FALHA AO CONECTAR AO BANCO");

            return Collections.emptyList();

        }



    }

}
