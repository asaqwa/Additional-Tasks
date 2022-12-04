package dataBase._2;

import java.sql.*;

import static dataBase.ConnectionData.*;

/*
* Интерфейс ResultSet
* */

public class RetrieveData {
    private static final String SELECT_QUERY = "SELECT * FROM users;";

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
            System.out.printf("%-20s%s%n", "id", "username");
            System.out.println("-------------------------------");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                System.out.printf("%-20d%s%n", id, name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}