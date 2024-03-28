package br.com.mobileGenius.DAO;

import br.com.mobileGenius.Model.Mobile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MobileDAO {

    public void createMobile(Mobile mobile) {

        String SQL = "INSERT INTO CAR (NAME) VALUES (?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, mobile.getNome());
            preparedStatement.execute();

            System.out.println("SUCESSO!");

            connection.close();

        } catch (Exception e) {

            System.out.println("ERROR");

        }

    }

}
