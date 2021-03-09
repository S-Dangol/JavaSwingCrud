package org.personal.bookmgmt.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String USERNAME = "root";

    private static final String PASSWORD = "";

    private static final String URL = "jdbc:mysql://localhost:3306/books_crud";

    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER_CLASS_NAME);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
