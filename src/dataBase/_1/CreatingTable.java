package dataBase._1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static dataBase.ConnectionData.*;


/*
* Интерфейс Statement
*
* */

public class CreatingTable {
    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE users "
                    + "(id INT(5) NOT NULL AUTO_INCREMENT,"
                    + " username VARCHAR(50), "
                    + "PRIMARY KEY(id));";

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_TABLE_QUERY);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
