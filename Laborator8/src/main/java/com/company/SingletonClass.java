package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonClass {
    private static Connection con = null;

    static {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "student";
        String password = "password";
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e);
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }
}
