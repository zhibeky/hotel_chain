package kz.edu.nu.cs.se.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kz.edu.nu.cs.se.project.model.Registration;

public class RegistrationDao {
	public int registerUser(Registration registration) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO user" +
            " (user_id, username, password, ident_type, ident_numb, address, home_phone#, mobile_phone) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?);";

        int result = 0;
        int id = 1;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:postgresql://localhost/hotel_chain?user=postgres&password=password&sslmode=allow");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, registration.getUsername());
            preparedStatement.setString(3, registration.getPassword());
            preparedStatement.setString(4, registration.getIdent_type());
            preparedStatement.setString(5, registration.getIdent_number());
            preparedStatement.setString(6, registration.getAddress());
            preparedStatement.setString(7, registration.getHome_phone());
            preparedStatement.setString(8, registration.getMobile_phone());

            System.out.println(preparedStatement);
            id++;
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
