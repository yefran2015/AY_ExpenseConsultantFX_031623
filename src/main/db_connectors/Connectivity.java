package db_connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectivity {
    Connection connection;
   public Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/expense_consultant", "root", "1558");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
