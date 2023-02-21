package db_connectors;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectivity {
    Connection connection;
   public Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/expense_consultant", "root", "ics49901");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection to database\n cannot be  established.","Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            //throw new RuntimeException(e);
        }
        return connection;
    }
}
