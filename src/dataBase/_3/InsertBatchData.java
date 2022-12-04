package dataBase._3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static dataBase.ConnectionData.*;

public class InsertBatchData {
    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.addBatch("INSERT INTO users (username) VALUES ('sidorov')");
            statement.addBatch("INSERT INTO users (username) VALUES ('petrov')");
            statement.addBatch("INSERT INTO users (username) VALUES ('kozlov')");

            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}