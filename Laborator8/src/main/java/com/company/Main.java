package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        SingletonClass.closeConnection();

        System.out.println("Connection succesfully");
    }
}
